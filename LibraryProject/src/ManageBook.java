import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ManageBook {

	public static final int ALL_BOOK = 100;
	public static final int FAIL = -1;
	
	Scanner keyIn;
	ArrayList<Book> bookList;
	
	public ManageBook() {
		keyIn = new Scanner(System.in);
		bookList = new ArrayList<>(ALL_BOOK);
		
		bookList.add(new Book("����111", "��ȭ"));
		bookList.add(new Book("����323", "����"));
		bookList.add(new Book("����41234", "�Ҽ�"));
		bookList.add(new Book("����1222", "����"));
		bookList.add(new Book("����634211", "��ȭ"));
	}
	
	private ArrayList<Book> searchName(String name) {
		
		ArrayList<Book> listTemp = new ArrayList<>(ALL_BOOK);	// ��ȯ�� å ����Ʈ ��ü ����
		Book bookTemp;	// ã�Ƴ� å ������ �ӽ� ������ ����
		
		for(int i = 0 ; i < bookList.size() ; i++) {
			bookTemp = bookList.get(i);	// ���� å ���� ����
			
			if(bookTemp.getName().contains(name)) {	// å �̸��� ���޹��� �̸��� ���� ���
				listTemp.add(bookTemp);				// å �̸��� ��ȯ�� ����Ʈ�� �߰�
			}
		}
		
		return listTemp;
	}
	
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
		
		System.out.println("[���� �˻�(������)]");
		System.out.println("[�˻�] �������� �Է��ϼ���.");
		System.out.print("> ");
		key = keyIn.next();
		
		System.out.println("�뿩       ID     �з�      ������");
		System.out.println("=========================");
		
		listTemp = searchName(key);	// ���� �˻�
		
		Collections.sort(listTemp);	// ���� ����
		
		for(int i = 0 ; i < listTemp.size() ; i++) {
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
