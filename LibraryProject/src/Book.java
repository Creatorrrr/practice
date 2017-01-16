
public class Book implements Comparable<Book> {

	private static int serialMake = 0;
	
	private String name;
	private String serial;
	private String category;
	private boolean lent;
	private int lentCnt;
	
	public Book(String name, String category) {
		this.name = name;
		this.serial = "B" + String.format("%04d", ++serialMake);
		this.category = category;
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
	
	@Override
	public int compareTo(Book o) {
		return this.name.compareTo(o.getName());
	}
	
	@Override
	public String toString() {
		String str;
		
		if(lent == true) {
			str = "´ë¿©Áß";
		} else {
			str = "    ";
		}
		
		return str + String.format("%7s", serial) + String.format("%4s      ", category) + name;
	}
}
