package com.globallogic.oauth.drive

import com.google.gdata.client.spreadsheet.FeedURLFactory
import com.google.gdata.client.spreadsheet.SpreadsheetQuery
import com.google.gdata.client.spreadsheet.SpreadsheetService as GoogleSpreadsheetService
import com.google.gdata.data.spreadsheet.SpreadsheetEntry
import com.google.gdata.data.spreadsheet.SpreadsheetFeed

class GoogleService {

	/** The SHEET_NAME */	
	private final String SHEET_NAME = "TCP002 - Carga de horas"
	
	/** The APP_NAME */
	private final String APP_NAME = "Fnx Tracker"
	
	/** The WORKSHEET_NAME */
	private final String WORKSHEET_NAME = "Datos cargados"
	
	public List<SpreadsheetEntry> list(final String accessToken){
		GoogleSpreadsheetService service = this.getService(accessToken)
		SpreadsheetQuery query = new SpreadsheetQuery(FeedURLFactory.getDefault().getSpreadsheetsFeedUrl());
		SpreadsheetFeed feed = service.getFeed(query, SpreadsheetFeed.class);
		return feed.getEntries();
	}
	
	private GoogleSpreadsheetService getService(final String accessToken){
		GoogleSpreadsheetService service = new GoogleSpreadsheetService(APP_NAME)
		service.setHeader("Authorization", "Bearer " + accessToken)
		return service
	}
}
