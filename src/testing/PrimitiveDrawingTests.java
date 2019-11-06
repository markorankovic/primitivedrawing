package testing;

import org.junit.Assert;
import org.junit.Test;
import primitivedrawing.DrawingCommandProcessor;
import primitivedrawing.Commands.CircleCommand;
import primitivedrawing.Commands.ClearCommand;
import primitivedrawing.Commands.ColorCommand;
import primitivedrawing.Commands.Command;
import primitivedrawing.Commands.DrawToCommand;
import primitivedrawing.Commands.PositionCommand;
import primitivedrawing.Commands.RectCommand;
import primitivedrawing.Commands.ResetCommand;
import primitivedrawing.Commands.RunCommand;
import primitivedrawing.Commands.TriangleCommand;

public class PrimitiveDrawingTests {

	DrawingCommandProcessor dcp = new DrawingCommandProcessor();
	
	@Test
	public void validCommandFormatTest() {
		Assert.assertTrue(commandStringValid("rect 450, 600"));
		Assert.assertTrue(commandStringValid("circle 800"));
		Assert.assertTrue(commandStringValid("position 645, 745"));
		Assert.assertTrue(commandStringValid("drawto 645, 745"));
		Assert.assertTrue(commandStringValid("triangle 567, 896"));
	}
	
	@Test
	public void invalidCommandFormatTest() {
		Assert.assertFalse(commandStringValid("rect, 450, 600"));
		Assert.assertFalse(commandStringValid("drawto479,876"));
		Assert.assertFalse(commandStringValid("triangle 479,876"));
		Assert.assertFalse(commandStringValid("drawto 645 745"));
		Assert.assertFalse(commandStringValid("triangle 567, 896,"));
	}
	
	@Test
	public void userInputToCommandTest() {
		Assert.assertTrue(commandInputEvaluation("rect", (Class<? extends Command>) RectCommand.class));
		Assert.assertTrue(commandInputEvaluation("circle", (Class<? extends Command>) CircleCommand.class));
		Assert.assertTrue(commandInputEvaluation("triangle", (Class<? extends Command>) TriangleCommand.class));
		Assert.assertTrue(commandInputEvaluation("drawto", (Class<? extends Command>) DrawToCommand.class));
		Assert.assertTrue(commandInputEvaluation("position", (Class<? extends Command>) PositionCommand.class));
		Assert.assertTrue(commandInputEvaluation("clear", (Class<? extends Command>) ClearCommand.class));
		Assert.assertTrue(commandInputEvaluation("reset", (Class<? extends Command>) ResetCommand.class));
		Assert.assertTrue(commandInputEvaluation("run", (Class<? extends Command>) RunCommand.class));
		Assert.assertTrue(commandInputEvaluation("color", (Class<? extends Command>) ColorCommand.class));
		
		Assert.assertFalse(commandInputEvaluation("fly", (Class<? extends Command>) ColorCommand.class));
		Assert.assertFalse(commandInputEvaluation("drive", (Class<? extends Command>) PositionCommand.class));
	}
		
	boolean commandStringValid(String input) {
		return dcp.isValidCommandInput(input);
	}
	
	boolean commandInputEvaluation(String input, Class<? extends Command> commandClass) {
		Class<? extends Command> value = DrawingCommandProcessor.commandReference.get(input);
		if (value == null) {
			return false;
		}
		return value.equals(commandClass);
	}

}
