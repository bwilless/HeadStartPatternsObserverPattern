
public class ForecastDisplay implements Observer, DisplayElement {

	private float lastPressure;
	private float currentPressure;
	
	private Subject weatherData;

	public ForecastDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	
	@Override
	public void display() {

		String forecast = "Rain Expected";
		
		if(currentPressure == lastPressure) {
			forecast = "No Change Expected";
		} else if (currentPressure < lastPressure) {
			forecast = "Clear Weather Expected";
		}			
		
		
		System.out.printf("Forecast: %s\n", forecast);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {

		lastPressure = currentPressure;
		currentPressure = pressure;
		
		display();
		
	}
}
