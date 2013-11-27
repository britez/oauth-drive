package com.globallogic.oauth.drive

import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse

class AuthController {
	
	def oauthService

	//Tengo que obtener el codigo de google y hacer que el usuario se loguee
    def index() {}
	
	//Con el codigo, obtengo el access token
	def code() {}
}
