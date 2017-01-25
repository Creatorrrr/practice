package frame;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constants.SGConstants.ELabelItems;
import controller.SGStudent;

public class SGPrintPanel extends JPanel {
	
	private JTable table;
	private DefaultTableModel tableModel;

	public SGPrintPanel() {
		tableModel = new DefaultTableModel();
		
		for(ELabelItems e : ELabelItems.values()) {
			tableModel.addColumn(e.name());
		}
		
		setLayout(new GridLayout(1, 1, 0, 0));	
		
		table = new JTable(tableModel);
		
		add(new JScrollPane(table));
	}
	
	public void setTable(ArrayList<SGStudent> studentList) {
		
		tableModel.getDataVector().removeAllElements();	// tableModel���� ��� �������� vector�� �ҷ��� �� ��� ����
		
		for(SGStudent s : studentList) {
			tableModel.addRow(s.getArray());
		}
	}

}
