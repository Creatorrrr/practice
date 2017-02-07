package ui;

import ui.framework.MainUI;
import ui.impl.MainUILogic;

public class ShopLauncher {
	
	public static void main(String[] args) {
		MainUI mui = new MainUILogic();

		mui.initialize();
	}
	
}
