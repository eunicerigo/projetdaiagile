/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import bd.bd;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Utilisateur;

/**
 *
 * @author evaba
 */
@WebServlet(name = "ServletListeTtClient", urlPatterns = {"/ServletListeTtClient"})
public class ServletListeClientStatut extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        /*----- Type de la réponse -----*/
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*----- Ecriture de la page XML -----*/
            out.println("<?xml version=\"1.0\"?>");
            out.println("<liste_clients>");

            String statut = request.getParameter("statut");
            
            try {
                /*----- Lecture de liste de clients dans la BD -----*/
                ArrayList<Utilisateur> listUser = bd.obteniruClientsSelonStatut(statut);

                for (Utilisateur user : listUser) {
                    out.println("<Utilisateur>"
                            + "<Nom>" + user.getNomu() + "</Nom>"
                            + "<Prenom>" + user.getPrenomu() + "</Prenom>"
                            + "<Statut>" + user.getStatutu() + "</Statut>"
                            + "<DateInsc>" + user.getDateinscri() + "</DateInsc>"
                            + "</Utilisateur>");
                }
            } catch (ParseException ex) {
                System.out.println("Erreur lors du parsage " +ex.getMessage());;
            }

        } catch (IOException ex) {
            System.out.println(" Erreur" + ex.getMessage());
        }
    }

        @Override
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
        }

    }
