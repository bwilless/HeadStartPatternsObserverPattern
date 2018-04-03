

public class StasticsDisplay implements Observer, DisplayElement {

	private float sumTemperature;
	private float averageTemperature;
	
	private float sumHumidity;
	private float averageHumidity;
	
	private float sumPressure;
	private float averagePressure;
	
	private Subject weatherData;
	
	private int dataCount;
	
	
	public StasticsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	
	@Override
	public void display() {

		System.out.printf("Weather Statistics\nAverage Temperature: %.2f\nAverate Humidity: %.2f\nAverage Pressure: %.2f\n",
				averageTemperature, averageHumidity, averagePressure);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {

		
		dataCount++;
		
		sumTemperature += temp;
		averageTemperature = sumTemperature / (float) (dataCount);
		
		sumHumidity += humidity;
		averageHumidity = sumHumidity / (float) (dataCount);
				
		sumPressure += pressure;
		averagePressure = sumPressure / (float) (dataCount);
				
		display();
		
	}
}
