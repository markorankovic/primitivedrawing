package primitivedrawing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CommandProcessor {

	static HashMap<String, Command> commandReference = new HashMap<String, Command>();
	
	void initializeCommandReference() {
	}
					
	ArrayList<String> getProcessedInput(String input) {
		String lowercaseInput = input.toLowerCase();
		System.out.println(lowercaseInput);
		if (!lowercaseInput.matches("^((\\w+)( \\d+(, \\d+)*)?)$")) {
			return null;
		}
		String[] lowercaseInputSeparatedBySpaceAndComma = lowercaseInput.split(" |, ");	
		ArrayList<String> processedInput = new ArrayList<String>();
		for (String str : lowercaseInputSeparatedBySpaceAndComma) {
			processedInput.add(str);
		}
		return processedInput;
	}
	
	Command getCommand(ArrayList<String> processedInput) {
		return commandReference.get(processedInput.get(0));
	}
	
	void setArguments(Command command, ArrayList<String> processedInput) {
		for (int i = 1; i < processedInput.size(); i++) {
			command.arguments.add(processedInput.get(i));
		}
	}
	
	ArrayList<String> readInputFromFile(String fileName) {
		ArrayList<String> input = new ArrayList<String>();
		File file = new File(fileName);
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				input.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	public CommandProcessor() { }
	
}
