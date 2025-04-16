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
    private ArrayList<ForgeDisc> disc = new ArrayList<>();
    @FXML
    private ImageView imgPieceToupie;




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

        PerformanceTip Defense = new PerformanceTip("Defense",3,9,6,15,"Performance_Tip/DriverDefense.png");

        PerformanceTip Keep = new PerformanceTip("Keep",2,9,7,16,"Performance_Tip/DriverKeep.png");
        PerformanceTip Nothing = new PerformanceTip("Nothing",2,5,9,14,"Performance_Tip/DriverNothing.png");
        PerformanceTip Xtend = new PerformanceTip("Xtend",1,6,10,13,"Performance_Tip/DriverXtend.png");
        PerformanceTip Operate = new PerformanceTip("Operate",8,3,4,10,"Performance_Tip/Operate_tip.png");
        PerformanceTip Evolution = new PerformanceTip("Evolution",7,4,7,12,"Performance_Tip/PerformanceTip_Evolution.png");

        tip.add(Defense);
        tip.add(Keep);
        tip.add( Nothing);
        tip.add(Xtend);
        tip.add(Operate);
        tip.add(Evolution);

        ForgeDisc Disk8 = new ForgeDisc("8",3,4,8,18.5,"Forge_Discs/Disk8.png");
        ForgeDisc Disk11 = new ForgeDisc("11",7,6,9,31.5,"Forge_Discs/Disk11.png");
        ForgeDisc Disk12 = new ForgeDisc("12",8,5,5,24.5,"Forge_Discs/Disk12.png");
        ForgeDisc DiskCentral = new ForgeDisc("Central",4,8,5,23.5,"Forge_Discs/DiskCentral.png");
        ForgeDisc DiskHurricane = new ForgeDisc("Hurricane",9,3,4,28.5,"Forge_Discs/DiskHurricane.png");
        ForgeDisc Disk2A = new ForgeDisc("2A",6,6,7,18.5,"Forge_Discs/ForgeDisc_2A.png");

        disc.add(Disk8);
        disc.add(Disk11);
        disc.add(Disk12);
        disc.add(DiskCentral);
        disc.add(DiskHurricane);
        disc.add(Disk2A);













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

        int chiffreAlea = (int) (Math.random()*2);

        if (1 == chiffreAlea){
            afficheForgeDisc();
        }else {
            affichePerformanceTip();
        }


    }

    public void afficheForgeDisc(){
        int nombreAleatoire = (int) (Math.random()*6);
        if (disc.indexOf(new ForgeDisc("8")) == nombreAleatoire){

            changeImageViewImg(imgPieceToupie,"Forge_Discs/Disk8.png");
            writeRapideInt(lblStatAttaque, disc.get(0).getStatAttaqueDisc());
            writeRapideInt(lblStatDefense, disc.get(0).getStatDefenseDisc());
            writeRapideInt(lblStatEndurance, disc.get(0).getStatEnduranceDisc());
            writeRapideInt(lblPoids, (int) disc.get(0).getPoidsDisc());
        }
        if (disc.indexOf(new ForgeDisc("11")) == nombreAleatoire){
            changeImageViewImg(imgPieceToupie,"Forge_Discs/Disk11.png");
            writeRapideInt(lblStatAttaque, disc.get(1).getStatAttaqueDisc());
            writeRapideInt(lblStatDefense, disc.get(1).getStatDefenseDisc());
            writeRapideInt(lblStatEndurance, disc.get(1).getStatEnduranceDisc());
            writeRapideInt(lblPoids, (int) disc.get(1).getPoidsDisc());
        }
        if (disc.indexOf(new ForgeDisc("12")) == nombreAleatoire){
            changeImageViewImg(imgPieceToupie,"Forge_Discs/Disk12.png");
            writeRapideInt(lblStatAttaque, disc.get(2).getStatAttaqueDisc());
            writeRapideInt(lblStatDefense, disc.get(2).getStatDefenseDisc());
            writeRapideInt(lblStatEndurance, disc.get(2).getStatEnduranceDisc());
            writeRapideInt(lblPoids, (int) disc.get(2).getPoidsDisc());
        }
        if (disc.indexOf(new ForgeDisc("Central")) == nombreAleatoire){
            changeImageViewImg(imgPieceToupie,"Forge_Discs/DiskCentral.png");
            writeRapideInt(lblStatAttaque, disc.get(3).getStatAttaqueDisc());
            writeRapideInt(lblStatDefense, disc.get(3).getStatDefenseDisc());
            writeRapideInt(lblStatEndurance, disc.get(3).getStatEnduranceDisc());
            writeRapideInt(lblPoids, (int) disc.get(3).getPoidsDisc());
        }
        if (disc.indexOf(new ForgeDisc("Hurricane")) == nombreAleatoire){
            changeImageViewImg(imgPieceToupie,"Forge_Discs/DiskHurricane.png");
            writeRapideInt(lblStatAttaque, disc.get(4).getStatAttaqueDisc());
            writeRapideInt(lblStatDefense, disc.get(4).getStatDefenseDisc());
            writeRapideInt(lblStatEndurance, disc.get(4).getStatEnduranceDisc());
            writeRapideInt(lblPoids, (int) disc.get(4).getPoidsDisc());
        }
        if (disc.indexOf(new ForgeDisc("2A")) == nombreAleatoire){
            changeImageViewImg(imgPieceToupie,"Forge_Discs/ForgeDisc_2A.png");
            writeRapideInt(lblStatAttaque, disc.get(5).getStatAttaqueDisc());
            writeRapideInt(lblStatDefense, disc.get(5).getStatDefenseDisc());
            writeRapideInt(lblStatEndurance, disc.get(5).getStatEnduranceDisc());
            writeRapideInt(lblPoids, (int) disc.get(5).getPoidsDisc());
        }

    }

    public void affichePerformanceTip(){
        int nombreAleatoire = (int) (Math.random()*6);
        if (tip.indexOf(new PerformanceTip("Defense")) == nombreAleatoire){

            changeImageViewImg(imgPieceToupie,"Performance_Tip/DriverDefense.png");
            writeRapideInt(lblStatAttaque, tip.get(0).getStatAttaqueTip());
            writeRapideInt(lblStatDefense, tip.get(0).getStatDefenseTip());
            writeRapideInt(lblStatEndurance, tip.get(0).getStatEnduranceTip());
            writeRapideInt(lblPoids, (int) tip.get(0).getPoidsTip());
        }
        if (tip.indexOf(new PerformanceTip("Keep")) == nombreAleatoire){
            changeImageViewImg(imgPieceToupie,"Performance_Tip/DriverKeep.png");
            writeRapideInt(lblStatAttaque, tip.get(1).getStatAttaqueTip());
            writeRapideInt(lblStatDefense, tip.get(1).getStatDefenseTip());
            writeRapideInt(lblStatEndurance, tip.get(1).getStatEnduranceTip());
            writeRapideInt(lblPoids, (int) tip.get(1).getPoidsTip());
        }
        if (tip.indexOf(new PerformanceTip("Nothing")) == nombreAleatoire){
            changeImageViewImg(imgPieceToupie,"Performance_Tip/DriverXtend.png");
            writeRapideInt(lblStatAttaque, tip.get(2).getStatAttaqueTip());
            writeRapideInt(lblStatDefense, tip.get(2).getStatDefenseTip());
            writeRapideInt(lblStatEndurance, tip.get(2).getStatEnduranceTip());
            writeRapideInt(lblPoids, (int) tip.get(2).getPoidsTip());
        }
        if (tip.indexOf(new PerformanceTip("Xtend")) == nombreAleatoire){
            changeImageViewImg(imgPieceToupie,"Performance_Tip/DriverNothing.png");
            writeRapideInt(lblStatAttaque, tip.get(3).getStatAttaqueTip());
            writeRapideInt(lblStatDefense, tip.get(3).getStatDefenseTip());
            writeRapideInt(lblStatEndurance, tip.get(3).getStatEnduranceTip());
            writeRapideInt(lblPoids, (int) tip.get(3).getPoidsTip());
        }
        if (tip.indexOf(new PerformanceTip("Operate")) == nombreAleatoire){
            changeImageViewImg(imgPieceToupie,"Performance_Tip/Operate_tip.png");
            writeRapideInt(lblStatAttaque, tip.get(4).getStatAttaqueTip());
            writeRapideInt(lblStatDefense, tip.get(4).getStatDefenseTip());
            writeRapideInt(lblStatEndurance, tip.get(4).getStatEnduranceTip());
            writeRapideInt(lblPoids, (int) tip.get(4).getPoidsTip());
        }
        if (tip.indexOf(new PerformanceTip("Evolution")) == nombreAleatoire){
            changeImageViewImg(imgPieceToupie,"Performance_Tip/PerformanceTip_Evolution.png");
            writeRapideInt(lblStatAttaque, tip.get(5).getStatAttaqueTip());
            writeRapideInt(lblStatDefense, tip.get(5).getStatDefenseTip());
            writeRapideInt(lblStatEndurance, tip.get(5).getStatEnduranceTip());
            writeRapideInt(lblPoids, (int) tip.get(5).getPoidsTip());
        }

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
    public void writeRapideInt(Label lblTexte, int intTexte)
    {
        lblTexte.setText(Integer.toString(intTexte));
        return;
    }
}