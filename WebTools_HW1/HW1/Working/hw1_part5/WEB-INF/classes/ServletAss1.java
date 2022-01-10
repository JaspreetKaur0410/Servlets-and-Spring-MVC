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
		
		response.setContentType("text/html");
		String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
      								"Transitional//EN\">\n";
		PrintWriter printWriter  = response.getWriter();

		// uri related API's
        String uri = request.getRequestURI();
        String protocol = request.getProtocol();
        
        //headers
        Enumeration headerNames = request.getHeaderNames();
        response.setCharacterEncoding("UTF-8");
		printWriter.println(docType + "<HTML>");
		printWriter.println("<BODY BGCOLOR=\"#FDF5E6\">");

		

		printWriter.print("<div class = \"column\" float=\"left\" width=\"50%\">");
		printWriter.print("<h1 ALIGN=\"CENTER\">" + "<u>" + "HTTPREQUEST METHODS" + "</u>" + "</h1>");
		printWriter.print("</div>");
		printWriter.print("</div>");


		printWriter.print("<BR>\n" +
			                "<TABLE BORDER=0 ALIGN=\"CENTER\">\n" +
			                "<TR BGCOLOR=\"#FFAD00\">\n" +
			                "<TH>Method Name" +
							"</TH>" +
			                "<TH>Value" +
							"</TH>" +
							"</TR>" +
							"<TR>\n" +
							"<TD>URI" +
							"</TD>" +
							"<TD>" + uri +
							"</TD>" +
							"</TR>" + 

							"<TR>\n" +
							"<TD>AuthType" +
							"</TD>" +
							"<TD>" + request.getAuthType() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>ContextPath" +
							"</TD>" +
							"<TD>" + request.getContextPath() +
							"</TD>" +
							"</TR>" + 

							"<TR>\n" +
							"<TD>Method" +
							"</TD>" +
							"<TD>" + request.getMethod() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>PathInfo" +
							"</TD>" +
							"<TD>" + request.getPathInfo() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>RemoteUser" +
							"</TD>" +
							"<TD>" + request.getRemoteUser() +
							"</TD>" +
							"</TR>" + 

							"<TR>\n" +
							"<TD>RequestedSessionldValid" +
							"</TD>" +
							"<TD>" + request.getHeader("User-Agent") +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>Cookies" +
							"</TD>" +
							"<TD>" + request.getCookies() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>Connection Header" +
							"</TD>" +
							"<TD>" + request.getHeader("Connection") +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>isRequestedSessionIdFromURL" +
							"</TD>" +
							"<TD>" + request.isRequestedSessionIdFromURL() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>DateHeader" +
							"</TD>" +
							"<TD>" + request.getDateHeader("If-Modified-Since") +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>isRequestedSessionIdFromURL" +
							"</TD>" +
							"<TD>" + request.isRequestedSessionIdFromURL() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>isRequestedSessionIdFromUrl" +
							"</TD>" +
							"<TD>" + request.isRequestedSessionIdFromUrl() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>Session" +
							"</TD>" +
							"<TD>" + request.getSession(true) +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>changeSessionId" +
							"</TD>" +
							"<TD>" + request.changeSessionId() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>isRequestedSessionIdFromCookie" +
							"</TD>" +
							"<TD>" + request.isRequestedSessionIdFromCookie() +
							"</TD>" +
							"</TR>" 
							);

		
		printWriter.println("</TD");
		printWriter.println("</TH");
		printWriter.println("</TR>");
		printWriter.println("</TABLE><BR><BR>");
		
		printWriter.print("<h1 ALIGN=\"CENTER\">" + "<u>" + "HTTPREQUEST HEADERS" + "</u>" + "</h1>");

		printWriter.print("<BR>\n" +
			                "<TABLE BORDER=0 ALIGN=\"CENTER\">\n" +
			                "<TR BGCOLOR=\"#FFAD00\">\n" +
			                "<TH>Header Name<TH>Header Value");

		while(headerNames.hasMoreElements()) {
		    String headerName = (String)headerNames.nextElement();
		    printWriter.println("<TR><TD>" + headerName);
		    printWriter.println("    <TD>" + request.getHeader(headerName));		    
		}
		printWriter.println("</TD");
		printWriter.println("</TH");
		printWriter.println("</TR>");
		printWriter.println("</TABLE><BR><BR>");

		printWriter.print("<h1 ALIGN=\"CENTER\">" + "<u>" + "HTTPRESPONSE METHODS" + "</u>" + "</h1>");

		printWriter.print("<BR>\n" +
			                "<TABLE BORDER=0 ALIGN=\"CENTER\">\n" +
			                "<TR BGCOLOR=\"#FFAD00\">\n" +
			                "<TH>Method Name" +
							"</TH>" +
			                "<TH>Value" +
							"</TH>" +
							"</TR>" +
							"<TR>\n" +
							"<TD>PrintWriterObject" +
							"</TD>" +
							"<TD>" + response.getWriter() +
							"</TD>" +
							"</TR>" + 

							"<TR>\n" +
							"<TD>IsResponseCommitted" +
							"</TD>" +
							"<TD>" + response.isCommitted() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>userAgent " +
							"</TD>" +
							"<TD>" + request.getContextPath() +
							"</TD>" +
							"</TR>" + 

							"<TR>\n" +
							"<TD>ContentType" +
							"</TD>" +
							"<TD>" + response.getContentType() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>Status" +
							"</TD>" +
							"<TD>" + response.getStatus() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>Connection Header" +
							"</TD>" +
							"<TD>" + response.getHeader("Connection") +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>BufferSize" +
							"</TD>" +
							"<TD>" + response.getBufferSize() +
							"</TD>" +
							"</TR>" 

							

							);
		printWriter.println("</TD");
		printWriter.println("</TH");
		printWriter.println("</TR>");
		printWriter.println("</TABLE><BR><BR>");



		printWriter.print("<h1 ALIGN=\"CENTER\">" + "<u>" + "HTTP SUPER INTERFACE SERVLET REQUEST METHODS" + "</u>" + "</h1>");
		
		printWriter.print("<BR>\n" +
			                "<TABLE BORDER=0 ALIGN=\"CENTER\">\n" +
			                "<TR BGCOLOR=\"#FFAD00\">\n" +
			                "<TH>Method Name" +
							"</TH>" +
			                "<TH>Value" +
							"</TH>" +
							"</TR>" +
							"<TR>\n" +
							"<TD>ServerName" +
							"</TD>" +
							"<TD>" + request.getServerName() +
							"</TD>" +
							"</TR>" + 

							"<TR>\n" +
							"<TD>AttributeNames" +
							"</TD>" +
							"<TD>" + request.getAttributeNames() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>ServerPort" +
							"</TD>" +
							"<TD>" + request.getServerPort() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>DispatcherType" +
							"</TD>" +
							"<TD>" + request.getDispatcherType() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>LocalPort" +
							"</TD>" +
							"<TD>" + request.getLocalPort() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>ServletContext" +
							"</TD>" +
							"<TD>" + request.getServletContext() +
							"</TD>" +
							"</TR>" +

							

							"<TR>\n" +
							"<TD>Protocol" +
							"</TD>" +
							"<TD>" + request.getProtocol() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>Locale" +
							"</TD>" +
							"<TD>" + request.getLocale() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>Attribute Name" +
							"</TD>" +
							"<TD>" + request.getAttribute("serverHost") +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>getReader" +
							"</TD>" +
							"<TD>" + request.getReader() +
							"</TD>" +
							"</TR>" +

							"<TR>\n" +
							"<TD>IsAsync" +
							"</TD>" +
							"<TD>" + request.isAsyncStarted() +
							"</TD>" +
							"</TR>" 

							
							
							);

		
		printWriter.println("</TD");
		printWriter.println("</TH");
		printWriter.println("</TR>");
		printWriter.println("</TABLE><BR><BR>");


		printWriter.println("</BODY>");
		printWriter.println("</HTML>");
	}
	
	public void destroy() {
		//called only once by the servlet container to indicate to a servlet that the servlet is being taken out of service
		System.out.println("*** DESTROY METHOD CALLED ***");
	}
}