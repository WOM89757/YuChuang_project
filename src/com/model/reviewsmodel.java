package com.model;

public class reviewsmodel {
	private String name;
	private String img;
	private String content;
	private String id;
	public reviewsmodel(String name, String img, String content, String id) {
		super();
		this.name = name;
		this.img = img;
		this.content = content;
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public reviewsmodel(String name, String img, String content) {
		super();
		this.name = name;
		this.img = img;
		this.content = content;
	}

	
	
	

}
