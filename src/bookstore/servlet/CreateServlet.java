package bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.conn.*;
import bookstore.javabeans.*;
/**
 * Servlet implementation class CreateServlet
 */
//@WebServlet("/CreateServlet")
@WebServlet(name = "CreateServlet", urlPatterns = {"/CreateServlet"})
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// To send response back to the client, we need to obtain a writer from
		// the response object by calling the method getWriter() of the HttpServletResponse interface
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		String storeName = request.getParameter("storeName");
		String storeAddress = request.getParameter("storeAddress");
		String storeTelephone = request.getParameter("storeTelephone");
				
		Bookstore bookstore = new Bookstore(storeName, storeAddress, storeTelephone);
		
		// Save the data
		int status = BookstoreDao.save(bookstore);
		if(status > 0) {
//			request.getRequestDispatcher("ViewServlet").forward(request, response);
			response.sendRedirect("ViewServlet");
		}
		else {
			out.println("Error: Create action.");
		}
		out.close();
	}

}
