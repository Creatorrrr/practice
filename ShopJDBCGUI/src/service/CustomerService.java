package service;

import java.util.List;

import domain.Customer;

public interface CustomerService extends Service {
	
//	ID 확인
	public boolean checkId(String id);
	
//	회원 등록
	public boolean register(Customer customer);
	
//	이름 순 출력
	public List<Customer> printAllByName();
	
//	나이 순 출력
	public List<Customer> printAllByAge();
	
//	이름 검색
	public List<Customer> searchByName(String name);

//	지역 검색
	public List<Customer> searchByAddress(String address);
	
//	ID 검색
	public Customer searchById(String id);
	
//	삭제
	public boolean deleteCustomer(Customer customer);
	
//	수정
	public boolean modifyCustomer(Customer customer);
}
