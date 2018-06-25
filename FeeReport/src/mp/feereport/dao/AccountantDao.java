package mp.feereport.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mp.feereport.entity.Accountant;

public class AccountantDao {
	
	public static Connection getConn() {
		
		Connection con = null;
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			}
			catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
			try {			
				con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			}
			catch(SQLException e ) {
				e.printStackTrace();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
		
	}
	
	public static boolean validate(String uname, String password) {
		boolean status = false;
		Connection con = null;
		try {
			try{
				con = getConn();
				if(con == null)
					throw new NullPointerException("Connection = null");
			}
			catch(NullPointerException e) {
				e.printStackTrace();
			}
			PreparedStatement ps = con.prepareStatement("select * from freereport_accountant where name=? and password=?");
			ps.setString(1, uname);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static int save(Accountant a) {
		int status = 0;
		Connection con = null;
		try {
			con = getConn();
			if (con == null)
				throw new NullPointerException("Connection = null");
			PreparedStatement ps = con.prepareStatement("insert into feereport_accountant(name, password, email, contactno)");
			ps.setString(1, a.getName());
			ps.setString(2, a.getPassword());
			ps.setString(3, a.getEmail());
			ps.setString(4, a.getContact());
			status = ps.executeUpdate();
			con.close();
		}
		catch(NullPointerException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static List<Accountant> view() {
		List<Accountant> list = new ArrayList<Accountant>();
		try {
			Connection con=getConn();
			PreparedStatement ps=con.prepareStatement("select * from feereport_accountant");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Accountant a=new Accountant();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setPassword(rs.getString(3));
				a.setEmail(rs.getString(4));
				a.setContact(rs.getString(5));
				list.add(a);
			}
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
