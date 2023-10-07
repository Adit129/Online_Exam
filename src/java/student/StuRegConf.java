

package student;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
public class StuRegConf extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
    DB.DBConnect db=new DB.DBConnect();
    if(pswd.equals(cpswd))
    {
        db.pstmt=db.con.prepareStatement("insert into stu_info (email,sname,squa,sdob,sgender,sadd,scity,state,pin,scont)values(?,?,?,?,?,?,?,?,?,?)");
        db.pstmt.setString(1,email);
        db.pstmt.setString(2,sname);
        db.pstmt.setString(3,qua);
        db.pstmt.setString(4,dob);
        db.pstmt.setString(5,gender);
        db.pstmt.setString(6,addr);
        db.pstmt.setString(7,city);
        db.pstmt.setString(8,state);
        db.pstmt.setString(9,pin);
        db.pstmt.setString(10,cont);
       int i1=db.pstmt.executeUpdate();
       db.pstmt=db.con.prepareStatement("insert into login(email,password,usertype)values(?,?,'Student')");
       db.pstmt.setString(1,email);
       db.pstmt.setString(2,pswd);
    int i2=db.pstmt.executeUpdate();
     if(i1>0 && i2>0)
     {
         response.sendRedirect("index.html?msg=User Registered Succesfully");
     }
     else
         out.println("Error in Registration");
    }else
        response.sendRedirect("Registeration.html?msg=Password and Confirm Password does not Match");
        }
        catch(Exception e)
        {
            e.printStackTrace();
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
