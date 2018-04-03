import java.util.Observable;
import java.util.Observer;


public class StasticsDisplay implements Observer, DisplayElement {

	Observable observable;
	
	private float sumTemperature;
	private float averageTemperature;
	
	private float sumHumidity;
	private float averageHumidity;
	
	private float sumPressure;
	private float averagePressure;
	
	private Subject weatherData;
	
	private int dataCount;
	
	public StasticsDisplay(Observable observable) { 
		this.observable = observable;
		observable.addObserver(this);
	}
	
	
	@Override
	public void display() {

		System.out.printf("Weather Statistics\nAverage Temperature: %.2f\nAverate Humidity: %.2f\nAverage Pressure: %.2f\n",
				averageTemperature, averageHumidity, averagePressure);
	}


	public void update(Observable obs, Object arg) {

		if(obs instanceof WeatherSubject) {
			WeatherSubject weatherSubject = (WeatherSubject) obs;

			dataCount++;
			
			sumTemperature += ((WeatherSubject) obs).getTemperature();
			averageTemperature = sumTemperature / (float) (dataCount);
			
			sumHumidity += ((WeatherSubject) obs).getHumidity();
			averageHumidity = sumHumidity / (float) (dataCount);
					
			sumPressure += ((WeatherSubject) obs).getPressure();
			averagePressure = sumPressure / (float) (dataCount);
					
			display();
		}
	}
}
