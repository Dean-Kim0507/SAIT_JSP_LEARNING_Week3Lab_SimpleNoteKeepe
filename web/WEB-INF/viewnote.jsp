<%-- 
    Document   : viewnote
    Created on : Sep 30, 2020, 9:22:10 AM
    Author     : 834043
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <h3>Title: ${data.getTitle()}</h3>
        <h3>Contents: ${data.getContents()}</h3>
        <a href="note?edit" name="button" value="edit"> Edit</a>
    </body>
</html>
