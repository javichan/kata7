package kata7.gui;

import kata7.model.Observer;
import kata7.model.Watch;

public class WatchPresenter implements Observer<Watch> {

	private Watch watch;
	private WatchView view;
	
	public WatchPresenter(Watch watch, WatchView view) {
		this.watch = watch;
		this.view = view;
		watch.addObserver(this);
	}


	@Override
	public void notify(Watch observable) {
		view.render(watch.getTime());
	}
	
	
	
}
