package syf.c360sample;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class C360APIs {


    public String token;
    public String expires;
    String customerDataResponse;

    //Client ID and secret from the developer portal
    public static final String CLIENT_ID = "O4AosaTYj9KtxK9JUbbKiDGYP8yDQQ0z";
    public static final String CLIENT_SECRET = "fHDjoFrqSoeH2iwc";

    /**
     * Quite basic method that makes an oAuth request then a call to the customer credit profiles
     * Credit request is enqueued within oAuth request to make this demo simpler
     */
    public void callC360Apis() {
        Retrofit retro = getRetroInstance();

        //Create the retrofit instance of our API call interface
        final ApiInterface apiInterface = retro.create(ApiInterface.class);

        //Get the access token from the oAuth Request
        Call<AccessToken> call = apiInterface.getAccToken("application/x-www-form-urlencoded", CLIENT_ID,
                CLIENT_SECRET, "client_credentials");
        call.enqueue(new Callback<AccessToken>() {
            @Override
            public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                //On a successful oAuth request call, set the token and call the customer credit profile
                Log.d("well something happened", response.body().getAccessToken());
                if(response.body() != null) {
                    setToken(response.body().getAccessToken());
                    setExpires(response.body().getExpiresIn());

                    //Get a customer credit profile
                    Call<CustomerCreditProfile> customerCreditProfileCall = apiInterface.getCreditProfile(MainActivity.customerId, "application/json",
                            "Bearer " + response.body().getAccessToken());
                    customerCreditProfileCall.enqueue(new Callback<CustomerCreditProfile>() {
                        @Override
                        public void onResponse(Call<CustomerCreditProfile> call, Response<CustomerCreditProfile> response) {
                            if(response.body() != null) {
                                //Format the response to print to screen
                                Log.d("success happened. yay", response.body().getAccountAge());
                                String accountAge = response.body().getAccountAge();
                                String bankruptAccounts = response.body().getBankruptAccounts();
                                String delinquentAccounts = response.body().getDelinquentAccounts();
                                String ficoScore = response.body().getFicoScore();
                                String syfCreditScore = response.body().getSyfCreditScore();
                                String paymentHistory = response.body().getPaymentHistory();

                                //The response to send back to the UI
                                customerDataResponse = "Synchrony Demo Customer " + MainActivity.customerId +  ": \n {  \"syfCreditScore:\" " + syfCreditScore + "\n \"ficoScore:\" " + ficoScore + "\n \"delinquentAccounts:\" "
                                                            + delinquentAccounts + "\n \"bankruptAccounts:\" " + bankruptAccounts + "\n \"averageAccountAge:\" "
                                                            + accountAge + "\n \"paymentHistory:\" " + paymentHistory + " }";
                            }
                        }

                        @Override
                        public void onFailure(Call<CustomerCreditProfile> call, Throwable t) {
                            Log.e("errors errors everywher", t.toString());

                        }
                    });
                } else {
                    Log.d("something went wrong", response.toString());
                }
            }

            @Override
            public void onFailure(Call<AccessToken> call, Throwable t) {
                Log.e("failure", t.toString());
            }
        });

    }

    /**
     * Creates a retrofit instance with our base URL
     * @return A retrofit instance
     */
    public Retrofit getRetroInstance() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api-stg.syf.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }


    /**
     * Sets the access token for use later
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Sets the expiration time
     * @param expires
     */
    public void setExpires(String expires) {
        this.expires = expires;
    }

    /**
     * Gets the access token
     * @return Access Token
     */
    public String getToken() {
        return token;
    }

    /**
     * Gets the expiration time
     * @return Expiration Time
     */
    public String getExpires() {
        return expires;
    }

    /**
     * Method for the main activity to call to display customer information to the UI
     * @return Response from the API as a String
     */
    public String displayCustomerData() {

        return customerDataResponse;
    }

}
