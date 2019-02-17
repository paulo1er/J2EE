package org.mines.douai.j2ee.tp.DruMadeline;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TagLibMultiLanguageYellowJacketServlet
 */
@WebServlet("/TagLibMultiLanguageYellowJacket")
public class TagLibMultiLanguageYellowJacketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TagLibMultiLanguageYellowJacketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String lang = request.getParameter("lang");
		if (!"English".equals(lang)) {
			lang = "Français";
		}
		String pays = request.getParameter("pays");
		if (!"France".equals(pays) && !"Allemagne".equals(pays) && !"Pologne".equals(pays)) {
			pays = "France";
		}
		RequestDispatcher requestDispatcher;
		requestDispatcher = request.getRequestDispatcher("YellowJacketTag.jsp?lang=" + lang + "&pays=" + pays);

		requestDispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String lang = request.getParameter("lang");
		if (!"English".equals(lang)) {
			lang = "Français";
		}
		String pays = request.getParameter("pays");
		if (!"France".equals(pays) && !"Allemagne".equals(pays) && !"Pologne".equals(pays)) {
			pays = "France";
		}
		RequestDispatcher requestDispatcher;
		requestDispatcher = request.getRequestDispatcher("YellowJacketTag.jsp?lang=" + lang + "&pays=" + pays);

		requestDispatcher.include(request, response);
	}

}
