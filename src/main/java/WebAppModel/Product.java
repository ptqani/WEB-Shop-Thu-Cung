package WebAppModel;

import java.io.Serializable;

public class Product implements Serializable {
	private int id;
	private String name;
	private String image;
	private double price;
	private String sellprice;
	private String title;
	private String description;
	private int cateId;
	
	public Product(int id, String name, String image, double price, String sellprice, String title, String description,
			int cateId) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.sellprice = sellprice;
		this.title = title;
		this.description = description;
		this.cateId = cateId;
	}
	public Product() {
		  	id = 0;
	       description = "";
	        price = 0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSellprice() {
		return sellprice;
	}
	public void setSellprice(String sellprice) {
		this.sellprice = sellprice;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCateId() {
		return cateId;
	}
	public void setCateId(int cateId) {
		this.cateId = cateId;
	}
	
	

}
