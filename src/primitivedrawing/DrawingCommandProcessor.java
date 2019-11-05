package primitivedrawing;

public class DrawingCommandProcessor extends CommandProcessor {
	
	DrawingContext dc;

	@SuppressWarnings("unchecked")
	@Override
	void initializeCommandReference() {
		commandReference.put("rect", (Class<? extends Command>) RectCommand.class);
		commandReference.put("circle", (Class<? extends Command>) CircleCommand.class);
		commandReference.put("triangle", (Class<? extends Command>) TriangleCommand.class);
		commandReference.put("drawto", (Class<? extends Command>) DrawToCommand.class);
		commandReference.put("position", (Class<? extends Command>) PositionCommand.class);
		commandReference.put("clear", (Class<? extends Command>) ClearCommand.class);
		commandReference.put("reset", (Class<? extends Command>) ResetCommand.class);
		commandReference.put("run", (Class<? extends Command>) RunCommand.class);
	}
		
	public DrawingCommandProcessor() {
		super();
		initializeCommandReference();											
	}
	
	public DrawingCommandProcessor(DrawingContext dc) {
		this();
		this.dc = dc;
	}
	
	void setFocusToGraphics() {
		dc.getFocus();
	}
	
	@Override
	Command parseCommandString(String commandString) {
		Command command = super.parseCommandString(commandString);
		if (command == null) {
			return null;
		}
		if (command.getClass() == RunCommand.class) {
			setFocusToGraphics();
		}
		return command;
	}
	
}
