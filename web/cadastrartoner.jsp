<%-- 
    Document   : cadastrartonner
    Created on : 25/05/2016, 10:54:00
    Author     : TI-01
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Local"%>
<%@page import="controle.LocalImpl"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Toner</title>
    </head>
    <body>
        <h1>Adicionar Toner</h1>
        <form action="cadastrartoner" method="POST">
            
            <%
                LocalImpl localImpl = new LocalImpl();
                List<Local> list = localImpl.getListAll();
            %>
            
            Estado:
            <select name="local">
                <% for (Local e : list){ %>
                <option value="<%=e.getId()%>"><%=e.getNome()%></option>
                <%}%>
            </select><br>
            Cidade:<input type="text" name="toner"/><br>
            <input type="submit" value="Adcionar Toner"/>
        </form>
    </body>
</html>
