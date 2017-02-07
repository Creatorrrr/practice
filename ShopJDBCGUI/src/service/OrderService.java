package service;

import java.util.List;

import domain.Order;

public interface OrderService extends Service {
	
//	전체 주문 조회
	public List<Order> searchAll();
	
//	고객 별 주문 조회
	public List<Order> searchById(String id);
	
//	년도별 주문 조회
	public List<Order> searchByDate(String year);
	
//	기간 별 주문 조회
	public List<Order> searchByDate(String startYear, String endYear);
}
