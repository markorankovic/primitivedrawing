package primitivedrawing;

import java.awt.Graphics;

public class Circle extends Graphic {
	
	int radius;
	Position position;
	
	public Circle(Position position, int r) {
		this.position = position;
		this.radius = r;
	}
	
	@Override
	void draw(Graphics g) {
		g.drawOval(position.x, position.y, radius * 2, radius * 2);
	}
	
}
