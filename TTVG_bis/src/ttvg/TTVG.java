/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttvg;


import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author emmanuel
 */
public class TTVG {
    
    /**
     * @param args the command line arguments
     */
    static String[] listMembre;
    public static void main(String[] args) {
        init_Prg();
        Accueil_Ihm acc=new Accueil_Ihm();
    }// main 
    protected static void init_Prg(){
        System.out.println("debut init prg");
        Ville.villes=new ArrayList<Ville>();
        Competition.competitions= new ArrayList<>();
        Joueur.joueurs=new ArrayList<>();
        Connection con;
        PreparedStatement stm;
        ResultSet res;
        Calendar c=Calendar.getInstance();
        int annee_en_cours;
        annee_en_cours=c.get(Calendar.YEAR);
        String url, listmembrebureau;
        listmembrebureau="";
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
            System.out.println("init Ville");
            int idVille;
            String nomVille, cpVille;
            Ville v1;
            con=DriverManager.getConnection(url,"root","");
            stm=con.prepareStatement("select * from t_ville order by vil_nom_ville");
            res=stm.executeQuery();
            while(res.next()){
                idVille=res.getInt(1);
                cpVille=res.getString(2);
                nomVille=res.getString(3);
                v1=new Ville(idVille, cpVille, nomVille);
                Ville.villes.add(v1);
            }
            stm.close();
            int idComp, nbParticip;
            boolean isE,isI;
            String nomComp;
            Competition c1;
            System.out.println("init Competition");
            stm=con.prepareStatement("select * from t_competition");
            res=stm.executeQuery();
            while(res.next()){
                idComp=res.getInt(1);
                nomComp=res.getString(2);
                nbParticip=res.getInt(3);
                isI=res.getBoolean(4);
                isE=res.getBoolean(5);
                c1=new Competition(idComp, nomComp, nbParticip, isI, isE);
                Competition.competitions.add(c1);
            }
            stm.close();
            int idJoueur, idTypeLicence;
            String nom, prenom, datenaiss, adress, tel, mail;
            Joueur j1;
            System.out.println("Init Joueur");
            stm=con.prepareStatement("select * from t_joueur order by jou_nom_joueur");
            res=stm.executeQuery();
            while(res.next()){
                idJoueur=res.getInt(1);
                idTypeLicence=res.getInt(2);
                nom=res.getString(3);
                prenom=res.getString(4);
                datenaiss=res.getString(5);
                adress=res.getString(6);
                tel=res.getString(7);
                mail=res.getString(8);
                j1=new Joueur(idJoueur, idTypeLicence, nom, prenom, datenaiss, adress, tel, mail);
                Joueur.joueurs.add(j1);
            }
            stm.close();
            listmembrebureau="";
            System.out.println("recup bureau");
            stm=con.prepareStatement("select jou_nom_joueur,jou_pnom_joueur from t_joueur inner join r_administrer where jou_pk_id_joueur=adm_fk_id_joueur and adm_annee=?");
            stm.setInt(1,annee_en_cours);
            res=stm.executeQuery();
            while(res.next()){
                listmembrebureau+=res.getString(1)+"/";
                listmembrebureau+=res.getString(2)+"/";
            }
            stm.close();
            con.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        if(listmembrebureau.length()<=6){
            listmembrebureau="Non/Défini/Non/Défini/Non/Défini/Non/Défini/Non/Défini/Non/Défini/";
        }
        listMembre=listmembrebureau.split("/");
    }
}// class
