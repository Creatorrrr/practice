package ui.framework.customer;

import service.CustomerService;
import ui.framework.mainmenu.CustomerUI;

public interface CustomerDialogUI {
	public abstract void initialize(CustomerUI ui, CustomerService service);
	public abstract void openDialog();
	public abstract void closeDialog();
}
