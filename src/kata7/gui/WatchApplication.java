package kata7.gui;

import javax.swing.JFrame;

import kata7.model.Watch;

public class WatchApplication {
	
	private JFrame window;
	
	private Watch watch;
	
	public WatchApplication() {
		
		watch = new Watch();
		
		WatchView view = new WatchView();
		
		initWindow(view);
		
		new WatchPresenter(watch, view);
		
	}

	private void initWindow(WatchView view) {
		
		window = new JFrame("Watch Application");
		
		window.add(view);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	public void launch() {
		window.setVisible(true);
		watch.start();
	}

}
