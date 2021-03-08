import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JProgressBar;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class WindowBuilderApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderApp window = new WindowBuilderApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowBuilderApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 670, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		frame.getContentPane().add(menuBar);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(formattedTextField_1);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		frame.getContentPane().add(formattedTextField);
		
		JProgressBar progressBar = new JProgressBar();
		frame.getContentPane().add(progressBar);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox, BorderLayout.NORTH);
		
		JComboBox comboBox_1 = new JComboBox();
		panel.add(comboBox_1, BorderLayout.WEST);
	}

}
