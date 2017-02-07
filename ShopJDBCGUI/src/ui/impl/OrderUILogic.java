package ui.impl;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import constants.Constants.EOrderMenuItems;
import constants.Constants.EOrderTableItems;
import domain.Order;
import service.OrderService;
import service.Service;
import service.impl.OrderServiceLogic;
import ui.framework.customer.OrderDialogUI;
import ui.framework.mainmenu.OrderUI;

public class OrderUILogic extends JFrame implements OrderUI {
	
	private JTable table;
	private DefaultTableModel tableModel;
	
	private OrderService service;
	
	private OrderUILogic ouiLogic;

	public OrderUILogic() {
		table = null;
		tableModel = new DefaultTableModel();
		
		service = new OrderServiceLogic();
		
		ouiLogic = this;
	}
	
	@Override
	public void initialize() {
		JPanel panel = new JPanel();
		JButton button = null;
		
		this.service = (OrderService)service;
		
		// initialize Table Column
		for(EOrderTableItems e : EOrderTableItems.values()) {
			tableModel.addColumn(e.getName());
		}
		
		// create Table
		table = new JTable(tableModel);
		
		// set initial values
		// setTable(orderService.getCustomerList());
		
		// add Table
		this.add(new JScrollPane(table));
		
		// Set panel's Layout (4 Columns)
		panel.setLayout(new GridLayout(0, EOrderMenuItems.values().length));
		
		// add Ordermenu Buttons to Panel
		for(EOrderMenuItems e : EOrderMenuItems.values()) {
			button = new JButton(e.getName());
			button.setActionCommand(e.name());
			button.addActionListener(new ButtonEvent());
			panel.add(button);
		}

		// add Panel
		this.add(panel, BorderLayout.SOUTH);
		
		this.setBounds(700, 400, 500, 300);
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void openDialog() {
		this.setVisible(true);
	}
	
	@Override
	public void closeDialog() {
		this.setVisible(false);
	}
	
	public void setTable(List<Order> list) {
		tableModel.getDataVector().removeAllElements();	// tableModel에서 모든 데이터의 vector를 불러온 뒤 모두 삭제

		for(Order o : list) {
			tableModel.addRow(o.getArray());
		}
	}
	
	public class ButtonEvent implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(EOrderMenuItems.valueOf(e.getActionCommand())) {
			case ALL_ORDERS:
				ouiLogic.setTable(service.searchAll());
				break;
			case COUNT_BY_ID:
				// create New Dialog
				// ouiLogic.setTable();
				break;
			case ASK_BY_TIME:
				// create New Dialog
				// ouiLogic.setTable();
				break;

			};
		}
		
	}
	
}
