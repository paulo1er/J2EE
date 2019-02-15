package org.mines.douai.j2ee.tp.DruMadeline.servlet;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/YellowJacket")
public class YellowJacketServlet extends HttpServlet {
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
	public YellowJacketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html"); // Type MIME
		java.io.PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Nombre de gilets jaunes en Live !!</h1>");
		synchronized(this){
			out.println("<p>France : "+dic.get("France")+"</p>");
			out.println("<p>Allemagne : "+dic.get("Allemagne")+"</p>");
			out.println("<p>Pologne : "+dic.get("Pologne")+"</p>");
		}
		this.menuD(request, response);
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pays = request.getParameter("pays");
		String refresh = request.getParameter("refresh");
		if("true".equals(refresh)){
			dic.put("France", (int)(500 + Math.random()*2500));
			dic.put("Allemagne", (int)(Math.random()*800));
			dic.put("Pologne", (int)(10 + Math.random()*100));
		}
		response.setContentType("text/html"); // Type MIME
		java.io.PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Nombre de gilets jaunes en Live !!</h1>");
		out.println("<p>"+pays+" : "+dic.get(pays)+"</p>");
		out.println("<img src=\"/TP_ServIet/GraphicYellowJacket?pays="+pays+"\">");
		
		this.menuD(request, response);
		
		out.println("</body></html>");
	}
	
	protected void menuD(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		java.io.PrintWriter out = response.getWriter();
		out.println("<form action='/TP_ServIet/YellowJacket' method='post'>");
		out.println("<select name='pays'>");
		out.println("  <option value='France'>France</option>");
		out.println("  <option value='Allemagne'>Allemagne</option>");
		out.println("  <option value='Pologne'>Pologne</option>");
		out.println("</select>");
		out.println("<input type='checkbox' name='refresh' value='true'>refresh<br>");
		out.println("<input type='submit'/>");
		out.println("</form>");
	}
}
