package primitivedrawing;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class CommandFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	CommandProcessor commandProcessor;
	
	CommandTextArea commandList = new CommandTextArea(false);
	
	CommandTextArea commandEntry = new CommandTextArea(true);
	
	public CommandFrame(CommandProcessor commandProcessor) {
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		this.commandProcessor = commandProcessor;
		listPanel.add(commandList);
		listPanel.add(commandEntry);
		add(listPanel);
	}

}
