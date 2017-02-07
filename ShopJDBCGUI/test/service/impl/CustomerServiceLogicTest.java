package service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.Customer;
import service.CustomerService;

public class CustomerServiceLogicTest {
	
	@Before
	public void testBefore() {
		CustomerService cs = new CustomerServiceLogic();
		
		Customer customer = new Customer();
		
		customer.setId("1111");
		customer.setPasswd("1111");
		customer.setName("kkkk");
		customer.setAge(11);
		customer.setAddress("1111");
		
		cs.register(customer);
	}
	
	@After
	public void testAfter() {
		CustomerService cs = new CustomerServiceLogic();
		
		Customer customer = new Customer();
		
		customer.setId("1111");
		customer.setPasswd("1111");
		customer.setName("kkkk");
		customer.setAge(11);
		customer.setAddress("1111");
		
		cs.deleteCustomer(customer);
		
		customer.setId("2222");
		customer.setPasswd("2222");
		customer.setName("2222");
		customer.setAge(22);
		customer.setAddress("2222");
		
		cs.deleteCustomer(customer);
	}
	

	@Test
	public void testCheckId() {
		CustomerService csl = new CustomerServiceLogic();
		
		boolean result = csl.checkId("kkjin@nextree.co.kr");
		
		assertTrue(result);
	}
	
	@Test
	public void testRegister() {
		CustomerService cs = new CustomerServiceLogic();
		
		Customer customer = new Customer();
		
		customer.setId("2222");
		customer.setPasswd("2222");
		customer.setName("2222");
		customer.setAge(22);
		customer.setAddress("2222");
		
		boolean result = cs.register(customer);
		
		assertTrue(result);
	}
	
	@Test
	public void testPrintAllByName() {
		CustomerService cs = new CustomerServiceLogic();
		
		List<Customer> list = cs.printAllByName();
		
		assertEquals(6, list.size());
		assertEquals("Ha", list.get(0).getName());
	}
	
	@Test
	public void testPrintAllByAge() {
		CustomerService cs = new CustomerServiceLogic();
		
		List<Customer> list = cs.printAllByAge();
		
		assertEquals(6, list.size());
		assertEquals(25, list.get(0).getAge());
	}

	@Test
	public void testSearchByName() {
		CustomerService cs = new CustomerServiceLogic();
		
		List<Customer> list = cs.searchByName("Park");
		
		assertEquals(1, list.size());
		assertEquals("Park", list.get(0).getName());
	}
	
	@Test
	public void testSearchByAddress() {
		CustomerService cs = new CustomerServiceLogic();
		
		List<Customer> list = cs.searchByAddress("서울");
		
		assertEquals(2, list.size());
		assertEquals("서울", list.get(0).getAddress());
		assertEquals("서울", list.get(1).getAddress());
	}
	
	@Test
	public void testSearchById() {
		CustomerService cs = new CustomerServiceLogic();
		
		Customer customer = cs.searchById("tksong@nextree.co.kr");
		
		assertEquals("tksong@nextree.co.kr", customer.getId());
	}
	
	@Test
	public void testDeleteCustomer() {
		CustomerService cs = new CustomerServiceLogic();
		
		Customer customer = new Customer();
		
		customer.setId("1111");
		customer.setPasswd("1111");
		customer.setName("1111");
		customer.setAge(11);
		customer.setAddress("1111");
		
		boolean result = cs.deleteCustomer(customer);
		
		assertTrue(result);
		
		Customer searched = cs.searchById(customer.getId());
		
		assertEquals(null, searched.getId());
	}
	
	@Test
	public void testModifyCustomer() {
		CustomerService cs = new CustomerServiceLogic();
		
		Customer customer = new Customer();
		
		customer.setId("1111");
		customer.setPasswd("3333");
		customer.setName("3333");
		customer.setAge(33);
		customer.setAddress("3333");
		
		boolean result = cs.modifyCustomer(customer);
		
		assertTrue(result);
		
		Customer selected = cs.searchById(customer.getId());
		
		assertEquals("3333", selected.getAddress());
	}
}
