package ui.impl;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constants.Constants.ECustomerMenuItems;
import constants.Constants.ECustomerTableItems;
import domain.Customer;
import service.CustomerService;
import service.impl.CustomerServiceLogic;
import ui.framework.customer.CustomerDialogUI;
import ui.framework.mainmenu.CustomerUI;
import ui.impl.customer.CustomerDeleteUILogic;
import ui.impl.customer.CustomerModifyUILogic;
import ui.impl.customer.CustomerPrintUILogic;
import ui.impl.customer.CustomerRegisterUILogic;
import ui.impl.customer.CustomerSearchUILogic;

public class CustomerUILogic extends JFrame implements CustomerUI {
	
	private JTable table;
	private DefaultTableModel tableModel;
	
	private CustomerService service;
	
	private CustomerDialogUI registerUI;
	private CustomerDialogUI modifyUI;
	private CustomerDialogUI searchUI;
	private CustomerDialogUI deleteUI;
	private CustomerDialogUI printUI;
	
	public CustomerUILogic() {
		table = null;
		tableModel = new DefaultTableModel();
		
		service = new CustomerServiceLogic();
		
		registerUI = new CustomerRegisterUILogic();
		modifyUI = new CustomerModifyUILogic();
		searchUI = new CustomerSearchUILogic();
		deleteUI = new CustomerDeleteUILogic();
		printUI = new CustomerPrintUILogic();
	}

	@Override
	public void initialize() {
		JPanel panel = new JPanel();
		JButton button = null;
		
		this.service = (CustomerService)service;
		
		// initialize Table Column
		for(ECustomerTableItems e : ECustomerTableItems.values()) {
			tableModel.addColumn(e.getName());
		}
		
		// create Table
		table = new JTable(tableModel);
		
		// set initial values
		// setTable(service.getCustomerList());
		
		// add Table
		this.add(new JScrollPane(table));
		
		// Set panel's Layout (5 Columns)
		panel.setLayout(new GridLayout(0, ECustomerTableItems.values().length));
		
		// add Customermenu Buttons to Panel
		for(ECustomerMenuItems e : ECustomerMenuItems.values()) {
			button = new JButton(e.getName());
			button.setActionCommand(e.name());
			button.addActionListener(new ButtonEvent());
			panel.add(button);
		}

		// add Panel
		this.add(panel, BorderLayout.SOUTH);
		
		this.setBounds(300, 400, 500, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		// initialize
		registerUI.initialize(this, service);
		modifyUI.initialize(this, service);
		searchUI.initialize(this, service);
		deleteUI.initialize(this, service);
		printUI.initialize(this, service);
	}
	
	@Override
	public void openDialog() {
		// setTable
		this.setTable(service.printAllByName());
		
		// setVisible
		this.setVisible(true);
	}
	
	@Override
	public void closeDialog() {
		this.setVisible(false);
	}
	
	@Override
	public void setTable(List<Customer> list) {
		tableModel.getDataVector().removeAllElements();	// tableModel에서 모든 데이터의 vector를 불러온 뒤 모두 삭제

		for(Customer c : list) {
			tableModel.addRow(c.getArray());
		}
	}
	
	@Override
	public void getSelected() {
		// (**8****JOptionPane.showMessageDialog(null, table.getValueAt(table.getSelectedRow(), 0));
	}
	
	public class ButtonEvent implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(ECustomerMenuItems.valueOf(e.getActionCommand())) {
			case REGISTER:
				registerUI.openDialog();
				break;
			case MODIFY:
				modifyUI.openDialog();
				break;
			case SEARCH:
				searchUI.openDialog();
				break;
			case DELETE:
				deleteUI.openDialog();
				break;
			case PRINT:
				printUI.openDialog();
				break;
			};
		}
		
	}
	
}
