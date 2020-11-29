package com.test.application;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import com.test.model.CurrentWeather;
import com.test.utilities.Alertes;
import com.test.utilities.Api;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final String GENERIC_ERROR_MESSAGE = "Une erreur est survenue";
	public static final String GENERIC_INFORMATION_MESSAGE = "Veuillez vérifier votre connexion Internet";

	private String retourVille = "";
	private JLabel locationLabel;
	private JLabel timeLabel;
	private JLabel temperatureLabel;
	private JPanel otherInfosPanel;
	private JLabel humidityLabel;
	private JLabel humidityValue;
	private JLabel precipLabel;
	private JLabel precipValue;
	private JLabel summaryLabel;

	private CurrentWeather currentWeather;

	public MainFrame(String title) {

		super(title);
		Container contentPane = getContentPane();
		setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		contentPane.setBackground(Color.WHITE);

		locationLabel = new JLabel(retourVille, SwingConstants.CENTER);
		locationLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		locationLabel.setFont(new Font("San Francisco", Font.PLAIN, 30));

		timeLabel = new JLabel("...", SwingConstants.CENTER);
		timeLabel.setFont(new Font("San Francisco", Font.PLAIN, 10));
		timeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		temperatureLabel = new JLabel("--");
		temperatureLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		temperatureLabel.setFont(new Font("San Francisco", Font.PLAIN, 100));
		temperatureLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));

		otherInfosPanel = new JPanel(new GridLayout(2, 2));
		otherInfosPanel.setBackground(Color.WHITE);

		humidityLabel = new JLabel("Humidité".toUpperCase(), SwingConstants.CENTER);
		humidityLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		humidityLabel.setFont(new Font("San Francisco", Font.PLAIN, 20));

		humidityValue = new JLabel("--", SwingConstants.CENTER);
		humidityValue.setAlignmentX(Component.CENTER_ALIGNMENT);
		humidityValue.setFont(new Font("San Francisco", Font.PLAIN, 20));

		precipLabel = new JLabel("Risques de pluie".toUpperCase(), SwingConstants.CENTER);
		precipLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		precipLabel.setFont(new Font("San Francisco", Font.PLAIN, 20));

		precipValue = new JLabel("--", SwingConstants.CENTER);
		precipValue.setAlignmentX(Component.CENTER_ALIGNMENT);
		precipValue.setFont(new Font("San Francisco", Font.PLAIN, 20));

		otherInfosPanel.add(humidityLabel);
		otherInfosPanel.add(precipLabel);
		otherInfosPanel.add(humidityValue);
		otherInfosPanel.add(precipValue);

		summaryLabel = new JLabel("Récupération de la température actuelle");
		summaryLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		summaryLabel.setBorder(BorderFactory.createEmptyBorder(100, 0, 0, 0));
		summaryLabel.setFont(new Font("San Francisco", Font.PLAIN, 20));

		add(locationLabel);
		add(timeLabel);
		add(temperatureLabel);
		add(otherInfosPanel);
		add(summaryLabel);

		setContentPane(contentPane);

		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(Api.getForecastUrl()).build();

		Call call = client.newCall(request);
		call.enqueue(new Callback() {

			@Override
			public void onResponse(Call call, Response response) {
				try (ResponseBody body = response.body()) {
					if (response.isSuccessful()) {
						String jsonData = body.string();
						currentWeather = getCurrentWeatherDetails(jsonData);

						EventQueue.invokeLater(() -> updateScreen());

					} else {
						Alertes.error(MainFrame.this, GENERIC_ERROR_MESSAGE);
					}
				} catch (ParseException | IOException e) {
					Alertes.error(MainFrame.this, GENERIC_ERROR_MESSAGE);
				}
			}

			@Override
			public void onFailure(Call call, IOException e) {
				Alertes.error(MainFrame.this, GENERIC_INFORMATION_MESSAGE);
			}
		});
	}

	protected void updateScreen() {
		timeLabel.setText(currentWeather.getFormattedTime());

	}

	private CurrentWeather getCurrentWeatherDetails(String jsonData) throws ParseException {
		CurrentWeather currentWeather = new CurrentWeather();
		JSONArray forecast = (JSONArray) JSONValue.parseWithException(jsonData);
		
		currentWeather.setLocalizedName((String) forecast.get("LocalizedName"));

		return currentWeather;
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(500, 500);
	}

	@Override
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}

	@Override
	public Dimension getMaximumSize() {
		return getPreferredSize();
	}

}