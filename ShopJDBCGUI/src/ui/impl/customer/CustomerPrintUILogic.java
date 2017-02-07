package ui.impl.customer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JRadioButton;

import constants.Constants.ECustomerTableItems;
import constants.Constants.EPrintButtonItems;
import service.CustomerService;
import ui.framework.customer.CustomerDialogUI;
import ui.framework.mainmenu.CustomerUI;

public class CustomerPrintUILogic extends JDialog implements CustomerDialogUI {
	private ButtonGroup buttonGroup;
	JRadioButton nameRadio;
	JRadioButton ageRadio;
	
	private CustomerUI customerUI;
	private CustomerService service;
	
	public CustomerPrintUILogic() {
		buttonGroup = new ButtonGroup();
		nameRadio = null;
		ageRadio = null;
		
		customerUI = null;
		service = null;
	}
	
	@Override
	public void initialize(CustomerUI ui, CustomerService service) {
		JButton button = null;
		
		this.customerUI = ui;
		this.service = service;
		
		this.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		nameRadio = new JRadioButton(ECustomerTableItems.NAME.getName());
		nameRadio.setPreferredSize(new Dimension(100,30));
		ageRadio = new JRadioButton(ECustomerTableItems.AGE.getName());
		ageRadio.setPreferredSize(new Dimension(100,30));
		
		buttonGroup.add(nameRadio);
		buttonGroup.add(ageRadio);
		
		this.add(nameRadio);
		this.add(ageRadio);
		
		for(EPrintButtonItems e : EPrintButtonItems.values()) {
			button = new JButton(e.getName());
			button.setPreferredSize(new Dimension(100, 30));
			button.setActionCommand(e.name());
			button.addActionListener(new ButtonEvent());	
			this.add(button);
		}

		this.setBounds(500, 500, 240, 120);
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
	
	public class ButtonEvent implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(EPrintButtonItems.valueOf(e.getActionCommand())) {
			case PRINT:
				if(nameRadio.isSelected()) {
					customerUI.setTable(service.printAllByName());
				} else if(ageRadio.isSelected()) {
					customerUI.setTable(service.printAllByAge());
				}
				break;
			case CANCEL:
				break;
			};
			
			closeDialog();
		}
		
	}
	
}
