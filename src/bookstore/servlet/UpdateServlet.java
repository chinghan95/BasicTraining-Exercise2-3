package bookstore.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.conn.BookstoreDao;
import bookstore.javabeans.Bookstore;

/**
 * Servlet implementation class UpdateServlet
 */
//@WebServlet("/UpdateServlet")
@WebServlet(name = "UpdateServlet", urlPatterns = {"/UpdateServlet"})
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		int bookstoreId = Integer.parseInt(id);
		
		// Get the data by Id
		Bookstore bookstore = BookstoreDao.getBookstoreById(bookstoreId);

		request.setAttribute("bookstoreById", bookstore);
		request.getRequestDispatcher("UpdateForm.jsp").forward(request, response);
		
	}

}
