package com.test.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CurrentWeather {
	private String localizedName;
	private long time;
	private double temperature;
	private double humidity;
	private double precipProbability;
	private String summary;

	public String getLocalizedName() {
		return localizedName;
	}

	public String getFormattedTime() {
		Date date = new Date(time * 1000L);
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		formatter.setTimeZone(TimeZone.getTimeZone(getLocalizedName()));
		String formattedDate = formatter.format(date);
		return formattedDate;
	}

	public void setLocalizedName(String localizedName) {
		this.localizedName = localizedName;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getHumidity() {
		return humidity;
	}

	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	public double getPrecipProbability() {
		return precipProbability;
	}

	public void setPrecipProbability(double precipProbability) {
		this.precipProbability = precipProbability;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
