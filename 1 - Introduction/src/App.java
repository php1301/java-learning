import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
//		Multi Thread
		SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							JFrame frame = new JFrame("Hello World");
							frame.setVisible(true);
							frame.setSize(600, 500);
							frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});

	}
	
	

}
