package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;

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
		setSize(340, 230);

		okBtn = new JButton("Ok");
		cancelBtn = new JButton("Cancel");

		spinnerModel = new SpinnerNumberModel(3306, 0, 9999, 1);
		spinner = new JSpinner(spinnerModel);

		username = new JTextField(10);
		password = new JPasswordField(10);

		password.setEchoChar('*');
		layoutControl();
		// dialog can theo parent
		setLocationRelativeTo(parent);
		
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
		
		cancelBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
	}

	public void setPreferListener(PrefsListener listener) {
		this.prefsListener = listener;
	}

	public void setDefautls(String user, String pass, int port) {
		username.setText(user);
		password.setText(pass);
		spinner.setValue(port);

	}

	private void layoutControl() {
		int space = 15;
		JPanel controlsPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		Border spaceBorder = BorderFactory.createEmptyBorder(space, space, space, space);
		Border titleBorders = BorderFactory.createTitledBorder("Database Preferences");
		
		controlsPanel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		controlsPanel.setBorder(BorderFactory.createCompoundBorder(spaceBorder, titleBorders));
		buttonsPanel.setBorder(BorderFactory.createLineBorder(Color.black));

//		First
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = new Insets(0, 0, 0, 15);
		controlsPanel.add(new JLabel("Username: "), gc);
		gc.gridx++;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.WEST;
		controlsPanel.add(username, gc);

//		Second
		gc.gridx = 0;
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = new Insets(0, 0, 0, 15);
		controlsPanel.add(new JLabel("Password: "), gc);
		gc.gridx++;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.WEST;
		controlsPanel.add(password, gc);

//		Third
		gc.gridx = 0;
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets = new Insets(0, 0, 0, 15);
		controlsPanel.add(new JLabel("Port: "), gc);
		gc.gridx++;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.WEST;
		controlsPanel.add(spinner, gc);

//		Fourth - B
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		buttonsPanel.add(okBtn, gc);
		buttonsPanel.add(cancelBtn, gc);
		

// 		2 buttons size bang nhau
		Dimension btnSize = cancelBtn.getPreferredSize();
		okBtn.setPreferredSize(btnSize);

//		add sub panels to dialog
		setLayout(new BorderLayout());
		add(controlsPanel, BorderLayout.CENTER);
		add(buttonsPanel, BorderLayout.SOUTH);
	}
}
