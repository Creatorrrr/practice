package store;

import java.util.List;

import domain.Order;

public interface OrderStore {
	
//	��ü �ֹ� ��ȸ
	public List<Order> selectAll();
	
//	�� �� �ֹ� ��ȸ
	public List<Order> selectById(String id);
	
//	�⵵�� �ֹ� ��ȸ
	public List<Order> selectOrderByDate(String year);
	
//	�Ⱓ�� �ֹ� ��ȸ
	public List<Order> selectOrderByDate(String startYear, String endYear);

}
