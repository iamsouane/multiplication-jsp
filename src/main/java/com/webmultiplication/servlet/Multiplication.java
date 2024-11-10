package com.webmultiplication.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.ServletConfig;
import java.io.PrintWriter;


/**
 * Servlet implementation class Multiplication
 */
@WebServlet("/Multiplication")
public class Multiplication extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Multiplication() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private int nombre;
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	
    	String strNombre = getInitParameter("nombre");
    	nombre = Integer.parseInt(strNombre);
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Table de multiplication</title>");
			out.println("<body>");
			out.println("<h2>Table de multiplication de " + nombre + "</title>");
			for(int i = 0; i <= 10; i++) {
				out.println("<p>" + nombre + " x " + i + " = " + (nombre * i) + "<br></p>");
			}
			out.println("</body>");
			out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
