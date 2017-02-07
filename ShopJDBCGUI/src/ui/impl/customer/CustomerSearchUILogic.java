package ui.impl.customer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import constants.Constants.ECustomerTableItems;
import constants.Constants.ERegisterButtonItems;
import constants.Constants.ESearchButtonItems;
import domain.Customer;
import service.CustomerService;
import ui.framework.customer.CustomerDialogUI;
import ui.framework.mainmenu.CustomerUI;

public class CustomerSearchUILogic extends JDialog implements CustomerDialogUI {
	JComboBox<String> comboBox;
	private JTextField textField;
	
	private CustomerUI customerUI;
	private CustomerService service;
	
	public CustomerSearchUILogic() {
		comboBox = new JComboBox<>();
		textField = null;
		
		customerUI = null;
		service = null;
	}
	
	@Override
	public void initialize(CustomerUI ui, CustomerService service) {
		JButton button = null;
		
		this.customerUI = ui;
		this.service = service;
		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		comboBox.setPreferredSize(new Dimension(60,30));
		comboBox.addItem(ECustomerTableItems.NAME.getName());
		comboBox.addItem(ECustomerTableItems.ADDRESS.getName());
		comboBox.addItem(ECustomerTableItems.ID.getName());
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(200, 30));
		this.add(comboBox);
		this.add(textField);
		
		for(ESearchButtonItems e : ESearchButtonItems.values()) {
			button = new JButton(e.getName());
			button.setPreferredSize(new Dimension(100, 30));
			button.setActionCommand(e.name());
			button.addActionListener(new ButtonEvent());	
			this.add(button);
		}

		this.setBounds(500, 500, 300, 120);
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
	
	private void clearTextField() {
		textField.setText("");
	}

	public class ButtonEvent implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			List<Customer> list = null;
			
			switch(ESearchButtonItems.valueOf(e.getActionCommand())) {
			case SEARCH:
				if(comboBox.getSelectedItem().equals(ECustomerTableItems.NAME.getName())) {
					list = service.searchByName(textField.getText());
					customerUI.setTable(list);
				} else if(comboBox.getSelectedItem().equals(ECustomerTableItems.ADDRESS.getName())) {
					list = service.searchByAddress(textField.getText());
					customerUI.setTable(list);
				} else if(comboBox.getSelectedItem().equals(ECustomerTableItems.ID.getName())) {
					list = new ArrayList<Customer>();
					list.add(service.searchById(textField.getText()));
					customerUI.setTable(list);
				}
				break;
			case CANCEL:
				break;
			};
			
			clearTextField();
			closeDialog();
		}
		
	}
	
}
