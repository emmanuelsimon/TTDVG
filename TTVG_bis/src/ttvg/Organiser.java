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
public class Organiser {
    Ville o_VilleComp;
    Competition o_Compete;
    String dt_dateComp, sz_NomResponsable, sz_TelResponsable;
       
    // methode permettant d'ajouter un tuple à la table R_Organiser de la BD
    public void new_Organiser(Organiser og){
        //initialisation des variables
        Organiser og1=og;
        int idVille, idComp;
        String dtcomp, nomresp, telresp, url;
        Connection con;
        PreparedStatement stm;
        Ville villeC;
        Competition comp;
        // affectation aux variables
        villeC=og1.getVillecomp();
        idVille=villeC.getIdVille();
        comp=og1.getCompete();
        idComp=comp.getId_Compete();
        dtcomp=og1.getDateComp();
        nomresp=og1.getSz_NomResponsable();
        telresp=og1.getSz_TelResponsable();
        url="jdbc:mysql://localhost:3306/pingpong";
        // chargement du Driver mysql
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
        // connection à la bd
        con=DriverManager.getConnection(url,"root","");
        System.out.println("ca marche pour la Organiser");
        // préparation de la requête
        stm=con.prepareStatement("insert into r_organiser values (?,?,?,?,?)");
        // attribution des valeurs pour la requête
        stm.setInt(1, idVille);
        stm.setInt(2, idComp);
        stm.setString(3, dtcomp);
        stm.setString(4, nomresp);
        stm.setString(5, telresp);
        // exécution update
        stm.executeUpdate();
        stm.close();
        }
        catch(Exception e)
        {
        e.printStackTrace();
        }        
    }
    
    // Constructeurs
    public Organiser(){
    }    
    public Organiser(Ville v1,Competition c1,String dateComp,String nom_Respon,String tel_Respon){
        o_VilleComp=v1;
        o_Compete=c1;
        dt_dateComp=dateComp;
        sz_NomResponsable=nom_Respon;
        sz_TelResponsable=tel_Respon;
    }
    // getteurs & setteurs
    public Ville getVillecomp() {
        return o_VilleComp;
    }
    public void setVillecomp(Ville VilleComp) {
        o_VilleComp = VilleComp;
    }
    public Competition getCompete() {
        return o_Compete;
    }
    public void setCompete(Competition Compete) {
        o_Compete = Compete;
    }
    public String getDateComp() {
        return dt_dateComp;
    }
    public void setDateComp(String dateComp) {
        dt_dateComp = dateComp;
    }
    public String getSz_NomResponsable() {
        return sz_NomResponsable;
    }
    public void setSz_NomResponsable(String nomResponsable) {
        sz_NomResponsable = nomResponsable;
    }
    public String getSz_TelResponsable() {
        return sz_TelResponsable;
    }
    public void setSz_TelResponsable(String telResponsable) {
        this.sz_TelResponsable = telResponsable;
    }
    
    
}// fin class
