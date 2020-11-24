package com.shubham.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shubham.beans.LoginBean;
import com.shubham.dao.LoginDAO;

/**
 * Servlet implementation class LoginHandler
 */
@WebServlet("/LoginHandler")
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	LoginDAO loginDao;
	LoginBean loginBean;
    public LoginHandler() {
        super();
        loginDao= new LoginDAO();
        loginBean= new LoginBean();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation= request.getParameter("operation");
		String redirect="";
		int result;
		HttpSession session=request.getSession();
		if(operation.equals("login")) {
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			System.out.println("name: "+name+"\t"+"password: "+password);
			loginBean.setUserName(name);
			loginBean.setPassword(password);
			result=loginDao.isvalidLogin(loginBean);
			if(result==0) {
				session.setAttribute("status", "Username doesn't exists.");
				session.setAttribute("statuscode", result);
			}else if(result==1) {
				session.setAttribute("status", "logged in successfully.");
				session.setAttribute("statuscode", result);
			}else {
				session.setAttribute("status", "Wrong password");
				session.setAttribute("statuscode", result);
			}
			redirect="status.jsp";
			request.getRequestDispatcher(redirect).forward(request, response);
		}else if(operation.equals("signin")) {
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			System.out.println("name: "+name+"\t"+"password: "+password);
			loginBean.setUserName(name);
			loginBean.setPassword(password);
			result=loginDao.addUser(loginBean);
			if(result==0) {
				session.setAttribute("status", "user already exists.");
				session.setAttribute("statuscode", result);
			}else {
				session.setAttribute("status", "User added successfully.");
				session.setAttribute("statuscode", result);
			}
			redirect="status.jsp";
			request.getRequestDispatcher(redirect).forward(request, response);
		}else if(operation.equals("logout")) {
			session.invalidate();
			redirect="index.jsp";
			request.getRequestDispatcher(redirect).forward(request, response);
		}else if(operation.equals("homepage")) {
			session.invalidate();
			redirect="index.jsp";
			request.getRequestDispatcher(redirect).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
