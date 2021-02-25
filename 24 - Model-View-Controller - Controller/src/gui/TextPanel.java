package gui;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextPanel extends JPanel {
	private JTextArea textarea;

	// Constructor
	public TextPanel() {
		textarea = new JTextArea();
		setLayout(new BorderLayout());
		add(new JScrollPane(textarea), BorderLayout.CENTER);

	}
	
	public void appendText(String text) {
		textarea.append(text);
	}
}
