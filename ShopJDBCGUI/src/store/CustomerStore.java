package store;

import java.util.List;

import domain.Customer;

public interface CustomerStore {
//	ID 중복 확인
	public boolean selectId(String id);
	
//	고객 등록
	public boolean insert(Customer customer);

//	이름 순 출력
	public List<Customer> selectAllByName();
	
//	나이 순 출력
	public List<Customer> selectAllByAge();
	
//	이름 검색
	public List<Customer> selectByName(String name);

//	지역 검색
	public List<Customer> selectByAddress(String address);
	
//	ID 검색
	public Customer selectById(String id);
	
//	삭제
	public boolean delete(Customer customer);
	
//	수정
	public boolean update(Customer customer);
	
	
}
