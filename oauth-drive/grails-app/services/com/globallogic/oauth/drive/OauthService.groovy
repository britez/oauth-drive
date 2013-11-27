package com.globallogic.oauth.drive

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse
import com.google.api.client.http.HttpRequest
import com.google.api.client.http.HttpRequestInitializer
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.oauth2.Oauth2

class OauthService {

	final String SPREADSHEET_SCOPE = "https://spreadsheets.google.com/feeds"
	final String EMAIL_SCOPE = "https://www.googleapis.com/auth/userinfo#email"
	final String CLIENT_SECRET = "9vMO2377dZqikiuxjf2qubZL"
	final String CLIENT_ID = "119451786372-t5c5ba52gb77thuv60cd1fa6j4ue5c1h.apps.googleusercontent.com"
	final String REDIRECT_URI = "http://localhost:8080/oauth-drive/auth/code"

	String getAuthURL() {
	    this.buildGoogleFlow().newAuthorizationUrl().setRedirectUri(REDIRECT_URI).build()
    }
	
	GoogleTokenResponse getTokenResponse(final String code){
		this.buildGoogleFlow().newTokenRequest(code).setRedirectUri(REDIRECT_URI).execute()
	}
	
//	String getEmail(final String accessToken){
//		Oauth2 userInfoService = new Oauth2.Builder(new NetHttpTransport(), new JacksonFactory(), new GoogleHttpRequestInitializer(accessToken)).setApplicationName("theApiName").build();
//		log.info("Obteniendo el mail para el cliente actual")
//		userInfoService.userinfo().get().execute().getEmail();
//	}

	private GoogleAuthorizationCodeFlow buildGoogleFlow(){
		def flow = new GoogleAuthorizationCodeFlow.Builder(new NetHttpTransport(),new JacksonFactory(),CLIENT_ID,CLIENT_SECRET,[SPREADSHEET_SCOPE,EMAIL_SCOPE])
		flow.setAccessType("offline").setApprovalPrompt("force").build()
	}
	
//	private class GoogleHttpRequestInitializer implements HttpRequestInitializer {
//		
//		private String accessToken; 
//		
//		GoogleHttpRequestInitializer(final String accessToken){
//			this.accessToken = accessToken;
//		}
//
//		@Override
//		public void initialize(HttpRequest req) throws IOException {
//			req.getHeaders().put("Authorization", ["Bearer " + accessToken])
//		}
//		
//	}
}