<%-- 
    Document   : cadastrarLocal
    Created on : 25/05/2016, 12:25:32
    Author     : TI-01
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Adiconar Local</h1>
        <form action="cadastrarLocal" method="POST">
            Local: <input type="text" name="local"/>
            <input type="submit" value="Adicionar"/>
        </form>
    </body>
</html>
