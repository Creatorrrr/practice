package constants;

public class SGConstants {

	public static final String MAINFRAME_TITLE = "학적관리 ver0.01";

	public static final int MAINFRAME_WIDTH = 500;
	public static final int MAINFRAME_HEIGHT = 500;

	public enum ELabelItems {
		이름, 학번, 국어, 영어, 수학
	}

	public enum EMenuBarItems {
		파일, 편집
	}

	public enum EFileMenuItems {
		저장, 종료
	}

	public enum EEditMenuItems {
		학생등록, 학생검색, 학생삭제, 학생출력, 학생수정
	}
	
	public static final String REGIST_STUDENT = EEditMenuItems.values()[0].name();
	public static final String SEARCH_STUDENT = EEditMenuItems.values()[1].name();
	public static final String DELETE_STUDENT = EEditMenuItems.values()[2].name();
	public static final String PRINT_STUDENT = EEditMenuItems.values()[3].name();
	public static final String MODIFY_STUDENT = EEditMenuItems.values()[4].name();

}
