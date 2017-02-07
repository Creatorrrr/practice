package service.impl;

import java.util.List;

import domain.Customer;
import service.CustomerService;
import store.CustomerStore;
import store.impl.CustomerStoreLogic;

public class CustomerServiceLogic implements CustomerService {
	
	private CustomerStore store;
	
	public CustomerServiceLogic() {
		store = new CustomerStoreLogic();
	}

	@Override
	public boolean checkId(String id) {
		return store.selectId(id);
	}

	@Override
	public boolean register(Customer customer) {
		return store.insert(customer);
	}

	@Override
	public List<Customer> printAllByName() {
		return store.selectAllByName();
	}

	@Override
	public List<Customer> printAllByAge() {
		return store.selectAllByAge();
	}
	
	@Override
	public List<Customer> searchByName(String name) {
		return store.selectByName(name);
	}

	@Override
	public List<Customer> searchByAddress(String address) {
		return store.selectByAddress(address);
	}
	
	@Override
	public Customer searchById(String id) {
		return store.selectById(id);
	}
	
	@Override
	public boolean deleteCustomer(Customer customer) {
		return store.delete(customer);
	}
	
	@Override
	public boolean modifyCustomer(Customer customer) {
		return store.update(customer);
	}
}
