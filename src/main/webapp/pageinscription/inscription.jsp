<%-- 
    Document   : inscription
    Created on : 27 mars 2018, 13:17:03
    Author     : 21104333
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>Inscription client</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <link rel="stylesheet" type="text/css" 
                  href="Vlava/js/rs-plugin/css/settings.css" media="screen">
            <link rel="stylesheet" type="text/css" href="Vlava/css/isotope.css" media="screen">
            <link rel="stylesheet" 
                  href="flexslider.css" type="text/css">
            <link rel="stylesheet" href="Vlava/js/jquery.fancybox.css" type="text/css" 
                  media="screen">
            <link rel="stylesheet" href="Vlava/css/bootstrap.css">
            <link rel="stylesheet" 
                  href="https://fonts.googleapis.com/css?family=Noto+Serif:400,400italic,700|Open+Sans:300,400,600,700">
            <link rel="stylesheet" href="Vlava/css/style.css">
            <!-- skin -->
            <link rel="stylesheet" href="Vlava/css/default.css">
        <SCRIPT language="JavaScript"  src="script.js"></script>
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

                <!-- Menu en haut -->
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav" data-0="margin-top:20px;" data-300="margin-top:5px;">
                        <li><a href="#section-about">Home</a></li>
                        <li><a href="#testimonials">Apercu</a></li>
                        <li><a href="#section-contact">Contact</a></li>
                    </ul>
                </div>
            </div>
        </div>

        <section id="intro">
            <div class="intro-content">
                <h2>JEAN DAVID COACHING</h2>
                <h3>Page Inscription</h3>
            </div>
        </section>

        <section id="section-contact" class="section appear clearfix">
            <div class="container">
                <div class="row mar-bot40">
                    <div class="col-md-offset-3 col-md-6">
                        <div class="section-header">
                            <h2 class="section-heading animated" data-animation="bounceInUp">Inscrivez vos coordonnées</h2>
                            <h3>Les informations suivies d'un astérisque sont obligatoires.</h3>
                        </div>
                        <div class="cform" id="contact-form">
                            <form name="Formulaires" method="get" onsubmit="return verifier()">
                                <div name='genre'>
                                    Civilité: <select name="genre" id ="genre">
                                        <option value="H">Homme.</option>
                                        <option value="F">Femme.</option>
                                    </select>(*)
                                </div>

                                <div class="field your-name form-group">
                                    Nom:<input type="text" name="Nom" id ="nom" placeholder="Nom" class="cform-text" size="40" required>(*)
                                    <div class="validation"></div>
                                </div>
                                <div class="field your-name form-group">
                                    Prénom:<input type="text" name="Prenom" id ="prenom" placeholder="Prénom" class="cform-text" size="40" required>(*)
                                    <div class="validation"></div>
                                </div>
                                    Date de naissance:<input type="date" name="date" id ="date" placeholder="dd/mm/yyyy" required>(*)
                                    Numéro de téléphone:<input type="text" name="tel" id="tel" pattern="[0-9]{10}" required>(*)
                                    Adresse e-mail:<input type="email" name="mail1" id="mail1" required>(*)
                                    Confirmation e-mail:<input type="email" name="mail2" id="mail2" required>(*)
                                    Mot de passe:<input type="password" name="mdp" id = "mdp" required>(*)
                                    Objectif:<select name="obj" id="obj">
                                        <option value="objs">objectif sportif</option>
                                        <option value="objm">objectif minceur</option>
                                    </select>(*)

                                    <p><input type="submit" onClick="inscrireUtilisateur()" value="Envoyer"/>

                                        <input type="reset" value="Effacer"/></p>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </section>


    </body>
</html>
<f:view>