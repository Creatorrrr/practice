import controller.SGStudent;
import jdbc.SGStoreDB;

public class Test {

	public static void main(String[] args) {
		SGStoreDB store = new SGStoreDB();
		
		store.insertStudent(new SGStudent("asdf", "0000", 12, 23, 34));
//		store.updateStudent(new SGStudent("qwer", "2222", 33, 24, 37), "1111");
//		store.deleteStudent("2222");
		for(SGStudent s : store.selectStudent("1111")) {
			System.out.println(s.toString());
		}
	}
}
