package store.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import domain.Customer;
import store.CustomerStore;

public class CustomerStoreLogicTest {
	
	@Before
	public void testBefore() {
		CustomerStore cs = new CustomerStoreLogic();
		
		Customer customer = new Customer();
		
		customer.setId("1111");
		customer.setPasswd("1111");
		customer.setName("kkkk");
		customer.setAge(11);
		customer.setAddress("1111");
		
		cs.insert(customer);
	}
	
	@After
	public void testAfter() {
		CustomerStore cs = new CustomerStoreLogic();
		
		Customer customer = new Customer();
		
		customer.setId("1111");
		customer.setPasswd("1111");
		customer.setName("kkkk");
		customer.setAge(11);
		customer.setAddress("1111");
		
		cs.delete(customer);
		
		customer.setId("2222");
		customer.setPasswd("2222");
		customer.setName("2222");
		customer.setAge(22);
		customer.setAddress("2222");
		
		cs.delete(customer);
	}

	@Test
	public void testSelectId() {
		CustomerStore cs = new CustomerStoreLogic();
		
		boolean result = cs.selectId("jypark@nextree.co.kr");
		
		assertTrue(result);
	}
	
	@Test
	public void testInsert() {
		CustomerStore cs = new CustomerStoreLogic();
		
		Customer customer = new Customer();
		
		customer.setId("2222");
		customer.setPasswd("2222");
		customer.setName("2222");
		customer.setAge(22);
		customer.setAddress("2222");
		
		boolean result = cs.insert(customer);
		
		assertTrue(result);
	}

	@Test
	public void TestSelectAllByName() {
		CustomerStoreLogic csl = new CustomerStoreLogic();
		
		List<Customer> list = csl.selectAllByName();
		
		assertEquals(6, list.size());
		assertEquals("Ha", list.get(0).getName());
	}
	
	@Test
	public void TestSelectAllByAge() {
		CustomerStore cs = new CustomerStoreLogic();
		
		List<Customer> list = cs.selectAllByAge();
		
		assertEquals(6, list.size());
		assertEquals(25, list.get(0).getAge());
	}
	
	@Test
	public void TestSelectByName() {
		CustomerStoreLogic csl = new CustomerStoreLogic();
		
		List<Customer> list = csl.selectByName("Park");
		
		assertEquals(1, list.size());
		assertEquals("Park", list.get(0).getName());
	}

	@Test
	public void TestSelectByAddress() {
		CustomerStore cs = new CustomerStoreLogic();
		
		List<Customer> list = cs.selectByAddress("서울");
		
		assertEquals(2, list.size());
		assertEquals("서울", list.get(0).getAddress());
		assertEquals("서울", list.get(1).getAddress());
	}
	
	@Test
	public void TestSelectById() {
		CustomerStore cs = new CustomerStoreLogic();
		
		Customer customer = cs.selectById("tksong@nextree.co.kr");
		
		assertEquals("tksong@nextree.co.kr", customer.getId());
	}
	
	@Test
	public void TestDelete() {
		CustomerStore cs = new CustomerStoreLogic();
		
		Customer customer = new Customer();
		
		customer.setId("1111");
		customer.setPasswd("1111");
		customer.setName("kkkk");
		customer.setAge(11);
		customer.setAddress("1111");
		
		boolean result = cs.delete(customer);
		
		assertTrue(result);
		
		Customer selected = cs.selectById(customer.getId());
		
		assertEquals(null, selected.getId());
	}
	
	@Test
	public void TestUpdate() {
		CustomerStore cs = new CustomerStoreLogic();
		
		Customer customer = new Customer();
		
		customer.setId("1111");
		customer.setPasswd("3333");
		customer.setName("3333");
		customer.setAge(33);
		customer.setAddress("3333");
		
		boolean result = cs.update(customer);
		
		assertTrue(result);
		
		Customer selected = cs.selectById(customer.getId());
		
		assertEquals("3333", selected.getAddress());
	}
}
