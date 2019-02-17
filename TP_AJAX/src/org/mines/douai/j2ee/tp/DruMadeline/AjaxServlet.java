package org.mines.douai.j2ee.tp.DruMadeline;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/Ajax")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String, Integer> dic = new HashMap<String, Integer>();
	{
		dic.put("France", (int)(500 + Math.random()*2500));
		dic.put("Allemagne", (int)(Math.random()*800));
		dic.put("Pologne", (int)(10 + Math.random()*100));
	}
       
    /**
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse
    		response) throws ServletException, IOException {
    		response.setContentType("application/json");
    		PrintWriter writer = response.getWriter();
    		String pays = request.getParameter("pays");
    		String refresh = request.getParameter("refresh");
    		if (!"France".equals(pays) && !"Allemagne".equals(pays) && !"Pologne".equals(pays)) {
    			pays = "France";
    		}
    		if("true".equals(refresh)) {
    			this.doRefresh();
    		}
    		writer.println("{");
    		writer.println("\"nb\" : \"" + dic.get(pays) + "\",");
    		writer.println("\"pays\" : \"" + pays + "\"");
    		writer.println("}");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void doRefresh() {
		dic.put("France", (int)(500 + Math.random()*2500));
		dic.put("Allemagne", (int)(Math.random()*800));
		dic.put("Pologne", (int)(10 + Math.random()*100));
	}

}
