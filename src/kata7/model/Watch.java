package kata7.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Watch implements Observable {
		
	private Timer timer;
	
	private Time time;
	
	private final List<Observer<Watch>> observers;
	
	public Watch() {
		timer = new Timer();
		time = new Time();
		observers = new LinkedList<>();
	}
	
	public void start() {
		timer.schedule(task(), 0, 1000);
	}
	
	public void stop() {
		timer.cancel();
	}
	
	private TimerTask task() {
		
		return new TimerTask() {

			@Override
			public void run() {
				time.step();
				notifyObservers();
			}
			
		};
	}

	@Override
	public void notifyObservers() {
		observers.forEach(obs -> obs.notify(this));
	}

	@Override
	public void addObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	public Time getTime() {
		return time;
	}
	

}
