import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class ManageBook {

//	private static final int FAIL = -1;
	
	private Scanner keyIn;
	private HashMap<String, Book> bookMap;
	
	private Book mostFavorite;
	
	public ManageBook() {
		keyIn = new Scanner(System.in);
		bookMap = new HashMap<>();
		
		mostFavorite = null;
		
		Book bTemp = new Book("Book111", "Novel", "도끼로 이마까");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("Book323", "Essay", "도끼로 이마까");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("Book41234", "Magazine", "도끼로 이마까");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("Book1222", "Webtoom", "도끼로 이마까");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("Book634211", "Novel", "도끼로 이마까");
		bookMap.put(bTemp.getSerial(), bTemp);
	}
	
	private ArrayList<Book> searchCategory(int category) {
		
		ArrayList<Book> bookList = new ArrayList<>();
		
		Iterator<Entry<String, Book>> bookIt = bookMap.entrySet().iterator();
		
		Book bookTemp;
		String categoryStr = null;
		
		switch(category) {
		case 1:
			categoryStr = "Novel";
			break;
		case 2:
			categoryStr = "Essay";
			break;
		case 3:
			categoryStr = "Magazine";
			break;
		case 4:
			categoryStr = "Webtoon";
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
		
		System.out.println("대여       ID     분류                도서명");
		System.out.println("================================");
		
		listTemp = searchName(key);
		
		for(int i = 0 ; i < listTemp.size() ; i++) {
			System.out.println(listTemp.get(i).toString());
		}
		
		System.out.println("-------------------------");
		
	}
	
	public void searchBookCategory() {
		
		ArrayList<Book> listTemp;
		int key = 0;
		
		System.out.println("[도서 검색(카테고리)]");
		System.out.println("[검색] 카테고리을 선택해 주세요.");
		System.out.println("1.	Novel");
		System.out.println("2.	Essay");
		System.out.println("3.	Magazine");
		System.out.println("4.	Webtoon");
		System.out.print("> ");
		
		while (true) {
			try {
				key = Integer.parseInt(keyIn.next());
				
			} catch (NumberFormatException e) {
				System.out.println("숫자값만 입력이 가능합니다.");
				System.out.print("> ");
				continue;
			}
			
			if(key >= 1 && key <= 4) {
				break;
			} else {
				System.out.println("카테고리를 다시 확인해 주세요.");
				System.out.print("> ");
			}
		}
		
		System.out.println("대여       ID     분류                도서명");
		System.out.println("================================");
		
		listTemp = searchCategory(key);
		
		for(int i = 0 ; i < listTemp.size() ; i++) {
			System.out.println(listTemp.get(i).toString());
		}
		
		System.out.println("-------------------------");
		
	}
	
	public void lentBook() {
		
		Book bookTemp;
		
		String key;
		
		System.out.println("[도서 대여]");
		System.out.println("[대여] 도서ID를 입력하세요.");
		System.out.print("> ");
		
		key = keyIn.next();
		bookTemp = bookMap.get(key);
		
		if(bookTemp != null) {
			if(bookTemp.getLent() == Book.NOT_LENTED) {
				bookTemp.setLent(Book.LENTED);	// 대여 상태로 설정
				bookTemp.increaseLentCnt();		// 대여 횟수 1회 증가
				mostFavoriteUpdate(bookTemp);	// 인기 도서 업데이트
				System.out.println("대여가 완료되었습니다.");
				return;	// 대여에 성공하면 바로 메소드 종료
			}
		}
		
		// 대여에 실패했을 경우
		System.out.println("대여할 수 없는 도서입니다. 다시 확인해주세요.");
	}
	
	private void mostFavoriteUpdate(Book book) {
		if (mostFavorite == null) {	// 가장 인기있는 도서가 없을 경우 바로 등록
			mostFavorite = book;
		} else if(book.getLentCnt() > mostFavorite.getLentCnt()) {	// 가장 인기있는 도서의 대여횟수보다 클 경우 업데이트
			mostFavorite = book;
		}
	}
	
	public void returnBook() {
		
		Book bookTemp;
		
		String key;
		
		System.out.println("[도서 반납]");
		System.out.println("[반납] 도서ID를 입력하세요.");
		System.out.print("> ");
		
		key = keyIn.next();
		bookTemp = bookMap.get(key);
		
		if(bookTemp != null) {
			if(bookTemp.getLent() == Book.LENTED) {
				bookTemp.setLent(Book.NOT_LENTED);		// 반납 상태로 설정
				System.out.println("반납이 완료되었습니다.");
				return;	// 반납에 성공하면 바로 메소드 종료
			}
		}
		
		// 반납에 실패했을 경우
		System.out.println("반납할 수 없는 도서입니다. 다시 확인해주세요.");
		
	}
	
	public void favoriteBook() {
		if(mostFavorite == null) {
			System.out.println("가장 인기있는 도서가 아직 등록되지 않았습니다.");
			return;
		}
		
		System.out.println("[가장 인기있는 도서]");
		System.out.println("ID\t| " + mostFavorite.getSerial());
		System.out.println("분류\t| " + mostFavorite.getCategory());
		System.out.println("도서명\t| " + mostFavorite.getName());
		System.out.println("저자\t| " + mostFavorite.getAuthor());
		
		if(mostFavorite.getLent() == Book.LENTED) {
			System.out.println("* 현재 대여중인 도서입니다.");
		} else {
			System.out.println("* 대여가능합니다.");
		}
		
		System.out.println("-------------------------");
	}
}
