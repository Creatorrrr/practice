package constants;

public class SGConstants {

	public static final String MAINFRAME_TITLE = "�������� ver0.01";

	public static final int MAINFRAME_WIDTH = 500;
	public static final int MAINFRAME_HEIGHT = 500;
	
	public static final int TRUE = 1;
	public static final int FALSE = 0;
	public static final int EXIST = 2;

	public enum ELabelItems {
		NAME("�̸�"),
		STUDENT_ID("�й�"),
		KOR("����"),
		ENG("����"),
		MATH("����"),
		TOTAL("����"),
		AVG("���");
		
		private String label;
		
		private ELabelItems(String label) {
			this.label = label;
		}
		
		public String getLabel() {
			return label;
		}
	}

	public enum EEditButtonItems {
		REGIST_STUDENT("�л����"),
		SEARCH_STUDENT("�л��˻�"),
		PRINT_STUDENT("�л����"),
		DELETE_STUDENT("�л�����"),
		MODIFY_STUDENT("�л�����");
		
		private String usage;
		
		private EEditButtonItems(String usage) {
			this.usage = usage;
		}
		
		public String getUsage() {
			return usage;
		}
	}
	
	public enum EActionButtonItems {
		REGIST("���"),
		SEARCH("�˻�"),
		PRINT("���"),
		DELETE("����"),
		MODIFY("����"),
		CLOSE("�ݱ�");
		
		private String usage;
		
		private EActionButtonItems(String usage) {
			this.usage = usage;
		}
		
		public String getUsage() {
			return usage;
		}
	}
	
	public enum ESortOptionItems {
		SORT_BY_ID("�й������"),
		SORT_BY_SCORE("���������");
		
		private String order;
		
		private ESortOptionItems(String order) {
			this.order = order;
		}
		
		public String getOrder() {
			return order;
		}
	}

}
