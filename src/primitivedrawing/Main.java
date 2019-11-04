package primitivedrawing;

import java.awt.Component;

public class Main {

	public static void main(String[] args) {
		DrawingFrame gf = new DrawingFrame("primitivedrawing demo");
		gf.setSize(500, 500);
        gf.setVisible(true);  
        
		DrawingCommandProcessor dcp = new DrawingCommandProcessor((DrawingContext) new DrawingGraphics());
		gf.add((Component) dcp.dc);
		
		dcp.dc.drawCircle(100);
				
		System.out.println(1);
	}

}
