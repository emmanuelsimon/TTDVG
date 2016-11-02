/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttvg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
/**
 *
 * @author emmanuel
 */
public class Modif_Joueur_Ihm extends JPanel{
    private JPanel pan_FenetreCentrale, pan_nord,pan_footer, pan_centrecentre, pan_centre_sud,pan_centre,pan_centresud;
    private JLabel lbl_Nom,lbl_Nom2, lbl_Prenom, lbl_DateNaiss, lbl_Adresse, lbl_Tel,lbl_TypeLice, lbl_Mail, lbl_Titre,img_Logo,lbl_PiedDePage;
    private JTextField txt_Nom, txt_Prenom, txt_DateNaiss, txt_Tel, txt_Mail;
    private JTextArea txt_Adresse;
    private JComboBox cbo_TypeLicence, cbo_NomJoueur;
    private JButton btn_Valider, btn_Annuler;
    public Joueur jm;
    
        public Modif_Joueur_Ihm(){
        initControls();   
        this.setVisible(true);
    }    
        private void initControls(){
            this.setLayout(new BorderLayout());
            img_Logo=new JLabel(new ImageIcon("./src/images/logo.jpg")); 
            img_Logo.addMouseListener(new mod_Joueur_MouseListener());
            lbl_Titre= new JLabel("       Modification d'un joueur");
            lbl_Titre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,32));
            lbl_PiedDePage=new JLabel("V0.2a - E.S (c) 2016");
            lbl_Nom=new JLabel("Nom : ");
            lbl_Nom2=new JLabel("Nom : ");
            lbl_TypeLice=new JLabel("Licence");
            lbl_Prenom=new JLabel("Prénom : ");
            lbl_DateNaiss=new JLabel("Date de naissance :");
            lbl_Adresse=new JLabel("Adresse complète :");
            lbl_Tel=new JLabel("Téléphone");
            lbl_Mail=new JLabel("Email");
            cbo_NomJoueur=new JComboBox();
            cbo_NomJoueur.addItem("");
            for(Joueur j1:Joueur.joueurs){
                cbo_NomJoueur.addItem(j1.getNomJoueur()+" "+j1.getPrenomJoueur());
            }
            cbo_NomJoueur.addActionListener(new modif_joueur_Actlistener());
            txt_Nom=new JTextField();
            txt_Prenom=new JTextField();
            txt_DateNaiss=new JTextField();
            txt_Tel=new JTextField();
            txt_Mail=new JTextField();
            txt_Adresse=new JTextArea();
            txt_Adresse.setColumns(55);
            txt_Adresse.setRows(3);            
            cbo_TypeLicence=new JComboBox();
            cbo_TypeLicence.addItem("");
            cbo_TypeLicence.addItem("Compétition");
            cbo_TypeLicence.addItem("Loisir");
            btn_Valider=new JButton("Valider");
            btn_Valider.addActionListener(new modif_joueur_Actlistener());
            btn_Annuler=new JButton("Annuler");
            btn_Annuler.addActionListener(new modif_joueur_Actlistener());                   
            // panneau principal
            pan_FenetreCentrale=new JPanel();
            pan_FenetreCentrale.setLayout(new BorderLayout());
            pan_nord=new JPanel();
            pan_nord.add(lbl_Nom);
            pan_nord.add(cbo_NomJoueur);
            pan_centre=new JPanel();
            pan_centre.setLayout(new BorderLayout());
            pan_centrecentre=new JPanel();
            pan_centrecentre.setLayout(new GridLayout(4,4,10,10));
            pan_centrecentre.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 150));
            pan_centrecentre.add(lbl_Nom2);
            pan_centrecentre.add(txt_Nom);
            pan_centrecentre.add(lbl_Prenom);
            pan_centrecentre.add(txt_Prenom);
            pan_centrecentre.add(lbl_DateNaiss);
            pan_centrecentre.add(txt_DateNaiss);
            pan_centrecentre.add(lbl_TypeLice);
            pan_centrecentre.add(cbo_TypeLicence);
            pan_centrecentre.add(lbl_Tel);
            pan_centrecentre.add(txt_Tel);
            pan_centrecentre.add(lbl_Mail);
            pan_centrecentre.add(txt_Mail);
            pan_centrecentre.add(lbl_Adresse);
            pan_centre.add(pan_centrecentre, BorderLayout.CENTER);
            pan_centresud=new JPanel();
            pan_centresud.add(txt_Adresse);
            pan_centre.add(pan_centresud, BorderLayout.SOUTH);
            pan_centre.add(pan_nord, BorderLayout.NORTH);
            pan_centre_sud=new JPanel();
            pan_centre_sud.setLayout(new GridLayout(1,2,10,20));
            pan_centre_sud.setBorder(BorderFactory.createEmptyBorder(0, 300, 0, 150));
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
            this.add(pan_nord, BorderLayout.NORTH);
            this.add(pan_FenetreCentrale, BorderLayout.CENTER);
            this.add(pan_footer, BorderLayout.SOUTH);
        }

        private void retour_page_acceuil(){
            this.removeAll();
            this.add(new Page_Accueil());
            this.validate();
        }
        private void cmdCbo_Nom_click(){
            String nomj=cbo_NomJoueur.getSelectedItem().toString();
            int num_type_lice;
            boolean flag;
            flag=true;
            for(Joueur j1:Joueur.joueurs){
                if(nomj.equalsIgnoreCase(j1.getNomJoueur()+" "+j1.getPrenomJoueur())){
                    flag=false;
                    jm=j1;
                    txt_Nom.setText(j1.getNomJoueur());
                    txt_Prenom.setText(j1.getPrenomJoueur());
                    txt_Adresse.setText(j1.getAdresse());
                    txt_DateNaiss.setText(j1.getDateNaissn());
                    txt_Tel.setText(j1.getTel());
                    txt_Mail.setText(j1.getMailJoueur());
                    num_type_lice=j1.getTypeLicence();
                    cbo_TypeLicence.setSelectedIndex(num_type_lice);
                    break;
                }  
            }
            if(flag){
                txt_Nom.setText("");
                txt_Prenom.setText("");
                txt_Adresse.setText("");
                txt_DateNaiss.setText("");
                txt_Tel.setText("");
                txt_Mail.setText("");
                cbo_TypeLicence.setSelectedIndex(0);                
            }
        }
        private void cmdBtn_Valider_click(){
            // Test des valeurs pour maj
            String nomj, pnomj, telj, datenaisj, msg, erreur;
            msg="La fiche du joueur a été mise à jour";
            erreur="";
            boolean isValide, isDateOk;
            isValide=true;
            isDateOk=false;
            nomj=txt_Nom.getText();
            pnomj=txt_Prenom.getText();
            telj=txt_Tel.getText();
            datenaisj=txt_DateNaiss.getText();
            if(nomj==null||nomj.trim().isEmpty()){
                isValide=false;
                erreur="Le nom doit être renseigné.";
            }
            if(isValide &&(pnomj==null||pnomj.trim().isEmpty())){
                isValide=false;
                erreur="Le prénom doit être renseigné.";
            }
            if(isValide && cbo_TypeLicence.getSelectedIndex()<1){
                isValide=false;
                erreur="Vous devez choisir un type de licence";
            }
            Pattern regx=Pattern.compile("[1-2]{1}[0-9]{3}-[0-1]{1}[0-9]-{1}[0-3]{1}[0-9]{1}");
            Matcher m=regx.matcher(datenaisj);
            boolean isDtNaisOk=m.matches();
            if(isDtNaisOk){
                isDateOk=true;
            }
            else{
                erreur="Date sous la forme \"aaaa-mm-jj\" exemple 1972-22-01";
                isDateOk=false;
            }
            if(isValide && isDateOk){
                jm.setNomJoueur(txt_Nom.getText());
                jm.setTypeLicence(cbo_TypeLicence.getSelectedIndex());
                jm.setPrenomJoueur(txt_Prenom.getText());
                jm.setDateNaissn(txt_DateNaiss.getText());
                jm.setAdresse(txt_Adresse.getText());
                jm.setTel(txt_Tel.getText());
                jm.setMailJoueur(txt_Mail.getText());
                jm.modif_joueur(jm);
                Accueil_Ihm.pan_tt.removeAll();
                Accueil_Ihm.pan_tt.add(new Modif_Joueur_Ihm());
                Accueil_Ihm.pan_tt.validate();
                JOptionPane.showMessageDialog(this,msg ," Confirmation ",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, erreur," Attention ",JOptionPane.WARNING_MESSAGE);
            }
        }
        class modif_joueur_Actlistener implements ActionListener {
        @Override 
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==cbo_NomJoueur) cmdCbo_Nom_click();
            if(e.getSource()==btn_Valider) cmdBtn_Valider_click(); 
            if(e.getSource()==btn_Annuler) retour_page_acceuil();
            }
        }
        class mod_Joueur_MouseListener implements MouseListener{
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
}
