package Domain;

public class UserDTO {
	int member_no; 
	String member_name; 
	char grade; 
	String phone;  
	String address;

	public UserDTO() {}
	
	public UserDTO(int member_no, String member_name, char grade, String phone, String address) {
		super();
		this.member_no = member_no;
		this.member_name = member_name;
		this.grade = grade;
		this.phone = phone;
		this.address = address;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserDTO [member_no=" + member_no + ", member_name=" + member_name + ", grade=" + grade + ", phone="
				+ phone + ", address=" + address + "]";
	}
}
