package menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEConstants.EColorMenuItems;

public class GEColorMenu extends JMenu{
	
	public GEColorMenu(String title) {
		super(title);
		
		for(EColorMenuItems e : EColorMenuItems.values()) {
			JMenuItem item = new JMenuItem(e.name());
			this.add(item);
		}
	}
}
