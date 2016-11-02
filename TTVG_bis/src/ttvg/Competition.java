package ttvg;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author emmanuel
 */
public class Competition {
    int n_Id_Compete;
    String sz_NomCompete;
    int n_NbrMaxParticipant;
    boolean isIndiv, isEquip;
    static ArrayList <Competition> competitions;
    
    // methode permettant d'ajouter un tuple à la table T_Competition de la BD
    protected Competition new_Compete (Competition c1){
        //initialisation des variables
        Connection con;
        //Competition compet=c1;
        ResultSet res;
        String nomComp, url;
        int nbjoueur,lastId;
        boolean indiv, equip;
        PreparedStatement stm;
        // affectation aux variables
        nomComp=c1.sz_NomCompete;
        nbjoueur=c1.getNbrMaxParticipant();
        indiv=c1.getIsIndiv();
        equip=c1.getIsEquip();
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
        // préparation de la requête
        stm=con.prepareStatement("insert into t_competition(com_nom_compete, com_nb_participant,com_flg_indiv, com_flg_equip) "
                + "values (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
        // attribution des valeurs pour la requête
        stm.setString(1, nomComp);
        stm.setInt(2, nbjoueur);
        stm.setBoolean(3, indiv);
        stm.setBoolean(4, equip);
        // execution update
        stm.executeUpdate();
        // récupération de l'Id auto_incremente
        res = stm.getGeneratedKeys();
        res.next();
        lastId=res.getInt(1);
        // mise à jour de l'Obj Competition concerné
        c1.setN_Id_Compete(lastId);
        // mise à jour de l'ArrayList
        Competition.competitions.add(c1);
        stm.close();
        }
        catch(Exception e)
        {
        e.printStackTrace();
        }
        return (c1);
    }
    // Constructeurs    
    // Vide par défaut à priori pas d'utilité...
    public Competition(){
    }    
    // Sans l'id donc avant mise à jour de la BD
    public Competition(String nomComp, int nbrJoueurs, boolean indiv, boolean equip){
        sz_NomCompete=nomComp;
        n_NbrMaxParticipant=nbrJoueurs;
        isIndiv=indiv;
        isEquip=equip;
    }
    // Complet une fois l'id récupéré
    public Competition(int idCom, String nomComp, int nbrJoueurs, boolean indiv, boolean equip){
        n_Id_Compete=idCom;
        sz_NomCompete=nomComp;
        n_NbrMaxParticipant=nbrJoueurs;
        isIndiv=indiv;
        isEquip=equip;
    }
    // Getteurs & Setteurs
    // Getteurs
    public int getId_Compete(){
        return n_Id_Compete;
    }
    public String getNomComp(){
        return sz_NomCompete;
    }
    public int getNbrMaxParticipant(){
        return n_NbrMaxParticipant;
    }
    public boolean getIsIndiv(){
        return isIndiv;
    }
    public boolean getIsEquip(){
        return isEquip;
    }
    // Setteurs
    public void setNomComp(String nomComp){
        sz_NomCompete=nomComp;
    }
    public void setNbrMaxParticipant(int nbr){
        n_NbrMaxParticipant=nbr;
    }
    public void setIsIndiv(boolean indiv){
        isIndiv=indiv;
    }
    public void setIsEquip(boolean equip){
        isEquip=equip;
    }
    public void setN_Id_Compete(int idComp){
        n_Id_Compete=idComp;
    }
}// fin de class
