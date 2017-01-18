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
		
		Book bTemp = new Book("Book111", "Novel", "������ �̸���");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("Book323", "Essay", "������ �̸���");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("Book41234", "Magazine", "������ �̸���");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("Book1222", "Webtoom", "������ �̸���");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("Book634211", "Novel", "������ �̸���");
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
		
		System.out.println("[���� �˻�(������)]");
		System.out.println("[�˻�] �������� �Է��ϼ���.");
		System.out.print("> ");
		key = keyIn.next();
		
		System.out.println("�뿩       ID     �з�                ������");
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
		
		System.out.println("[���� �˻�(ī�װ�)]");
		System.out.println("[�˻�] ī�װ��� ������ �ּ���.");
		System.out.println("1.	Novel");
		System.out.println("2.	Essay");
		System.out.println("3.	Magazine");
		System.out.println("4.	Webtoon");
		System.out.print("> ");
		
		while (true) {
			try {
				key = Integer.parseInt(keyIn.next());
				
			} catch (NumberFormatException e) {
				System.out.println("���ڰ��� �Է��� �����մϴ�.");
				System.out.print("> ");
				continue;
			}
			
			if(key >= 1 && key <= 4) {
				break;
			} else {
				System.out.println("ī�װ��� �ٽ� Ȯ���� �ּ���.");
				System.out.print("> ");
			}
		}
		
		System.out.println("�뿩       ID     �з�                ������");
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
		
		System.out.println("[���� �뿩]");
		System.out.println("[�뿩] ����ID�� �Է��ϼ���.");
		System.out.print("> ");
		
		key = keyIn.next();
		bookTemp = bookMap.get(key);
		
		if(bookTemp != null) {
			if(bookTemp.getLent() == Book.NOT_LENTED) {
				bookTemp.setLent(Book.LENTED);	// �뿩 ���·� ����
				bookTemp.increaseLentCnt();		// �뿩 Ƚ�� 1ȸ ����
				mostFavoriteUpdate(bookTemp);	// �α� ���� ������Ʈ
				System.out.println("�뿩�� �Ϸ�Ǿ����ϴ�.");
				return;	// �뿩�� �����ϸ� �ٷ� �޼ҵ� ����
			}
		}
		
		// �뿩�� �������� ���
		System.out.println("�뿩�� �� ���� �����Դϴ�. �ٽ� Ȯ�����ּ���.");
	}
	
	private void mostFavoriteUpdate(Book book) {
		if (mostFavorite == null) {	// ���� �α��ִ� ������ ���� ��� �ٷ� ���
			mostFavorite = book;
		} else if(book.getLentCnt() > mostFavorite.getLentCnt()) {	// ���� �α��ִ� ������ �뿩Ƚ������ Ŭ ��� ������Ʈ
			mostFavorite = book;
		}
	}
	
	public void returnBook() {
		
		Book bookTemp;
		
		String key;
		
		System.out.println("[���� �ݳ�]");
		System.out.println("[�ݳ�] ����ID�� �Է��ϼ���.");
		System.out.print("> ");
		
		key = keyIn.next();
		bookTemp = bookMap.get(key);
		
		if(bookTemp != null) {
			if(bookTemp.getLent() == Book.LENTED) {
				bookTemp.setLent(Book.NOT_LENTED);		// �ݳ� ���·� ����
				System.out.println("�ݳ��� �Ϸ�Ǿ����ϴ�.");
				return;	// �ݳ��� �����ϸ� �ٷ� �޼ҵ� ����
			}
		}
		
		// �ݳ��� �������� ���
		System.out.println("�ݳ��� �� ���� �����Դϴ�. �ٽ� Ȯ�����ּ���.");
		
	}
	
	public void favoriteBook() {
		if(mostFavorite == null) {
			System.out.println("���� �α��ִ� ������ ���� ��ϵ��� �ʾҽ��ϴ�.");
			return;
		}
		
		System.out.println("[���� �α��ִ� ����]");
		System.out.println("ID\t| " + mostFavorite.getSerial());
		System.out.println("�з�\t| " + mostFavorite.getCategory());
		System.out.println("������\t| " + mostFavorite.getName());
		System.out.println("����\t| " + mostFavorite.getAuthor());
		
		if(mostFavorite.getLent() == Book.LENTED) {
			System.out.println("* ���� �뿩���� �����Դϴ�.");
		} else {
			System.out.println("* �뿩�����մϴ�.");
		}
		
		System.out.println("-------------------------");
	}
}
