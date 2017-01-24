package menus;

import javax.swing.JMenuBar;

import frames.GEDrawingPanel;

public class GEMenuBar extends JMenuBar{

	private GEFileMenu fileMenu;
	private GEEditMenu editMenu;
	private GEColorMenu colorMenu;
	
	public GEMenuBar() {
		fileMenu = new GEFileMenu("����");
		editMenu = new GEEditMenu("����");
		colorMenu = new GEColorMenu("�÷�");
		
		this.add(fileMenu);
		this.add(editMenu);
		this.add(colorMenu);
	}

	public void initialization(GEDrawingPanel drawingPanel) {
		colorMenu.initialization(drawingPanel);
	}
}
