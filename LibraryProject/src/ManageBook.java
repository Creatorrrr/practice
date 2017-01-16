import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class ManageBook {

	public static final int FAIL = -1;
	
	Scanner keyIn;
	HashMap<String, Book> bookMap;
	
	public ManageBook() {
		keyIn = new Scanner(System.in);
		bookMap = new HashMap<>();
		
		Book bTemp = new Book("도서111", "소설");
		bookMap.put(bTemp.getName(), bTemp);
		bTemp = new Book("도서323", "에세이");
		bookMap.put(bTemp.getName(), bTemp);
		bTemp = new Book("도서41234", "잡지");
		bookMap.put(bTemp.getName(), bTemp);
		bTemp = new Book("도서1222", "웹툰");
		bookMap.put(bTemp.getName(), bTemp);
		bTemp = new Book("도서634211", "소설");
		bookMap.put(bTemp.getName(), bTemp);
	}
	
//	private Book searchName(String name) {		
//		return bookMap.get(name);
//	}
	
	private ArrayList<Book> searchCategory(String category) {
		
		ArrayList<Book> listTemp = new ArrayList<>(ALL_BOOK);	// 반환할 책 리스트 객체 생성
		Book bookTemp;	// 찾아낸 책 정보를 임시 저장할 공간
		
		for(int i = 0 ; i < bookList.size() ; i++) {
			bookTemp = bookList.get(i);	// 현재 책 정보 추출
			
			if(bookTemp.getCategory().contains(category)) {	// 책 카테고리가 전달받은 이름과 같을 경우
				listTemp.add(bookTemp);				// 책 카테고리를 반환할 리스트에 추가
			}
		}
		
		return listTemp;
	}
	
	public void searchBookName() {
	
		ArrayList<Book> listTemp;
		String key;
		
		Iterator<Book> iter;
		
		System.out.println("[도서 검색(도서명)]");
		System.out.println("[검색] 도서명을 입력하세요.");
		System.out.print("> ");
		key = keyIn.next();
		
		System.out.println("대여       ID     분류      도서명");
		System.out.println("=========================");
		
		iter = bookMap.values().iterator();
		
		Book bTemp;
		
		for(Book b : bookMap.entrySet()) {
			
		}
		
		while(iter.hasNext()) {
			bTemp = iter.next();
			if(bTemp.getName().contains(key)) {
				System.out.println(bTemp.toString());	// key와 일치하는 문자열을 포함한 모든 Book에 대해 toString
			}
		}
		
		for(int i = 0 ; i < bookMap.size() ; i++) {
			System.out.println(listTemp.get(i).toString());	// key와 일치하는 문자열을 포함한 모든 Book에 대해 toString
		}
		
		System.out.println("-------------------------");
		
	}
	
	public void searchBookCategory() {
		
	}
	
	public void lentBook() {
		
	}
	
	public void returnBook() {
		
	}
	
	public void favoriteBook() {
		
	}

}
