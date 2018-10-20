package syf.c360sample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccessToken {
    @SerializedName("token_type")
    @Expose
    String tokenType;
    @SerializedName("issued_at")
    @Expose
    String issuedAt;
    @SerializedName("client_id")
    @Expose
    String clientId;
    @SerializedName("access_token")
    @Expose
    String accessToken;
    @SerializedName("application_name")
    @Expose
    String appName;
    @SerializedName("expires_in")
    @Expose
    String expiresIn;
    @SerializedName("status")
    @Expose
    String approved;

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getIssuedAt() {
        return issuedAt;
    }

    public void setIssuedAt(String issuedAt) {
        this.issuedAt = issuedAt;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String token) {
        accessToken = token;
    }

    public String getExpiresIn() {
        return  this.expiresIn;
    }

    public void setExpiresIn(String expiry) {
        expiresIn = expiry;
    }

}
