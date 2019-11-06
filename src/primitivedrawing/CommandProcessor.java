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

	// Association between the command as a String and the command as a class
	public static HashMap<String, Class<? extends Command>> commandReference = new HashMap<String, Class<? extends Command>>();
	
	// History of added Commands
	ArrayList<Command> commandHistory = new ArrayList<Command>();
	
	// Commands due for execution
	ArrayList<Command> commands = new ArrayList<Command>();
	
	// Command line
	CommandTextArea commandList;
	
	void initializeCommandReference() { }
					
	// Returns an input processed to split the command from its arguments
	ArrayList<String> getProcessedInput(String input) {
		String lowercaseInput = input.toLowerCase();
		System.out.println(lowercaseInput);
		// Ensures input is in the format command arg1, arg2, arg3 ...
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
	
	// Adds a Command both to the list to be executed and the history of Commands
	void addCommand(Command command) {
		commands.add(command);
		commandHistory.add(command);
	}
	
	// Removes all Commands due for execution
	void removeAllCommands() {
		commands.removeAll(commands);
	}
	
	// The command line if present will display invalid command to user
	void reportInvalidToCommandLine() {
		if (commandList != null) {
			commandList.setText(commandList.getText() + "\n" + "Invalid command.");
		}
	}
		
	/* Takes an input string and creates the corresponding Command instance
	 * If the command is a Run Command then it executes all other Commands
	 */
	Command parseCommandString(String commandString) {
		Command command = createCommand(getProcessedInput(commandString));
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
		return command;
	}
	
	// Runs all typed commands
	void runCommands() {
		for (Command command : commands) {
			command.execution();
		}
	}
	
	// Creates a Command from processed user input
	Command createCommand(ArrayList<String> processedInput) {
		try {
			String key = processedInput.get(0);
			if (commandReference.containsKey(key)) {
				Class<? extends Command> cls = commandReference.get(processedInput.get(0));
				Command command;
				command = cls.getDeclaredConstructor(CommandProcessor.class).newInstance(this);
				System.out.println(command);
				setStringArguments(command, processedInput);
				return command.argumentsValid() ? command : null;
			}
		} catch (Exception e) { }
		return null;
	}
	
	// Sets arguments from String input to corresponding Command
	void setStringArguments(Command command, ArrayList<String> processedInput) {
		for (int i = 1; i < processedInput.size(); i++) {
			command.arguments.add(processedInput.get(i));
		}
	}
	
	// Gets list of commands executed to String
	ArrayList<String> commandsToStrings() {
		ArrayList<String> result = new ArrayList<String>();
		for (Command command : commandHistory) {
			result.add(command.toString());
		}
		return result;
	}
	
	// Saves the history of executed commands to file
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
	
	// Clear any existing command line
	void clearCommandList() {
		if (commandList != null) {
			commandList.setText("");
		}
	}
	
	// Loads command line input from file
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
	
	// Reads file as String
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
