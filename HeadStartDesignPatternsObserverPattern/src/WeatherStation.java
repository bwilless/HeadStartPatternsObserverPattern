
public class WeatherStation {

	public static void main(String[] args) {
		
		WeatherSubject weatherData = new WeatherSubject();
		
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		StasticsDisplay stasticsDisplay = new StasticsDisplay(weatherData);
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		
		weatherData.setMeasurements(100.0f, 23.0f, 76.33f);
		weatherData.setMeasurements(111.0f, 20.0f, 80.11f);
		weatherData.setMeasurements(87.0f, 5.0f, 70.44f);
		
	}
	
}
