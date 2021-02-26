package gui;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Toolbar extends JPanel implements ActionListener {

	private JButton saveButton;
	private JButton refreshButton;

//	Separate cac components ra voi nhau
//	interface co the la bat ki cai gi
	private ToolbarListener textListener;

	public Toolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		saveButton = new JButton("Save");
		refreshButton = new JButton("Refresh");

		saveButton.addActionListener(this);
		refreshButton.addActionListener(this);

//		Flow Layout - more control

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(saveButton);
		add(refreshButton);
	}

	public void setStringListener(ToolbarListener listener) {
//		gan vo bien private
		this.textListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		Ep kieu
		JButton clicked = (JButton) e.getSource();

		if (textListener != null) {
			if (clicked == saveButton) {
				textListener.saveEventOccured();
			}

			else {
				textListener.refreshEventOccured();
			}

		}
	}
}
