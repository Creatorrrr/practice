package ui.impl.customer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import constants.Constants.ECustomerMenuItems;
import constants.Constants.ECustomerTableItems;
import constants.Constants.ERegisterButtonItems;
import domain.Customer;
import service.CustomerService;
import ui.framework.customer.CustomerDialogUI;
import ui.framework.mainmenu.CustomerUI;

public class CustomerRegisterUILogic extends JDialog implements CustomerDialogUI {
	
	private JTextField[] textField;
	
	private CustomerUI customerUI;
	private CustomerService service;
	
	public CustomerRegisterUILogic() {
		textField = new JTextField[ECustomerMenuItems.values().length];
	}

	@Override
	public void initialize(CustomerUI ui, CustomerService service) {
		JLabel label = null;
		JButton button = null;
		
		this.customerUI = ui;
		this.service = service;
		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		for(ECustomerTableItems e : ECustomerTableItems.values()) {
			label = new JLabel(e.getName());
			label.setPreferredSize(new Dimension(60,30));
			textField[e.getIndex()] = new JTextField();
			textField[e.getIndex()].setPreferredSize(new Dimension(200, 30));
			this.add(label);
			this.add(textField[e.getIndex()]);
		}
		
		for(ERegisterButtonItems e : ERegisterButtonItems.values()) {
			button = new JButton(e.getName());
			button.setPreferredSize(new Dimension(100, 30));
			button.setActionCommand(e.name());
			button.addActionListener(new ButtonEvent());	
			this.add(button);
		}

		this.setBounds(500, 500, 300, 260);
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
		for(ECustomerTableItems e : ECustomerTableItems.values()) {
			textField[e.getIndex()].setText("");
		}
	}
	
	public class ButtonEvent implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(ERegisterButtonItems.valueOf(e.getActionCommand())) {
			case REGISTER:
				Customer customer = new Customer();
				
				try {				
					customer.setId(textField[ECustomerTableItems.ID.getIndex()].getText());
					customer.setPasswd(textField[ECustomerTableItems.PASSWD.getIndex()].getText());
					customer.setName(textField[ECustomerTableItems.NAME.getIndex()].getText());
					customer.setAge(Integer.parseInt(textField[ECustomerTableItems.AGE.getIndex()].getText()));
					customer.setAddress(textField[ECustomerTableItems.ADDRESS.getIndex()].getText());

					if(!service.register(customer)) {
						JOptionPane.showMessageDialog(null, "이미 등록된 학생입니다.");
					}
				} catch (NumberFormatException exception) {
					JOptionPane.showMessageDialog(null, "'나이'란에 정수값을 입력해주세요.");
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
