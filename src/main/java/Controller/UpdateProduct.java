package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Productdao;
import dto.Productdto;
@WebServlet("/update")
public class UpdateProduct extends HttpServlet {
	 @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    	String name = req.getParameter("name");
	    	int id = Integer.parseInt(req.getParameter("id"));
	    	double price = Double.parseDouble(req.getParameter("price"));
	    	String brand = req.getParameter("brand");
	    	double discount = Double.parseDouble(req.getParameter("discount"));
	    	Part image = req.getPart("image");
	    	
	    	Productdto p = new Productdto();
	    	p.setId(id);
	    	p.setName(name);
	    	p.setPrice(price);
	    	p.setBrand(brand);
	    	p.setDiscount(discount);
	    	p.setImage(image.getInputStream().readAllBytes());
	    	
	    	Productdao pdao = new Productdao();
	    	try {
	    		if(image.getSize()>1) {
	    			
	    			
	    		}
				pdao.updateProduct(p);
				req.setAttribute("products", pdao.getAll());
				RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
				dispatcher.include(req, resp);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

}}
