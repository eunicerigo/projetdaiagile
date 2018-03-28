<%-- 
    Document   : accueil
    Created on : 28 mars 2018, 11:56:14
    Author     : FLEXICSSS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>Accueil Page</title>
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
        <section id="header" class="appear"></section>
        <div class="navbar navbar-fixed-top" role="navigation" 
             data-0="line-height:100px; height:100px; background-color:rgba(0,0,0,0.3);" 
             data-300="line-height:60px; height:60px; background-color:rgba(5, 42, 62, 1);">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="fa fa-bars color-white"></span>
                    </button>
                </div>

                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav" data-0="margin-top:20px;" data-300="margin-top:5px;">
                        <li><a href="#section-about">Home</a></li>
                        <li><a href="#section-image">Apercu</a></li>
                        <li><a href="#section-contact">Contact</a></li>
                    </ul>
                </div>
                <!--/.navbar-collapse -->
            </div>
        </div>
        <section id="intro">
            <div class="intro-content">
                <h2>JEAN DAVID COACHING</h2>
                <h3>Bienvenue!</h3>
                <div>
                    <a href="login.jsp" class="btn-get-started scrollto">LOG IN</a>
                    <a href="#section-services" class="btn-get-started scrollto">INSCRIRE</a>
                </div>
            </div>
        </section>

    </body>
</html>
</f:view>
