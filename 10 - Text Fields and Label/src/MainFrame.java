import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer.Form;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame{
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
		
	}
}
