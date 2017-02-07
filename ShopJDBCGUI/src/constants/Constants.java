package constants;

public class Constants {
	
	public static final int CUSTOMER_COLUMN = 5;
	public static final int CUSTOMER_ROW = 25;
	public static final int PRODUCT_COLUMN = 4;
	public static final int PRODUCT_ROW = 25;
	public static final int ORDER_COLUMN = 4;
	public static final int ORDER_ROW = 25;

	public enum EMainMenuItems {
		CUSTOMER(0, "ȸ�� ����"),
		PRODUCT(1, "��ǰ ����"),
		ORDER(2, "�ֹ� ����");
		
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
		REGISTER(0, "ȸ�� ����"),
		MODIFY(1, "ȸ�� ����"),
		SEARCH(2, "ȸ�� �˻�"),
		DELETE(3, "ȸ�� ����"),
		PRINT(4, "ȸ�� ���");
		
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
		ALL_GOODS(0, "��ü ��ǰ ��ȸ"),
		COUNT_BY_CATEGORY(1, "��ǰ������ �ֹ� ���� ��ȸ");
		
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
		ALL_ORDERS(0, "��ü �ֹ� ���� ��ȸ"),
		COUNT_BY_ID(1, "����ں� �ֹ� ��ȸ"),
		ASK_BY_TIME(2, "�ð� �ֹ� ��ȸ");
		
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
		PASSWD(1, "��й�ȣ"),
		NAME(2, "�̸�"),
		AGE(3, "����"),
		ADDRESS(4, "�ּ�");
		
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
		PRODUCTID(0, "��ǰID"),
		PRODUCTNAME(1, "��ǰ �̸�"),
		CATEGORY(2, "����"),
		INFORMATION(3, "����");
		
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
		PRODUCTID(1, "��ǰ ID"),
		ORDERDATE(2, "�ֹ� ��¥"),
		QUANTITY(3, "����");
		
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
		REGISTER(0, "���"),
		CANCEL(1, "���");
		
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
		SEARCH(0, "�˻�"),
		CANCEL(1, "���");
		
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
		DELETE(0, "����"),
		CANCEL(1, "���");
		
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
		PRINT(0, "���"),
		CANCEL(1, "���");
		
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
		MODIFY(0, "����"),
		CANCEL(1, "���");
		
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
