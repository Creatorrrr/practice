package menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import constants.GEConstants.EEditMenuItems;

public class GEEditMenu extends JMenu{

	public GEEditMenu(String title) {
		super(title);
		
		for(EEditMenuItems e : EEditMenuItems.values()) {
			JMenuItem item = new JMenuItem(e.name());
			this.add(item);
		}
	}
}
