package bookstore.javabeans;

public class Bookstore {
	
	private int storeId;
	private String name;
	private String address;
	private String tel;
	
	public Bookstore() {
		
	}
	
	public Bookstore(int storeId, String name, String address, String tel) {
		this.storeId = storeId;
		this.name = name;
		this.address = address;
		this.tel = tel;
	}
	public Bookstore(String name, String address, String tel) {
		this.name = name;
		this.address = address;
		this.tel = tel;
	}

	public void setStoreId(int id) {
		this.storeId = id;
	}
	
	public int getStoreId() {
		return storeId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getTel() {
		return tel;
	}
}
