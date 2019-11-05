package primitivedrawing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import primitivedrawing.Commands.Command;
import primitivedrawing.Commands.RunCommand;

public class CommandProcessor {

	public static HashMap<String, Class<? extends Command>> commandReference = new HashMap<String, Class<? extends Command>>();
	
	
	ArrayList<Command> commandHistory = new ArrayList<Command>();
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
		commandHistory.add(command);
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
	
	ArrayList<String> commandsToStrings() {
		ArrayList<String> result = new ArrayList<String>();
		for (Command command : commandHistory) {
			result.add(command.toString());
		}
		return result;
	}
	
	void saveCommandsToFile(File file) {
		String result = "";
		System.out.println(commandsToStrings());
		for (String command : commandsToStrings()) {
			result += command + "\n";
			System.out.println(result);
		}
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(result);
			writer.close();
		} catch (IOException e) { }
	}
	
	void clearCommandList() {
		commandList.setText("");
	}
	
	void loadCommandsFromFile(File file) {
		clearCommandList();
		commands.clear();
		ArrayList<String> input = readInputFromFile(file);
		for (String line : input) {
			if (parseCommandString(line) == null) {
				commands.clear();
				return;
			}
			commandList.setText(commandList.getText() + line + "\n");
		}
	}
	
	private ArrayList<String> readInputFromFile(File file) {
		ArrayList<String> input = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				input.add(scanner.nextLine());
			}
			scanner.close();
		} catch (FileNotFoundException e) { }
		return input;
	}
	
	public CommandProcessor() { }
	
}
