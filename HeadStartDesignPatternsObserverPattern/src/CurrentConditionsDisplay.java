
import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	Observable observable;
	
	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	
	public void display() {

		System.out.printf("Current Conditions\nTemperature: %.2f\nHumidity: %.2f\n", temperature, humidity);
	}

	@Override
	public void update(Observable obs, Object arg) {

		if(obs instanceof WeatherSubject) {
			WeatherSubject weatherSubject = (WeatherSubject) obs;
			this.temperature = ((WeatherSubject) obs).getTemperature();
			this.humidity = ((WeatherSubject) obs).getHumidity();
			display();
		}
	}
}
