package primitivedrawing;

import java.awt.Graphics;

public class Rect extends Graphic {

	int width;
	int height;
	Position position;
	
	public Rect(Position position, int width, int height) {
		this.width = width;
		this.height = height;
		this.position = position;
	}
	
	@Override
	void draw(Graphics g) {
		g.drawRect(position.x, position.y, width, height);
	}
	
}
