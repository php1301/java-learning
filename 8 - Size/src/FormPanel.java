import java.awt.Dimension;

import javax.swing.JPanel;

public class FormPanel extends JPanel {
	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		System.out.println(dim);
	}
}
