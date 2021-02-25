package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.Controller;

public class MainFrame extends JFrame {
	private TextPanel textPanel;
//	private JButton btn;
	private Toolbar toolbar;
	private FormPanel formPanel;
	private JFileChooser fileChooser;
	private TablePanel tablePanel;
	private Controller controller;
	private PrefsDialog dialog;
	private Preferences prefs;

	public MainFrame() {
		textPanel = new TextPanel();
//		btn = new JButton("Click Me");
		toolbar = new Toolbar();
		formPanel = new FormPanel();
		fileChooser = new JFileChooser();
		fileChooser.addChoosableFileFilter(new PersonFileFilter());
		tablePanel = new TablePanel();
		controller = new Controller();
		dialog = new PrefsDialog(this);
		prefs = Preferences.userRoot().node("db");
		tablePanel.setData(controller.getPeople());
		tablePanel.setPersonTableListener(new PersonTableListener() {
			public void rowDeleted(int row) {
				controller.removePerson(row);
			}
		});
//		Anonymous class
		toolbar.setStringListener(new StringListener() {

			public void textEmitted(String text) {
//				System.out.println(text);
				textPanel.appendText(text);
			}
		});

		formPanel.setFormListener(new FormListener() {

			public void formEventOccured(FormEvent e) {
				controller.addPerson(e);
				tablePanel.refresh();
			}
		});

//		Dialog
		dialog.setPreferListener(new PrefsListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void preferencesSet(String user, String password, int portNumber) {
				prefs.put("user", user);
				prefs.put("password", password);
				prefs.put("portNumber", new Integer(portNumber).toString());
			}
		});

		String user = prefs.get("user", "");
		String password = prefs.get("password", "");
		Integer port = prefs.getInt("portNumber", 3306);
		dialog.setDefautls(user, password, port);
		
//		add(textPanel, BorderLayout.CENTER);
//		add(btn, BorderLayout.SOUTH);
		add(toolbar, BorderLayout.NORTH);
		add(formPanel, BorderLayout.WEST);
		add(tablePanel, BorderLayout.CENTER);
//		btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				textPanel.appendText("Hello\n");
//			}
//		});

		setMinimumSize(new Dimension(500, 400));
		setSize(600, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setJMenuBar(createMenuBar());

	}

	private JMenuBar createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenuItem exportDataItem = new JMenuItem("Export Data....");
		JMenuItem importDataItem = new JMenuItem("Import Data....");
		JMenuItem exitItem = new JMenuItem("Exit");

		JMenu fileMenu = new JMenu("File");
		fileMenu.add(exportDataItem);
		fileMenu.add(importDataItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		JMenu windowMenu = new JMenu("Window");
		JMenu showMenu = new JMenu("Show");
		JMenuItem prefsItem = new JMenuItem("Preferences...");

		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person form");
		showFormItem.setSelected(true);
		showMenu.add(showFormItem);

		windowMenu.add(showMenu);
		windowMenu.add(prefsItem);

		menuBar.add(fileMenu);
		menuBar.add(windowMenu);

		showFormItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();

				formPanel.setVisible(menuItem.isSelected());
			}
		});
//		gan key F
		fileMenu.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);

//		Accelerators
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

		exitItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = JOptionPane.showInputDialog(MainFrame.this, "Enter your Username", "Exit User Name",
						JOptionPane.OK_OPTION | JOptionPane.QUESTION_MESSAGE);
				System.out.println(text);
//				Display trên component cha nào
				int action = JOptionPane.showConfirmDialog(MainFrame.this, "Do you really want to exit", "Exit Confirm",
						JOptionPane.OK_CANCEL_OPTION);
				if (action == JOptionPane.OK_OPTION)
					System.exit(0);
			}
		});

//		File Chooser
		importDataItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ((fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)) {
					try {
						controller.loadFromFile(fileChooser.getSelectedFile());
						tablePanel.refresh();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, "File import failed", "Failed",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		exportDataItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if ((fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION)) {
					try {
						controller.saveToFile(fileChooser.getSelectedFile());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(MainFrame.this, "File save failed", "Failed",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		// Dialog
		prefsItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);

			}
		});
		return menuBar;
	}
}
