package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import constants.SGConstants;
import constants.SGConstants.EEditMenuItems;

public class SGInterfaceEvent implements ActionListener {
 
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		if(btn.getText().equals(SGConstants.REGIST_STUDENT)) {
			new SGRegisterInterface().initialize();
		} else if (btn.getText().equals(SGConstants.SEARCH_STUDENT)) {
			new SGSearchInterface().initialize();
		} else if (btn.getText().equals(SGConstants.PRINT_STUDENT)) {
			new SGPrintInterface().initialize();
		} else if (btn.getText().equals(SGConstants.DELETE_STUDENT)) {
			new SGDeleteInterface().initialize();
		} else if (btn.getText().equals(SGConstants.MODIFY_STUDENT)) {
			new SGModifyInterface().initialize();
		}
		
	}

}
