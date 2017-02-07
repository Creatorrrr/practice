package ui.impl.customer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import constants.Constants.ECustomerTableItems;
import constants.Constants.EDeleteButtonItems;
import constants.Constants.ESearchButtonItems;
import domain.Customer;
import service.CustomerService;
import ui.framework.customer.CustomerDialogUI;
import ui.framework.mainmenu.CustomerUI;

public class CustomerDeleteUILogic extends JDialog implements CustomerDialogUI {
	private JTextField textField;
	
	private CustomerUI customerUI;
	private CustomerService service;
	
	public CustomerDeleteUILogic() {
		textField = null;
		
		customerUI = null;
		service = null;
	}
	
	@Override
	public void initialize(CustomerUI ui, CustomerService service) {
		JLabel label = null;
		JButton button = null;
		
		this.customerUI = ui;
		this.service = service;
		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		label = new JLabel(ECustomerTableItems.ID.getName());
		label.setPreferredSize(new Dimension(60,30));
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(200, 30));
		this.add(label);
		this.add(textField);
		
		for(EDeleteButtonItems e : EDeleteButtonItems.values()) {
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
			
			switch(EDeleteButtonItems.valueOf(e.getActionCommand())) {
			case DELETE:
				Customer customer = new Customer();
				
				customer.setId(textField.getText());
				
				if(!service.deleteCustomer(customer)) {
					JOptionPane.showMessageDialog(null, "존재하지 않는 학생입니다.");
				}
				
				customerUI.setTable(service.printAllByName());
				
				break;
			case CANCEL:
				break;
			};
			
			clearTextField();
			closeDialog();
		}
		
	}
	
}
