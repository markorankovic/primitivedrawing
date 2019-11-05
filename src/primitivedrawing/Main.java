package primitivedrawing;

import java.awt.Component;

public class Main {

	public static void main(String[] args) {
		int width = 600;
		int height = 600;
				
		DrawingFrame gf = new DrawingFrame("primitivedrawing demo");
		DrawingCommandProcessor dcp = new DrawingCommandProcessor((DrawingContext) new DrawingGraphics(width, height));
		CommandFrame commandFrame = new CommandFrame(dcp);

		gf.setSize(width, height);
		gf.setVisible(true);
        
		gf.add((Component) dcp.dc);
		
		//System.out.println(dcp.commandReference);
		int w = 300;
		int h = 500;
		commandFrame.setTitle("commands");
		commandFrame.setSize(w, h);
		commandFrame.setVisible(true);
	}

}
