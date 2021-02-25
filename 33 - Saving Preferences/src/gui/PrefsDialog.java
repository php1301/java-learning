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
import javax.swing.SpinnerNumberModel;

public class PrefsDialog extends JDialog {
	private JButton okBtn;
	private JButton cancelBtn;
	private JSpinner spinner;
	private SpinnerNumberModel spinnerModel;
	private JTextField username;
	private JPasswordField password;
	private PrefsListener prefsListener;

	public PrefsDialog(JFrame parent) {
		super(parent, "Preferences", false);
		setSize(400, 500);

		okBtn = new JButton("Ok");
		cancelBtn = new JButton("Cancel");

		spinnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
		spinner = new JSpinner(spinnerModel);

		username = new JTextField(10);
		password = new JPasswordField(10);

		password.setEchoChar('*');
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

//		First
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		add(new JLabel("Username: "), gc);
		gc.gridx++;
		add(username, gc);
//		Second
		gc.gridx = 0;
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		add(new JLabel("Password: "), gc);
		gc.gridx++;
		add(password, gc);

//		Third
		gc.gridx = 0;
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;

		add(new JLabel("Port: "), gc);
		gc.gridx++;
		add(spinner, gc);

//		Fourth
		gc.gridy++;
		gc.gridx = 0;
		add(okBtn, gc);
		okBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Integer port = (Integer) spinner.getValue();
				String usernameVal = username.getText();
				char[] passwordVal = password.getPassword();

				System.out.println(new String(passwordVal));

				if (prefsListener != null) {
					prefsListener.preferencesSet(usernameVal, new String(passwordVal), port);
					setVisible(false);
				}
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

	public void setPreferListener(PrefsListener listener) {
		this.prefsListener = listener;
	}
	
	public void setDefautls(String user, String pass, int port) {
		username.setText(user);
		password.setText(pass);
		spinner.setValue(port);
		
	}
}
