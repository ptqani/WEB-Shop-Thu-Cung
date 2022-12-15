package WebAppModel;

public class UserShop {
	private String name;
	private String sdt;
	private String address;
	private String email;
	private int userid;

	public UserShop(String name, String sdt, String address, String email, int userid) {
		super();
		this.name = name;
		this.sdt = sdt;
		this.address = address;
		this.email = email;
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
