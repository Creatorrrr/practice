package ui.framework.mainmenu;

import java.util.List;

import domain.Customer;

public interface CustomerUI {
	
	public abstract void initialize();
	public abstract void openDialog();
	public abstract void closeDialog();
	public abstract void setTable(List<Customer> list);
	public abstract void getSelected();
}
