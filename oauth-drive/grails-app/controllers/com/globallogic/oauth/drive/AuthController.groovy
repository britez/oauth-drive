package com.globallogic.oauth.drive

import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse

class AuthController {
	
	def oauthService

    def index() {
		session["redirectUrl"] = params.redirectURL
		redirect(url:oauthService.getAuthURL())
	}
	
	def code() {
		GoogleTokenResponse tokenResponse = oauthService.getTokenResponse(params.code)
		session["accessToken"] = tokenResponse.getAccessToken()
		session["refreshToken"] = tokenResponse.getRefreshToken()
		
		redirect url: session["redirectUrl"]
	}
}
