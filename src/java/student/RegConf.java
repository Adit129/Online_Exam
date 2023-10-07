package student;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RegConf extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
             String email=request.getParameter("email");
    String sname=request.getParameter("sname");
    String qua=request.getParameter("qua");
    String addr=request.getParameter("addr");
    String gender=request.getParameter("gender");
    String dob=request.getParameter("dob");
    String city=request.getParameter("city");
    String state=request.getParameter("state");
    String pin=request.getParameter("pin");
    String cont=request.getParameter("cont");
    String pswd=request.getParameter("pswd");
    String cpswd=request.getParameter("cpswd");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Student Registration Detail</title>");            
            out.println("</head>");
            out.println("<body><center>");
            out.println("<h1>Student Registration Detail</h1>"
                    + "<form action=EditEmpReg1>"
                    + "<table width=200 height=400 cellpadding=20 border=1>"
                    + "<tr><td>Student email ID</td><td>"+email+"</td></tr>"
                    + "<tr><td>Student Name</td><td>"+sname+"</td></tr>"
                    + "<tr><td>Qualification</td><td>"+qua+"</td></tr>"
                    + "<tr><td>Address</td><td>"+addr+"</td></tr>"
                    + "<tr><td>Gender</td><td>"+gender+"</td></tr>"
                    + "<tr><td>DOB</td><td>"+dob+"</td></tr>"
                    + "<tr><td>City</td><td>"+city+"</td></tr>"
                    + "<tr><td>State</td><td>"+state+"</td></tr>"
                    + "<tr><td>Pincode</td><td>"+pin+"</td></tr>"
                    + "<tr><td>Contact</td><td>"+cont+"</td></tr>"
                  
                    + "<input type=hidden name=code value="+sname+">"
                    + "<input type=hidden name=name value="+qua+">"
                    + "<input type=hidden name=addr value="+addr+">"
                    + "<input type=hidden name=addr value="+gender+">"
                    + "<input type=hidden name=addr value="+dob+">"
                    + "<input type=hidden name=city value="+city+">"
                    + "<input type=hidden name=cont value="+state+">"
                    + "<input type=hidden name=addr value="+pin+">"
                    + "<input type=hidden name=addr value="+cont+">"
                    + "<tr><td><input type=submit value=Edit></td><td><input type=button value=Confirm></td></tr>");
            out.println("</table></form></center></body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
