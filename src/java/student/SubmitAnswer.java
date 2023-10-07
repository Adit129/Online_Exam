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
public class SubmitAnswer extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
             HttpSession session=request.getSession();
                 String user=(String)session.getAttribute("user");

 String qid[]=new String[10];
String ans[]=new String[10];
int i,obt=0;
DB.DBConnect db=new DB.DBConnect();
for(i=1;i<=10;i++)
{
   qid[i-1]=request.getParameter("qid" +i);
     if(request.getParameter("ans"+i)!=null)
          ans[i-1]=request.getParameter("ans"+i);
     else
               ans[i-1]="Not Submitted";
//code to store answer sheet

db.pstmt=db.con.prepareStatement("insert into result_trans(stu_id,ques_id,ans,date)values(?,?,?,?)");
db.pstmt.setString(1,user);
db.pstmt.setString(2,qid[i-1]);
db.pstmt.setString(3,ans[i-1]);
db.pstmt.setString(4,new java.util.Date().toString());
db.pstmt.executeUpdate();
//code for obtain marks
db.pstmt=db.con.prepareStatement("select * from ques_mstr where qid=? and ans=?");
db.pstmt.setString(1,qid[i-1]);
db.pstmt.setString(2,ans[i-1]);
db.rst=db.pstmt.executeQuery();
if(db.rst.next())
{
obt=obt+10;
}
}
db.pstmt=db.con.prepareStatement("insert into result_mstr(stu_id,exam_date,maximum,obtained)values(?,?,?,?)");
db.pstmt.setString(1,user);
db.pstmt.setString(2,new java.util.Date().toString());
db.pstmt.setString(3,"70");
db.pstmt.setString(4,""+obt);
i=db.pstmt.executeUpdate();
if(i>0)
response.sendRedirect("StuResult");

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
