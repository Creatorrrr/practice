package frame;

import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.GridLayout;

public class SGPrintPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public SGPrintPanel() {
		setLayout(new GridLayout(1, 1, 0, 0));
		
		table = new JTable(5, 5);
		add(table);

	}

}
