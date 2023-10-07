/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package student;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author user
 */
public class StuResult extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StuResult</title>");            
            out.println("</head>");
            out.println("<body><center>");
            out.println("<h1>Student Marks Statement</h1>");
            HttpSession session=request.getSession();
            String user=(String)session.getAttribute("user");
            DB.DBConnect db=new DB.DBConnect();
            db.pstmt=db.con.prepareStatement("SELECT stu_info.sname, stu_info.sdob, stu_info.sgender, stu_info.squa,result_mstr.exam_date,result_mstr.maximum,result_mstr.obtained FROM stu_info,result_mstr WHERE stu_info.email=result_mstr.stu_id AND result_mstr.stu_id=?");
            db.pstmt.setString(1,user);
            db.rst=db.pstmt.executeQuery();
            if(db.rst.next())
            {
               out.println("<table width=500 cellspacing=0 cellpadding=10 border=1 bgcolor=lightgrey>");
               out.println("<tr><td>Student ID</td><td>"+user+"</td></tr>");
               out.println("<tr><td>Student Name</td><td>"+db.rst.getString(1)+"</td></tr>");
               out.println("<tr><td>Date of Birth</td><td>"+db.rst.getString(2)+"</td></tr>");
               out.println("<tr><td>Gender</td><td>"+db.rst.getString(3)+"</td></tr>");
               out.println("<tr><td>Qualification</td><td>"+db.rst.getString(4)+"</td></tr>");
               out.println("<tr><td>Exam Date</td><td>"+db.rst.getString(5)+"</td></tr>");
               out.println("<tr><td>Maximum Marks</td><td>"+db.rst.getString(6)+"</td></tr>");
               out.println("<tr><td>Obtained Marks</td><td>"+db.rst.getString(7)+"</td></tr>");
              out.println("</table>");
            }
            out.println("</center></body>");
            out.println("</html>");
            
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
