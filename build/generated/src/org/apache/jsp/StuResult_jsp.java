package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import java.text.SimpleDateFormat;

public final class StuResult_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Student Result</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <h1>Exam Result</h1>\n");
      out.write("    \n");
      out.write("    ");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    ");
      out.write("\n");
      out.write("    ");
 String obtainedMarks = (String) request.getAttribute("obtained"); 
      out.write("\n");
      out.write("    ");
 String examDate = (String) request.getAttribute("exam_date"); 
      out.write("\n");
      out.write("    \n");
      out.write("    ");
      out.write("\n");
      out.write("    ");
 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
      out.write("\n");
      out.write("    \n");
      out.write("    ");
      out.write("\n");
      out.write("    <p>Hello ");
      out.print( session.getAttribute("user") );
      out.write(",</p>\n");
      out.write("    <p>Your exam result is as follows:</p>\n");
      out.write("    <p>Obtained Marks: ");
      out.print( obtainedMarks );
      out.write("</p>\n");
      out.write("    <p>Exam Date: ");
      out.print( sdf.format(new Date(examDate)) );
      out.write("</p>\n");
      out.write("    \n");
      out.write("    <p>Thank you for taking the exam.</p>\n");
      out.write("</body>\n");
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
