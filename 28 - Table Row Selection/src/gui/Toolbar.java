package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {

	private JButton helloButton;
	private JButton goodbyeButton;

//	Separate cac components ra voi nhau
//	interface co the la bat ki cai gi
	private StringListener textListener;

	public Toolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		helloButton = new JButton("Hello");
		goodbyeButton = new JButton("Goodbye");

		helloButton.addActionListener(this);
		goodbyeButton.addActionListener(this);

//		Flow Layout - more control

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(helloButton);
		add(goodbyeButton);
	}

	public void setStringListener(StringListener listener) {
//		gan vo bien private
		this.textListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		Ep kieu
		JButton clicked = (JButton) e.getSource();

		if (textListener != null) {
			if (clicked == helloButton) {
				textListener.textEmitted("Hello\n");
			}

			else {
				textListener.textEmitted("Goodbye\n");
			}

		}
	}
}
