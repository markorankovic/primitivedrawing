package primitivedrawing;

import java.util.ArrayList;

public class Command implements Executable {
	
	CommandProcessor processor;
		
	public Command(CommandProcessor processor) {
		this.processor = processor;
	}
	
	public ArrayList<String> arguments = new ArrayList<String>();
	
	int numberOfArguments;
		
	@Override
	public void execution() { }
	
	boolean validNumberOfArguments() {
		if (arguments.size() != numberOfArguments) {
			System.out.println("Invalid number of arguments");
			return false;
		}
		return true;
	}
	
	boolean validArgumentTypes() {
		return false;
	}
	
	boolean argumentsValid() {
		return validNumberOfArguments() && validArgumentTypes();
	}

}
