package primitivedrawing;

import java.awt.Canvas;

public class DrawingGraphics extends Canvas implements DrawingContext  {

	private static final long serialVersionUID = 1L;

	@Override
	public void clear() {
		clear();
	}

	@Override
	public void reset() {
		reset();
	}

	@Override
	public void position(int x, int y) {
		position(x, y);
	}

	@Override
	public void drawTo(int x, int y) {
		drawTo(x, y);
	}

	@Override
	public void drawRect(int width, int height) {
		drawRect(width, height);
	}

	@Override
	public void drawCircle(int r) {
		drawCircle(r);
	}

	@Override
	public void drawTriangle(int width, int height) {
		drawTriangle(width, height);
	}

}
