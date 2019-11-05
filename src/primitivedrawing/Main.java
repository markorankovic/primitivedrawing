package primitivedrawing;

import java.awt.Component;

public class Main {

	public static void main(String[] args) {
		DrawingFrame gf = new DrawingFrame("primitivedrawing demo");
		int width = 600;
		int height = 600;
		gf.setSize(width, height);
		gf.setVisible(true);
        
		DrawingCommandProcessor dcp = new DrawingCommandProcessor((DrawingContext) new DrawingGraphics(width, height));
		gf.add((Component) dcp.dc);
		
		CommandFrame commandFrame = new CommandFrame(dcp);
		int w = 300;
		int h = 500;
		commandFrame.setTitle("commands");
		commandFrame.setSize(w, h);
		commandFrame.setVisible(true);
	}

}
