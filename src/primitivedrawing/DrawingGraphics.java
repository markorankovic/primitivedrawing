package primitivedrawing;

import java.awt.Canvas;
import java.awt.Graphics;

public class DrawingGraphics extends Canvas implements DrawingContext  {

	private static final long serialVersionUID = 1L;

	Position currentPosition = new Position();
	
	public DrawingGraphics() {
		System.out.println(this.getGraphics());
	}
	
	Graphic rootGraphic;
	
	@Override
	public void paint(Graphics g) {
		rootGraphic.drawTree(g);
	}
	
	@Override
	public void clear() {
		this.getGraphics().clearRect(0, 0, this.getWidth(), this.getHeight());
	}

	@Override
	public void reset() {
		
	}

	@Override
	public void position(int x, int y) {
		currentPosition = new Position(x, y);
	}

	@Override
	public void drawTo(int x, int y) {
		//this.getGraphics().drawLine(currentPosition.x, currentPosition.y, x, y);
	}

	@Override
	public void drawRect(int width, int height) {
		//this.getGraphics().drawRect(currentPosition.x, currentPosition.y, width, height);
	}

	@Override
	public void drawCircle(int r) {
		//this.getGraphics().drawOval(currentPosition.x, currentPosition.y, r * 2, r * 2);
	}

	@Override
	public void drawTriangle(int width, int height) {
		//this.getGraphics().drawPolyline(new int[]{currentPosition.x, currentPosition.x + width, currentPosition.x + width/2}, new int[]{currentPosition.y - height, currentPosition.y - height, currentPosition.y}, 3); 
	}

}
