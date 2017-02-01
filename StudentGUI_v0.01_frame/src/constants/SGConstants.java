package constants;

public class SGConstants {

	public static final String MAINFRAME_TITLE = "학적관리 ver0.01";

	public static final int MAINFRAME_WIDTH = 500;
	public static final int MAINFRAME_HEIGHT = 500;
	
	public static final int TRUE = 1;
	public static final int FALSE = 0;
	public static final int EXIST = 2;

	public enum ELabelItems {
		NAME("이름"),
		STUDENT_ID("학번"),
		KOR("국어"),
		ENG("영어"),
		MATH("수학"),
		TOTAL("총점"),
		AVG("평균");
		
		private String label;
		
		private ELabelItems(String label) {
			this.label = label;
		}
		
		public String getLabel() {
			return label;
		}
	}

	public enum EEditButtonItems {
		REGIST_STUDENT("학생등록"),
		SEARCH_STUDENT("학생검색"),
		PRINT_STUDENT("학생출력"),
		DELETE_STUDENT("학생삭제"),
		MODIFY_STUDENT("학생수정");
		
		private String usage;
		
		private EEditButtonItems(String usage) {
			this.usage = usage;
		}
		
		public String getUsage() {
			return usage;
		}
	}
	
	public enum EActionButtonItems {
		REGIST("등록"),
		SEARCH("검색"),
		PRINT("출력"),
		DELETE("삭제"),
		MODIFY("수정"),
		CLOSE("닫기");
		
		private String usage;
		
		private EActionButtonItems(String usage) {
			this.usage = usage;
		}
		
		public String getUsage() {
			return usage;
		}
	}
	
	public enum ESortOptionItems {
		SORT_BY_ID("학번순출력"),
		SORT_BY_SCORE("성적순출력");
		
		private String order;
		
		private ESortOptionItems(String order) {
			this.order = order;
		}
		
		public String getOrder() {
			return order;
		}
	}

}
