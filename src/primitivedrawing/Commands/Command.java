package primitivedrawing.Commands;

import java.util.ArrayList;

import primitivedrawing.CommandProcessor;
import primitivedrawing.Executable;

public class Command implements Executable {
	
	CommandProcessor processor;
	
	String commandAsString = "Command"; // Command as string so the command can be saved into a file. 
		
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
		return validNumberOfArguments() && numberOfArguments == 0;
	}
	
	public String toString() {
		String result = "";
		result += commandAsString + " ";
		for (int i = 0; i < arguments.size(); i++) {
			result += arguments.get(i);
			if (i < arguments.size() - 1) {
				result += ", ";
			}
		}
		return result;
	}

}
