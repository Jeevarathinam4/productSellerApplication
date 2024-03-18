package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import java.sql.Blob; 

import dto.Productdto;

public class Productdao {
	static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/productseller?user=root&password=root");
		return con;
	}
	
	
	public int saveProduct(Productdto dto) throws ClassNotFoundException, SQLException {
	Connection con=getConnection();
	PreparedStatement pst=con.prepareStatement("insert into product values(?,?,?,?,?,?)");
	pst.setInt(1, dto.getId());
	pst.setString(2, dto.getName());
	pst.setDouble(3, dto.getPrice());
	pst.setString(4, dto.getBrand());
	pst.setDouble(5, dto.getDiscount());
   Blob image=new SerialBlob(dto.getImage());
   pst.setBlob(6, image);
   return pst.executeUpdate();
  
	
	}
	public int updateProduct(Productdto product) throws SQLException, ClassNotFoundException {
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("update product set name=?,price=?,brand=?,discount=?,image=?,where id=?");
		pst.setInt(1, product.getId());
		pst.setString(2, product.getName());
		pst.setDouble(3, product.getPrice());
		pst.setString(4, product.getBrand());
		pst.setDouble(5, product.getDiscount());
	   Blob image=new SerialBlob(product.getImage());
	   pst.setBlob(6, image);
	   return pst.executeUpdate();
	}
	public Productdto findById(int id) throws SQLException, ClassNotFoundException {
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select *from product where id=?");
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		Productdto pdao=new Productdto();
		pdao.setId(rs.getInt(1));
		pdao.setName(rs.getString(2));
		pdao.setPrice(rs.getDouble(3));
		pdao.setBrand(rs.getString(4));
		pdao.setDiscount(rs.getDouble(5));
		Blob image=rs.getBlob(6);
		int imagelength=(int)image.length();
		byte[]Bytes=image.getBytes(1, imagelength);
		pdao.setImage(Bytes);
		return pdao;
	}
	public List<Productdto>getAll() throws ClassNotFoundException, SQLException{
		Connection con =getConnection();
		PreparedStatement pst=con.prepareStatement("select *from product"); 
		ResultSet rs=pst.executeQuery();
		List<Productdto>products=new ArrayList<Productdto>();
		while(rs.next()) {
			Productdto p=new Productdto();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setPrice(rs.getDouble(3));
			p.setBrand(rs.getString(4));
			p.setDiscount(rs.getDouble(5));
			Blob imageBlob=rs.getBlob(6);
			byte[] image=imageBlob.getBytes(1, (int)imageBlob.length());
			p.setImage(image);
			products.add(p);
		}
		return products;
	}


	public int deleteById(int id) throws SQLException, ClassNotFoundException {
		Connection con = getConnection();
    	PreparedStatement pst = con.prepareStatement("delete  from product where id =?");
    	pst.setInt(1, id);
    	int res = pst.executeUpdate();

		return res;
	}
	
	 

}
