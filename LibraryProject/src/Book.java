
public class Book{

	private static int serialMake = 0;

	public static final boolean LENTED = true;
	public static final boolean NOT_LENTED = false;
	
	private String name;
	private String serial;
	private String category;
	private String author;

	private boolean lent;
	private int lentCnt;
	
	public Book(String name, String category, String author) {
		this.name = name;
		this.serial = "B" + String.format("%04d", ++serialMake);
		this.category = category;
		this.author = author;
		this.lent = false;
		this.lentCnt = 0;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSerial(String serial) {
		this.serial = serial;
	}
	
	public String getSerial() {
		return this.serial;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getCategory() {
		return this.category;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setLent(boolean lent) {
		this.lent = lent;
	}
	
	public boolean getLent() {
		return this.lent;
	}
	
	public void setLentCnt(int lentCnt) {
		this.lentCnt = lentCnt;
	}
	
	public int getLentCnt() {
		return this.lentCnt;
	}
	
	public void increaseLentCnt() {
		this.lentCnt++;
	}
	
	@Override
	public String toString() {
		String str;
		
		if(lent == true) {
			str = "´ë¿©Áß    ";
		} else {
			str = "      ";
		}
		
		return str + String.format("%s  ", serial) + String.format("%-8s  ", category) + name;
	}
}
