package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class StuProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body><center>\n");
      out.write("        <h1>Student Profile</h1>\n");
      out.write("      ");
  
         try{
            DB.DBConnect db=new DB.DBConnect();
            db.pstmt=db.con.prepareStatement("select * from stu_info");
            HttpSession session1=request.getSession();
            String user=(String)session1.getAttribute("user");
             
            db.rst=db.pstmt.executeQuery();
         if(db.rst.next())
          {
               out.println("<table width=500 cellspacing=0 cellpadding=10 border=1 bgcolor=lightyellow>");
               out.println("<tr><td>Email</td><td>"+user+"</td></tr>");
               out.println("<tr><td>Student Name</td><td>"+db.rst.getString(2)+"</td></tr>");
               out.println("<tr><td>Qualification</td><td>"+db.rst.getString(3)+"</td></tr>");
               out.println("<tr><td>DOB</td><td>"+db.rst.getString(4)+"</td></tr>");
               out.println("<tr><td>Gender</td><td>"+db.rst.getString(5)+"</td></tr>");
               out.println("<tr><td>Address</td><td>"+db.rst.getString(6)+"</td></tr>");
               out.println("<tr><td>City</td><td>"+db.rst.getString(7)+"</td></tr>");
               out.println("<tr><td>State</td><td>"+db.rst.getString(8)+"</td></tr>");
               out.println("<tr><td>Pincode</td><td>"+db.rst.getString(9)+"</td></tr>");
               out.println("<tr><td>Contact</td><td>"+db.rst.getString(10)+"</td></tr>");
               
              out.println("</table>");
              }}
              catch(Exception e)
                      {
                      e.printStackTrace();
                      }
            
         
            
      out.write("\n");
      out.write("    </center>  </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
