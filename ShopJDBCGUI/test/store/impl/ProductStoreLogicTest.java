package store.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Product;

public class ProductStoreLogicTest {

	@Test
	public void testSelectAll() {
		ProductStoreLogic psl = new ProductStoreLogic();
		
		List<Product> list = psl.selectAll();
		
		assertEquals(6, list.size());
	}
	
	@Test
	public void testSelectCountByCategory() {
		ProductStoreLogic psl = new ProductStoreLogic();
		
		List<String> list = psl.selectCountByCategory();
		
		assertEquals(3, list.size());
	}

}
