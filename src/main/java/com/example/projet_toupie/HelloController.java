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
    private ArrayList<EnergyLayer> layer = new ArrayList<>();
    private ArrayList<ToupiePersonnage> listToupie = new ArrayList<>();
    @FXML
    private ImageView imgPieceToupie;
    @FXML
    private Label lblBeyPoint;
    @FXML
    private ImageView imgLogo;
    @FXML
    private ImageView imgToupiePerso;
    @FXML
    private Label lblNomToupie;
    @FXML
    private AnchorPane apFichePerso;
    @FXML
    private Label lblRotationToupie;
    @FXML
    private Label lblVieMaxToupie;
    @FXML
    private Label lblEnduranceToupie;
    @FXML
    private Label lblAttaqueToupie;
    @FXML
    private Label lblDefenseToupie;
    @FXML
    private Label lblTypeToupie;

    int choixToupie = 0;
    /*ToupiePersonnage Drain_Fafnir;
    ToupiePersonnage Brave_Valkyrie;
    ToupiePersonnage Kerbeus;*/



    ClasseToupie attaque = new ClasseToupie("Attaque");
    ClasseToupie défense = new ClasseToupie("Défense");
    ClasseToupie endurance = new ClasseToupie("Endurance");
    ClasseToupie equilibre = new ClasseToupie("Equilibre");

    Rotation droite = new Rotation("droite");
    Rotation gauche = new Rotation("gauche");
    Rotation doubleRotation = new Rotation("double-rotation");




    ToupiePersonnage t = new ToupiePersonnage("null",null,null,null,null,0,0,0,0,null,"null");
    ClasseToupie c;
    Rotation r;
    PerformanceTip pt = new PerformanceTip("null",0,0,0,0,"null");

    EnergyLayer e;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        visible(apCommencement);
        invisible(apMenuPrincipal);
        invisible(apBoutique);
        invisible(apInvocation);
        invisible(apFichePerso);

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

        GTSystem gtLayerBushin = new GTSystem("Ashura","Ten","Bushin");
        SparkingSystem spBraveValkyrie = new SparkingSystem("Brave","2A");

        EnergyLayer LayerKerbeus = new EnergyLayer("Kerbeus", EnergyLayer.SystemeLayer.SINGLE,droite,2,6,5,33,"Energy_Layer/LayerKerbeus.png");
        EnergyLayer LayerHellSalamander = new EnergyLayer("Hell Salamander", EnergyLayer.SystemeLayer.cho_z,gauche,4,4,6,62,"Energy_Layer/LayerHellSalamander.png");
        EnergyLayer LayerDrainFafnir = new EnergyLayer("Drain Fafnir", EnergyLayer.SystemeLayer.GOD,gauche,3,4,8,37,"Energy_Layer/LayerDrainFafnir.png");
        EnergyLayer LayerZAchilles = new EnergyLayer("Z Achilles", EnergyLayer.SystemeLayer.cho_z,droite,8,3,4,43,"Energy_Layer/LayerZAchilles.png");
        EnergyLayer LayerBraveValkyrie= new EnergyLayer("Brave Valkyrie", EnergyLayer.SystemeLayer.SPARKING,droite,9,3,3,62,"Energy_Layer/EnergyLayer_BraveValkyrie.png", spBraveValkyrie);
        EnergyLayer LayerAshuraBushinChip = new EnergyLayer("Ashura", EnergyLayer.SystemeLayer.GT,droite,1,2,1,2.9,"Energy_Layer/GatinkoChipAshura.png",gtLayerBushin);
        EnergyLayer LayerAshuraBushinWeight = new EnergyLayer("Ten", EnergyLayer.SystemeLayer.GT,droite,0,1,1,4.6,"Energy_Layer/LayerWeightTen.png",gtLayerBushin);
        EnergyLayer LayerAshuraBushinBase = new EnergyLayer("Bushin", EnergyLayer.SystemeLayer.GT,droite,1,3,1,7.3,"Energy_Layer/LayerBaseBushin.png",gtLayerBushin);
        EnergyLayer LayerAshuraBushin = new EnergyLayer("Bushin Ashura", EnergyLayer.SystemeLayer.GT,droite,1,7,4,20.2,"",gtLayerBushin);

        layer.add(LayerKerbeus);
        layer.add(LayerHellSalamander);
        layer.add(LayerDrainFafnir);
        layer.add(LayerZAchilles);
        layer.add(LayerBraveValkyrie);
        layer.add(LayerAshuraBushinChip);
        layer.add(LayerAshuraBushinWeight);
        layer.add(LayerAshuraBushinBase);


        ToupiePersonnage Kerbeus = new ToupiePersonnage("Kerbeus Central Defense",LayerKerbeus,DiskCentral,Defense, défense,300,2,8,5,droite,"");
        ToupiePersonnage Bushin_Ashura = new ToupiePersonnage("Bushin Ashura Hurricane Keep",LayerAshuraBushin,DiskHurricane,Keep, défense,345,3,8,4,droite,"");
        //ToupiePersonnage Roar_Bahamut = new ToupiePersonnage("Roar Bahamut","Giga","Moment-10", défense,7,10,4,gauche);
         ToupiePersonnage Brave_Valkyrie = new ToupiePersonnage("Brave Valkyrie Evolution 2A ",LayerBraveValkyrie,Disk2A,Evolution, attaque,350,9,3,2,droite,"");
        ToupiePersonnage Hell_Salamander = new ToupiePersonnage("HellSalamander 12 Operate  ",LayerHellSalamander,Disk12,Operate, endurance,330,4,5,6,gauche,"");
         ToupiePersonnage Drain_Fafnir = new ToupiePersonnage("Drain Fafnir 8 Nothing ",LayerDrainFafnir,Disk8,Nothing, endurance,335,2,3,9,gauche,"");
        ToupiePersonnage Z_Achilles = new ToupiePersonnage("Z Achilles 11 Xtend  ",LayerZAchilles,Disk11,Xtend, attaque,340,7,4,4,droite,"");
        //ToupiePersonnage Lucifer_The_End = new ToupiePersonnage("Lucifer The End","Kou","Drift", endurance,9,6,3,droite);
        //ToupiePersonnage Astral_Spriggan = new ToupiePersonnage("Astral Spriggan ","Over","Quattro-0", attaque,7,6,8,doubleRotation);
        //ToupiePersonnage Master_Diablos = new ToupiePersonnage("Master Diabolos +  Diabolos GT Chip","","Generate(GT)",equilibre,8,7,8,doubleRotation);
        //ToupiePersonnage Nova_Neptune = new ToupiePersonnage("Nova Neptune","Vertical","Zephyr",equilibre,5,5,6,droite);
        //ToupiePersonnage Flare_Dragon= new ToupiePersonnage("Flare Dragon","Around","Planet ",equilibre,4,3,3,droite);



        listToupie.add(Kerbeus);
        listToupie.add(Bushin_Ashura);
        listToupie.add(Brave_Valkyrie);
        listToupie.add(Hell_Salamander);
        listToupie.add(Drain_Fafnir);
        listToupie.add(Z_Achilles);


        System.out.println("Indice de Kerbeus "+listToupie.indexOf(Kerbeus));
        System.out.println("Indice de Brave Valkyrie   "+listToupie.indexOf(Brave_Valkyrie));
        System.out.println("Indice de Drain Fafnir   "+listToupie.indexOf(Drain_Fafnir));











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

        choixToupie = 1;


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

        choixToupie = 2;
    }

    @FXML
    public void btnToupieAttaque(MouseEvent mouseEvent) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Vous avez Choisi Attaque");
        a.setHeaderText("Le nom de votre toupie est : Brave Valkyrie Evolution 2A");
        a.setContentText("Les toupies de type attaques envoient des attaques très puissantes");

        a.showAndWait();
        clearAll();

        visible(apMenuPrincipal);
        changeImageViewImg(imgFond,"Environnement/Ecran_d'accueil_3.png");
        choixToupie = 3;

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
        changeImageViewImg(imgLogo,"Logo/Logo_BeyPoint.png");
        writeRapideInt(lblBeyPoint,t.getNombreBeyPoints());


    }

    @FXML
    public void btnFichePerso(MouseEvent event) {
        clearAll();
        if (choixToupie == 1){
            writeRapideString(lblNomToupie, listToupie.get(4).getNomToupie());
            changeImageViewImg(imgToupiePerso,"Toupie/fafnir_gpt.png");
            visible(apFichePerso);
            changeZone("Toupie/fafnir_gpt.png",apFichePerso);
            writeRapideInt(lblAttaqueToupie, listToupie.get(4).getAttaqueToupie());
            writeRapideInt(lblDefenseToupie, listToupie.get(4).getDefenseToupie());
            writeRapideInt(lblEnduranceToupie, listToupie.get(4).getEnduranceToupie());
            writeRapideInt(lblVieMaxToupie, listToupie.get(4).getVieMaxToupie());
            writeRapideString(lblRotationToupie, String.valueOf(listToupie.get(4).getRotation().getTypeRotation()));
            writeRapideString(lblTypeToupie, String.valueOf(listToupie.get(4).getClasseToupie().getTypeToupie()));


        }
        if (choixToupie == 2){

            changeImageViewImg(imgToupiePerso,"Toupie/kerbeus_gpt.png");
            visible(apFichePerso);
            changeZone("Toupie/kerbeus_gpt.png",apFichePerso);
            writeRapideString(lblNomToupie, listToupie.get(0).getNomToupie());
            writeRapideInt(lblAttaqueToupie, listToupie.get(0).getAttaqueToupie());
            writeRapideInt(lblDefenseToupie, listToupie.get(0).getDefenseToupie());
            writeRapideInt(lblEnduranceToupie, listToupie.get(0).getEnduranceToupie());
            writeRapideInt(lblVieMaxToupie, listToupie.get(0).getVieMaxToupie());
            writeRapideString(lblRotationToupie, String.valueOf(listToupie.get(0).getRotation().getTypeRotation()));
            writeRapideString(lblTypeToupie, String.valueOf(listToupie.get(0).getClasseToupie().getTypeToupie()));

        }
        if (choixToupie == 3){
            changeImageViewImg(imgToupiePerso,"Toupie/valkyrie_gpt.png");
            visible(apFichePerso);
            changeZone("Toupie/valkyrie_gpt.png",apFichePerso);
            writeRapideString(lblNomToupie, listToupie.get(2).getNomToupie());
            writeRapideInt(lblAttaqueToupie, listToupie.get(2).getAttaqueToupie());
            writeRapideInt(lblDefenseToupie, listToupie.get(2).getDefenseToupie());
            writeRapideInt(lblEnduranceToupie, listToupie.get(2).getEnduranceToupie());
            writeRapideInt(lblVieMaxToupie, listToupie.get(2).getVieMaxToupie());
            writeRapideString(lblRotationToupie, String.valueOf(listToupie.get(2).getRotation().getTypeRotation()));
            writeRapideString(lblTypeToupie, String.valueOf(listToupie.get(2).getClasseToupie().getTypeToupie()));

        }
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

        int chiffreAlea = (int) (Math.random()*3);

        if (1 == chiffreAlea){
            afficheForgeDisc();
        }else if (2 == chiffreAlea){
            affichePerformanceTip();
        }else {
            afficheEnergyLayer();
        }


    }

    public void afficheForgeDisc(){
        int nombreAleatoire = (int) (Math.random()*6);
        ForgeDisc selectedDisc = disc.get(nombreAleatoire);
        changeImageViewImg(imgPieceToupie, selectedDisc.getUrlDisc());
        writeRapideInt(lblStatAttaque, selectedDisc.getStatAttaqueDisc());
        writeRapideInt(lblStatDefense, selectedDisc.getStatDefenseDisc());
        writeRapideInt(lblStatEndurance, selectedDisc.getStatEnduranceDisc());
        writeRapideInt(lblPoids, (int) selectedDisc.getPoidsDisc());




    }

    public void affichePerformanceTip(){
        int nombreAleatoire = (int) (Math.random()*6);
        PerformanceTip selectedTip = tip.get(nombreAleatoire);
        changeImageViewImg(imgPieceToupie, selectedTip.getUrlTip());
        writeRapideInt(lblStatAttaque, selectedTip.getStatAttaqueTip());
        writeRapideInt(lblStatDefense, selectedTip.getStatDefenseTip());
        writeRapideInt(lblStatEndurance, selectedTip.getStatEnduranceTip());
        writeRapideInt(lblPoids, (int) selectedTip.getPoidsTip());


    }
    public void afficheEnergyLayer(){
        int nombreAleatoire = (int) (Math.random()*8);
        EnergyLayer selectedTip = layer.get(nombreAleatoire);
        changeImageViewImg(imgPieceToupie, selectedTip.getUrlLayer());
        writeRapideInt(lblStatAttaque, selectedTip.getStatAttaqueLayer());
        writeRapideInt(lblStatDefense, selectedTip.getStatDefenseLayer());
        writeRapideInt(lblStatEndurance, selectedTip.getStatEnduranceLayer());
        writeRapideInt(lblPoids, (int) selectedTip.getPoidsLayer());


    }


    public void clearAll(){
        invisible(apBoutique);
        invisible(apMenuPrincipal);
        invisible(apCommencement);
        invisible(apInvocation);
        invisible(apFichePerso);
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
    public void writeRapideString(Label lblTexte, String stringTexte)
    {
        lblTexte.setText(stringTexte);
        return;
    }

    @FXML
    public void btnDetailToupie(MouseEvent event) {
    }
}