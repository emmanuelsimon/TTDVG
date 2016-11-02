/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttvg;
import java.sql.*;
/**
 *
 * @author emmanuel
 */
public class Administration {
    Joueur o_Jr;
    int n_Annee, n_Id_Bureau;
    
    // méthode pour création d'un tuple dans la Table r_administrer
    protected void new_Administration (int idj, int annee,int id_poste){
        Connection con;
        String url;
        PreparedStatement stm;
        url="jdbc:mysql://localhost:3306/pingpong";
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }  
        try
        {
        con=DriverManager.getConnection(url,"root","");
        stm=con.prepareStatement("insert into r_administrer(adm_fk_id_joueur, adm_fk_id_bureau, adm_annee) values (?,?,?)");
        stm.setInt(1, idj);
        stm.setInt(2, id_poste);
        stm.setInt(3, annee);
        stm.executeUpdate();
        stm.close();
        }
        catch(Exception e)
        {
        e.printStackTrace();
        System.err.println("ca merde garcon");
        }  
    }
    // Différents constructeurs
    // Vide mais à priori inutile
    public Administration(){
    }
    // Complet pour mise à jour BD
    public Administration(Joueur jr, int annee, int id_bureau){
        o_Jr=jr;
        n_Annee=annee;
        n_Id_Bureau=id_bureau;
    }
    // Getters & Setters
    public Joueur getJr() {
        return o_Jr;
    }
    public void setJr(Joueur Jr) {
        o_Jr = Jr;
    }

    public int getAnnee() {
        return n_Annee;
    }

    public void setAnnee(int Annee) {
        n_Annee = Annee;
    }

    public int getId_Bureau() {
        return n_Id_Bureau;
    }
    public void setId_Bureau(int Id_Bureau) {
        n_Id_Bureau = Id_Bureau;
    }  
}// Fin de class
