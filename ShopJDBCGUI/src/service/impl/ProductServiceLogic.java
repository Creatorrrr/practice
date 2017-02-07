package service.impl;

import java.util.List;

import domain.Product;
import service.ProductService;
import store.ProductStore;
import store.impl.ProductStoreLogic;

public class ProductServiceLogic implements ProductService {
	
	private ProductStore store;
	
	public ProductServiceLogic() {
		store = new ProductStoreLogic();
	}

	@Override
	public List<Product> searchAll() {
		return store.selectAll();
	}
	
	@Override
	public List<String> searchCountByCategory() {
		return store.selectCountByCategory();
	}

}
