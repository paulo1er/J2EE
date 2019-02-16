package org.mines.douai.j2ee.tp.DruMadeline;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
@WebServlet("/YellowJacketEconomic")
public class YellowJacketEconomicServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public YellowJacketEconomicServelet() {
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

		String pays = request.getParameter("pays");
		if ("France".equals(pays) || "Allemagne".equals(pays) || "Pologne".equals(pays)) {
			out.println("<h2>" + pays + "</h2>");
			out.println("<img src=\"/TP_Servlet/GraphicYellowJacket?pays=" + pays + "\">");
		}
		else{
			out.println("<h2>France</h2>");
			out.println("<img src=\"/TP_Servlet/GraphicYellowJacket?pays=France\">");
			out.println("<h2>Allemagne</h2>");
			out.println("<img src=\"/TP_Servlet/GraphicYellowJacket?pays=Allemagne\">");
			out.println("<h2>Plologne</h2>");
			out.println("<img src=\"/TP_Servlet/GraphicYellowJacket?pays=Plologne\">");
		}

		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}