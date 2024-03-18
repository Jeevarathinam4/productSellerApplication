package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

import com.mysql.cj.xdevapi.PreparableStatement;

import dto.Sellerdto;

public class Sellerdao extends HttpServlet {
 static Connection getConnection() throws ClassNotFoundException, SQLException {
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysol://localhost:3306/productseller?user=root&password=root");
	return con;
 }
 public Sellerdto findByEmail(String email) throws ClassNotFoundException, SQLException{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/productseller?user=root&password=root");
	PreparedStatement pst= con.prepareStatement("select * from seller where email=?");
	pst.setString(1, email);
	ResultSet rs=pst.executeQuery();
	Sellerdto seller=new Sellerdto();
	if (rs.next()){
	seller.setId(rs.getInt(1));
	seller.setName(rs.getString(2));
	seller.setContact(rs.getLong(3));
	seller.setEmail(rs.getString(4));
	seller.setPassword(rs.getString(5));
	con.close();
	
	}
	return seller;
	
 }
 
 public int signup(Sellerdto dto) throws ClassNotFoundException, SQLException {
	 Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/productseller?user=root&password=root");
		PreparedStatement pst= con.prepareStatement("insert into seller values(?,?,?,?,?)");
		pst.setInt(1, dto.getId());
		pst.setString(2, dto.getName());
		pst.setLong(3, dto.getContact());
		pst.setString(4, dto.getEmail());
		pst.setString(5, dto.getPassword());
		
		return pst.executeUpdate();
 }
}
