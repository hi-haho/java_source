package pack;

import java.sql.Date;

public class Product {
	private String name;
	private double price;
	private String description;
	private java.util.Date releaseDate;
	
	public Product(String name,double price, String description, java.util.Date releaseDate) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.releaseDate = releaseDate;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public java.util.Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(java.util.Date releaseDate) {
		this.releaseDate = releaseDate;
	}
}
