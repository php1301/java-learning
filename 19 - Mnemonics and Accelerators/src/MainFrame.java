import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.Normalizer.Form;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class MainFrame extends JFrame {
	private TextPanel textPanel;
//	private JButton btn;
	private Toolbar toolbar;
	private FormPanel formPanel;

	public MainFrame() {
		textPanel = new TextPanel();
//		btn = new JButton("Click Me");
		toolbar = new Toolbar();
		formPanel = new FormPanel();
//		Anonymous class
		toolbar.setStringListener(new StringListener() {

			@Override
			public void textEmitted(String text) {
//				System.out.println(text);
				textPanel.appendText(text);
			}
		});

		formPanel.setFormListener(new FormListener() {

			@Override
			public void formEventOccured(FormEvent e) {
				String name = e.getName();
				String occupation = e.getOccupation();
				int ageCat = e.getAgeCateogry();
				String empCat = e.getEmpCategory();
				String gender = e.getGender();
				System.out.println(ageCat);
				textPanel.appendText(name + ": " + occupation + "- ageCat " + ageCat + " Employment" + empCat
						+ " Gender" + gender + "\n");
			}
		});

		add(textPanel, BorderLayout.CENTER);
//		add(btn, BorderLayout.SOUTH);
		add(toolbar, BorderLayout.NORTH);
		add(formPanel, BorderLayout.WEST);
//		btn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				textPanel.appendText("Hello\n");
//			}
//		});

		System.out.print("test");
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
		JCheckBoxMenuItem showFormItem = new JCheckBoxMenuItem("Person form");
		showFormItem.setSelected(true);
		showMenu.add(showFormItem);
		windowMenu.add(showMenu);
		
		menuBar.add(fileMenu);
		menuBar.add(windowMenu);
		
		showFormItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem)e.getSource();
				
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
				System.exit(0);
			}
		});
		return menuBar;
	}
}
