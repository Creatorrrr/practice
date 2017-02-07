package ui.framework.mainmenu;

import java.util.List;

import domain.Product;

public interface ProductUI {
	
	public abstract void initialize();
	public abstract void openDialog();
	public abstract void closeDialog();
	public abstract void setTable(List<Product> list);
	
}
