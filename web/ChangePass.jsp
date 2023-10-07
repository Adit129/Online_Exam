<%-- 
    Document   : ChangePass
    Created on : Jul 20, 2023, 5:46:12 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <center>
        <div style="width:800px; height:600px;border:2px solid black; background-color: lightcyan">
            <h2>Change Password</h2>
            <form action="ChangePswd1">
  <table width=400 height=300 cellpadding=30 bgcolor=Lightgrey opacity="20" border="2px solid black">
       
      <tr><td>Old Password</td><td><input type="password" name="opswd"></td></tr> 
            <tr><td>New Password</td><td><input type="password" name="npswd"></td></tr>
            <tr><td>Confirm Password</td><td><input type="password" name="cpswd"></td></tr>
            <tr><td><input type="submit" value="Update"></td><td><input type="reset" Value="Reset"></td></tr> 
            
            
        </table>
   </form>
    </div>
</center>
    </body>
</html>
