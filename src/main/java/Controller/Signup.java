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

@WebServlet("/Signup")
public class Signup extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		long contact=Long.parseLong(req.getParameter("contact"));
		String email=req.getParameter("email");
		String password=req.getParameter("Password");
		//Productdao prod= new Productdao();
		Sellerdto dto=new Sellerdto();
		dto.setId(id);
		dto.setName(name);
		dto.setContact(contact);
		dto.setEmail(email);
		dto.setPassword(password);
		
		Sellerdao seller=new Sellerdao();
		
			try {
				int res;
				try {
					res = seller.signup(dto);
					if(res==1){
						
						req.setAttribute("message","signup succesful");
						RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
						dispatcher.include(req, resp);
					}
					else {
						req.setAttribute("message", "signup failed");
						RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
						rd.include(req, resp);
					}}
					catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}}
			