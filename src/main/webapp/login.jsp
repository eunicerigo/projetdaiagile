<%-- 
    Document   : login
    Created on : 2018-3-27, 17:35:37
    Author     : evaba
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <%
            Connection cx;
            String emailutil;
            String mdputil;
            //Données de connexion
            String url = "jdbc:mysql://ivgz2rnl5rh7sphb.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/pef1s12npqjzdjql";
            String login = "vaburf7btkwebup2";
            String password = "yd1h1k477wysphga";

            //Chargement du pilote pour la base de données
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //Ouverture de la connexcion
            cx = DriverManager.getConnection(url, login, password);

            //GET Utilisateur
            emailutil = request.getParameter("txtemai");
            mdputil = request.getParameter("txtmdp");
            //SQL
            String sql = "select * from UTILISATEUR where MAILU='" + emailutil + "' and MDPU = '" + mdputil + "'";
            Statement stmt = cx.createStatement();
            ResultSet rs = stmt.executeQuery(sql); //resultat

            //verifier
            if (rs.next()) {
                out.println("Login sucès!!!");
            } else //ko
            {
                out.println("Adresse mail ou mot de passe pas correct!!!");
            }

            rs.close();
            stmt.close();
            cx.close();
        %>
    </body>
</html>
