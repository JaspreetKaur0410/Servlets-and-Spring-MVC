import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import java.util.*;

public class ServletAss1 extends HttpServlet {
	//BE CAREFUL
	//DO NOT DEFINE ANY VARIABLES OR INSTANCES HERE
	//SHARED, PUBLIC STATIC
	//THREAD UNSAFE
	
	
	public void init() {
		//called only once in the beginning by the container to indicate that the servlet is being placed into service
		System.out.println("*** INIT METHOD CALLED ***");
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		//called for each request
		//each request is handled by a seperate thread
		//synchronized. isolated
		//thread-safe
		System.out.println("*** SERVICE METHOD CALLED ***");
		Enumeration headerNames = request.getHeaderNames();
		response.setContentType("text/html");
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      								"Transitional//EN\">\n";
		PrintWriter out = response.getWriter();
		out.println(docType + "<HTML>");
		out.println("<BODY>");
		out.println("<div class=\"col-lg-6\">");
		out.println("<h5 ALIGN=\"CENTER\">Request Method: " +request.getMethod() + "</h5>");
		out.println("<h5 ALIGN=\"CENTER\">Request URI: " + request.getRequestURI() + "</h5>");
		out.println("<h5 ALIGN=\"CENTER\">Request Protocol: " + request.getProtocol() + "</h5>");
		out.println("</div>");
		out.println("<div class=\"col-lg-6\">");
		out.println("<TABLE BORDER=none ALIGN=\"CENTER\">\n" +
                "<TR BORDER=none>\n" +
                "<TH BORDER=\"none\">Header Name<TH>Header Value") ;
		out.println("</div>");
		
		
		while(headerNames.hasMoreElements()) {
	      String headerName = (String)headerNames.nextElement();
		  Enumeration values = request.getHeaders(headerName);
		 
	      out.println("<TR color=\"blue\"><TD Border=\"none\">" +  
	      				headerName);
	      out.println("    <TD>"  + request.getHeader(headerName));

	      
		}
		
		
		out.println("</BODY>");
		out.println("</HTML>");
	}
	
	public void destroy() {
		//called only once by the servlet container to indicate to a servlet that the servlet is being taken out of service
		System.out.println("*** DESTROY METHOD CALLED ***");
	}
}