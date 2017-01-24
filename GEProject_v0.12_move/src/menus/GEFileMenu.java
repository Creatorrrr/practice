package menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEConstants.EFileMenuItems;

public class GEFileMenu extends JMenu{
	
	public GEFileMenu(String title) {
		super(title);
		
		for(EFileMenuItems e : EFileMenuItems.values()) {
			JMenuItem item = new JMenuItem(e.name());
			this.addSeparator();
			this.add(item);
		}
	}
}
