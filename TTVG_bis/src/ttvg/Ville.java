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
public class Ville {
    int n_idVille;
    String sz_cpVille, sz_nomVille;
    static ArrayList <Ville> villes; // pour pouvoir y acceder de n'importe ou 
    // methodes diverses
    // Enregistrement de la nouvelle ville dans la DB
    protected void new_Ville_Db (Ville v1){
        Connection con;
        Ville ville=v1;
        ResultSet res;
        int lastId;
        String cp, nomville,url;
        PreparedStatement stm;
        cp=v1.getSz_cpVille();
        nomville=v1.getNomVille();
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
        stm=con.prepareStatement("insert into t_ville(vil_cp_ville, vil_nom_ville) values (?,?)",Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, cp);
        stm.setString(2, nomville);
        stm.executeUpdate();
        res = stm.getGeneratedKeys();
        res.next();
        lastId = res.getInt(1);
        v1.setIdVille(lastId);
        villes.add(v1);
        stm.close();
        }
        catch(Exception e)
        {
        e.printStackTrace();
        System.err.println("ca merde garcon");
        }
    }
    // Constructeur minimaliste
    public Ville() {
    }
    // Constructeur de base sans id (auto_increment bd)     
    public Ville(String cpVille, String nomVille){
        sz_cpVille=cpVille;
        sz_nomVille=nomVille;
    }
    public Ville(int idVille, String cpVille, String nomVille){
        n_idVille=idVille;
        sz_cpVille=cpVille;
        sz_nomVille=nomVille;
    }
    // getteur & setteur
    public int getIdVille() {
        return n_idVille;
    }
    public void setIdVille(int idVille) {
        n_idVille=idVille;
    }
    public String getSz_cpVille() {
        return sz_cpVille;
    }
    public void setCpVille(String cpVille) {
        sz_cpVille = cpVille;
    }
    public String getNomVille() {
        return sz_nomVille;
    }
    public void setNomVille(String nomVille) {
        sz_nomVille = nomVille;
    }
}// fin de classe
