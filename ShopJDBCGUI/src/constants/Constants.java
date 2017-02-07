package constants;

public class Constants {
	
	public static final int CUSTOMER_COLUMN = 5;
	public static final int CUSTOMER_ROW = 25;
	public static final int PRODUCT_COLUMN = 4;
	public static final int PRODUCT_ROW = 25;
	public static final int ORDER_COLUMN = 4;
	public static final int ORDER_ROW = 25;

	public enum EMainMenuItems {
		CUSTOMER(0, "회원 관리"),
		PRODUCT(1, "상품 관리"),
		ORDER(2, "주문 관리");
		
		private int index;
		private String name;
		
		private EMainMenuItems(int index, String name) {
			this.index = index;
			this.name = name;
		}
		
		public int getIndex() {return this.index;}
		public String getName() {return this.name;}
	}
	
	public enum ECustomerMenuItems {
		REGISTER(0, "회원 가입"),
		MODIFY(1, "회원 수정"),
		SEARCH(2, "회원 검색"),
		DELETE(3, "회원 삭제"),
		PRINT(4, "회원 출력");
		
		private int index;
		private String name;
		
		private ECustomerMenuItems(int index, String name) {
			this.index = index;
			this.name = name;
		}
		
		public int getIndex() {return this.index;}
		public String getName() {return this.name;}
	}
	
	public enum EProductMenuItems {
		ALL_GOODS(0, "전체 상품 조회"),
		COUNT_BY_CATEGORY(1, "상품종류별 주문 수량 조회");
		
		private int index;
		private String name;
		
		private EProductMenuItems(int index, String name) {
			this.index = index;
			this.name = name;
		}
		
		public int getIndex() {return this.index;}
		public String getName() {return this.name;}
	}
	
	public enum EOrderMenuItems {
		ALL_ORDERS(0, "전체 주문 내역 조회"),
		COUNT_BY_ID(1, "사용자별 주문 조회"),
		ASK_BY_TIME(2, "시간 주문 조회");
		
		private int index;
		private String name;
		
		private EOrderMenuItems(int index, String name) {
			this.index = index;
			this.name = name;
		}
		
		public int getIndex() {return this.index;}
		public String getName() {return this.name;}
	}
	
	public enum ECustomerTableItems {
		ID(0, "ID"),
		PASSWD(1, "비밀번호"),
		NAME(2, "이름"),
		AGE(3, "나이"),
		ADDRESS(4, "주소");
		
		private int index;
		private String name;
		
		private ECustomerTableItems(int index, String name) {
			this.index = index;
			this.name = name;
		}
		
		public int getIndex() {return this.index;}
		public String getName() {return this.name;}
	}
	
	public enum EProductTableItems {
		PRODUCTID(0, "제품ID"),
		PRODUCTNAME(1, "제품 이름"),
		CATEGORY(2, "종류"),
		INFORMATION(3, "정보");
		
		private int index;
		private String name;
		
		private EProductTableItems(int index, String name) {
			this.index = index;
			this.name = name;
		}
		
		public int getIndex() {return this.index;}
		public String getName() {return this.name;}
	}
	
	public enum EOrderTableItems {
		ID(0, "ID"),
		PRODUCTID(1, "제품 ID"),
		ORDERDATE(2, "주문 날짜"),
		QUANTITY(3, "수량");
		
		private int index;
		private String name;
		
		private EOrderTableItems(int index, String name) {
			this.index = index;
			this.name = name;
		}
		
		public int getIndex() {return this.index;}
		public String getName() {return this.name;}
	}
	
	public enum ERegisterButtonItems {
		REGISTER(0, "등록"),
		CANCEL(1, "취소");
		
		private int index;
		private String name;
		
		private ERegisterButtonItems(int index, String name) {
			this.index = index;
			this.name = name;
		}
		
		public int getIndex() {return this.index;}
		public String getName() {return this.name;}
	}
	
	public enum ESearchButtonItems {
		SEARCH(0, "검색"),
		CANCEL(1, "취소");
		
		private int index;
		private String name;
		
		private ESearchButtonItems(int index, String name) {
			this.index = index;
			this.name = name;
		}
		
		public int getIndex() {return this.index;}
		public String getName() {return this.name;}
	}
	
	public enum EDeleteButtonItems {
		DELETE(0, "삭제"),
		CANCEL(1, "취소");
		
		private int index;
		private String name;
		
		private EDeleteButtonItems(int index, String name) {
			this.index = index;
			this.name = name;
		}
		
		public int getIndex() {return this.index;}
		public String getName() {return this.name;}
	}
	
	public enum EPrintButtonItems {
		PRINT(0, "출력"),
		CANCEL(1, "취소");
		
		private int index;
		private String name;
		
		private EPrintButtonItems(int index, String name) {
			this.index = index;
			this.name = name;
		}
		
		public int getIndex() {return this.index;}
		public String getName() {return this.name;}
	}
	
	public enum EModifyButtonItems {
		MODIFY(0, "수정"),
		CANCEL(1, "취소");
		
		private int index;
		private String name;
		
		private EModifyButtonItems(int index, String name) {
			this.index = index;
			this.name = name;
		}
		
		public int getIndex() {return this.index;}
		public String getName() {return this.name;}
	}
}
