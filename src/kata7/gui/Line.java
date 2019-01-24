package kata7.gui;

import java.awt.Point;

public class Line {
	
	private final Point start;
	private Point end;
	private int length;
	
	public Line(Point start, Point end, int length) {
		this.start = start;
		this.end = end;
		this.length = length;
	}
	
	public void rotate(final double angle) {
		Point point = 
				new Point((int)(Math.cos(angle)*length), (int)(Math.sin(angle)*length));
		
		end.setLocation(start.x - point.x, start.y - point.y);
	}

	public int getWidth() {
		return length;
	}
	
	public int startX() {
		return start.x;
	}
	
	public int startY() {
		return start.y;
	}
	
	public int endX() {
		return end.x;
	}
	
	public int endY() {
		return end.y;
	}
	
}
