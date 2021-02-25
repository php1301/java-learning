package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

public class PrefsDialog extends JDialog {
	private JButton okBtn;
	private JButton cancelBtn;
	private JSpinner spinner;
	private SpinnerNumberModel spinnerModel;

	public PrefsDialog(JFrame parent) {
		super(parent, "Preferences", false);
		setSize(400, 500);

		okBtn = new JButton("Ok");
		cancelBtn = new JButton("Cancel");

		spinnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
		spinner = new JSpinner(spinnerModel);

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

//		First
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		add(new JLabel("Port: "), gc);
		gc.gridx++;
		add(spinner, gc);
//		Second
		gc.gridy++;
		gc.gridx = 0;
		add(okBtn, gc);
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Integer value = (Integer) spinner.getValue();
			}
		});
		gc.gridx++;
		add(cancelBtn, gc);
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		// dialog can theo parent
		setLocationRelativeTo(parent);
	}
}
