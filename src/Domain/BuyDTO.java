package Domain;

public class BuyDTO {
	int buy_no;
	int member_no;
	int acc_no;
	char grade; 
	String brand;
	int price;

	public BuyDTO() {}

	public BuyDTO(int buy_no, int member_no, int acc_no, char grade, String brand, int price) {
		super();
		this.buy_no = buy_no;
		this.member_no = member_no;
		this.acc_no = acc_no;
		this.grade = grade;
		this.brand = brand;
		this.price = price;
	}

	public int getBuy_no() {
		return buy_no;
	}

	public void setBuy_no(int buy_no) {
		this.buy_no = buy_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BuyDTO [buy_no=" + buy_no + ", member_no=" + member_no + ", acc_no=" + acc_no + ", grade=" + grade
				+ ", brand=" + brand + ", price=" + price + "]";
	}
	
}
