package Domain;

public class AccDTO {
	int acc_no; 
	String acc_type; 
	int price; 
	int brand_no; 
	int material_no;  


	@Override
	public String toString() {
		return "AccDTO [acc_no=" + acc_no + ", acc_type=" + acc_type + ", price=" + price + ", brand_no=" + brand_no
				+ ", material_no=" + material_no + "]";
	}

	public AccDTO(int acc_no, String acc_type, int price, int brand_no, int material_no) {
		super();
		this.acc_no = acc_no;
		this.acc_type = acc_type;
		this.price = price;
		this.brand_no = brand_no;
		this.material_no = material_no;
	}

	public AccDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getAcc_no() {
		return acc_no;
	}

	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}

	public String getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBrand_no() {
		return brand_no;
	}

	public void setBrand_no(int brand_no) {
		this.brand_no = brand_no;
	}

	public int getMaterial_no() {
		return material_no;
	}

	public void setMaterial_no(int material_no) {
		this.material_no = material_no;
	}


	
}
