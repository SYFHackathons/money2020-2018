import requests
import json


class OauthClient(object):
    def __init__(self, client_id, client_secret, token_endpoint="https://api-stg.syf.com/oauth2/v1/token"):
        self.client_id = client_id
        self.client_secret = client_secret
        self.token_endpoint = token_endpoint

    def get_token(self):
        # Initialize headers and body for OAuth2 API call
        headers = {
            'Content-Type': 'application/x-www-form-urlencoded'
        }
        body = {
            'grant_type': 'client_credentials',
            'client_id': self.client_id,
            'client_secret': self.client_secret
        }
        # Call OAuth2 API and return response
        res = requests.post(self.token_endpoint, data=body, headers=headers)
        resp_body = json.loads(res.text)
        access_token = resp_body['access_token']
        return access_token
