package ui.console;

import java.util.List;
import java.util.Scanner;

import domain.Product;
import service.ProductService;
import service.impl.ProductServiceLogic;

public class ProductUI_C {
	private Scanner keyIn;
	private ProductService service;

	public ProductUI_C() {
		keyIn = new Scanner(System.in);
		service = new ProductServiceLogic();
	}

	public void menuPrint() {
		int select;
		while (true) {
			System.out.println("------상품 메뉴-------");
			System.out.println("1. 전체 상품 조회");
			System.out.println("2. 상품종류별 주문 수량 조회");
			System.out.println("3. 메인으로...");
			System.out.print("#메뉴 : ");

			select = keyIn.nextInt();
			switch (select) {
			case 1:
				printAll();
				break;
			case 2:
				printCountByCategory();
				break;
			case 3:
				return;
			}
		}
	}

	private void printAll() {
		List<Product> list;

		list = service.searchAll();

		System.out.println("------전체 상품-------");
		for (Product pdt : list) {
			System.out.println(pdt);
		}
	}

	private void printCountByCategory() {
		List<String> list;

		list = service.searchCountByCategory();

		System.out.println("------상품별 판매 수-------");
		for (String data : list) {
			System.out.println(data);
		}
	}

}
