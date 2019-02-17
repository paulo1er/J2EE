package org.mines.douai.j2ee.tp.DruMadeline;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GraphicYellowJacketServlet
 */
@WebServlet("/GraphicYellowJacket")
public class JSPGraphicYellowJacketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Integer[] france = {random("France"), random("France"), random("France"), random("France"), random("France"), random("France"), random("France"), random("France"), random("France"), random("France"), random("France"), random("France")};
	Integer[] allemagne = {random("Allemagne"), random("Allemagne"), random("Allemagne"), random("Allemagne"), random("Allemagne"), random("Allemagne"), random("Allemagne"), random("Allemagne"), random("Allemagne"), random("Allemagne"), random("Allemagne"), random("Allemagne")};
	Integer[] pologne = {random("Pologne"), random("Pologne"), random("Pologne"), random("Pologne"), random("Pologne"), random("Pologne"), random("Pologne"), random("Pologne"), random("Pologne"), random("Pologne"), random("Pologne"), random("Pologne")};
	
	HashMap<String, Integer[]> dic = new HashMap<String, Integer[]>();
	{
		dic.put("France", france);
		dic.put("Allemagne", allemagne);
		dic.put("Pologne", pologne);
	}
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JSPGraphicYellowJacketServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		
		BufferedImage bufferedImage = new BufferedImage(240, 200, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bufferedImage.createGraphics();

        String pays = request.getParameter("pays");
        Integer[] paysList = dic.get(pays);
        if (paysList == null) {
        	pays = "France";
        	paysList = dic.get("France");
        }
        
		// Draw on the image
		g2d.setColor(Color.red);
		int max = 0;

		if("France".equals(pays)){
			max = 3000;
		}
		else if("Allemagne".equals(pays)) {
			max = 800;
		}
		else {
			max = 120;
		}
		
		for(int i = 0; i < paysList.length; i++){
			int value = (int) ((((double) paysList[i])/((double) max))*200);
			g2d.fill(new Rectangle(i*20, 200-value, 20, value));
		}

		g2d.setColor(Color.white);
		g2d.fill(new Rectangle(0, 0, 240, 1));
		g2d.fill(new Rectangle(0, 50, 240, 1));
		g2d.fill(new Rectangle(0, 100, 240, 1));
		g2d.fill(new Rectangle(0, 150, 240, 1));
		g2d.drawString(Integer.toString(max),0,10); 
		g2d.drawString(Integer.toString(max*3/4),0,60); 
		g2d.drawString(Integer.toString(max/2),0,110); 
		g2d.drawString(Integer.toString(max/4),0,160); 
		g2d.dispose();
		
	    ServletOutputStream outputStream = response.getOutputStream();
	    ImageIO.write(bufferedImage, "jpeg", outputStream);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected int random(String pays) {

		if("France".equals(pays)){
			return (int)(500 + Math.random()*2500);
		}
		else if("Allemagne".equals(pays)) {
			return (int)(Math.random()*800);
		}
		else {
			return (int)(10 + Math.random()*100);
		}
	}

}
