package store;

import java.util.List;

import domain.Product;

public interface ProductStore {
	
//	전체 상품 검색
	public List<Product> selectAll();
	
//	상품 종류별 판매 수 검색
	public List<String> selectCountByCategory();

}
