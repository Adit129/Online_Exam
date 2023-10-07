<%@page import="DB.DBConnect"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@800&family=Baloo+Bhaina+2:wght@800&display=swap" rel="stylesheet">
    <style>
        /* CSS RESET  */
        body{
            font-family: 'Baloo Bhai 2', cursive;
            margin: 0px;
            padding: 0px;
            background: url(Images/Student7.jpg);
            background-repeat:no-repeat ;
           background-size: 1550px 800px;  
           font-family: Baloo Bhai;  
           
        }
        .navbar
        {
         display: inline-block;
         border: 3px solid white;
        margin-left: 0%;
         margin-top: 25px;
         border-radius: 5px;
        }
        .navbar li{
            display: inline-block;
        }
        .navbar li a{
            color: white;
            font-size:23px;
            padding: 15px;
            text-decoration: none;
        }
        .navbar li a:hover{
           
           color: grey;
           font-size:23px;
           padding:15px;
           text-decoration: none; 
       }
     

    
    </style>
</head>
<body>
    <header>
        <div class="navbar">
        <ul>
        <li><a href="StudentList.jsp"> Student List</a> </li>
        <li><a href="AddQuestion.jsp">Add Question</a></li>
        <li><a href="QusList.jsp">Question List</a></li>
        <li> <a href="UpDelQues.jsp">Update/Delete Question</a></li>
        <li><a href="AdminResult.jsp">Result</a></li>
        <li><a href="AdminChangePassword.jsp">Change Password</a></li>
        <li><a href="AdminLogout">Log Out</a></li>
        </ul>
    </div><hr>
    </header>
    <center>
    <div style="width:800px; height:600px;border:2px solid black; background-color: lightcyan">
        <h2>Update Question</h2>
        <form action="UpdateQuestion">
            <%
              try{ 
                  
                  String qid=request.getParameter("qid");
                DBConnect db=new DBConnect();
                db.pstmt=db.con.prepareStatement("select * from ques_mstr where qid=?");
                db.pstmt.setString(1,qid);
                
                db.rst=db.pstmt.executeQuery();
                if(db.rst.next())
                {
                    
                %>
                
                <table width="500" height="400" cellspacing="30" >
       
            <tr><td>Question ID</td><td><input type="number" name="qid" value= <%=qid %>></td></tr> 
            <tr><td>Question</td><td><textarea name="ques"row="4"style="width:200px;" value="<%=db.rst.getString(2)%>"><%=db.rst.getString(2)%></textarea></td></tr> 
            <tr><td>Option1</td><td><input type="text" name="opt1"style="width:200px;" value="<%=db.rst.getString(3)%> "></td></tr> 
            <tr><td>Option2</td><td><input type="text" name="opt2"style="width:200px;" value="<%=db.rst.getString(4)%> "></td></tr> 
            <tr><td>Option3</td><td><input type="text" name="opt3"style="width:200px;" value="<%=db.rst.getString(5)%> "></td></tr> 
            <tr><td>Option4</td><td><input type="text" name="opt4"style="width:200px;" value="<%=db.rst.getString(6)%> "></td></tr> 
             <tr><td>Answer</td><td><input type="text" name="ans"style="width:200px;" value="<%=db.rst.getString(7)%> "></td></tr> 
            <tr><td><input type="submit" value="Submit"></td><td><input type="reset" Value="Reset"></td></tr> 
            
            
        </table>
                <%
                }}
              catch(Exception e)
              {
                  e.printStackTrace();
              }
                %>
        </form>
    </div>
</center>
</body>
</html>