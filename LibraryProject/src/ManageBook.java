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
		
		Book bTemp = new Book("����111", "�Ҽ�");
		bookMap.put(bTemp.getName(), bTemp);
		bTemp = new Book("����323", "������");
		bookMap.put(bTemp.getName(), bTemp);
		bTemp = new Book("����41234", "����");
		bookMap.put(bTemp.getName(), bTemp);
		bTemp = new Book("����1222", "����");
		bookMap.put(bTemp.getName(), bTemp);
		bTemp = new Book("����634211", "�Ҽ�");
		bookMap.put(bTemp.getName(), bTemp);
	}
	
//	private Book searchName(String name) {		
//		return bookMap.get(name);
//	}
	
	private ArrayList<Book> searchCategory(String category) {
		
		ArrayList<Book> listTemp = new ArrayList<>(ALL_BOOK);	// ��ȯ�� å ����Ʈ ��ü ����
		Book bookTemp;	// ã�Ƴ� å ������ �ӽ� ������ ����
		
		for(int i = 0 ; i < bookList.size() ; i++) {
			bookTemp = bookList.get(i);	// ���� å ���� ����
			
			if(bookTemp.getCategory().contains(category)) {	// å ī�װ��� ���޹��� �̸��� ���� ���
				listTemp.add(bookTemp);				// å ī�װ��� ��ȯ�� ����Ʈ�� �߰�
			}
		}
		
		return listTemp;
	}
	
	public void searchBookName() {
	
		ArrayList<Book> listTemp;
		String key;
		
		Iterator<Book> iter;
		
		System.out.println("[���� �˻�(������)]");
		System.out.println("[�˻�] �������� �Է��ϼ���.");
		System.out.print("> ");
		key = keyIn.next();
		
		System.out.println("�뿩       ID     �з�      ������");
		System.out.println("=========================");
		
		iter = bookMap.values().iterator();
		
		Book bTemp;
		
		for(Book b : bookMap.entrySet()) {
			
		}
		
		while(iter.hasNext()) {
			bTemp = iter.next();
			if(bTemp.getName().contains(key)) {
				System.out.println(bTemp.toString());	// key�� ��ġ�ϴ� ���ڿ��� ������ ��� Book�� ���� toString
			}
		}
		
		for(int i = 0 ; i < bookMap.size() ; i++) {
			System.out.println(listTemp.get(i).toString());	// key�� ��ġ�ϴ� ���ڿ��� ������ ��� Book�� ���� toString
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
