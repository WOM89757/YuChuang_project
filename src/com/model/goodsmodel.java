package com.model;

public class goodsmodel {
	private int id;
	private String name;
	private String img;
	private double price;
	private String intro;
	private String description;
	private String sort;
	private int quantity;

	
	
	
	public goodsmodel(int id, String name, String img, double price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.price = price;
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public goodsmodel(int id, String name, String img, double price, String intro, String description, String sort) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.price = price;
		this.intro = intro;
		this.description = description;
		this.sort = sort;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public goodsmodel() {
		super();
	}
	public goodsmodel(int id, String name, String img, double price, String intro, String description) {
		super();
		this.id = id;
		this.name = name;
		this.img = img;
		this.price = price;
		this.intro = intro;
		this.description = description;
	}
	@Override
	public String toString() {
		return "goodsmodel [id=" + id + ", name=" + name + ", img=" + img + ", price=" + price + ", intro=" + intro
				+ ", description=" + description + "]";
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
