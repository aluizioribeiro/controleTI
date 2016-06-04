<%-- 
    Document   : listar
    Created on : 25/05/2016, 11:12:10
    Author     : TI-01
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Impressora"%>
<%@page import="controle.ImpressoraImpl"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Lista de Impressoras</title>
    </head>
    <body>
        <h1>Impressoras</h1>
        <div>
            <table>
                <tr>
                    <td>ID</td>
                    <td>MARCA</td>
                    <td>MODELO</td>
                    <td>LOCAL</td>
                </tr>
                <%
                    ImpressoraImpl impressoraImpl = new ImpressoraImpl();
                    List<Impressora> list = impressoraImpl.getListAll();
                    for(Impressora i : list){
                        %>
                        <tr>
                            <td><%= i.getId() %></td>
                            <td><%= i.getMarca()%></td>
                            <td><%= i.getModelo()%></td>
                            <td><%= i.getLocal()%></td>
                        </tr>
                        <%
                    }
                %>
            </table>
        </div>
    </body>
</html>
