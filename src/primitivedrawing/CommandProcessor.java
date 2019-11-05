package primitivedrawing;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CommandProcessor {

	static HashMap<String, Class<? extends Command>> commandReference = new HashMap<String, Class<? extends Command>>();
	
	ArrayList<Command> commands = new ArrayList<Command>();
	
	CommandTextArea commandList;
	
	void initializeCommandReference() { }
					
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
	
	void addCommand(Command command) {
		commands.add(command);
	}
	
	void removeAllCommands() {
		commands.removeAll(commands);
	}
	
	void reportInvalidToCommandLine() {
		if (commandList != null) {
			commandList.setText(commandList.getText() + "\n" + "Invalid command.");
		}
	}
		
	Command parseCommandString(String commandString) {
		Command command = createCommand(getProcessedInput(commandString));
		System.out.println(command);
		if (command == null) {
			reportInvalidToCommandLine();
			return null;
		}
		if (command.getClass() == RunCommand.class) {
			runCommands();
			commands.clear();
			return command;
		}
		addCommand(command);
		System.out.println(commands);
		return command;
	}
	
	void runCommands() {
		for (Command command : commands) {
			command.execution();
		}
	}
	
	Command createCommand(ArrayList<String> processedInput) {
		try {
			String key = processedInput.get(0);
			if (commandReference.containsKey(key)) {
				Class<? extends Command> cls = commandReference.get(processedInput.get(0));
				Command command;
				command = cls.getDeclaredConstructor(CommandProcessor.class).newInstance(this);
				System.out.println(command);
				setArguments(command, processedInput);
				return command.argumentsValid() ? command : null;
			}
		} catch (Exception e) { }
		return null;
	}
	
	void setArguments(Command command, ArrayList<String> processedInput) {
		for (int i = 1; i < processedInput.size(); i++) {
			command.arguments.add(processedInput.get(i));
		}
	}
	
	void loadCommandsFromFile(String fileName) {
		ArrayList<String> input = readInputFromFile(fileName);
		ArrayList<Command> commandList = new ArrayList<Command>();
		for (String line : input) {
			ArrayList<String> processedLine = getProcessedInput(line);
			Command command = createCommand(processedLine);
			commandList.add(command);
		}
		commands = commandList;
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
