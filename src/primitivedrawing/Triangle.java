package primitivedrawing;

import java.awt.Graphics;

public class Triangle extends Graphic {
	
	int width;
	int height;
	Position position;
	
	public Triangle(Position position, int width, int height) {
		this.width = width;
		this.height = height;
		this.position = position;
	}
	
	@Override
	void draw(Graphics g) {
		Position p = position;
		g.drawPolygon(new int[]{p.x, p.x + width, p.x + width/2}, new int[]{p.y + height, p.y + height, p.y}, 3);
	}

}
