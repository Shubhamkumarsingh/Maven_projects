package com.shubham.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shubham.beans.UserBean;
import com.shubham.dao.UserDao;

/**
 * Servlet implementation class UserHandler
 */
@WebServlet("/UserHandler")
public class UserHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	UserBean user;
	UserDao dao;
    public UserHandler() {
        super();
        user=new UserBean();
        dao=new UserDao();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirect,operation;
		operation=request.getParameter("operation");
		if(operation.equals("addUser")) {
			int id=Integer.parseInt(request.getParameter("id"));
			user.setId(id);
			user.setFirstName(request.getParameter("firstName"));
			user.setLastName(request.getParameter("lastName"));
			dao.addUser(user);
			redirect="listUser.jsp";
			request.setAttribute("users", dao.getUsers());
			request.getRequestDispatcher(redirect).forward(request, response);
		}else if(operation.equals("update")) {
			int id= Integer.parseInt(request.getParameter("id"));
			user.setId(id);
			request.setAttribute("user", dao.getUserById(user));
			redirect="edit.jsp";
			request.getRequestDispatcher(redirect).forward(request, response);
		}else if(operation.equals("updateUser")) {
			user.setId(Integer.parseInt(request.getParameter("id")));
			user.setFirstName(request.getParameter("firstName"));
			user.setLastName(request.getParameter("lastName"));
			dao.updateUser(user);
			redirect="listUser.jsp";
			request.getRequestDispatcher(redirect).forward(request, response);
		}else if(operation.equals("delete")) {
			user.setId(Integer.parseInt(request.getParameter("id")));
			dao.deleteUser(user);
			redirect="listUser.jsp";
			request.getRequestDispatcher(redirect).forward(request, response);
		}else if(operation.equals("listUsers")) {
			redirect="listUser.jsp";
			request.getRequestDispatcher(redirect).forward(request, response);
		}else {
			redirect="user.jsp";
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
