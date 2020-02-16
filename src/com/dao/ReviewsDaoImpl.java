package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.db.DBHelper;
import com.model.goodsmodel;
import com.model.reviewsmodel;

public class ReviewsDaoImpl {
	//删除评论信息
	public int delete(int id) {
		int i = 0;
		try {
			DBHelper db = new DBHelper();
			String sql = "delete from reviews where reviews_id = ?";
			 i = db.executeUpdate(sql,id);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
		//添加评论信息
		public int addReviews(int userid,int goodsid,String content) throws SQLException {
			DBHelper db = new DBHelper();
			String sql="INSERT INTO `reviews`(`user_id`,`goods_id`,`content`)  VALUES (?,?,?) ";
			int i = db.executeUpdate(sql,userid,goodsid,content);
			return  i;
		}
		@Test
		public void addtest() throws SQLException {
			System.out.println(this.addReviews(1, 1, "adad"));
		}
		//返回评论列表
		public List<reviewsmodel> findReviewsList() {
			List<reviewsmodel> list = new ArrayList<reviewsmodel>();
			try {
				DBHelper db = new DBHelper();
				String sql = "select u.`name`,g.img,r.content " + 
						"from user u ,goods g,reviews r " + 
						"where u.id=r.user_id and g.goods_id=r.goods_id";
				ResultSet result = db.executeQuery(sql);
				while (result.next()) {
					reviewsmodel reviews = this.createreviews(result);
					list.add(reviews);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
		
		/**
		 * 创建评论对象
		 * @param rs
		 * @return
		 * @throws SQLException
		 */
		private reviewsmodel createreviews(ResultSet rs) throws SQLException {
			reviewsmodel reviews = new reviewsmodel(rs.getString(1),rs.getString(2),rs.getString(3));

			return reviews;
		}

}
