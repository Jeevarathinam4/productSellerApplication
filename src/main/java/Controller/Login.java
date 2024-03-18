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
import dao.Sellerdao;
import dto.Sellerdto;
@WebServlet("/Login")

public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		Productdao prod= new Productdao();
		Sellerdao seller=new Sellerdao();
		try {
			Sellerdto sdt=seller.findByEmail(email);
			if(sdt!=null) {
				if(sdt.getPassword().equals (password)) {
					HttpSession session=req.getSession();
					session.setAttribute("email", email);
					req.setAttribute("products", prod.getAll());
					RequestDispatcher dispatcher=req.getRequestDispatcher("Home.jsp");
					dispatcher.include(req, resp);
				}
				else {
					req.setAttribute("message", "wrong password");
					RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
					rd.include(req, resp);
				}
			}
			else {
				req.setAttribute("message", "wrong email");
				RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
				rd.include(req, resp);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	

}
