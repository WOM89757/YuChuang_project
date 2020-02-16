package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DBHelper;
import com.model.goodsmodel;
import com.model.usermodel;

public class userdao {
	
	
	
	public List<usermodel> userlist(String sql) throws SQLException
    {
		
		DBHelper db = new DBHelper();
	    sql = "select * from user ";
		ResultSet rs = db.executeQuery(sql);
        List<usermodel> users=new ArrayList<>();

        while(rs.next())
        {
            usermodel user=new usermodel();
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
            users.add(user);
        }
        
        return users;
    }

	
	/**
	 * 返回用户列表
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public List<usermodel> userlist() throws SQLException
    {
			List<usermodel> list = new ArrayList<usermodel>();
	    
			DBHelper db = new DBHelper();
		  String  sql = "select * from user ";
			ResultSet result = db.executeQuery(sql);
			while (result.next()) {
				usermodel goods = this.createUser(result);
				list.add(goods);
	    }
			return list;
    }
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


}
