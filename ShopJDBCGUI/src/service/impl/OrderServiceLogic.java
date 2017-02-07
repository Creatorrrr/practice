package service.impl;

import java.util.List;

import domain.Order;
import service.OrderService;
import store.OrderStore;
import store.impl.OrderStoreLogic;

public class OrderServiceLogic implements OrderService {

	private OrderStore store;
	
	public OrderServiceLogic() {
		store = new OrderStoreLogic();
	}

	@Override
	public List<Order> searchAll() {
		return store.selectAll();
	}
	
	@Override
	public List<Order> searchById(String id) {
		return store.selectById(id);
	}
	
	@Override
	public List<Order> searchByDate(String year) {
		return store.selectOrderByDate(year);
	}
	
	@Override
	public List<Order> searchByDate(String startYear, String endYear) {
		return store.selectOrderByDate(startYear, endYear);
	}
}
