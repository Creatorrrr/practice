import java.util.Scanner;

public class LibraryLauncher {

	public static void main(String[] args) {
		
		/* ���� ���� �޴� ����
		 * 1. ���� ����
		 * 1.1. ���� �˻�(������)
		 * 1.2. ���� �˻�(ī�װ�)
		 * 1.3. ���� �뿩
		 * 1.4. ���� �ݳ�
		 * 1.5. ���� �α��ִ� ����
		 */
		
		System.out.println();
		
		Scanner keyIn = new Scanner(System.in);
		
		ManageBook manageBook = new ManageBook();
		
		String keyTemp;
		int key = 0;
		
		while(true) {
			System.out.println("========================");
			System.out.println("	�����Ҹ� ������ v1.0");
			System.out.println("========================");
			System.out.println("[�޴�]");
			System.out.println("1.	���� �˻�(������)");
			System.out.println("2.	���� �˻�(ī�װ�)");
			System.out.println("3.	���� �뿩");
			System.out.println("4.	���� �ݳ�");
			System.out.println("5.	���� �α��ִ� ����");
			System.out.println("e.	����");
			System.out.print("> ");
			
			keyTemp = keyIn.next();
			
			try {
				key = Integer.parseInt(keyTemp);
			} catch (NumberFormatException e) {
				if(keyTemp.equals("e")) {
					break;
				}
			}
			
			switch(key) {
			case 1:
				manageBook.searchBookName();
				break;
			case 2:
				manageBook.searchBookCategory();
				break;
			case 3:
				manageBook.lentBook();
				break;
			case 4:
				manageBook.returnBook();
				break;
			case 5:
				manageBook.favoriteBook();
				break;
			}
		}
		
		System.out.println("����Ǿ����ϴ�");
		
	}
	
}
