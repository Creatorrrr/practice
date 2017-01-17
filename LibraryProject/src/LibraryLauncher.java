import java.util.Scanner;

public class LibraryLauncher {

	public static void main(String[] args) {
		
		Scanner keyIn = new Scanner(System.in);
		
		ManageBook manageBook = new ManageBook();
		
		String keyTemp;
		int key = 0;
		
		while(true) {
			System.out.println("========================");
			System.out.println("	나무소리 도서관 v1.0");
			System.out.println("========================");
			System.out.println("[메뉴]");
			System.out.println("1.	도서 검색(도서명)");
			System.out.println("2.	도서 검색(카테고리)");
			System.out.println("3.	도서 대여");
			System.out.println("4.	도서 반납");
			System.out.println("5.	가장 인기있는 도서");
			System.out.println("e.	종료");
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
		
		System.out.println("종료되었습니다");
		
	}
	
}
