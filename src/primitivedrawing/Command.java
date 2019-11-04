package primitivedrawing;

import java.util.ArrayList;

public class Command implements Executable {
	
	CommandProcessor processor;
	
	public Command(CommandProcessor processor) {
		this.processor = processor;
	}
	
	public ArrayList<String> arguments = new ArrayList<String>();
		
	@Override
	public void execution() {
		
	}
	
	boolean validNumberOfArguments(int num) {
		if (arguments.size() != num) {
			System.out.println("Invalid number of arguments");
			return false;
		}
		return true;
	}

}
