package primitivedrawing;

public class DrawingCommandProcessor extends CommandProcessor {

	DrawingContext dc;
	
	@Override
	void initializeCommandReference() {
		commandReference.put("rect", new RectCommand(this));
		commandReference.put("circle", new CircleCommand(this));
		commandReference.put("triangle", new TriangleCommand(this));
		commandReference.put("drawto", new DrawToCommand(this));
		commandReference.put("position", new PositionCommand(this));
		commandReference.put("clear", new ClearCommand(this));
		commandReference.put("reset", new ResetCommand(this));
	}
		
	public DrawingCommandProcessor() {
		super();
		initializeCommandReference();											
	}
	
	public DrawingCommandProcessor(DrawingContext dc) {
		this();
		this.dc = dc;
	}
	
}
