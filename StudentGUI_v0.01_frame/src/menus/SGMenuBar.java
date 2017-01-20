package menus;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import constants.SGConstants.EMenuBarItems;

public class SGMenuBar extends JMenuBar{
	
	private SGMenuFile fileMenu;
	private SGMenuEdit editMenu;
	
	public SGMenuBar() {
//		fileMenu = new fileMenu();
//		editMenu = new editMenu();
		
		this.add(fileMenu);
		this.add(editMenu);
	}
}
