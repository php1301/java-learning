import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel {

	private JButton helloButton;
	private JButton goodbyeButton;

	public Toolbar() {
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye");

//		Flow Layout - more control

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(helloButton);
		add(goodbyeButton);
	}
}
