package primitivedrawing;

public class DrawingCommandProcessor extends CommandProcessor {
	
	DrawingContext dc;

	@SuppressWarnings("unchecked")
	@Override
	void initializeCommandReference() {
		commandReference.put("rect", (Class<Command>) RectCommand.class.getSuperclass());
		commandReference.put("circle", (Class<Command>) CircleCommand.class.getSuperclass());
		commandReference.put("triangle", (Class<Command>) TriangleCommand.class.getSuperclass());
		commandReference.put("drawto", (Class<Command>) DrawToCommand.class.getSuperclass());
		commandReference.put("position", (Class<Command>) PositionCommand.class.getSuperclass());
		commandReference.put("clear", (Class<Command>) ClearCommand.class.getSuperclass());
		commandReference.put("reset", (Class<Command>) ResetCommand.class.getSuperclass());
		commandReference.put("run", (Class<Command>) RunCommand.class.getSuperclass());
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
