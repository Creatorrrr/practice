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

import constants.Constants.EProductMenuItems;
import constants.Constants.EProductTableItems;
import domain.Product;
import service.ProductService;
import service.impl.ProductServiceLogic;
import ui.framework.mainmenu.ProductUI;

public class ProductUILogic extends JFrame implements ProductUI {
	
	private JTable table;
	private DefaultTableModel tableModel;
	
	private ProductService service;
	
	private ProductUILogic puiLogic;
	
	public ProductUILogic() {
		table = null;
		tableModel = new DefaultTableModel();
		
		service = new ProductServiceLogic();
		
		puiLogic = this;
	}

	@Override
	public void initialize() {
		JPanel panel = new JPanel();
		JButton button = null;
		
		this.service = (ProductService)service;
		
		// initialize Table Column
		for(EProductTableItems e : EProductTableItems.values()) {
			tableModel.addColumn(e.getName());
		}
		
		// create Table
		table = new JTable(tableModel);
		
		// set initial values
		// setTable(productService.getCustomerList());
		
		// add Table
		this.add(new JScrollPane(table));
		
		// Set panel's Layout (4 Columns)
		panel.setLayout(new GridLayout(0, EProductMenuItems.values().length));
		
		// add Productmenu Buttons to Panel
		for(EProductMenuItems e : EProductMenuItems.values()) {
			button = new JButton(e.getName());
			button.setActionCommand(e.name());
			button.addActionListener(new ButtonEvent());
			panel.add(button);
		}

		// add Panel
		this.add(panel, BorderLayout.SOUTH);
		
		this.setBounds(500, 400, 500, 300);
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
	
	public void setTable(List<Product> list) {
		tableModel.getDataVector().removeAllElements();	// tableModel에서 모든 데이터의 vector를 불러온 뒤 모두 삭제

		for(Product p : list) {
			tableModel.addRow(p.getArray());
		}
	}
	
	public class ButtonEvent implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(EProductMenuItems.valueOf(e.getActionCommand())) {
			case ALL_GOODS:
				puiLogic.setTable(service.searchAll());
				break;
			case COUNT_BY_CATEGORY:
				// 테이블 모델 재설정 필요
				// puiLogic.setTable(service.searchCountByCategory());
				break;
			};
		}
		
	}
	
}
