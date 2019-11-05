package primitivedrawing;

import java.awt.Canvas;
import java.awt.Graphics;

public class DrawingGraphics extends Canvas implements DrawingContext  {

	private static final long serialVersionUID = 1L;

	Position currentPosition = new Position();
		
	Graphic rootGraphic = new Graphic();
	
	public DrawingGraphics(int width, int height) {
		super.setSize(width, height);;
	}
	
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
		rootGraphic.add(new Line(new Position(currentPosition.x, currentPosition.y), new Position(x, y)));
	}

	@Override
	public void drawRect(int width, int height) {
		rootGraphic.add(new Rect(new Position(currentPosition.x, currentPosition.y), width, height));
	}

	@Override
	public void drawCircle(int r) {
		rootGraphic.add(new Circle(currentPosition, r));
	}

	@Override
	public void drawTriangle(int width, int height) {
		rootGraphic.add(new Triangle(new Position(currentPosition.x, currentPosition.y), width, height));
	}

	@Override
	public void repaint() {
		System.out.println(getWidth());
		this.repaint(0, 0, this.getWidth(), this.getHeight());
	}

}
