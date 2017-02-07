package service;

import java.util.List;

import domain.Product;

public interface ProductService extends Service {
	
//	전체 상품 검색
	public List<Product> searchAll();
	
//	상품 종류별 판매 수 검색
	public List<String> searchCountByCategory();

}
