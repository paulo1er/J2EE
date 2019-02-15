package org.mines.douai.j2ee.tp.DruMadeline;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JSPYellowJacketServlet
 */
@WebServlet("/JSPYellowJacket")
public class JSPYellowJacketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Integer> dic = new HashMap<String, Integer>();
	{
		dic.put("France", (int)(500 + Math.random()*2500));
		dic.put("Allemagne", (int)(Math.random()*800));
		dic.put("Pologne", (int)(10 + Math.random()*100));
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSPYellowJacketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		response.setContentType("text/html"); // Type MIME
		java.io.PrintWriter out = response.getWriter();
		String pays = request.getParameter("pays");
		if (!"France".equals(pays) && !"Allemagne".equals(pays) && !"Pologne".equals(pays)) {
			pays = "France";
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("JSPYellowJacket.jsp?pays="+pays+"&nb="+dic.get(pays)) ;
	    requestDispatcher.include(request, response) ;
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html"); // Type MIME
		java.io.PrintWriter out = response.getWriter();
		String pays = request.getParameter("pays");
		if (!"France".equals(pays) && !"Allemagne".equals(pays) && !"Pologne".equals(pays)) {
			pays = "France";
		}
		
		String refresh = request.getParameter("refresh");
		if("true".equals(refresh)){
			dic.put("France", (int)(500 + Math.random()*2500));
			dic.put("Allemagne", (int)(Math.random()*800));
			dic.put("Pologne", (int)(10 + Math.random()*100));
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("JSPYellowJacket.jsp?pays="+pays+"&nb="+dic.get(pays)) ;
	    requestDispatcher.include(request, response) ;
	}

}
