import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame{
	private TextPanel textPanel;
//	private JButton btn;
	private Toolbar toolbar;
	
	public MainFrame() {
		textPanel = new TextPanel();
//		btn = new JButton("Click Me");
		toolbar = new Toolbar();
		toolbar.setTextPanel(textPanel);
		
		add(textPanel, BorderLayout.CENTER);
//		add(btn, BorderLayout.SOUTH);
		add(toolbar, BorderLayout.NORTH);
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
