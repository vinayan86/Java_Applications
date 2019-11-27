package com.face.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.face.bo.Product;
import com.face.dao.AddProductDAO;

/**
 * Servlet implementation class ProductEditServlet
 */

@WebServlet(urlPatterns= {"/ProductEdit"})
public class ProductEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		  
		
		
		
		ArrayList<Product> Productlist;
		try {
			Productlist = AddProductDAO.getAllDetails();
			 request.setAttribute("product", Productlist);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
		  
		String id=request.getParameter("edit");
		System.out.println(id);
		Product data;
		try {
			data = AddProductDAO.editSearch(id);
			System.out.println(data);
			request.setAttribute("data",data);
			String update="true";
			request.setAttribute("update",update);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		   RequestDispatcher dispatcher //
           = this.getServletContext().getRequestDispatcher("/WEB-INF/views/Product.jsp");
   dispatcher.forward(request, response);
		
	}

}
