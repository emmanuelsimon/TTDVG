/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttvg;
import javax.swing.*;
import java.awt.*;
//import static ttvg.TTVG.listMembre;
/**
 *
 * @author emmanuel
 */
public class Page_Accueil extends JPanel{
    private JPanel pan_FenetreCentrale, pan_nord,pan_footer, pan_centre, pan_centrecentre, pan_centre_sud, pan_centresud, pan_bureau;
    private JLabel lbl_Pres, lbl_PresAdj, lbl_Tsor, lbl_TsorAdj, lbl_Secr, lbl_SecrAdj, lbl_Titre,img_Logo,lbl_PiedDePage;
    private JTextField txt_Pres, txt_PresAdj, txt_Tsor, txt_TsorAdj, txt_Secr, txt_SecrAdj;
    private String pres, presAdj, tsor, tsorAdj, secr, secrAdj;


    public Page_Accueil(){
        initControls();   
        this.setVisible(true);
    }
    private void initControls(){
        this.setLayout(new BorderLayout());
        pan_nord=new JPanel();
        img_Logo=new JLabel(new ImageIcon("./src/images/logo.jpg"));
        lbl_Titre= new JLabel("    Bienvenue au CTTVG");
        lbl_Titre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,32));
        lbl_PiedDePage=new JLabel("V0.2a - E.S (c) 2016");
        pres=TTVG.listMembre[0]+" "+TTVG.listMembre[1];
        lbl_Pres=new JLabel("Président : ");
        txt_Pres=new JTextField(pres);
        txt_Pres.setEditable(false);
        presAdj=TTVG.listMembre[2]+" "+TTVG.listMembre[3];
        lbl_PresAdj=new JLabel("Adjoint : ");
        txt_PresAdj=new JTextField(presAdj);
        txt_PresAdj.setEditable(false);
        tsor=TTVG.listMembre[4]+" "+TTVG.listMembre[5];
        lbl_Tsor=new JLabel("Trésorier : ");
        txt_Tsor=new JTextField(tsor);
        txt_Tsor.setEditable(false);
        tsorAdj=TTVG.listMembre[6]+" "+TTVG.listMembre[7];
        lbl_TsorAdj=new JLabel("Adjoint : ");
        txt_TsorAdj=new JTextField(tsorAdj);
        txt_TsorAdj.setEditable(false);        
        secr=TTVG.listMembre[8]+" "+TTVG.listMembre[9];
        lbl_Secr=new JLabel("Secrétaire : ");
        txt_Secr=new JTextField(secr);
        txt_Secr.setEditable(false);
        secrAdj=TTVG.listMembre[10]+" "+TTVG.listMembre[11];
        lbl_SecrAdj=new JLabel("Adjoint : ");
        txt_SecrAdj=new JTextField(secrAdj);
        txt_SecrAdj.setEditable(false);                     
        // panneau principal
        pan_FenetreCentrale=new JPanel();
        pan_FenetreCentrale.setLayout(new BorderLayout());
        pan_centre=new JPanel();
        pan_centre.setLayout(new BorderLayout());
        pan_centrecentre=new JPanel();
        pan_centrecentre.setLayout(new BorderLayout());
        pan_centrecentre.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
        pan_bureau=new JPanel();
        pan_bureau.setLayout(new GridLayout(3,4,2,2));
        pan_bureau.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        pan_bureau.add(lbl_Pres);
        pan_bureau.add(txt_Pres);
        pan_bureau.add(lbl_PresAdj);
        pan_bureau.add(txt_PresAdj);
        pan_bureau.add(lbl_Tsor);
        pan_bureau.add(txt_Tsor);
        pan_bureau.add(lbl_TsorAdj);
        pan_bureau.add(txt_TsorAdj); 
        pan_bureau.add(lbl_Secr);
        pan_bureau.add(txt_Secr); 
        pan_bureau.add(lbl_SecrAdj);
        pan_bureau.add(txt_SecrAdj);
        pan_centrecentre.add(pan_bureau, BorderLayout.WEST);
        pan_centre.add(pan_centrecentre, BorderLayout.CENTER);
        pan_centre.add(pan_nord, BorderLayout.NORTH);
        pan_centresud=new JPanel();
        pan_centre.add(pan_centresud, BorderLayout.SOUTH);
        pan_centre_sud=new JPanel();
        pan_centre_sud.setLayout(new GridLayout(1,2,10,20));
        pan_centre_sud.setBorder(BorderFactory.createEmptyBorder(20, 300, 20, 150));
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
}// fin de class
