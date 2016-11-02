/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttvg;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author emmanuel
 */
public class Joueur {
    int n_idJoueur, n_TypeLicence;
    String sz_NomJoueur, sz_PrenomJoueur, sz_DateNaissn, sz_Adresse, sz_Tel, sz_MailJoueur;
    static ArrayList <Joueur> joueurs; // pour pouvoir y acceder de n'importe ou 
 
    // Enregistrement de la nouvelle ville dans la DB
    protected void new_Joueur_Db (Joueur j1){
        Connection con;
        Joueur jou=j1;
        ResultSet res;
        int lastId, typeLicence;
        String nomJoueur, prenomJoueur, dateNaiss, adresse, tel, mailJoueur,url;
        PreparedStatement stm;
        nomJoueur=jou.getNomJoueur();
        prenomJoueur=jou.getPrenomJoueur();
        dateNaiss=jou.getDateNaissn();
        adresse=jou.getAdresse();
        tel=jou.getTel();
        mailJoueur=jou.getMailJoueur();
        typeLicence=jou.getTypeLicence();
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
        stm=con.prepareStatement("insert into t_joueur(jou_fk_id_typ_licence,jou_nom_joueur, jou_pnom_joueur, jou_dt_nais_joueur, jou_adress_joueur, jou_tel_joueur, jou_mail_joueur) values (?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        stm.setInt(1, typeLicence);
        stm.setString(2, nomJoueur);
        stm.setString(3, prenomJoueur);
        stm.setString(4, dateNaiss);
        stm.setString(5, adresse);
        stm.setString(6, tel);
        stm.setString(7, mailJoueur);
        stm.executeUpdate();
        res = stm.getGeneratedKeys();
        res.next();
        lastId = res.getInt(1);
        jou.setIdJoueur(lastId);
        joueurs.add(jou);
        stm.close();
        }
        catch(Exception e)
        {
        e.printStackTrace();
        System.err.println("ca merde garcon");
        }
    }

    protected void modif_joueur(Joueur j1){
        Connection con;
        Joueur jou=j1;
        //ResultSet res;
        int id_Joueur,typeLicence;
        String nomJoueur, prenomJoueur, dateNaiss, adresse, tel, mailJoueur,url;
        PreparedStatement stm;
        id_Joueur=jou.getIdJoueur();
        nomJoueur=jou.getNomJoueur();
        prenomJoueur=jou.getPrenomJoueur();
        dateNaiss=jou.getDateNaissn();
        adresse=jou.getAdresse();
        tel=jou.getTel();
        mailJoueur=jou.getMailJoueur();
        typeLicence=jou.getTypeLicence();
        System.out.println("test licence"+typeLicence);
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
        stm=con.prepareStatement("update t_joueur set jou_pk_id_joueur=?, "
                + "jou_fk_id_typ_licence=?,"
                + "jou_nom_joueur=?,"
                + "jou_pnom_joueur=?"
                + ",jou_dt_nais_joueur=?,"
                + "jou_adress_joueur=?,"
                + "jou_tel_joueur=?,"
                + "jou_mail_joueur=? "
                + "where jou_pk_id_joueur=?"); 
        stm.setInt(1, id_Joueur);
        stm.setInt(2, typeLicence);
        stm.setString(3, nomJoueur);
        stm.setString(4, prenomJoueur);
        stm.setString(5, dateNaiss);
        stm.setString(6, adresse);
        stm.setString(7, tel);
        stm.setString(8, mailJoueur);
        stm.setInt(9, id_Joueur);
        stm.executeUpdate();
        stm.close();
        }
        catch(Exception e)
        {
        e.printStackTrace();
        System.err.println("ca merde garcon");
        }        
    }
    static Joueur retour_idjoueur(String nom){
        Joueur j=null;
        for(Joueur j1:Joueur.joueurs){
            if(nom.equalsIgnoreCase(j1.getNomJoueur()+" "+j1.getPrenomJoueur())){
                j=j1;
                break;
                }
            } 
        return j;
    }
    
    public Joueur(){
    }
    
    public Joueur(int typeLice, String nomJoueur, String prenomJoueur, String dateNaiss, String adresse, String telJoueur, String mailJoueur){
        n_TypeLicence=typeLice;
        sz_NomJoueur=nomJoueur;
        sz_PrenomJoueur=prenomJoueur;
        sz_DateNaissn=dateNaiss;
        sz_Adresse=adresse;
        sz_Tel=telJoueur;
        sz_MailJoueur=mailJoueur;
    }
    public Joueur(int idJoueur,int typeLice,String nomJoueur, String prenomJoueur, String dateNaiss, String adresse, String telJoueur, String mailJoueur){
        n_idJoueur=idJoueur;
        n_TypeLicence=typeLice;
        sz_NomJoueur=nomJoueur;
        sz_PrenomJoueur=prenomJoueur;
        sz_DateNaissn=dateNaiss;
        sz_Adresse=adresse;
        sz_Tel=telJoueur;
        sz_MailJoueur=mailJoueur;
    }

    public int getIdJoueur() {
        return n_idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.n_idJoueur = idJoueur;
    }

    public int getTypeLicence() {
        return n_TypeLicence;
    }

    public void setTypeLicence(int typeLicence) {
        this.n_TypeLicence = typeLicence;
    }

    public String getNomJoueur() {
        return sz_NomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.sz_NomJoueur = nomJoueur;
    }

    public String getPrenomJoueur() {
        return sz_PrenomJoueur;
    }

    public void setPrenomJoueur(String prenomJoueur) {
        this.sz_PrenomJoueur = prenomJoueur;
    }

    public String getDateNaissn() {
        return sz_DateNaissn;
    }

    public void setDateNaissn(String dateNaissn) {
        this.sz_DateNaissn = dateNaissn;
    }

    public String getAdresse() {
        return sz_Adresse;
    }

    public void setAdresse(String adresse) {
        sz_Adresse = adresse;
    }

    public String getTel() {
        return sz_Tel;
    }

    public void setTel(String tel) {
        sz_Tel = tel;
    }

    public String getMailJoueur() {
        return sz_MailJoueur;
    }

    public void setMailJoueur(String mailJoueur) {
        sz_MailJoueur = mailJoueur;
    }
}//fin de class
