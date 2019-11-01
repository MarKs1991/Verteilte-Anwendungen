import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Random
 */
@WebServlet("/Random")
public class Random extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Random() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
  //Zugriff von anderen Rechner im Netzwerk (kann abweichen): http://192.168.56.128:8080/MyWebApp/random.html
	
  //Zugriff vom selben Rechner:  http://localhost:8080/MyWebApp/random.html oder http://127.0.0.1:8080/MyWebApp/random.html
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
		
			int a = Integer.parseInt(request.getParameter("a"));
			int b = Integer.parseInt(request.getParameter("b"));
		
			double randomDouble = (a + Math.random() * (b - a));
		
			randomDouble = Math.round(randomDouble);
			int randomInt = (int)randomDouble;
		
			if(a > b)
				{
				RequestDispatcher rd = request.getRequestDispatcher("/invalidValues.html");
				rd.forward(request, response);
				}
		
			response.setContentType("text/html");
			response.getWriter().println(randomInt);	
			
			System.out.println("GET aufgerufen");
			}
		
		catch (NumberFormatException InvalidType) 
			{
			RequestDispatcher rd = request.getRequestDispatcher("/invalidValues.html");
			rd.forward(request, response);
			}
	}

	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try{
			
			int a = Integer.parseInt(request.getParameter("a"));
			int b = Integer.parseInt(request.getParameter("b"));
		
			double randomDouble = (a + Math.random() * (b - a));
		
			randomDouble = Math.round(randomDouble);
			int randomInt = (int)randomDouble;
		
			if(a > b)
				{
				RequestDispatcher rd = request.getRequestDispatcher("/invalidValues.html");
				rd.forward(request, response);
				}
		
			response.setContentType("text/html");
			response.getWriter().println(randomInt);	
			
			System.out.println("POST aufgerufen");
			}
		
		catch (NumberFormatException InvalidType) 
			{
			RequestDispatcher rd = request.getRequestDispatcher("/invalidValues.html");
			rd.forward(request, response);
			}
	}

	//service auskommentiert um GET und POST Methode zu testen
	/*
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try{
			
			int a = Integer.parseInt(request.getParameter("a"));
			int b = Integer.parseInt(request.getParameter("b"));
		
			double randomDouble = (a + Math.random() * (b - a));
		
			randomDouble = Math.round(randomDouble);
			int randomInt = (int)randomDouble;
		
			if(a > b)
				{
				RequestDispatcher rd = request.getRequestDispatcher("/invalidValues.html");
				rd.forward(request, response);
				}
		
			response.setContentType("text/html");
			response.getWriter().println(randomInt);	
			
			}
		
		catch (NumberFormatException InvalidType) 
			{
			RequestDispatcher rd = request.getRequestDispatcher("/invalidValues.html");
			rd.forward(request, response);
			}
	}
	*/
}
