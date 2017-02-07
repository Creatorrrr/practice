package ui.framework.mainmenu;

import java.util.List;

import domain.Order;

public interface OrderUI {
	
	public abstract void initialize();
	public abstract void openDialog();
	public abstract void closeDialog();
	public abstract void setTable(List<Order> list);
	
}
