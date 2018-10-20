from OauthClient import OauthClient
import requests

# OAuth variables -- Replace values with your app credentials
client_id = "YOUR_CLIENT_ID"
client_secret = "YOUR_CLIENT_SECRET"
# API Endpoint (hardcoded for customer id=1)
api_endpoint = "https://api-stg.syf.com/m2020/customers/1/interactions"


# Creates an HTTP GET request to a specified endpoint
def call_api(endpoint, access_token):
    headers = {
        'Content-Type': 'application/x-www-form-urlencoded',
        'Authorization': 'Bearer ' + access_token
    }
    res = requests.get(endpoint, headers=headers)
    return res.text


# Initialize OAuth2 Client
client = OauthClient(client_id, client_secret)
# Retrieve Access token
token = client.get_token()
# Make API Call with access token
print(call_api(api_endpoint, token))
