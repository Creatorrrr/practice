package frames;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;

import constants.GEConstants.EToolbarButtons;

public class GEToolBar extends JToolBar{

	public GEToolBar(String title) {
		super(title);
		
		ButtonGroup group = new ButtonGroup();
		
		for(EToolbarButtons e : EToolbarButtons.values()) {
			JRadioButton item = new JRadioButton();
			
			item.setIcon(new ImageIcon("images/" + e.name() + ".gif"));
			item.setSelectedIcon(new ImageIcon("images/" + e.name() +"SLT.gif"));
			
			this.add(item);
			group.add(item);
		}
	}
}
