package ui.console;

import java.util.List;
import java.util.Scanner;

import domain.Customer;
import service.CustomerService;
import service.impl.CustomerServiceLogic;

public class CustomerUI_C {

	private Scanner keyIn;
	private CustomerService service;

	public CustomerUI_C() {
		keyIn = new Scanner(System.in);
		service = new CustomerServiceLogic();
	}

	public void menuPrint() {
		int select;

		while (true) {
			System.out.println("1.회원 가입");
			System.out.println("2.회원 수정");
			System.out.println("3.회원 검색");
			System.out.println("4.회원 삭제");
			System.out.println("5.회원 출력");
			System.out.println("6.종료");
			System.out.print("#메뉴 : ");
			select = keyIn.nextInt();

			switch (select) {
			case 1:
				registerMenu();
				break;
			case 2:
				modifyMenu();
				break;
			case 3:
				searchMenu();
				break;
			case 4:
				deleteMenu();
				break;
			case 5:
				printAll();
				break;
			case 6:
				return;
			}
		}
	}

	private void registerMenu() {
		String id;

		System.out.println("-----회원 등록-----");
		System.out.print("#ID : ");
		id = keyIn.next();

		// ID 중복 체크
		if (!service.checkId(id)) {
			System.out.println("*사용 가능 ID 입니다.");

			Customer customer = new Customer();
			customer.setId(id);

			System.out.print("#이름 : ");
			customer.setName(keyIn.next());

			System.out.print("#PW : ");
			customer.setPasswd(keyIn.next());

			System.out.print("#나이 : ");
			customer.setAge(keyIn.nextInt());

			System.out.print("#주소 : ");
			customer.setAddress(keyIn.next());

			// 고객 등록
			if (service.register(customer)) {
				System.out.println("-----고객 등록 완료-----");
			} else {
				System.out.println("-----등록 실패-----");
			}
		} else {
			System.out.println("*사용 불가 ID");
		}
	}

	private void searchMenu() {
		int select;

		List<Customer> list = null;
		Customer customer = null;

		System.out.println("------검색 메뉴-----");
		System.out.println("1.이름 검색");
		System.out.println("2.지역 검색");
		System.out.println("3.ID 검색");
		System.out.print("#메뉴 : ");
		select = keyIn.nextInt();

		if (select == 1) {
			System.out.print("#이름 : ");
			list = service.searchByName(keyIn.next());
		} else if (select == 2) {
			System.out.print("#지역 : ");
			list = service.searchByAddress(keyIn.next());
		} else {
			System.out.print("#ID : ");
			customer = service.searchById(keyIn.next());
		}

		// 결과 출력
		if (list != null) {
			for (Customer cus : list) {
				System.out.println(cus.toString());
			}
		} else {
			System.out.println(customer.toString());
		}
	}

	private void deleteMenu() {
		Customer customer = null;

		System.out.println("------삭제 메뉴-----");
		System.out.print("#ID : ");

		// 검색
		customer = service.searchById(keyIn.next());
		// 삭제
		if (customer != null) {
			System.out.print(customer.getName() + "- 고객을 삭제 하시겠습니까? (y/n) : ");
			if (keyIn.next().toLowerCase().equals("y")) {
				if (service.deleteCustomer(customer)) {
					System.out.println("삭제 되었습니다.");
				}
			}
		}else{
			System.out.println("-- 해당 고객이 존재하지 않습니다 --");
		}

	}

	private void modifyMenu() {
		Customer customer = null;
		System.out.println("------수정 메뉴-----");

		System.out.print("#ID : ");

		// 검색
		customer = service.searchById(keyIn.next());
		// 수정
		if (customer != null) {
			System.out.println(customer.getName() + "- 고객의 주소를 변경 합니다.");
			System.out.print("#주소 : ");
			customer.setAddress(keyIn.next());
			if (service.modifyCustomer(customer)) {
				System.out.println("수정 되었습니다.");
			}
		} else {
			System.out.println("-- 해당 고객이 존재하지 않습니다 --");
		}

	}

	private void printAll() {
		int select;
		System.out.println("------출력 메뉴-----");
		System.out.println("1.이름 순 출력");
		System.out.println("2.나이 순 출력");
		System.out.print("#메뉴 : ");
		select = keyIn.nextInt();

		List<Customer> list;
		if (select == 1) {
			list = service.printAllByName();
		} else {
			list = service.printAllByAge();
		}

		for (Customer customer : list) {
			System.out.println(customer.toString());
		}
	}
}
