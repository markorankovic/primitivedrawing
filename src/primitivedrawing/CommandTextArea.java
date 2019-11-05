package primitivedrawing;

import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CommandTextArea extends TextArea implements KeyListener {

	private static final long serialVersionUID = 1L;
	
	CommandFrame frame;
	
	public CommandTextArea(boolean editable, CommandFrame frame) {
		setEditable(editable);
		this.frame = frame;
		addKeyListener(this);
	}
	
	void sendInput(String input, CommandTextArea to) {
		to.setText(to.getText() + input);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (isEditable()) {
				sendInput(getText(), frame.commandList);
				frame.commandEntry.setText("");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
