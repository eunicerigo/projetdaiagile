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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Utilisateur;

/**
 *
 * @author eunicerigo
 */
public class ServletInscriptionUtilisateur extends HttpServlet {
     // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/xml;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        
        String genre = request.getParameter("genre");
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");    
        String datenaissance = request.getParameter("datenaissance");    
        String tel = request.getParameter("tel");
        String mail1 = request.getParameter("mail1");
        String mdp = request.getParameter("mdp");
        String obj = request.getParameter("obj");
        
        
       //Utilisateur ut1  = new Utilisateur(nom,prenom,mail1,mdp,genre,datenaissance,tel,"CLIENT",obj,,"potentiel");
        
      //  bd newbd = new bd(); 
        
      //  newbd.inscrirebaseutilisateur(new Utilisateur());
        
        
        
        
                
                  
                
    }
}
