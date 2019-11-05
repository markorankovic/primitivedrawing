package primitivedrawing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import primitivedrawing.Graphics.Circle;
import primitivedrawing.Graphics.Graphic;
import primitivedrawing.Graphics.Line;
import primitivedrawing.Graphics.Rect;
import primitivedrawing.Graphics.Triangle;

public class DrawingGraphics extends Canvas implements DrawingContext, FocusListener  {

	private static final long serialVersionUID = 1L;

	Position currentPosition = new Position();
		
	Graphic rootGraphic = new Graphic();
	
	public DrawingGraphics(int width, int height) {
		super.setSize(width, height);
		this.addFocusListener(this);
	}
		
	@Override
	public void paint(Graphics g) {
		rootGraphic.drawTree(g);
	}
		
	@Override
	public void clear() {
		rootGraphic.children.clear();
	}

	@Override
	public void reset() {
		currentPosition = new Position();
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
	public void focusGained(FocusEvent e) {
		System.out.println(5);
		repaint();
	}

	@Override
	public void focusLost(FocusEvent e) { }

	@Override
	public void getFocus() {
		this.requestFocus();
	}

	@Override
	public void setColor(int r, int g, int b) {
		System.out.println(this.getGraphics());
		this.getGraphics().setColor(new Color(r, g, b));
		System.out.println(b);
		System.out.println(this.getGraphics().getColor());
	}
	
}
