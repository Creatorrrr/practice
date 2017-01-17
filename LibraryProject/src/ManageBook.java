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
		
		Book bTemp = new Book("����111", "�Ҽ�");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("����323", "������");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("����41234", "����");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("����1222", "����");
		bookMap.put(bTemp.getSerial(), bTemp);
		bTemp = new Book("����634211", "�Ҽ�");
		bookMap.put(bTemp.getSerial(), bTemp);
	}
	
	private ArrayList<Book> searchCategory(int category) {
		
		ArrayList<Book> bookList = new ArrayList<>();
		
		Iterator<Entry<String, Book>> bookIt = bookMap.entrySet().iterator();
		
		Book bookTemp;
		String categoryStr = null;
		
		switch(category) {
		case 1:
			categoryStr = "�Ҽ�";
			break;
		case 2:
			categoryStr = "������";
			break;
		case 3:
			categoryStr = "����";
			break;
		case 4:
			categoryStr = "����";
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
		
		System.out.println("�뿩       ID     �з�      ������");
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
		
		System.out.println("[���� �˻�(ī�װ�)]");
		System.out.println("[�˻�] ī�װ��� ������ �ּ���.");
		System.out.println("1.	�Ҽ�");
		System.out.println("2.	������");
		System.out.println("3.	����");
		System.out.println("4.	����");
		System.out.print("> ");
		
		while (true) {
			key = keyIn.nextInt();
			if(key >= 1 && key <= 4) {
				break;
			} else {
				System.out.println("ī�װ��� �ٽ� Ȯ���� �ּ���.");
				System.out.print("> ");
			}
		}
		
		System.out.println("�뿩       ID     �з�      ������");
		System.out.println("=========================");
		
		listTemp = searchCategory(key);
		
		for(int i = 0 ; i < listTemp.size() ; i++) {
			listTemp.get(i).toString();
		}
		
		System.out.println("-------------------------");
		
	}
	
	public void lentBook() {
		
		System.out.println("[���� �뿩]");
		System.out.println("[�ݳ�] ����ID�� �Է��ϼ���.");
		System.out.print("> ");
		
		
	}
	
	public void returnBook() {
		
	}
	
	public void favoriteBook() {
		
	}

}
