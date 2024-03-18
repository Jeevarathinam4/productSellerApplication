package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Productdao;
import dto.Productdto;
@WebServlet("/Saveproduct")
@MultipartConfig(maxFileSize = 1024*1024*5)

public class Saveproduct extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id =Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		double price=Double.parseDouble(req.getParameter("price"));
		String brand=req.getParameter("brand");
		double  discount=Double.parseDouble(req.getParameter("discount"));
		Part image = req.getPart("image");

		
		Productdto p = new Productdto();
		p.setImage(image.getInputStream().readAllBytes());
		p.setId(id);
		p.setBrand(brand);
		p.setPrice(price);
		p.setDiscount(discount);
		p.setName(name);

		
		Productdao product = new Productdao();
		try {
			int res = product.saveProduct(p);
			if (res==1)
			{
			   req.setAttribute("products", product.getAll());
			   RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
			   dispatcher.include(req, resp);
			}
			else {
				req.setAttribute("message", "product saved failed...");
				RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
				dispatcher.include(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}

		
	}


