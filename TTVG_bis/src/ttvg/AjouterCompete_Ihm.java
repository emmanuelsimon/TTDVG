package ttvg;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author emmanuel
 */
public class AjouterCompete_Ihm extends JPanel{
    private JPanel pan_footer,pan_fenetreCentrale, pan_nord, pan_cent_east,pan_cent_center, pan_c_e_south, pan_c_e_west,pan_cent_center_north;
    private JLabel lbl_PiedDePage, img_Logo, lbl_Titre, lbl_Libelle, lbl_Datecomp, lbl_Respon,lbl_Resp, lbl_Indiv, lbl_Equip, lbl_NbMax, lbl_TelResp;
    private JComboBox cbo_Ville;
    private JTextField txt_NomComp, txt_Nb_Max, txt_NomResp, txt_TelResp, txt_DateComp;
    private JCheckBox cb_Indiv, cb_Equip;
    private JButton btn_Valider, btn_Annuler, btn_AjVille;

    public AjouterCompete_Ihm(){
        initControls();   
        this.setVisible(true);
    }

    private void initControls(){
        this.setLayout(new BorderLayout());
        // Initialisation des divers objets de l'IHM    
        img_Logo=new JLabel(new ImageIcon("./src/images/logo.jpg"));
        img_Logo.addMouseListener(new aj_Compete_MouseListener());
        lbl_Titre= new JLabel("       Création d'une compétition");
        lbl_Titre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,32));
        lbl_PiedDePage=new JLabel("V0.2a - E.S (c) 2016");
        lbl_Libelle=new JLabel("Nom de la compétition");
        lbl_Datecomp=new JLabel("Date ");
        lbl_Indiv=new JLabel("Indiv");
        lbl_Equip=new JLabel("Equipe");
        lbl_Respon=new JLabel("Responsable");
        lbl_Respon.setBorder(BorderFactory.createEmptyBorder(10,10,0,0));
        lbl_Respon.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,20));
        btn_AjVille=new JButton("Ajouter ville");
        btn_AjVille.addActionListener(new accueil_ActionListener());
        lbl_Resp=new JLabel("Contact :");
        lbl_NbMax=new JLabel("Nombre maxi de participants");
        lbl_TelResp=new JLabel("Tel :");
        cbo_Ville=new JComboBox();
        recup_Ville(); // récupère les villes pour la combobox 
        txt_NomComp=new JTextField();
        txt_Nb_Max=new JTextField();
        txt_NomResp=new JTextField();
        txt_NomResp.setColumns(10);
        txt_TelResp=new JTextField();
        txt_DateComp=new JTextField();
        txt_Nb_Max=new JTextField();
        cb_Indiv=new JCheckBox();
        cb_Equip=new JCheckBox();
        btn_Valider=new JButton("Valider");
        btn_Valider.addActionListener(new accueil_ActionListener());
        btn_Annuler=new JButton("Annuler");
        btn_Annuler.addActionListener(new accueil_ActionListener());
        // panneau principal
        pan_fenetreCentrale=new JPanel();
        pan_fenetreCentrale.setLayout(new BorderLayout());
        // panneau principal EAST
        pan_cent_east=new JPanel();
        pan_cent_east.setLayout(new BorderLayout());
        pan_cent_east.setBorder(BorderFactory.createEmptyBorder(10,10,55,5)); 
        pan_cent_east.add(lbl_Respon, BorderLayout.NORTH);     
        // Pan Cent EAST South
        pan_c_e_south=new JPanel();
        pan_c_e_south.setBorder(BorderFactory.createEmptyBorder(20,0,0,0));
        // Pan Cent EAST West
        pan_c_e_west=new JPanel();
        pan_c_e_west.setLayout(new GridLayout(4,0));
        pan_c_e_west.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        pan_c_e_west.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        pan_c_e_west.add(lbl_Resp);
        pan_c_e_west.add(txt_NomResp);
        pan_c_e_west.add(lbl_TelResp);
        pan_c_e_west.add(txt_TelResp);
        // Construction pan Pan Cent EAST
        pan_cent_east.add(pan_c_e_south, BorderLayout.SOUTH);
        pan_cent_east.add(pan_c_e_west, BorderLayout.CENTER);
        // Pan cent center
        pan_cent_center=new JPanel();
        pan_cent_center.setLayout(new BorderLayout());
        pan_cent_center_north=new JPanel();
        pan_cent_center_north.setLayout(new GridLayout(8,2,20,5));   
        pan_cent_center_north.setBorder(BorderFactory.createEmptyBorder(30,100,25,20));
        pan_cent_center_north.add(lbl_Libelle);
        pan_cent_center_north.add(lbl_Datecomp);
        pan_cent_center_north.add(txt_NomComp);
        pan_cent_center_north.add(txt_DateComp);
        pan_cent_center_north.add(btn_AjVille);
        pan_cent_center_north.add(cbo_Ville);
        pan_cent_center_north.add(lbl_NbMax);
        pan_cent_center_north.add(txt_Nb_Max);
        pan_cent_center_north.add(lbl_Indiv);
        pan_cent_center_north.add(lbl_Equip);
        pan_cent_center_north.add(cb_Indiv);
        pan_cent_center_north.add(cb_Equip);
        pan_cent_center_north.add(btn_Annuler);
        pan_cent_center_north.add(btn_Valider);
        pan_cent_center.add(pan_cent_center_north, BorderLayout.CENTER);
         // nord central
        pan_nord=new JPanel();
        pan_nord.setLayout(new BorderLayout());
        pan_nord.add(img_Logo, BorderLayout.WEST);
        pan_nord.add(lbl_Titre, BorderLayout.CENTER);
        pan_fenetreCentrale.add(pan_cent_east, BorderLayout.EAST);
        pan_fenetreCentrale.add(pan_cent_center, BorderLayout.CENTER);
        // pied de page
        pan_footer = new JPanel();
        pan_footer.add(lbl_PiedDePage);
        // Construction de la fenetre
        this.add(pan_nord, BorderLayout.NORTH);
        this.add(pan_fenetreCentrale, BorderLayout.CENTER);
        this.add(pan_footer, BorderLayout.SOUTH);
        // fin de l'interface graphique
    }

        private void retour_page_acceuil(){
            this.removeAll();
            this.add(new Page_Accueil());
            this.validate();
        }
        private void cmdBtn_AjVille_click(){
            AjouterVille_Ihm ajv=new AjouterVille_Ihm();
            this.removeAll();
            this.add(new AjouterCompete_Ihm());
            this.validate();
        }
        private void recup_Ville(){
           if(Ville.villes.size()>=0){
                cbo_Ville.removeAllItems();
                cbo_Ville.addItem("");
                for(Ville v1:Ville.villes){
                   cbo_Ville.addItem(v1.getNomVille()); 
                } 
            }
            else System.out.println("liste de ville vide");
        }
        /* méthode click bouton Valider */
        private void cmdBtn_Valider_click(){
            // initialisation des variables
            int idVilleComp, nb_J_max, idVille;
            String nomResp, telResp, dateCom, nomVille,nomComp, msg, erreur;
            msg="Nouvelle compétition enregistrée.";
            erreur="";
            boolean isE,isI,isValide, isDtOk;
            isValide=true;
            isDtOk=false;
            Ville orgaVille = null;
            Competition orgaComp;
            Organiser orga;
            // récupération des valeurs des différents objets 
            nomComp=txt_NomComp.getText();
            if(!txt_Nb_Max.getText().isEmpty()){
                nb_J_max=Integer.parseInt(txt_Nb_Max.getText());
            }
            else{
                nb_J_max=0;
            }
            nomResp=txt_NomResp.getText();
            telResp=txt_TelResp.getText();
            dateCom=txt_DateComp.getText();
            isE=cb_Equip.isSelected();
            isI=cb_Indiv.isSelected();
            idVille=cbo_Ville.getSelectedIndex();
            nomVille=cbo_Ville.getSelectedItem().toString();
            // faire contrôle des différentes valeur avant de poursuivre 
            System.out.println("idVille : "+idVille+"/"+nomVille+" ...");
            // recherche de la ville concernée par l'ajout de compétition 
            if(Ville.villes.size()>=0){
                for(Ville v1:Ville.villes){
                    if(nomVille.equalsIgnoreCase(v1.getNomVille())){
                        idVilleComp=v1.getIdVille();
                        orgaVille=v1;
                        System.out.println("idVille : "+idVille+"/"+nomVille+" ..."+idVilleComp);
                    } 
                }   
            }
            else{
                System.out.println("liste de ville vide");
            }
            if(nomComp==""||nomComp.trim().isEmpty()){
                isValide=false;
                erreur="Il faut un nom à cette compétition.";
            }
            if(isValide && (nomResp==null||nomResp.trim().isEmpty())){
                isValide=false;
                erreur="Il faut un nom de responsable pour cette compétition.";               
            }
            if(isValide && (telResp==null||telResp.trim().isEmpty())){
                isValide=false;
                erreur="Il faut le téléphone du responsable.";
            }
            if(isValide && !isE && !isI){
                erreur="La competition n'est ni par équipe ni individuelle !!";
                isValide=false;
            }
            if(isValide && cbo_Ville.getSelectedIndex()<1){
                erreur="Vous n'avez pas sélectionner de ville";
                isValide=false;
            }
            Pattern regx=Pattern.compile("[1-2]{1}[0-9]{3}-[0-1]{1}[0-9]-{1}[0-3]{1}[0-9]{1}");
            Matcher m=regx.matcher(dateCom);
            boolean isDtNaisOk=m.matches();
            if(isValide && isDtNaisOk){
                isDtOk=true;
            }
            else{
                if(!isDtNaisOk){
                    erreur="Date sous la forme \"aaaa-mm-jj\" exemple 1972-22-01";
                }
                isDtOk=false;
            }
            if(isValide && isDtOk){
                // création de l'objet Compétition
                Competition comp=new Competition(nomComp, nb_J_max, isI, isE);
                orgaComp=comp.new_Compete(comp); // maj de la base de données
                // création de l'objet Organiser
                orga=new Organiser(orgaVille, orgaComp,dateCom,nomResp,telResp);
                orga.new_Organiser(orga); // maj de la base de données
                // réinitialisation des champs
                txt_NomResp.setText("");
                txt_TelResp.setText("");
                txt_DateComp.setText("");
                txt_NomComp.setText("");
                txt_Nb_Max.setText("");
                JOptionPane.showMessageDialog(this,msg ," Confirmation ",JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(this, erreur," Attention ",JOptionPane.WARNING_MESSAGE);
            }
        }    
        // inner Class des listener divers
        // ActionListener
        class accueil_ActionListener implements ActionListener {
        @Override 
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==btn_Valider) cmdBtn_Valider_click(); 
            if(e.getSource()==btn_AjVille) cmdBtn_AjVille_click();
            if(e.getSource()==btn_Annuler) retour_page_acceuil();
        }
        }// fin AppActionListener       
        class aj_Compete_MouseListener implements MouseListener{
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
}// fin de classe
