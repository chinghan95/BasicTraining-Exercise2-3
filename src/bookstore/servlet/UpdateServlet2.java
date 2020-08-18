package bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.conn.BookstoreDao;
import bookstore.javabeans.Bookstore;

/**
 * Servlet implementation class UpdateServlet2
 */
@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("storeId");
		int bookstoreId = Integer.parseInt(id);
		String storeName = request.getParameter("storeName");
		String storeAddress = request.getParameter("storeAddress");
		String storeTelephone = request.getParameter("storeTelephone");
		
		Bookstore bookstoreById = new Bookstore(bookstoreId, storeName, storeAddress, storeTelephone);
		
		// Update the data
		int status = BookstoreDao.update(bookstoreById);
		if(status > 0) {
			response.sendRedirect("ViewServlet");
		}
		else {
			out.println("Error: Update action.");
		}
		
	}

}
