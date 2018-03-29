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





function inscrireUtilisateur(){
    var xhr = getXMLHttpRequest();
    //ou ca 
    // var xhr = XMLHttpRequest();
    
    
    var genre = "genre=" + document.getElementById("genre").value;
    var nom = "nom=" + document.getElementById("nom").value;
    var prenom = "prenom=" + document.getElementById("prenom").value;
    var datenaissance = "date=" + document.getElementById("date").value;
    var tel = "tel=" + document.getElementById("tel").value;
    var mail1 = "mail1=" + document.getElementById("mail1").value;
     var mail2 = "mail2=" + document.getElementById("mail2").value;
     var mdp = "mdp=" + document.getElementById("mdp").value;
     var obj = "obj=" + document.getElementById("obj").value;
     
     
     requeteXML.onreadystatechange = function ()
    {
        //Si l'on a tout reçu et que la requête http s'est bien passée.
        if (requeteXML.readyState === 4 && requeteXML.status === 200) {
            processKey();
        }
    };
     

    xhr.open("get", "ServeletInscriptionUtilisateur?genre=" + genre);
    xhr.open("get", "ServeletInscriptionUtilisateur?nom=" + nom);
    xhr.open("get", "ServeletInscriptionUtilisateur?prenom=" + prenom);
    xhr.open("get", "ServeletInscriptionUtilisateur?datenaissance=" + datenaissance);
    xhr.open("get", "ServeletInscriptionUtilisateur?tel=" + tel);
    xhr.open("get", "ServeletInscriptionUtilisateur?mail1=" + mail1);
    xhr.open("get", "ServeletInscriptionUtilisateur?mdp=" + mdp);
    xhr.open("get", "ServeletInscriptionUtilisateur?obj=" + obj);

    requeteXML.send(null);
    

     
     
}


