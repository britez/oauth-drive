package com.globallogic.oauth.drive

class SpreadsheetController {

	def googleService
	
	private String BASE_URL = "http://localhost:8080/oauth-drive/"

	def list() {
		def accessToken = session["accessToken"]
		if(accessToken == null){
			return redirect(controller: "auth", action: "index", params: [redirectURL:BASE_URL+"spreadsheet/list"])
		}
		
		def list = googleService.list(accessToken)
		list
	}
}
