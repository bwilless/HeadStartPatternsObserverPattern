
import java.util.Observable;
import java.util.Observer;


public class ForecastDisplay implements Observer, DisplayElement {

	Observable observable;

	private float lastPressure;
	private float currentPressure;
	private Subject weatherData;

	public ForecastDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}	
	
	public void display() {

		String forecast = "Rain Expected";
		
		if(currentPressure == lastPressure) {
			forecast = "No Change Expected";
		} else if (currentPressure < lastPressure) {
			forecast = "Clear Weather Expected";
		}			
		
		
		System.out.printf("Forecast: %s\n", forecast);
	}

	
	public void update(Observable obs, Object arg) {

		if(obs instanceof WeatherSubject) {
			WeatherSubject weatherSubject = (WeatherSubject) obs;
			lastPressure = currentPressure;
			this.currentPressure = ((WeatherSubject) obs).getPressure();
			display();
		}
	}
	
}

