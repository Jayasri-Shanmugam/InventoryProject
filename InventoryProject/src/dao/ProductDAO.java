package dao;

import java.sql.*;

import connectionmanager.ConnectionManager;

import model.Product;

public class ProductDAO

{

   public void addProduct(Product product) throws ClassNotFoundException, SQLException

   {

 //1.java and  JDBC connect

  connectionmanager.ConnectionManager conm= new ConnectionManager();

  Connection con=conm.establishConnection();

 

  String sql_query="insert into product(productId,productName,minSellQuantity,price,quantity) values (?,?,?,?,?)";

  PreparedStatement ps=con.prepareStatement(sql_query);

 

  ps.setInt(1,product.getProductId());

  ps.setString(2,product.getProductName());

  ps.setInt(3,product.getMinSellQuantity());

  ps.setInt(4,product.getPrice());

  ps.setInt(5,product.getQuantity());

 

  ps.executeUpdate();

 

  conm.closeConnection();

 



   }

   public void display() throws ClassNotFoundException , SQLException

   {

	   ConnectionManager conm= new ConnectionManager();

	   Connection con=conm.establishConnection();

		Statement st = con.createStatement();//statement class declare

		

		ResultSet rs = st.executeQuery("select * from product"); // write query

		

		//check username and password

		while(rs.next())

		{

		  System.out.println(rs.getInt("productId")+"|"+rs.getString("productName")+"|"+rs.getInt("minSellQuantity")+"|"+rs.getInt("price")+"|"+rs.getInt("quantity")+"|");

		

		}

		conm.closeConnection();



   }

}

