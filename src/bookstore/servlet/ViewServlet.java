package bookstore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.conn.BookstoreDao;
import bookstore.javabeans.Bookstore;

/**
 * Servlet implementation class ViewServlet
 */
//@WebServlet("/ViewServlet")
@WebServlet(name = "ViewServlet", urlPatterns = {"/ViewServlet"})
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding(arg0);
		List<Bookstore> listBookstore = BookstoreDao.getAllBookstores();
		
		// Setting the attribute of the request object 
		// which will be later fetched by a JSP page
		request.setAttribute("bookstoresData", listBookstore);
		
		// Dispatch the request to another resource (List.jsp)
		// The request will be forwarded to the resource specified
		request.getRequestDispatcher("List.jsp").forward(request, response);
		
	}

}
