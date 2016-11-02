package ttvg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

/**
 *
 * @author emmanuel
 */
public class Aj_Joueur_Ihm extends JPanel{
    private JPanel pan_FenetreCentrale, pan_nord,pan_footer, pan_centre, pan_centrecentre, pan_centre_sud, pan_centresud;
    private JLabel lbl_Nom, lbl_Prenom, lbl_DateNaiss, lbl_Adresse, lbl_Tel, lbl_Mail, lbl_Titre,img_Logo,lbl_PiedDePage, lbl_TypeLice;
    private JTextField txt_Nom, txt_Prenom, txt_DateNaiss, txt_Tel, txt_Mail;
    private JTextArea txt_Adresse;
    private JComboBox cbo_TypeLicence;
    private JButton btn_Valider, btn_Annuler;
    
    
        public Aj_Joueur_Ihm(){
        initControls();   
        this.setVisible(true);
    }

        
        private void initControls(){
            this.setLayout(new BorderLayout());
            img_Logo=new JLabel(new ImageIcon("./src/images/logo.jpg"));
            img_Logo.addMouseListener(new aj_Joueur_MouseListener());
            lbl_Titre= new JLabel("       Création d'un joueur");
            lbl_Titre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,32));
            lbl_PiedDePage=new JLabel("V0.2a - E.S (c) 2016");
            lbl_TypeLice=new JLabel("Licence");
            lbl_Nom=new JLabel("Nom : ");
            lbl_Prenom=new JLabel("Prénom : ");
            lbl_DateNaiss=new JLabel("Date de naissance :");
            lbl_Adresse=new JLabel("Adresse complète :");
            lbl_Tel=new JLabel("Téléphone");
            lbl_Mail=new JLabel("Email");
            txt_Nom=new JTextField();
            txt_Prenom=new JTextField();
            txt_DateNaiss=new JTextField();
            txt_Tel=new JTextField();
            txt_Mail=new JTextField();
            txt_Adresse=new JTextArea();
            txt_Adresse.setColumns(55);
            txt_Adresse.setRows(3);
            // ComboBox en dur peu de risque d'évolution
            cbo_TypeLicence=new JComboBox();
            cbo_TypeLicence.addItem(""); // pour avoir la premiere ligne vide
            cbo_TypeLicence.addItem("Compétition");
            cbo_TypeLicence.addItem("Loisir");
            btn_Valider=new JButton("Valider");
            btn_Valider.addActionListener(new aj_Joueur_ActionListener());
            btn_Annuler=new JButton("Annuler");
            btn_Annuler.addActionListener(new aj_Joueur_ActionListener());              
            // panneau principal
            pan_FenetreCentrale=new JPanel();
            pan_FenetreCentrale.setLayout(new BorderLayout());
            pan_centre=new JPanel();
            pan_centre.setLayout(new BorderLayout());
            pan_centrecentre=new JPanel();
            pan_centrecentre.setLayout(new GridLayout(4,4,10,10));
            pan_centrecentre.setBorder(BorderFactory.createEmptyBorder(20, 100, 5, 150));
            pan_centrecentre.add(lbl_Nom);
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
            this.add(pan_nord, BorderLayout.NORTH);
            this.add(pan_FenetreCentrale, BorderLayout.CENTER);
            this.add(pan_footer, BorderLayout.SOUTH);
        }
        // méthode pour retour à l'accueil Btn Annuler & Dble clic sur le Logo
        private void retour_page_acceuil(){
            this.removeAll();
            this.add(new Page_Accueil());
            this.validate();
        }
        // méthode click btn valider
        public void cmdBtn_Valider_click(){
            // etape 1 rapporter tout les elements pour creation obj Joueur
            boolean flagValide, dtnaisValide;// pour tester les différents champs afin d'éviter maj BD si false
            dtnaisValide=false;
            flagValide=true;
            int typeLicence;
            String nom, prenom, dateNaiss, adres, tel, email, erreur, msg;
            erreur="";// pour informer l'utilisateur sur la nature de l'erreur de saisie
            typeLicence=cbo_TypeLicence.getSelectedIndex();
            nom=txt_Nom.getText();
            prenom=txt_Prenom.getText();
            dateNaiss=txt_DateNaiss.getText();
            adres=txt_Adresse.getText();
            tel=txt_Tel.getText();
            email=txt_Mail.getText();
            // test si un champ obligatoire est vide 
            if(nom.trim().isEmpty()|| nom==null ){
                erreur="le champ Nom est obligatoire est vide";
                flagValide=false;
            }
            if(flagValide &&(prenom.trim().isEmpty()||prenom==null)){
                erreur="le champ Prenom est obligatoire est vide";
                dtnaisValide=false;                
            }
            if(flagValide && typeLicence<1){
                erreur="Il faut choisir un type de licence";
                dtnaisValide=false;
            }
            Pattern regx=Pattern.compile("[1-2]{1}[0-9]{3}-[0-1]{1}[0-9]-{1}[0-3]{1}[0-9]{1}");
            Matcher m=regx.matcher(dateNaiss);
            boolean isDtNaisOk=m.matches();
            if(isDtNaisOk){
                dtnaisValide=true;
            }
            else{
                erreur="Date sous la forme \"aaaa-mm-jj\" exemple 1972-22-01";
                dtnaisValide=false;
            }
            if(flagValide && dtnaisValide){
                msg="Le joueur "+nom+" "+prenom+" a été ajouter";
                Joueur j1=new Joueur(typeLicence, nom, prenom, dateNaiss, adres, tel, email);
                j1.new_Joueur_Db(j1);
                System.out.println("Joueur ajouter DB");
                txt_Nom.setText("");
                txt_Prenom.setText("");
                txt_DateNaiss.setText("");
                txt_Adresse.setText("");
                txt_Tel.setText("");
                txt_Mail.setText("");
                JOptionPane.showMessageDialog(this,msg ," Confirmation ",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, erreur," Attention ",JOptionPane.WARNING_MESSAGE);
            }
        }
        
        // Début des listeners
        
        // Action pour les boutons Valider & Annuler
        class aj_Joueur_ActionListener implements ActionListener {
        @Override 
            public void actionPerformed(ActionEvent e){
                if(e.getSource()==btn_Valider) cmdBtn_Valider_click(); 
                if(e.getSource()==btn_Annuler) retour_page_acceuil();
            }
        }
        
        // Mouse pour le dble clic Logo
        class aj_Joueur_MouseListener implements MouseListener{
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
        public void mouseExited(MouseEvent e) { }
        }
}
