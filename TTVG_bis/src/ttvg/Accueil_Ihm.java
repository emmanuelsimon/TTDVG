/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttvg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
        
/**
 *
 * @author emmanuel
 */
public class Accueil_Ihm  extends JFrame{
    public static JPanel pan_tt;
    private JMenuBar mb_menu;
    private JMenu m_Joueur, m_Competition,m_Administration;
    private JMenuItem m_j_it1, m_j_it2, m_c_it1, m_a_it1;
    
    public Accueil_Ihm(){
        this.setSize(820, 500);
        this.setTitle("Club de Tennis de Table de la Vallée du Gapeau");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initControls();   
        this.setVisible(true);
    }

    private void initControls(){
        pan_tt=(JPanel)this.getContentPane();
        // début de l'interface graphique
        // maFenetre est la fenetre "complete"
        setLayout(new BorderLayout());       
        // Création du menu         
        mb_menu = new JMenuBar(); // bar de menu pour commune à toutes les pages
        m_Joueur = new JMenu("Joueur"); // menu 1
        m_j_it1= new JMenuItem("Créer"); // sous menu 1-1
        m_j_it1.addActionListener(new menu_ActionList());
        m_j_it2= new JMenuItem("Modifier"); // sous menu 1-2
        m_j_it2.addActionListener(new menu_ActionList());
        m_Joueur.add(m_j_it1); 
        m_Joueur.add(m_j_it2);
        m_Competition = new JMenu("Compétition"); // menu 2
        m_c_it1= new JMenuItem("Créer"); // sous menu 2-1
        m_c_it1.addActionListener(new menu_ActionList());
        m_Competition.add(m_c_it1);
        m_Administration=new JMenu("Administration");// menu 3
        m_a_it1=new JMenuItem("Bureau");
        m_a_it1.addActionListener(new menu_ActionList());
        m_Administration.add(m_a_it1);
        mb_menu.add(m_Joueur);
        mb_menu.add(m_Competition);
        mb_menu.add(m_Administration);
        this.setJMenuBar(mb_menu);
        // fin du menu   
       // pan_tt.add(new Page_Accueil());
    }
    // les diverses méthodes correspondant à l'affichage du panneau concerné
    private void m_CreerJoueur_click(){
        pan_tt.removeAll();
        pan_tt.add(new Aj_Joueur_Ihm());
        pan_tt.validate();
    }
    private void m_ModfiJoueur_click(){
        pan_tt.removeAll();
        pan_tt.add(new Modif_Joueur_Ihm());
        pan_tt.validate();
    }
    private void m_AjouterCompete_click(){
        pan_tt.removeAll();
        pan_tt.add(new AjouterCompete_Ihm());
        pan_tt.validate();
    }  
    private void m_Definir_Bureau_click(){
        pan_tt.removeAll();
        pan_tt.add(new Def_Bureau_Ihm());
        pan_tt.validate();
    }
    // Début des Listeners
    class menu_ActionList implements ActionListener {
    @Override 
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==m_j_it1) m_CreerJoueur_click(); 
            if(e.getSource()==m_j_it2) m_ModfiJoueur_click();
            if(e.getSource()==m_c_it1) m_AjouterCompete_click();
            if(e.getSource()==m_a_it1) m_Definir_Bureau_click();
        }
    }
}// fin de class
   