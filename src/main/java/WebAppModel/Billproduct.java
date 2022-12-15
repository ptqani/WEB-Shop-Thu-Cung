package WebAppModel;

public class Billproduct {
	private int id_product;
	private int idcustom;
	private int quantity;
	private String datetime;

	public Billproduct(int id_product, int idcustom, int quantity, String datetime) {
		super();
		this.id_product = id_product;
		this.idcustom = idcustom;
		this.quantity = quantity;
		this.datetime = datetime;
	}

	public int getId_product() {
		return id_product;
	}

	public void setId_product(int id_product) {
		this.id_product = id_product;
	}

	public int getIdcustom() {
		return idcustom;
	}

	public void setIdcustom(int idcustom) {
		this.idcustom = idcustom;
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

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

}
