package com.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @category 用户实体类
 *
 * @author WOM
 *
 */
public class usermodel {
	private int id;
	private String username;
	private String password;
	private String img; 
	private String name;
	private int qq;
	private String email;
	private int range;
	
	public usermodel() {
		super();
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	/**
	 * @category 用过用户信息集合，给各项属性赋值，并返回user
	 * @param rs
	 * @return user
	 * @throws SQLException
	 */
	public usermodel createUser(ResultSet rs) throws SQLException {
		usermodel user = new usermodel();
		user.setId(rs.getInt(1));
		user.setName(rs.getString(2));
		
  		user.setUsername(rs.getString("username"));
  		user.setId(rs.getInt("id"));
  		user.setPassword(rs.getString(3));
  		user.setImg(rs.getString(4));
  		user.setName(rs.getString(5));
  		user.setQq(rs.getInt(6));
  		user.setRange(rs.getInt("range"));
  		
  		user.setEmail(rs.getString("email"));
		return user;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "usermodel [id=" + id + ", username=" + username + ", password=" + password + ", img=" + img + ", name="
				+ name + ", qq=" + qq + ", email=" + email + ", range=" + range + "]";
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
	public int getQq() {
		return qq;
	}
	public void setQq(int qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
	
}
