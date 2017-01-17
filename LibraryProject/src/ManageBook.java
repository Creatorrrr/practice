import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class ManageBook {

	public static final int FAIL = -1;
	
	Scanner keyIn;
	HashMap<String, Book> bookMap;
	
	public ManageBook() {
		keyIn = new Scanner(System.in);
		bookMap = new HashMap<>();
		
		Book bTemp = new Book("도서111", "소설");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("도서323", "에세이");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("도서41234", "잡지");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("도서1222", "웹툰");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("도서634211", "소설");
		bookMap.put(bTemp.getSerial(), bTemp);
	}
	
	private ArrayList<Book> searchCategory(int category) {
		
		ArrayList<Book> bookList = new ArrayList<>();
		
		Iterator<Entry<String, Book>> bookIt = bookMap.entrySet().iterator();
		
		Book bookTemp;
		String categoryStr = null;
		
		switch(category) {
		case 1:
			categoryStr = "소설";
			break;
		case 2:
			categoryStr = "에세이";
			break;
		case 3:
			categoryStr = "잡지";
			break;
		case 4:
			categoryStr = "웹툰";
			break;
		}
		
		while(bookIt.hasNext()) {
			bookTemp = bookIt.next().getValue();
			
			if(bookTemp.getCategory().equals(categoryStr)) {
				bookList.add(bookTemp);
			}
		}
		
		return bookList;
	}
	
	private ArrayList<Book> searchName(String name) {
		
		ArrayList<Book> bookList = new ArrayList<>();
		
		Iterator<Entry<String, Book>> bookIt = bookMap.entrySet().iterator();
		
		Book bookTemp;
		
		while(bookIt.hasNext()) {
			bookTemp = bookIt.next().getValue();
			
			if(bookTemp.getName().equals(name)) {
				bookList.add(bookTemp);
			}
		}
		
		return bookList;
	}
	
	public void searchBookName() {
	
		ArrayList<Book> listTemp;
		String key;
		
		System.out.println("[도서 검색(도서명)]");
		System.out.println("[검색] 도서명을 입력하세요.");
		System.out.print("> ");
		key = keyIn.next();
		
		System.out.println("대여       ID     분류      도서명");
		System.out.println("=========================");
		
		listTemp = searchName(key);
		
		for(int i = 0 ; i < listTemp.size() ; i++) {
			listTemp.get(i).toString();
		}
		
		System.out.println("-------------------------");
		
	}
	
	public void searchBookCategory() {
		
		ArrayList<Book> listTemp;
		int key = 0;
		
		System.out.println("[도서 검색(카테고리)]");
		System.out.println("[검색] 카테고리을 선택해 주세요.");
		System.out.println("1.	소설");
		System.out.println("2.	에세이");
		System.out.println("3.	잡지");
		System.out.println("4.	웹툰");
		System.out.print("> ");
		
		while (true) {
			key = keyIn.nextInt();
			if(key >= 1 && key <= 4) {
				break;
			} else {
				System.out.println("카테고리를 다시 확인해 주세요.");
				System.out.print("> ");
			}
		}
		
		System.out.println("대여       ID     분류      도서명");
		System.out.println("=========================");
		
		listTemp = searchCategory(key);
		
		for(int i = 0 ; i < listTemp.size() ; i++) {
			listTemp.get(i).toString();
		}
		
		System.out.println("-------------------------");
		
	}
	
	public void lentBook() {
		
		System.out.println("[도서 대여]");
		System.out.println("[반납] 도서ID를 입력하세요.");
		System.out.print("> ");
		
		
	}
	
	public void returnBook() {
		
	}
	
	public void favoriteBook() {
		
	}

}
