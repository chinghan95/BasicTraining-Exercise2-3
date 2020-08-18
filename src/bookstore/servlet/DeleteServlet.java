package bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.conn.BookstoreDao;

/**
 * Servlet implementation class DeleteServlet
 */
//@WebServlet("/DeleteServlet")
@WebServlet(name = "DeleteServlet", urlPatterns = {"/DeleteServlet"})
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		int bookstoreId = Integer.parseInt(id);
		
		// Delete the data
		int status = BookstoreDao.delete(bookstoreId);
		if(status > 0) {
			response.sendRedirect("ViewServlet");
		}
		else {
			out.println("Error: Delete action.");
		}
		out.close();
	}

}
