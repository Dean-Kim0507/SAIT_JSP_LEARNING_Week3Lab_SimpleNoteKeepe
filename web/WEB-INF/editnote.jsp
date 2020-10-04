<%-- 
    Document   : editnote
    Created on : Sep 30, 2020, 9:22:31 AM
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
        <form method="post" action="note">
            <h1>Simple Note Keeper</h1>
            <h2>Edit Note</h2>
            <label>Title: </label><input type="text" name="title" value="${data.getTitle()}">
            <p>
            <label>Contents: </label><textarea name="contents">${data.getContents()}</textarea>
            <p>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
