package primitivedrawing;

public interface DrawingContext {

	public void clear();
	public void reset();
	public void position(int x, int y);
	public void drawTo(int x, int y);
	public void drawRect(int width, int height);
	public void drawCircle(int r);
	public void drawTriangle(int width, int height);
	
}
