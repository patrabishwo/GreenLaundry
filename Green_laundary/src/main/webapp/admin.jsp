<%@ page  language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
    String email= request.getParameter("email");
    String password=request.getParameter("password");
    
    
    if(email.equals("kumarswaraj520@gmail.com") && password.equals("swaraj1234"))
    {
    	out.println("Login Successfully");
    	RequestDispatcher rd=request.getRequestDispatcher("admindashbord.html");
    	rd.forward(request, response);
    }else{
    	out.println("INVALID EMAIL/PASSWORD/TRY AGAIN");
    	RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
    	rd.include(request, response); 
    }
    
%>

</body>
</html>