package dao;//to check username password getted from user and the database predefined password and username are same

import java.sql.*;

import model.Login;
import connectionmanager.ConnectionManager;


public class LoginDAO
{

	public boolean validate(Login login) throws ClassNotFoundException, SQLException 
	{
		
		//user input
		String username=login.getUsername();
		String password=login.getPassword();
		
		//connect java and jdbc
		ConnectionManager conm=new ConnectionManager();
		Connection con=conm.establishConnection();
		
		//declare statement class
		Statement st=con.createStatement();
		
		//write query
		ResultSet rs=st.executeQuery("select*from login");
		
		//check result and password
		while(rs.next()) 
		{
			
		
		   if(username.equals(rs.getString("username")) && password.equals(rs.getString("password")))
		  {
			   
			conm.closeConnection();   
			return true;
			
			
		  }
		   
		   
		}
		
		conm.closeConnection();   
		return false;
		
	}
	
	
}
