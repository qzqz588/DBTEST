package Domain;

public class UserDTO {
	int bookCode; 
	int classificationId; 
	String bookAuthor; 
	String bookName; 
	String publisher;  
	boolean isreserve;
	public UserDTO(int bookCode, int classificationId, String bookAuthor, String bookName, String publisher,
			boolean isreserve) {
		super();
		this.bookCode = bookCode;
		this.classificationId = classificationId;
		this.bookAuthor = bookAuthor;
		this.bookName = bookName;
		this.publisher = publisher;
		this.isreserve = isreserve;
	}
	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public int getClassificationId() {
		return classificationId;
	}
	public void setClassificationId(int classificationId) {
		this.classificationId = classificationId;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public boolean isIsreserve() {
		return isreserve;
	}
	public void setIsreserve(boolean isreserve) {
		this.isreserve = isreserve;
	}  
	
	
}
