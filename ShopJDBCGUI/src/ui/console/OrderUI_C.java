package ui.console;

import java.util.List;
import java.util.Scanner;

import domain.Order;
import service.OrderService;
import service.impl.OrderServiceLogic;

public class OrderUI_C {
	private Scanner keyIn;
	private OrderService service;

	public OrderUI_C() {
		keyIn = new Scanner(System.in);

		service = new OrderServiceLogic();
	}

	public void menuPrint() {
		int select;
		while (true) {
			System.out.println("------상품 메뉴-------");
			System.out.println("1. 전체 주문 내역 조회");
			System.out.println("2. 사용자별 주문 조회");
			System.out.println("3. 시간 주문 조회");
			System.out.println("4. 메인으로...");
			System.out.print("#메뉴 : ");

			select = keyIn.nextInt();
			switch (select) {
			case 1:
				printAll();
				break;
			case 2:
				printOrderByUser();
				break;
			case 3:
				printOrderByDate();
				break;
			case 4:
				return;
			}
		}
	}

	private void printAll() {
		List<Order> list;

		list = service.searchAll();

		System.out.println("------전체 주문 내역-------");
		for (Order o : list) {
			System.out.println(o.toString());
		}
	}

	private void printOrderByUser() {
		List<Order> list;
		
		System.out.print("ID : ");
		list = service.searchById(keyIn.next());

		System.out.println("------ID별 주문 내역-------");
		for (Order o : list) {
			System.out.println(o.toString());
		}
	}
	
	private void printOrderByDate(){
		List<Order> list = null;

		int select;
		String year;
		String sYear, eYear;

		System.out.println("------년도별 주문 내역-------");
		System.out.println("1.년도별");
		System.out.println("2.기간별");
		System.out.print("#메뉴 : ");
		select = keyIn.nextInt();
		
		switch(select){
		case 1:
			System.out.print("년도 : ");
			year = keyIn.next();
			list = service.searchByDate(year);
			break;
		case 2:
			System.out.print("시작 년도 : ");
			sYear = keyIn.next();
			System.out.print("종료 년도 : ");
			eYear = keyIn.next();
			list = service.searchByDate(sYear, eYear);
			break;
			
		}
		
		for(Order o : list){
			System.out.println(o.toString());
		}
	}
}
