/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttvg;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;
import javax.swing.*;


/**
 *
 * @author emmanuel
 */
public class AjouterVille_Ihm extends JPanel{
    public JDialog fenAjouterVille;
    public JPanel pan_Nord, pan_West, pan_Est, pan_Sud;
    public JLabel img_Logo, lbl_AjVille, lbl_NomVille, lbl_CpVille;
    public JTextField txt_NomVille, txt_CpVille;
    public JButton btn_Valider, btn_Annuler;
    
    public AjouterVille_Ihm(){
        fenAjouterVille=new JDialog();
        fenAjouterVille.setSize(325, 280);
        fenAjouterVille.setTitle("Fenêtre Ajouter Ville");
        fenAjouterVille.setLocationRelativeTo(this);
        fenAjouterVille.setModal(true);
        initControls();   
        fenAjouterVille.setVisible(true);
    }
    public void initControls(){
        // maFenetre est la fenetre "complete"
        fenAjouterVille.setLayout(new BorderLayout());
        lbl_NomVille=new JLabel("Ville");
        txt_NomVille=new JTextField();
        lbl_CpVille=new JLabel("Code Postal");
        txt_CpVille=new JTextField();
        lbl_AjVille= new JLabel("Ajouter une ville");
        lbl_AjVille.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,20));
        img_Logo=new JLabel(new ImageIcon("./src/images/logo.jpg")); 
        btn_Valider=new JButton("Valider");
        btn_Valider.addActionListener(new ajoutVille_ActionListener());
        btn_Annuler=new JButton("Annuler");
        btn_Annuler.addActionListener(new ajoutVille_ActionListener());
        pan_Nord= new JPanel();
        pan_Nord.add(img_Logo);
        pan_Nord.add(lbl_AjVille);
        pan_West= new JPanel();
        pan_West.setLayout(new GridLayout(2,2)); 
        pan_West.add(lbl_NomVille);
        pan_West.add(txt_NomVille);
        pan_West.add(lbl_CpVille);
        pan_West.add(txt_CpVille);
        pan_Sud=new JPanel();
        pan_Sud.add(btn_Annuler);
        pan_Sud.add(btn_Valider);
        //fenAjouterVille.add(pan_Est, BorderLayout.EAST);
        fenAjouterVille.add(pan_Nord, BorderLayout.NORTH);
        fenAjouterVille.add(pan_West, BorderLayout.CENTER);
        fenAjouterVille.add(pan_Sud, BorderLayout.SOUTH);       
    }
    class ajoutVille_ActionListener implements ActionListener {
        @Override 
        public void actionPerformed(ActionEvent e){
            if(e.getSource()==btn_Valider) cmdBtn_Valider_click(); 
            if(e.getSource()==btn_Annuler) cmdBtn_Annuler_click();
        }
    }
    private void cmdBtn_Valider_click(){
        // déclaration des variables
        boolean isVilleOk, isCpOk;
        String nomVille, cpVille;
        // test de conformité des champs via Exp Regulière
        nomVille=txt_NomVille.getText();
        cpVille=txt_CpVille.getText();
        Pattern regx=Pattern.compile("[a-zA-Z]*-?[a-zA-Z]*{2,20}");
        Matcher m=regx.matcher(nomVille);
        isVilleOk=m.matches();
        regx=Pattern.compile("[0-9]{5}");
        m=regx.matcher(cpVille);
        isCpOk=m.matches();
        if(isVilleOk && isCpOk){
            nomVille=nomVille.toUpperCase();
            Ville vil=new Ville(cpVille, nomVille);
            vil.new_Ville_Db(vil);
            JOptionPane.showMessageDialog(this, "Nouvelle Ville enregistrée"," Confirmation ",JOptionPane.INFORMATION_MESSAGE);
            fenAjouterVille.dispose(); 
        }
        else JOptionPane.showMessageDialog(this, "Saisie\nNon conforme"," Attention ",JOptionPane.WARNING_MESSAGE);
    }
    private void cmdBtn_Annuler_click(){
        fenAjouterVille.dispose();
    }
}// fin de class
