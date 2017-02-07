package ui.framework.customer;

import service.OrderService;
import ui.framework.mainmenu.OrderUI;

public interface OrderDialogUI {
	public abstract void initialize(OrderUI ui, OrderService service);
	public abstract void openDialog();
	public abstract void closeDialog();
}
