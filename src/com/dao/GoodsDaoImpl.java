package com.dao;

import java.util.List;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.db.DBHelper;
import com.model.goodsmodel;

public class GoodsDaoImpl {
	
	public int delete(int id) {
		int i = 0;
		try {
			DBHelper db = new DBHelper();
			String sql = "delete from goods where goods_id = ?";
			 i = db.executeUpdate(sql,id);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	//返回商品列表
	public List<goodsmodel> findGoodList() {
		List<goodsmodel> list = new ArrayList<goodsmodel>();
		try {
			DBHelper db = new DBHelper();
			String sql = "select * from goods ";
			ResultSet result = db.executeQuery(sql);
			while (result.next()) {
				goodsmodel goods = this.creategoods(result);
				list.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//返回商品列表
	/**
	 * 根据商品id，返回商品信息
	 * @param id
	 * @return
	 */
	public List<goodsmodel> findGoodList(int id) {
		List<goodsmodel> list = new ArrayList<goodsmodel>();
		try {
			DBHelper db = new DBHelper();
			String sql = "select * from goods where goods_id=?";
			ResultSet result = db.executeQuery(sql,id);
			while (result.next()) {
				goodsmodel goods = this.creategoods(result);
				list.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
		/**
		 * 根据商品名字，返回相关商品信息
		 * @param name
		 * @return list
		 */
	public List<goodsmodel> findGoodnameList(String name) {
		List<goodsmodel> list = new ArrayList<goodsmodel>();
		try {
			DBHelper db = new DBHelper();
			String sql = "select *from goods where goods.sort REGEXP ? ";
			ResultSet result = db.executeQuery(sql,name);
			while (result.next()) {
				goodsmodel goods = this.creategoods(result);
				list.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	@Test
	public void findgoodsnametest() {
		System.out.println(this.findGoodnameList("床"));
	}
	
	/**
	 * 根据商品类型，返回同类商品信息
	 * @param id
	 * @return
	 */
	public List<goodsmodel> findGoodsortList(String sort) {
		List<goodsmodel> list = new ArrayList<goodsmodel>();
		try {
			DBHelper db = new DBHelper();
			String sql = "SELECT * from goods where goods.sort=?";
			
			ResultSet result = db.executeQuery(sql,sort);
			while (result.next()) {
				goodsmodel goods = this.creategoods(result);
				list.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 根据商品id，返回同类商品信息
	 * @param id
	 * @return
	 */
	public List<goodsmodel> findGoodsortList(int id) {
		List<goodsmodel> list = new ArrayList<goodsmodel>();
		try {
			DBHelper db = new DBHelper();
			String sql = "select * from goods " + 
					"where goods.sort in (select goods.sort from goods where goods_id=?);";
			ResultSet result = db.executeQuery(sql,id);
			while (result.next()) {
				goodsmodel goods = this.creategoods(result);
				list.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//通过商品ID查找商品信息
	public goodsmodel find(int id) {
		goodsmodel goods = null;
		try {
			DBHelper db = new DBHelper();
			String sql = "select * from goods where goods_id=?";
			ResultSet result = db.executeQuery(sql,id);
			while (result.next()) {
				goods=this.creategoods(result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goods;
	}
	@Test
	public void test() {
		System.out.println(this.findGoodList(1));
	}
	@Test
	public void testfind() {
		System.out.println(this.find(1));
	}

	/**
	 * 创建商品对象
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	private goodsmodel creategoods(ResultSet rs) throws SQLException {
		goodsmodel goods = new goodsmodel(rs.getInt(1),rs.getString(2),rs.getString(4),rs.getDouble(3),rs.getString(5),rs.getString(6),rs.getString(7));

		return goods;
	}
}
