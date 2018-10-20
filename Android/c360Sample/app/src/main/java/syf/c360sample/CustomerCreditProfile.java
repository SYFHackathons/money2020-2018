package syf.c360sample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CustomerCreditProfile {
    @SerializedName("syfCreditScore")
    @Expose
    String syfCreditScore;
    @SerializedName("ficoScore")
    @Expose
    String ficoScore;
    @SerializedName("delinquentAccounts")
    @Expose
    String delinquentAccounts;
    @SerializedName("bankruptAccounts")
    @Expose
    String bankruptAccounts;
    @SerializedName("averageAccountAge")
    @Expose
    String accountAge;
    @SerializedName("paymentHistory")
    @Expose
    String paymentHistory;

    public String getSyfCreditScore() {
        return syfCreditScore;
    }

    public void setSyfCreditScore(String syfCreditScore) {
        this.syfCreditScore = syfCreditScore;
    }

    public String getFicoScore() {
        return ficoScore;
    }

    public void setFicoScore(String ficoScore) {
        this.ficoScore = ficoScore;
    }

    public String getDelinquentAccounts() {
        return delinquentAccounts;
    }

    public void setDelinquentAccounts(String delinquentAccounts) {
        this.delinquentAccounts = delinquentAccounts;
    }

    public String getBankruptAccounts() {
        return bankruptAccounts;
    }

    public void setBankruptAccounts(String bankruptAccounts) {
        this.bankruptAccounts = bankruptAccounts;
    }

    public String getAccountAge() {
        return accountAge;
    }

    public void setAccountAge(String accountAge) {
        this.accountAge = accountAge;
    }

    public String getPaymentHistory() {
        return paymentHistory;
    }

    public void setPaymentHistory(String paymentHistory) {
        this.paymentHistory = paymentHistory;
    }
}

