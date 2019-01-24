package kata7.model;

public final class Time {
	
    private static final double SecondsPerStep = 2 * Math.PI / 60;
    private static final double MinutesPerStep = SecondsPerStep / 60;
    private static final double HoursPerStep = MinutesPerStep / 24;

    private double seconds = Math.PI / 2;
    private double minutes = Math.PI / 2;
    private double hours = Math.PI / 2;

	public Time() {

	}

	public void step() {
		
		seconds = normalize(seconds + SecondsPerStep);
		minutes = normalize(minutes + MinutesPerStep);
		hours = normalize(hours + HoursPerStep);
		
	}
	
	private double normalize(double n) {
		return (n % (2 * Math.PI));
	}
	
	public void set(int hours, int minutes, int seconds) {
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public double getHours() {
		return hours;
	}

	public double getMinutes() {
		return minutes;
	}

	public double getSeconds() {
		return seconds;
	}

	@Override
	public String toString() {
		return "Time [hours=" + hours + ", minutes=" + minutes + ", seconds=" + seconds + "]";
	}
	
	


}
