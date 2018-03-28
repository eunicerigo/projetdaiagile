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
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" 
              href="js/rs-plugin/css/settings.css" media="screen">
        <link rel="stylesheet" type="text/css" href="isotope.css" media="screen">
        <link rel="stylesheet" 
              href="flexslider.css" type="text/css">
        <link rel="stylesheet" href="jquery.fancybox.css" type="text/css" 
              media="screen">
        <link rel="stylesheet" href="bootstrap.css">
        <link rel="stylesheet" 
              href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700">
        <link rel="stylesheet" href="style.css">
        <!-- skin -->
        <link rel="stylesheet" href="default.css">
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
