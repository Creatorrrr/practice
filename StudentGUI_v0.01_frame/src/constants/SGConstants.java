package constants;

public class SGConstants {

	public static final String MAINFRAME_TITLE = "�������� ver0.01";

	public static final int MAINFRAME_WIDTH = 500;
	public static final int MAINFRAME_HEIGHT = 500;

	public enum ELabelItems {
		�̸�, �й�, ����, ����, ����
	}

	public enum EMenuBarItems {
		����, ����
	}

	public enum EFileMenuItems {
		����, ����
	}

	public enum EEditMenuItems {
		�л����, �л��˻�, �л�����, �л����, �л�����
	}
	
	public static final String REGIST_STUDENT = EEditMenuItems.values()[0].name();
	public static final String SEARCH_STUDENT = EEditMenuItems.values()[1].name();
	public static final String DELETE_STUDENT = EEditMenuItems.values()[2].name();
	public static final String PRINT_STUDENT = EEditMenuItems.values()[3].name();
	public static final String MODIFY_STUDENT = EEditMenuItems.values()[4].name();

}
