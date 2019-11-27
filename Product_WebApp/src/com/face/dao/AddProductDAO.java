package com.face.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.face.bo.Product;
import com.face.util.MySQLConnUtils;

public class AddProductDAO {





	public static ArrayList<Product> getAllDetails() throws ClassNotFoundException, SQLException, IOException {
	 
	      Connection con=MySQLConnUtils.getConnection();
	        Statement st = con.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM product");
	      ArrayList<Product> list=new ArrayList<Product>();
	        
	      Product p[] = new Product[100];
	      int i=0;
	        while(rs.next())
	        {
	        	p[i] = new Product();
	        	p[i].setPid(rs.getInt("pid"));
	        	p[i].setPname(rs.getString("pname"));
	        	p[i].setPrice(rs.getInt("price"));
	        	p[i].setQty(rs.getInt("qty"));
	        	list.add(p[i]);
	        	i++;
//	        	   list.set(0,rs.getInt("pid"));
//	             list.add(rs.getString("pname"));
//	             list.add(rs.getString("qty"));
//	             list.add(rs.getString("price"));
//	             
//	     
	            
	            }
	        System.out.println(list);
	      
	        return list;






	}

	public static Product editSearch(String id) throws ClassNotFoundException, SQLException, IOException {
		
		
		 Connection con=MySQLConnUtils.getConnection();
	        Statement st = con.createStatement();
	        String sql="SELECT * FROM product where pid='"+id+"'";
	        System.out.println(sql);
	      ResultSet rs = st.executeQuery(sql);
	      Product p = new Product();
	      while(rs.next())
	      {
	    	p.setPid(rs.getInt("pid"));
        	p.setPname(rs.getString("pname"));
        	p.setPrice(rs.getInt("price"));
        	p.setQty(rs.getInt("qty"));
	      }
	      
		return p;
	}

	
	public static Boolean deleteProduct(String pid) throws ClassNotFoundException, SQLException, IOException {
		Connection con=MySQLConnUtils.getConnection();
		Statement st1 = con.createStatement();
		String s="delete from product where pid='"+pid+"'";
		System.out.println(s);
		int rs=st1.executeUpdate(s);
		if(rs==1)
			return true;
		else
			return false;
	}

	public static Boolean updateProduct(Product p) throws ClassNotFoundException, SQLException, IOException {
		Connection con=MySQLConnUtils.getConnection();
		Statement st1 = con.createStatement();
		String s="update product set pname='"+p.getPname()+"',qty='"+p.getQty()+"',price='"+p.getPrice()+"' where pid='"+p.getPid()+"'";
		System.out.println(s);
		int rs=st1.executeUpdate(s);
		if(rs==1)
			return true;
		else
			return false;
	}

	public static Boolean storeProduct(Product p) throws ClassNotFoundException, SQLException, IOException {


		Connection con=MySQLConnUtils.getConnection();
		Statement st1 = con.createStatement();
		
		String s="INSERT INTO `product`(`pname`, `qty`, `price`) VALUES ('"+p.getPname()+"','"+p.getQty()+"','"+p.getPrice()+"')";
		System.out.println(s);
		int rs=st1.executeUpdate(s);
		if(rs==1)
			return true;
		else
			return false;
	}
}
