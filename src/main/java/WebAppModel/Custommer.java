package WebAppModel;

import java.util.ArrayList;
import java.util.List;

public class Custommer {
	private int iduser;
	private String name;
	private String email;
	private String address;
	private String sdt;
	private double sumallpro;
	private int quantity;
	private String datetime;
List<Product> listPro= new ArrayList<>();
List listCustommer = new ArrayList<>();
public Custommer() {
	
}
	public Custommer(int iduser, String name, String email, String address, String sdt, double sumallpro, int quantity,
			String datetime) {
		super();
		this.iduser = iduser;
		this.name = name;
		this.email = email;
		this.address = address;
		this.sdt = sdt;
		this.sumallpro = sumallpro;
		this.quantity = quantity;
		this.datetime = datetime;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public double getSumallpro() {
		return sumallpro;
	}

	public void setSumallpro(double sumallpro) {
		this.sumallpro = sumallpro;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDatetime() {
		return datetime;
	}

	public List<Product> getListPro() {
		return listPro;
	}

	public void setListPro(List<Product> listPro) {
		this.listPro = listPro;
	}
	public void setListCus(List<Custommer> listCustommer) {
		this.listCustommer = listCustommer;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}
