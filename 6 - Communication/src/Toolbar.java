import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {

	private JButton helloButton;
	private JButton goodbyeButton;
	
	private TextPanel textPanel;

	public Toolbar() {
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye");

		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);

//		Flow Layout - more control

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(helloButton);
		add(goodbyeButton);
	}

	public void setTextPanel(TextPanel textPanel) {
//		gan vo bien private
		this.textPanel = textPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		Ep kieu
		JButton clicked = (JButton) e.getSource();
		if (clicked == helloButton)
//			System.out.println("Hello");
			textPanel.appendText("Hello\n");
		else
//			System.out.println("Goodbye");
			textPanel.appendText("Goodbye\n");
	}
}
