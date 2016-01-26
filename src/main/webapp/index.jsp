<%-- 
    Document   : index
    Created on : 26-Jan-2016, 4:16:33 PM
    Author     : c0666985
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="db.db" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%=db.getTable()%>
        <h1>Hello World!</h1>
    </body>
</html>
