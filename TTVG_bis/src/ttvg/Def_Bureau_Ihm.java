/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttvg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author emmanuel
 */
public class Def_Bureau_Ihm extends JPanel{
    private JPanel pan_FenetreCentrale, pan_nord,pan_footer, pan_centre, pan_centrecentre, pan_centre_sud, pan_centresud;
    private JLabel lbl_Pres, lbl_PresAdj, lbl_Tsor, lbl_TsorAdj, lbl_Secr, lbl_SecrAdj, lbl_Titre,img_Logo,lbl_PiedDePage,lbl_Annee;
    private JComboBox cbo_Annee, cbo_NomJoueur1, cbo_NomJoueur2, cbo_NomJoueur3, cbo_NomJoueur4,cbo_NomJoueur5,cbo_NomJoueur6 ;
    private JButton btn_Valider, btn_Annuler;   
    
    public Def_Bureau_Ihm(){
        initControls();   
        this.setVisible(true);
    }

        
        private void initControls(){
            this.setLayout(new BorderLayout());
            pan_nord=new JPanel();
            img_Logo=new JLabel(new ImageIcon("./src/images/logo.jpg")); 
            img_Logo.addMouseListener(new aj_Def_Bureau_MouseListener());
            lbl_Titre= new JLabel("    Attribution des postes du Bureau");
            lbl_Titre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,32));
            lbl_PiedDePage=new JLabel("V0.2a - E.S (c) 2016");
            cbo_NomJoueur1=new JComboBox();
            cbo_NomJoueur2=new JComboBox();
            cbo_NomJoueur3=new JComboBox();
            cbo_NomJoueur4=new JComboBox();
            cbo_NomJoueur5=new JComboBox();
            cbo_NomJoueur6=new JComboBox();
            cbo_Annee=new JComboBox();
            cbo_Annee.addItem("");
            for(int i=2016; i<2030; i++){
                cbo_Annee.addItem(i);
            }
            cbo_Annee.addActionListener(new aj_Def_Bureau_ActionListener());
            lbl_Annee=new JLabel("Année");
            pan_nord.add(lbl_Annee);
            pan_nord.add(cbo_Annee);                
            
            cbo_NomJoueur1.addItem("");
            cbo_NomJoueur2.addItem("");
            cbo_NomJoueur3.addItem("");
            cbo_NomJoueur4.addItem("");
            cbo_NomJoueur5.addItem("");
            cbo_NomJoueur6.addItem("");
            for(Joueur j1:Joueur.joueurs){
                cbo_NomJoueur1.addItem(j1.getNomJoueur()+" "+j1.getPrenomJoueur());
                cbo_NomJoueur2.addItem(j1.getNomJoueur()+" "+j1.getPrenomJoueur());
                cbo_NomJoueur3.addItem(j1.getNomJoueur()+" "+j1.getPrenomJoueur());
                cbo_NomJoueur4.addItem(j1.getNomJoueur()+" "+j1.getPrenomJoueur());
                cbo_NomJoueur5.addItem(j1.getNomJoueur()+" "+j1.getPrenomJoueur());
                cbo_NomJoueur6.addItem(j1.getNomJoueur()+" "+j1.getPrenomJoueur());
            }
            lbl_Pres=new JLabel("Président : ");
            lbl_PresAdj=new JLabel("Adj : ");
            lbl_Tsor=new JLabel("Trésorier:");
            lbl_TsorAdj=new JLabel("Adj :");
            lbl_Secr=new JLabel("Secretaire");
            lbl_SecrAdj=new JLabel("Adj");


            btn_Valider=new JButton("Valider");
            btn_Valider.addActionListener(new aj_Def_Bureau_ActionListener());
            btn_Annuler=new JButton("Annuler");
            btn_Annuler.addActionListener(new aj_Def_Bureau_ActionListener());              
            // panneau principal
            pan_FenetreCentrale=new JPanel();
            pan_FenetreCentrale.setLayout(new BorderLayout());
            pan_centre=new JPanel();
            pan_centre.setLayout(new BorderLayout());
            pan_centrecentre=new JPanel();
            pan_centrecentre.setLayout(new GridLayout(3,4,10,10));
            pan_centrecentre.setBorder(BorderFactory.createEmptyBorder(20, 100, 5, 150));
            pan_centrecentre.add(lbl_Pres);
            pan_centrecentre.add(cbo_NomJoueur1);
            pan_centrecentre.add(lbl_PresAdj);
            pan_centrecentre.add(cbo_NomJoueur2);
            pan_centrecentre.add(lbl_Tsor);
            pan_centrecentre.add(cbo_NomJoueur3);
            pan_centrecentre.add(lbl_TsorAdj);
            pan_centrecentre.add(cbo_NomJoueur4);
            pan_centrecentre.add(lbl_Secr);
            pan_centrecentre.add(cbo_NomJoueur5);
            pan_centrecentre.add(lbl_SecrAdj);
            pan_centrecentre.add(cbo_NomJoueur6);
            pan_centre.add(pan_centrecentre, BorderLayout.CENTER);
            pan_centre.add(pan_nord, BorderLayout.NORTH);
            pan_centresud=new JPanel();
            pan_centre.add(pan_centresud, BorderLayout.SOUTH);
            pan_centre_sud=new JPanel();
            pan_centre_sud.setLayout(new GridLayout(1,2,10,20));
            pan_centre_sud.setBorder(BorderFactory.createEmptyBorder(20, 300, 20, 150));
            pan_centre_sud.add(btn_Annuler);
            pan_centre_sud.add(btn_Valider);
            pan_FenetreCentrale.add(pan_centre, BorderLayout.CENTER);
            pan_FenetreCentrale.add(pan_centre_sud, BorderLayout.SOUTH);
                // nord central
            pan_nord=new JPanel();
            pan_nord.setLayout(new BorderLayout());
            pan_nord.add(img_Logo, BorderLayout.WEST);
            pan_nord.add(lbl_Titre, BorderLayout.CENTER);
            // pied de page
            pan_footer = new JPanel();
            pan_footer.add(lbl_PiedDePage);
            // Construction de la fenetre
            //maFenetre.add(test_remplissage, BorderLayout.WEST);
            this.add(pan_nord, BorderLayout.NORTH);
            this.add(pan_FenetreCentrale, BorderLayout.CENTER);
            this.add(pan_footer, BorderLayout.SOUTH);
        }

        private void retour_page_acceuil(){
            this.removeAll();
            this.add(new Page_Accueil());
            this.validate();
        }
        private void cmdCbo_Annee_click(){
            String sz_annee=cbo_Annee.getSelectedItem().toString();
            boolean test;
            int n_annee=0;
            if(!sz_annee.isEmpty()){
                n_annee=Integer.parseInt(sz_annee);
            }
            test=new_Test_Existe(n_annee);
            System.out.println("tst "+test);
        }
        private void cmdBtn_Valider_click(){
            //test unicite des postes 
            boolean unicite=true;
            String p1,p2,p3,p4,p5,p6;
            p1=cbo_NomJoueur1.getSelectedItem().toString();
            p2=cbo_NomJoueur2.getSelectedItem().toString();        
            p3=cbo_NomJoueur3.getSelectedItem().toString();        
            p4=cbo_NomJoueur4.getSelectedItem().toString();        
            p5=cbo_NomJoueur5.getSelectedItem().toString();        
            p6=cbo_NomJoueur6.getSelectedItem().toString();
            if(p1.isEmpty()||p2.isEmpty()||p3.isEmpty()||p4.isEmpty()||p5.isEmpty()||p6.isEmpty()){
                unicite=false;
                JOptionPane.showMessageDialog(this, "Au moins un des champs n'eset pas rempli."," Confirmation ",JOptionPane.INFORMATION_MESSAGE);
            }
            else if(p1.equalsIgnoreCase(p2) || p1.equalsIgnoreCase(p3)|| p1.equalsIgnoreCase(p4)|| p1.equalsIgnoreCase(p5)|| p1.equalsIgnoreCase(p6)){
                unicite=false;
                JOptionPane.showMessageDialog(this, "Il y a un doublon du poste de Président."," Confirmation ",JOptionPane.INFORMATION_MESSAGE);
            } 
            else if(p2.equalsIgnoreCase(p3)||p2.equalsIgnoreCase(p4)||p2.equalsIgnoreCase(p5)||p2.equalsIgnoreCase(p6)){
                unicite=false;
                JOptionPane.showMessageDialog(this, "Il y a un doublon du poste de Président Adjoint."," Confirmation ",JOptionPane.INFORMATION_MESSAGE);
            }
            else if(p3.equalsIgnoreCase(p4)||p3.equalsIgnoreCase(p5)||p3.equalsIgnoreCase(p6)){
                unicite=false;
                JOptionPane.showMessageDialog(this, "Il y a un doublon du poste de Trésorier."," Confirmation ",JOptionPane.INFORMATION_MESSAGE);                
            }
            else if(p4.equalsIgnoreCase(p5)||p4.equalsIgnoreCase(p6)){
                unicite=false;
                JOptionPane.showMessageDialog(this, "Il y a un doublon du poste de Trésorier Adjoint."," Confirmation ",JOptionPane.INFORMATION_MESSAGE);                
            }
            else if(p5.equalsIgnoreCase(p6)){
                unicite=false;
                JOptionPane.showMessageDialog(this, "Il y a un doublon du poste de Secrétaire."," Confirmation ",JOptionPane.INFORMATION_MESSAGE);                   
            }   
            if(unicite){
                Joueur j=null;
                int id_j, annee;
                String nom;
                // Président
                nom=cbo_NomJoueur1.getSelectedItem().toString();
                j=Joueur.retour_idjoueur(nom);
                annee=Integer.parseInt(cbo_Annee.getSelectedItem().toString());
                Administration adm1=new Administration(j, annee, 1);
                id_j=j.getIdJoueur();
                adm1.new_Administration(id_j, annee, 1);
                // Président Adj
                nom=cbo_NomJoueur2.getSelectedItem().toString(); 
                j=Joueur.retour_idjoueur(nom);
                annee=Integer.parseInt(cbo_Annee.getSelectedItem().toString());
                Administration adm2=new Administration(j, annee, 2);
                id_j=j.getIdJoueur();
                adm1.new_Administration(id_j, annee, 2);
                // Trésorier
                nom=cbo_NomJoueur3.getSelectedItem().toString();
                j=Joueur.retour_idjoueur(nom);  
                annee=Integer.parseInt(cbo_Annee.getSelectedItem().toString());
                Administration adm3=new Administration(j, annee, 3);
                id_j=j.getIdJoueur();
                adm1.new_Administration(id_j, annee, 3);
                // Trésorier Adj
                nom=cbo_NomJoueur4.getSelectedItem().toString();  
                j=Joueur.retour_idjoueur(nom);
                annee=Integer.parseInt(cbo_Annee.getSelectedItem().toString());
                Administration adm4=new Administration(j, annee, 4);
                id_j=j.getIdJoueur();
                adm1.new_Administration(id_j, annee, 4);   
                // Secretaire 
                nom=cbo_NomJoueur5.getSelectedItem().toString();  
                j=Joueur.retour_idjoueur(nom);
                annee=Integer.parseInt(cbo_Annee.getSelectedItem().toString());
                Administration adm5=new Administration(j, annee, 5);
                id_j=j.getIdJoueur();
                adm1.new_Administration(id_j, annee, 5);
                // Secretaire Adj
                nom=cbo_NomJoueur6.getSelectedItem().toString();
                j=Joueur.retour_idjoueur(nom);
                annee=Integer.parseInt(cbo_Annee.getSelectedItem().toString());
                Administration adm6=new Administration(j, annee, 6);
                id_j=j.getIdJoueur();
                adm1.new_Administration(id_j, annee, 6);
                JOptionPane.showMessageDialog(this, "Le bureau a été saisie"," Confirmation ",JOptionPane.INFORMATION_MESSAGE);
                Accueil_Ihm.pan_tt.removeAll();
                Accueil_Ihm.pan_tt.add(new Page_Accueil());
                Accueil_Ihm.pan_tt.validate();
            }

        }
        protected void efface_bureau(int test_annee){
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
                stm=con.prepareStatement("delete from r_administrer where adm_annee=?");
                stm.setInt(1, test_annee);
                stm.executeUpdate();
                stm.close();
            }
            catch(Exception e)
            {
                e.printStackTrace();
                System.err.println("ca merde garcon");
            }     
        }
        protected boolean new_Test_Existe (int test_annee){
        boolean test=false;
        int tstn, rep;
        tstn=0;
        Connection con;
        String url;
        PreparedStatement stm;
        ResultSet res;
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
            stm=con.prepareStatement("select * from r_administrer where adm_annee=?");
            stm.setInt(1, test_annee);
            res=stm.executeQuery();
            while(res.next()){
            tstn=res.getInt(1);
        }
        if(tstn>0){
        test=true;
        rep=JOptionPane.showConfirmDialog(this, "Le Bureau pour l'année choisie existe déjà voulez vous le modifier"," Attention ",JOptionPane.YES_NO_OPTION);
        if(rep==0){
        efface_bureau(test_annee);
        }
        else{
        this.removeAll();
        this.add(new Page_Accueil());
        this.validate();
        }
        }
        stm.close();
        }
        catch(Exception e)
        {
        e.printStackTrace();
        System.out.println("ca merde garcon");
        }
        return test;
        }
        // Gestion des listeners
        class aj_Def_Bureau_ActionListener implements ActionListener {
        @Override 
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==cbo_Annee) cmdCbo_Annee_click();
            if(e.getSource()==btn_Valider) cmdBtn_Valider_click(); 
            if(e.getSource()==btn_Annuler) retour_page_acceuil();
            }
        }
        class aj_Def_Bureau_MouseListener implements MouseListener{
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount()==2) retour_page_acceuil();
        }
        @Override
        public void mousePressed(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
        }
        
}//fin de class
