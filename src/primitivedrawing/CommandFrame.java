package primitivedrawing;

import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class CommandFrame extends PrimitiveFrame {

	private static final long serialVersionUID = 1L;
	
	CommandProcessor commandProcessor;
	
	CommandTextArea commandList = new CommandTextArea(false, this);
	
	CommandTextArea commandEntry = new CommandTextArea(true, this);
	
	public CommandFrame(CommandProcessor commandProcessor) {
		JPanel listPanel = new JPanel();
		listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));
		this.commandProcessor = commandProcessor;
		listPanel.add(commandList);
		listPanel.add(commandEntry);
		add(listPanel);
		commandProcessor.commandList = commandList;
		createMenuBar();
	}
	
	void openFile() {
	    JFileChooser chooser = new JFileChooser();
        int returnValue = chooser.showOpenDialog( null ) ;
        if (returnValue == JFileChooser.APPROVE_OPTION ) {
        	File file = chooser.getSelectedFile();
        	commandProcessor.loadCommandsFromFile(file);
        }
	}
	
	void saveFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");   
		 
		int userSelection = fileChooser.showSaveDialog(this);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    commandProcessor.saveCommandsToFile(fileToSave);
		    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
		}	
	}
	
    private void createMenuBar() {
        var menuBar = new JMenuBar();

        var fileMenu = new JMenu("File");
        
        var openMenuItem = new JMenuItem("Open");
        openMenuItem.addActionListener((event) -> openFile());
        
        var saveMenuItem = new JMenuItem("Save");
        saveMenuItem.addActionListener((event) -> saveFile());


        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);

        setJMenuBar(menuBar);
    }

}