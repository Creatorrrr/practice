package ui.impl;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import constants.Constants.EMainMenuItems;
import ui.framework.MainUI;
import ui.framework.mainmenu.CustomerUI;
import ui.framework.mainmenu.OrderUI;
import ui.framework.mainmenu.ProductUI;

public class MainUILogic extends JFrame implements MainUI {

	private CustomerUI cui;
	private ProductUI pui;
	private OrderUI oui;
	
	public MainUILogic() {
		cui = new CustomerUILogic();
		pui = new ProductUILogic();
		oui = new OrderUILogic();
	}
	
	@Override
	public void initialize() {
		JButton button;
		
		// Layout Setting (3 Columns)
		this.setLayout(new GridLayout(0, 3));
		
		// add Mainmenu Buttons
		for(EMainMenuItems e : EMainMenuItems.values()) {
			button = new JButton(e.getName());
			button.setActionCommand(e.name());
			button.addActionListener(new ButtonEvent());
			this.add(button);
			
		}
		
		this.setBounds(700, 300, 300, 100);
		this.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		cui.initialize();
		pui.initialize();
		oui.initialize();
	}
	
	public class ButtonEvent implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			switch(EMainMenuItems.valueOf(e.getActionCommand())) {
			case CUSTOMER:
				cui.openDialog();
				break;
			case PRODUCT:
				pui.openDialog();
				break;
			case ORDER:
				oui.openDialog();
				break;
			}
		}
		
	}
	
}
