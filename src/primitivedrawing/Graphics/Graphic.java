package primitivedrawing.Graphics;

import java.awt.Graphics;
import java.util.ArrayList;

// Entity to be rendered onto a canvas
public class Graphic {

	public ArrayList<Graphic> children = new ArrayList<Graphic>();
	
	public void drawTree(Graphics graphics) {
		draw(graphics);
		for (Graphic child : children) {
			child.drawTree(graphics);
		}
	}
	
	public void add(Graphic graphic) {
		children.add(graphic);
	}

	void draw(Graphics graphics) { }
	
}
