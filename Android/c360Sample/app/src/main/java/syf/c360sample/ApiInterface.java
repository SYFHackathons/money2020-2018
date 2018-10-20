package syf.c360sample;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("oauth2/v1/token")
    Call<AccessToken> getAccToken(@Header("Content-Type") String contentType,
                                  @Field("client_id") String clientId,
                                  @Field("client_secret") String clientSecret,
                                  @Field("grant_type") String grantType);

    @GET("m2020/credit/customers/{customerId}/profile")
    Call<CustomerCreditProfile> getCreditProfile(@Path ("customerId") String customerId,
                                                 @Header("Content") String content,
                                                 @Header("Authorization") String token);
}
