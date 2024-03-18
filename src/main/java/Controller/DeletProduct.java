package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Productdao;
import dto.Productdto;
@WebServlet("/delete")
public class DeletProduct extends HttpServlet {
	 @Override
     protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   	int id = Integer.parseInt(req.getParameter("id"));
   	
   	try {
   		Productdao prod = new Productdao();
			HttpSession session = req.getSession();
			String email = (String)session.getAttribute("email");
			if(email!=null)
			{
				
				Productdao dao = new Productdao();
				int res = dao.deleteById(id);
				if(res == 1)
				{
					req.setAttribute("products", prod.getAll());
					RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
					dispatcher.include(req, resp);
				}
				else
				{
					resp.getWriter().print("Error");
				}
				
			}
			else
			{
				req.setAttribute("message", "Login Required");
				RequestDispatcher dispatcher = req.getRequestDispatcher("Home.jsp");
				dispatcher.include(req, resp);
			}
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}}
