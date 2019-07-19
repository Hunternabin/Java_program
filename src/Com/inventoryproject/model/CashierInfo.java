package Com.inventoryproject.model;

public class CashierInfo {

	int id;
	String Name,Mno,Address,email,password;
	
	public CashierInfo(int id,String Name,String Mno,String Address,String email,String password) {
		
		this.Name = Name;
		this.Mno = Mno;
		this.Address = Address;
		this.email = email;
		this.password = password;
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getMno() {
		return Mno;
	}

	public void setMno(String mno) {
		Mno = mno;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
