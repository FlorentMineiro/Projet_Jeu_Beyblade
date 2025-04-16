package com.example.projet_toupie;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class HelloController implements Initializable {


    @FXML
    public AnchorPane apCommencement;
    @FXML
    public AnchorPane apMenuPrincipal;
    @FXML
    private AnchorPane apBoutique;

    private Node zoomableNode;
    @FXML
    private ImageView imgFond;
    @FXML
    private ImageView imgCoffre;
    private String mapCourante;
    @FXML
    private ImageView imgRetour;
    @FXML
    private Label lblStatAttaque;
    @FXML
    private Label lblStatEndurance;
    @FXML
    private ImageView imgInvocation;
    @FXML
    private Label lblStatDefense;
    @FXML
    private Label lblPoids;
    @FXML
    private AnchorPane apInvocation;
    private ArrayList<PerformanceTip> tip = new ArrayList<>();




    ClasseToupie attaque = new ClasseToupie(true,false,false);
    ClasseToupie défense = new ClasseToupie(false,true,false);
    ClasseToupie endurance = new ClasseToupie(false,false,true);
    ClasseToupie equilibre = new ClasseToupie(false,false,false);

    Rotation droite = new Rotation(true,false,false);
    Rotation gauche = new Rotation(false,true,false);
    Rotation doubleRotation = new Rotation(false,false,true);

    ToupiePersonnage Kerbeus = new ToupiePersonnage("Kerbeus","Central","Defense", défense,6,8,2,droite);
    ToupiePersonnage Bushin_Ashura = new ToupiePersonnage("Bushin Ashura","Hurricane","Keep", défense,5,9,4,droite);
    ToupiePersonnage Roar_Bahamut = new ToupiePersonnage("Roar Bahamut","Giga","Moment-10", défense,7,10,4,gauche);
    ToupiePersonnage Brave_Valkyrie = new ToupiePersonnage("Brave Valkyrie","2A","Evolution", attaque,3,4,10,droite);
    ToupiePersonnage Hell_Salamander = new ToupiePersonnage("Hell Salamander","12","Operate", endurance,8,5,6,gauche);
    ToupiePersonnage Drain_Fafnir = new ToupiePersonnage("Drain Fafnir","8","Nothing", endurance,9,5,3,gauche);
    ToupiePersonnage Z_Achilles = new ToupiePersonnage("Z-Achilles","11","Xtend", attaque,6,5,8,droite);
    ToupiePersonnage Lucifer_The_End = new ToupiePersonnage("Lucifer The End","Kou","Drift", endurance,9,6,3,droite);
    ToupiePersonnage Astral_Spriggan = new ToupiePersonnage("Astral Spriggan ","Over","Quattro-0", attaque,7,6,8,doubleRotation);
    ToupiePersonnage Master_Diablos = new ToupiePersonnage("Master Diabolos + + Diabolos GT Chip","","Generate(GT)",equilibre,8,7,8,doubleRotation);
    ToupiePersonnage Nova_Neptune = new ToupiePersonnage("Nova Neptune","Vertical","Zephyr",equilibre,5,5,6,droite);
    ToupiePersonnage Knight_Shield = new ToupiePersonnage("Knight Core + Shield Blade","4-80 Disc","Balan ",equilibre,6,6,6,droite);


    ToupiePersonnage t = new ToupiePersonnage("null","null","null",null,0,0,0,null);
    ClasseToupie c;
    Rotation r;
    PerformanceTip pt = new PerformanceTip("null",0,0,0,0,"null");







    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        visible(apCommencement);
        invisible(apMenuPrincipal);
        invisible(apBoutique);
        invisible(apInvocation);
        tip.add(new PerformanceTip("Defense",3,9,6,15,"Performance_Tip/DriverDefense.png"));
        tip.add(new PerformanceTip("Keep",2,9,7,16,"Performance_Tip/DriverKeep.png"));
        tip.add(new PerformanceTip("Nothing",2,5,9,14,"Performance_Tip/DriverNothing.png"));
        tip.add(new PerformanceTip("Xtend",1,6,10,13,"Performance_Tip/DriverXtend.png"));
        tip.add(new PerformanceTip("Operate",8,3,4,10,"Performance_Tip/Operate_tip.png"));
        tip.add(new PerformanceTip("Evolution",7,4,7,12,"Performance_Tip/PerformanceTip_Evolution.png"));



        for(int i=0 ; i < tip.size() ; i++){
            System.out.println(tip.get(i));
        }





    }

    @FXML
    public void btnToupieEndurance(MouseEvent mouseEvent) {

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Vous avez Choisi Endurance");
        a.setHeaderText("Le nom de votre toupie est : Drain Fafnir 8 nothing");
        a.setContentText("Les toupies de type endurance tournent extrêmement longtemps");
        a.showAndWait();
        clearAll();
        visible(apMenuPrincipal);
        changeImageViewImg(imgFond,"Environnement/Ecran_d'accueil_3.png");


    }

    @FXML
    public void btnToupieDefense(MouseEvent mouseEvent) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Vous avez Choisi Défense");
        a.setHeaderText("Le nom de votre toupie est : Kerbeus Central Defense");
        a.setContentText("Les toupies de type endurance sont doués pour encaisser les attaques");
        a.showAndWait();
        clearAll();
        visible(apMenuPrincipal);
        changeImageViewImg(imgFond,"Environnement/Ecran_d'accueil_3.png");
    }

    @FXML
    public void btnToupieAttaque(MouseEvent mouseEvent) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Vous avez Choisi Endurance");
        a.setHeaderText("Le nom de votre toupie est : Brave Valkyrie Evolution 2A");
        a.setContentText("Les toupies de type attaques envoient des attaques très puissantes");

        a.showAndWait();
        clearAll();

        visible(apMenuPrincipal);
        changeImageViewImg(imgFond,"Environnement/Ecran_d'accueil_3.png");

    }

    public void visible(AnchorPane apCourante){
        apCourante.setVisible(true);

    }
    public void invisible(AnchorPane apCourante){
        apCourante.setVisible(false);

    }
    public void changeImageViewImg(ImageView imgView, String linkImage){
        imgView.setImage(
                new Image(
                        getClass().getResource(
                                "/"+linkImage
                        ).toExternalForm()
                )
        );
        if (imgView == imgFond) {
            mapCourante = linkImage;
        }
    }
    public void changeZone(String ZoneURL, AnchorPane ZoneAP)
    {
        clearAll();
        changeImageViewImg(imgFond, ZoneURL);
        visible(ZoneAP);
        return;
    }


    @FXML
    public void btnBoutique(MouseEvent event) {
        clearAll();

        changeImageViewImg(imgFond,"Environnement/fond-boutique_2.png");
        visible(apBoutique);
        changeZone("Environnement/fond-boutique_2.png",apBoutique);
        changeImageViewImg(imgCoffre,"Bouton_Spécial/toupie-invocation.png");
        changeImageViewImg(imgRetour,"Bouton_Spécial/Toupie_Retour.png");


    }

    @FXML
    public void btnFichePerso(MouseEvent event) {
    }

    @FXML
    public void btnModeCombat(MouseEvent event) {
    }

    @FXML
    public void btnCoffreToupie(MouseEvent mouseEvent) {
        clearAll();
        changeImageViewImg(imgInvocation , "Environnement/Fond-Invocation.png");
        visible(apInvocation);
        changeZone("Environnement/Fond-Invocation.png",apInvocation);
    }

    public void clearAll(){
        invisible(apBoutique);
        invisible(apMenuPrincipal);
        invisible(apCommencement);
        invisible(apInvocation);
    }


    @FXML
    public void btnRetour(MouseEvent mouseEvent) {
        clearAll();
        changeImageViewImg(imgFond,"Environnement/Ecran_d'accueil_3.png");
        visible(apMenuPrincipal);
        changeZone("Environnement/Ecran_d'accueil_3.png",apMenuPrincipal);
    }

    @FXML
    public void btnSuivant(MouseEvent event) {
        clearAll();
        changeImageViewImg(imgFond,"Environnement/fond-boutique_2.png");
        visible(apBoutique);
        changeZone("Environnement/fond-boutique_2.png",apBoutique);
        changeImageViewImg(imgCoffre,"Bouton_Spécial/toupie-invocation.png");
        changeImageViewImg(imgRetour,"Bouton_Spécial/Toupie_Retour.png");

    }
}