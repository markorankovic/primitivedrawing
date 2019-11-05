package primitivedrawing;

import java.awt.Graphics;
import java.util.ArrayList;

public class Graphic {

	ArrayList<Graphic> children = new ArrayList<Graphic>();
	
	public void drawTree(Graphics graphics) {
		draw(graphics);
		for (Graphic child : children) {
			child.drawTree(graphics);
		}
	}
	
	void add(Graphic graphic) {
		children.add(graphic);
	}

	void draw(Graphics graphics) { }
	
}
