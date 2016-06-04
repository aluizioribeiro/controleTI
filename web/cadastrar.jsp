<%-- 
    Document   : cadastrar impressora
    Created on : 18/05/2016
    Author     : Aluizio
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro de impressora</title>
    </head>
    <body>
        <h1>Cadastro de impressora</h1>
        <div>
            <form action="cadastrar impressora" method="post">
                Marca: <input type="text" name="marca"/><br>
                Modelo:<input type="text" name="modelo"/><br>
                Localização:<input type="text" name="local"/><br>
                <input type="submit" value="Adicionar"/>
            </form>
        </div>
    </body>
</html>
