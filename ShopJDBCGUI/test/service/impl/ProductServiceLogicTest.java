package service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import domain.Product;
import service.ProductService;

public class ProductServiceLogicTest {

	@Test
	public void testSearchAll() {
		ProductService ps = new ProductServiceLogic();
		
		List<Product> list = ps.searchAll();
		
		assertEquals(6, list.size());
	}
	
	@Test
	public void testSearchCountByCategory() {
		ProductService ps = new ProductServiceLogic();
		
		List<String> list = ps.searchCountByCategory();
		
		assertEquals(3, list.size());
	}

}
