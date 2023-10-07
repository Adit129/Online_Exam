<%-- 
    Document   : StuProfile
    Created on : Jul 22, 2023, 3:19:31 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body><center>
        <h1>Student Profile</h1>
      <%  
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
            
         
            %>
    </center>  </body>
</html>
