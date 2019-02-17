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
@WebServlet("/JSPMultiLanguageYellowJacket")
public class JSPMultiLanguageYellowJacketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Integer> dic = new HashMap<String, Integer>();
	{
		dic.put("France", (int)(500 + Math.random()*2500));
		dic.put("Allemagne", (int)(Math.random()*800));
		dic.put("Pologne", (int)(10 + Math.random()*100));
	}
	
	HashMap<String, String> dicLanguages = new HashMap<String, String>();
	{
		dicLanguages.put("France", "France");
		dicLanguages.put("Allemagne", "Germany");
		dicLanguages.put("Pologne", "Poland");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JSPMultiLanguageYellowJacketServlet() {
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
		String langue = request.getParameter("langue");
		RequestDispatcher requestDispatcher;
		if ("English".equals(langue) ) {
			requestDispatcher = request.getRequestDispatcher("JSPYellowJacket-en.jsp?pays="+pays+"&nb="+dic.get(pays)+"&paysName="+dicLanguages.get(pays)) ;
		}
		else {
			requestDispatcher = request.getRequestDispatcher("JSPYellowJacket-fr.jsp?pays="+pays+"&nb="+dic.get(pays)+"&paysName="+pays) ;
		}
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
			
		String langue = request.getParameter("langue");
		RequestDispatcher requestDispatcher;
		String paysName;
		
		if ("English".equals(langue) ) {
			requestDispatcher = request.getRequestDispatcher("JSPYellowJacket-en.jsp?pays="+pays+"&nb="+dic.get(pays)+"&paysName="+dicLanguages.get(pays)) ;
		}
		else {
			requestDispatcher = request.getRequestDispatcher("JSPYellowJacket-fr.jsp?pays="+pays+"&nb="+dic.get(pays)+"&paysName="+pays) ;
		}
		
		requestDispatcher.include(request, response) ;
	}

}
