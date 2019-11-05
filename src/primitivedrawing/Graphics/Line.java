package primitivedrawing.Graphics;

import java.awt.Graphics;

import primitivedrawing.Position;

public class Line extends Graphic {

	Position startPosition;
	Position endPosition;
	
	public Line(Position startPosition, Position endPosition) {
		this.startPosition = startPosition;
		this.endPosition = endPosition;
	}
	
	@Override
	void draw(Graphics g) {
		g.drawLine(startPosition.x, startPosition.y, endPosition.x, endPosition.y);
	}
	
}