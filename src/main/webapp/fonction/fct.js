/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function getXMLHttpRequest()
{
    var xhr = null;

    // Firefox et bien d'autres.
    if (window.XMLHttpRequest)
        xhr = new XMLHttpRequest();
    else

    // Internet Explorer.
    if (window.ActiveXObject)
    {
        try {
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e)
        {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }

    // XMLHttpRequest non supporté.
    else
    {
        alert("Votre navigateur ne supporte pas l'objet XmlHttpRequest.");
        xhr = false;
    }

    return xhr;
}

function liste_tout_Client() {
    liste_Client_EnAttente();
    liste_Client_Potentiel();
    liste_Client_Abonne();
}

function liste_Client_EnAttente() {
    requeteXML = new XMLHttpRequest();
    requeteXML.onreadystatechange = function ()
    {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {
            listeEnAttente = chargerListeClient(requeteXML.responseXML);

            var eltEnAttente = document.getElementById("clientEnAttente");

            eltEnAttente.innerHTML = listeEnAttente;
        }
    };
    // Requête au serveur avec les paramètres éventuels.
    requeteXML.open("GET", "ServletListeClientSelonStatut?statut=En Attente", true);
    requeteXML.send(null);
}

function liste_Client_Potentiel() {
    requeteXML = new XMLHttpRequest();
    requeteXML.onreadystatechange = function ()
    {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {
            listePotentiel = chargerListeClient(requeteXML.responseXML);

            var eltPotentiel = document.getElementById("clientPotentiel");

            eltPotentiel.innerHTML = listePotentiel;
        }
    };
    // Requête au serveur avec les paramètres éventuels.
    requeteXML.open("GET", "ServletListeClientSelonStatut" + "?statut=Potentiel", true);
    requeteXML.send(null);
}

function liste_Client_Abonne() {
    requeteXML = new XMLHttpRequest();
    requeteXML.onreadystatechange = function ()
    {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {
            listeAbonne = chargerListeClient(requeteXML.responseXML);

            var eltAbonne = document.getElementById("clientValider");

            eltAbonne.innerHTML = listeAbonne;
        }
    };
    // Requête au serveur avec les paramètres éventuels.
    requeteXML.open("GET", "ServletListeClientSelonStatut?statut=Abonné", true);
    requeteXML.send(null);
}

function chargerListeClient(listeClientXML) {
    var i, client, liste;
    liste = "";
    client = listeClientXML.getElementsByTagName("Utilisateur");
    for (i = 0; i < client.length; i++) {
        noeudNom = client[i].getElementsBytagName("Nom")[0];
        nom = noeudNom.firstChild.nodeValue;

        noeudPrenom = client[i].getElementsBytagName("Prenom")[0];
        prenom = noeudPrenom.firstChild.nodeValue;

        noeudStatut = client[i].getElementsBytagName("Statut")[0];
        statut = noeudStatut.firstChild.nodeValue;

        noeudDateInsc = client[i].getElementsBytagName("DateInsc")[0];
        dateinsc = noeudDateInsc.firstChild.nodeValue;

        if(liste.length===0) {
            liste = "Pas de clients pour le moment";
        } else {
            liste = liste + "<p>" + nom + " " + prenom + " " + statut + " "
                + dateinsc + "</p";
        }
    }
    return liste;
}

function displayDate() {
    document.getElementById("demo").innerHTML = Date();
}