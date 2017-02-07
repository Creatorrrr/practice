package ui.framework.customer;

import service.ProductService;
import ui.framework.mainmenu.ProductUI;

public interface ProductDialogUI {
	public abstract void initialize(ProductUI ui, ProductService service);
	public abstract void openDialog();
	public abstract void closeDialog();
}
