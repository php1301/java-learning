import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	private JTextArea textarea;
	private JButton btn;

	public MainFrame() {
		textarea = new JTextArea();
		btn = new JButton("Click Me");

		add(textarea, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);

//		lang nghe su kien

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textarea.append("Hello\n");
			}
		});
		setVisible(true);
		setSize(600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
