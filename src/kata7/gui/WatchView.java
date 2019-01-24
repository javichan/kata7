package kata7.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import kata7.model.Time;

public class WatchView extends JPanel {
	
	private Image background;
	private Point backgroundPos;
	private Line[] sticks;
	
	private final Dimension size = new Dimension(900, 600);
	
	public WatchView() {

		setPreferredSize(size);
		
		createSticks();
		
		try {
			
			background = ImageIO.read(new File("resources/watch_background.jpg"));
			
			backgroundPos = new Point(background.getWidth(null)/2,
					background.getHeight(null)/2);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private void createSticks() {

		sticks = new Line[3];
		
		sticks[0] = new Line(new Point(size.width/2, size.height/2),
				new Point(size.width/2, 0), 120);
		
		sticks[1] = new Line(new Point(size.width/2, size.height/2),
				new Point(size.width/2, 0), 90);
		
		sticks[2] = new Line(new Point(size.width/2, size.height/2),
				new Point(size.width/2, 0), 50);
		
	}

	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		
		clear(g);
		
		render((Graphics2D) g);
		
		g.dispose();
		
	}
	
	public void render(Time time) {
		
		sticks[0].rotate(time.getSeconds());
		sticks[1].rotate(time.getMinutes());
		sticks[2].rotate(time.getHours());
		
		repaint();
		
	}
	
	private void render(Graphics2D g) {
		
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		
		g.drawImage(background, getWidth()/2-backgroundPos.x,
				getHeight()/2-backgroundPos.y, null);
		
		final Color[] colors = {Color.RED, Color.BLUE, Color.BLACK};
		
		for(int i = 0;i < 3;i++) {
			
			g.setColor(colors[i]);
			
			g.setStroke(new BasicStroke(i+1));
			
			Line line = sticks[i];

			g.drawLine(line.startX(), line.startY(), line.endX(), line.endY());
			
		}
		
	}

	private void clear(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
	}

}
