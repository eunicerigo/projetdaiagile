<%-- 
    Document   : newjsp
    Created on : 2018-3-29, 11:49:34
    Author     : wangziqi
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Metier.Utilisateur"%>
<%@page import="BD.bd"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifier en attent</title>
    </head>
    <body>
        <h1>Modifiez le statut </h1>
        <form action="" method="post">
        <%
        bd newbd = new bd();
        ArrayList<Utilisateur> listeU = newbd.ConsulterUtilisateur();
        for ( Utilisateur uti:listeU){
        out.print("<input type='checkbox' value='uti.getNomu()'>");
        }
        %>
        </form>
    </body>
</html>
