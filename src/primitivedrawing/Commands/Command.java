package primitivedrawing.Commands;

import java.util.ArrayList;

import primitivedrawing.CommandProcessor;
import primitivedrawing.Executable;

public class Command implements Executable {
	
	CommandProcessor processor;
		
	public Command(CommandProcessor processor) {
		this.processor = processor;
	}
	
	public ArrayList<String> arguments = new ArrayList<String>();
	
	int numberOfArguments = 0;
		
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
	
	public boolean argumentsValid() {
		return validNumberOfArguments() && arguments.size() == 0;
	}

}
