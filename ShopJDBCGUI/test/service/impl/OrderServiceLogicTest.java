package service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Order;
import service.OrderService;

public class OrderServiceLogicTest {

	@Test
	public void testSearchAll() {
		OrderService os = new OrderServiceLogic();
		
		List<Order> list = os.searchAll();
		
		assertEquals(6, list.size());
	}
	
	@Test
	public void testSearchById() {
		OrderService os = new OrderServiceLogic();
		
		List<Order> list = os.searchById("tksong@nextree.co.kr");
		
		assertEquals(2, list.size());
	}
	
	@Test
	public void testSearchByDate_1() {
		OrderService os = new OrderServiceLogic();
		
		List<Order> list = os.searchByDate("2016");
		
		assertEquals(2, list.size());
	}

	@Test
	public void testSearchByDate_2() {
		OrderService os = new OrderServiceLogic();
		
		List<Order> list = os.searchByDate("2010", "2012");
		
		assertEquals(3, list.size());
	}
}
