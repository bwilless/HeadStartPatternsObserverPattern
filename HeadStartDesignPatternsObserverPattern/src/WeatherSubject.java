import java.util.*;



public class WeatherSubject implements Subject {

	private ArrayList<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	
	public WeatherSubject () {
		observers = new ArrayList<Observer>();
	}
	
	
	public void registerObserver(Observer o) {

		observers.add(o);
	}

	public void removeObserver(Observer o) {
		
		int i = observers.indexOf(o);
		if(i >= 0) {
			observers.remove(i);
		} 
	}

	public void notifyObservers() {

		for(Observer observer: observers) {
			observer.update(temperature, humidity, pressure);
		
		}
	}

	public void measurementsChanges() {
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanges();
		
	}
	
	
}
