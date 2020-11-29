package com.test.utilities;

public class Api {

	private static final String FORECAST_API_BASE_URL = "http://dataservice.accuweather.com/locations/v1/cities/search?";
	private static final String PRIVATE_API_KEY = "apikey=vtRwOtir1SBnZtzOT2vYi0MUS76T3xT6&q=";
	

	public static String getForecastUrl() {
		return FORECAST_API_BASE_URL + PRIVATE_API_KEY + "Nantes";
	}
}
