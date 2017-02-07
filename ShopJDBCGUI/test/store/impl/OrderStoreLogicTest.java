package store.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import domain.Order;
import store.OrderStore;

public class OrderStoreLogicTest {

	@Test
	public void testSelectAll() {
		OrderStore os = new OrderStoreLogic();
		
		List<Order> list = os.selectAll();
		
		assertEquals(6, list.size());
	}
	
	@Test
	public void testSelectById() {
		OrderStore os = new OrderStoreLogic();
		
		List<Order> list = os.selectById("tksong@nextree.co.kr");
		
		assertEquals(2, list.size());
	}
	
	@Test
	public void testSelectOrderByDate_1() {
		OrderStore os = new OrderStoreLogic();
		
		List<Order> list = os.selectOrderByDate("2016");

		assertEquals(2, list.size());
	}
	
	@Test
	public void testSelectOrderByDate_2() {
		OrderStore os = new OrderStoreLogic();
		
		List<Order> list = os.selectOrderByDate("2010", "2012");

		assertEquals(3, list.size());
	}

}
