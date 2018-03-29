/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import metier.Utilisateur;

/**
 *
 * @author 21101690
 */
public class bd {

    private static Connection cx;

    //Données de connexion
    private String url = "jdbc:mysql://ivgz2rnl5rh7sphb.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/pef1s12npqjzdjql";
    private String login = "vaburf7btkwebup2";
    private String password = "yd1h1k477wysphga";
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY");

    //Constructeur
    public bd() {
        //Chargement du pilote pour la base de données
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Echec lors du chargement du driver" + e.getMessage());
        }

        //Ouverture de la connexcion
        try {
            cx = DriverManager.getConnection(url, login, password);
        } catch (SQLException ex) {
            System.out.println("Echec lors de la tentative de connexion à la bd" + ex.getMessage());
        }
    }

    public int verifLogin(String email, String mdp) throws SQLException {
        Statement st;
        int rs1 = 0;

        String sql = "select TYPEU from UTILISATEUR where MAILU='" + email + "' and MDPU = '" + mdp + "'";
        st = cx.createStatement();
        ResultSet rs = st.executeQuery(sql); //resultat

        //verifier
        if (rs.next()) {
            System.out.println("connect ok");
            //ok
            String type = rs.getString("TYPEU");
            if (type.equals("COACH")) {
                rs1 = 1;
                System.out.println("COACH");
            } else if (type.equals("CLIENT")) {
                rs1 = 2;
                System.out.println("CLIENT");
            } else if (type.equals("ADMIN")) {
                rs1 = 3;
                System.out.println("admin");
            }
        } else //ko
        {
            rs1 = 4;
        }
        return rs1;

    }

    //Methode de récuperration des utilisateurs
    public ArrayList<Utilisateur> ConsulterUtilisateur() throws SQLException {
        int codeu;
        String nomu ;
        String prenomu ;
        String mailu;
        String genreu;
        Date datenaissance;
        String telu;
        String infooptionnelle;
        String typeu;
        Statement st;
        ResultSet rs;

        String sql = "select CODEU,NOMU, PRENOMU, MAILU, GENREU, DATENAISSANCE, TELU, INFOOPTIONNELLE, TYPEU from UTILISATEUR;";
        st = cx.createStatement();
        ArrayList<Utilisateur> liste = new ArrayList<>();

        try{
            rs = st.executeQuery(sql);

            while (rs.next()) {
                codeu = rs.getInt("CODEU");
                nomu = rs.getString("NOMU");
                prenomu = rs.getString("PRENOMU");
                mailu = rs.getString("MAILU");
                genreu = rs.getString("GENREU");
                datenaissance=rs.getDate("DATENAISSANCE");
                telu=rs.getString("TELU");
                infooptionnelle=rs.getString("INFOOPTIONNELLE");
                typeu=rs.getString("TYPEU");

              //  Date x = formatDate.parse(datenaissance); 
                
                
          //      liste.add(new Utilisateur(codeu,nomu,prenomu, mailu,genreu, datenaissance,telu,infooptionnelle,typeu));
                
            }
        }
        catch(SQLException ex){
            System.out.println("erreur"+ex.getMessage());
        }
    return liste;
}


    public int inscrirebaseutilisateur(Utilisateur lutilisateur) {
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace d'exécution " + ex.getMessage());
        }

        //Requête SQL
        String inscrirebase = "INSERT INTO UTILISATEUR "
                + "(CODEU, NOMU, PRENOMU, MAILU, MDPU, GENREU, TELU) "
                + "VALUES ('" + lutilisateur.getCodeu() + "','" + lutilisateur.getNomu() + "','"
                + lutilisateur.getPrenomu() + "','" + lutilisateur.getMailu() + "','" + lutilisateur.getMdpu() + "','"
                + lutilisateur.getGenreu() + "','" + lutilisateur.getTelu()
                + "');";

        int nb_ligne_modifie = 0;
        try {
            //Ouverture de l'espace de requête
            nb_ligne_modifie = st.executeUpdate(inscrirebase);
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'insertion de l'utilisateur " + ex.getMessage());
        }

        //Fermeture de l'espace d'exécution de la requête
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace d'exécution de la requête " + ex.getMessage());
        }

        /*Commit de la modification de la base de donnére
         try {
         System.out.println("test du commit");
         cx.commit();
         } catch (SQLException ex) {
         System.out.println("Echec lors du commit d ela base de données "+ex.getMessage());
         }*/
        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la base de données " + ex.getMessage());
        }
        return nb_ligne_modifie;
    }

    public int supprimerutilisateur(Utilisateur lutilisateur) {
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace "
                    + "d'exécution " + ex.getMessage());
        }

        //Requête SQL
        String inscrirebase = "DELETE FROM UTILISATEUR WHERE MAILU = '"
                + lutilisateur.getMailu() + "';";

        int nb_ligne_modifie = 0;
        try {
            //Ouverture de l'espace de requête
            nb_ligne_modifie = st.executeUpdate(inscrirebase);
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'insertion de l'utilisateur "
                    + ex.getMessage());
        }

        //Fermeture de l'espace d'exécution de la requête
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace "
                    + "d'exécution de la requête " + ex.getMessage());
        }

        /*Commit de la modification de la base de donnére
         try {
         System.out.println("test du commit");
         cx.commit();
         } catch (SQLException ex) {
         System.out.println("Echec lors du commit d ela base de données "+ex.getMessage());
         }*/
        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la "
                    + "base de données " + ex.getMessage());
        }
        return nb_ligne_modifie;
    }
    
    //Methode de récuperration des utilisateurs
    public static ArrayList<Utilisateur> obteniruClientsSelonStatut(String statut) throws ParseException {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        String recupererUtilisateur = null;
        ArrayList<Utilisateur> listeUtilisateur = new ArrayList();
        //Espace d'exécution de la requête
        Statement st = null;
        try {
            //Espace d'exécution de la requête
            st = cx.createStatement();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la création de l'espace d'exécution " + ex.getMessage());
        }

        //Requête SQL
        if(statut.equals("Abonné")) {
            recupererUtilisateur = "SELECT NOMU, PRENOMU, STATUTU, DATEINSCRI "
                + "FROM UTILISATEUR WHERE TYPEU = 'CLIENT' AND STATUTU LIKE "
                + "'%"+statut+"%' ORDER BY NOMU, PRENOMU";
        } else {
            recupererUtilisateur = "SELECT NOMU, PRENOMU, STATUTU, DATEINSCRI "
                + "FROM UTILISATEUR WHERE TYPEU = 'CLIENT' AND STATUTU LIKE "
                + "'%"+statut+"%' DATEINSCRI";
        }
        
        //Ouverture de l'espace de requête
        ResultSet rs = null;
        try {
            rs = st.executeQuery(recupererUtilisateur);
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'interrogation de la base de données " + ex.getMessage());
        }

        //Ecriture des résultats de la requête dans la liste des messages
        try {
            while (rs.next()) {
                listeUtilisateur.add(new Utilisateur(rs.getString("NOMU"),
                        rs.getString("PRENOMU"), rs.getString("STATUTU"),
                        formatDate.parse(rs.getString("DATEINSCRI"))));
            }
        } catch (SQLException ex) {
            System.out.println("Echec lors de l'écriture dans la liste des messages " + ex.getMessage());
        }

        //Fermeture de l'espace de requête
        try {
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace de requête " + ex.getMessage());
        }

        //Fermeture de l'espace d'exécution de la requête
        try {
            st.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de l'espace d'exécution de la requête " + ex.getMessage());
        }

        //Fermeture de la connexion à la base de données
        try {
            cx.close();
        } catch (SQLException ex) {
            System.out.println("Echec lors de la fermeture de la connexion à la base de données " + ex.getMessage());
        }
        return listeUtilisateur;
    }
    
    //Admin peut modifier le statut de client en attente
    public void ModifierStatutUtilisateur(Utilisateur utimodif) throws SQLException{
              try{
             Statement st3;
           st3=cx.createStatement();
           /*requete SQL*/
           String sq="update UTILISATEUR set STATUTU='"+utimodif.getStatutu()+"' Where STATUTU='null' and TYPEU='CLIENT'";
           int nb = st3.executeUpdate(sq);
              }
              catch (SQLException ex){
                  System.out.println("erreur"+ex.getMessage());
         }
         }


    //Programme de test de la connexion à la bd
    public static void main(String[] args) throws SQLException, ParseException {
        bd unebd = new bd();
//        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
//        Utilisateur u1 = new Utilisateur("Setilahy", "Sergio", 
//            "sergio@example.com", "12test", "M", 
//            formatDate.parse("27/09/1990"), "01-23-45-67-89", 
//            "Client", new Date(), "Potentiel");
//
//        int nb_ligne_mod = unebd.inscrirebaseutilisateur(u1);

//        System.out.println("nombre de ligne modifiée " + nb_ligne_mod);
     
        bd newbd = new bd();
        ArrayList<Utilisateur> lstUtilisateur = newbd.ConsulterUtilisateur();
        for    (Utilisateur utili:lstUtilisateur){
            System.out.println("Utilisateur inscrit:" + utili.getNomu()+ " "+utili.getMailu());
            }

        

    }
}
