package com.example.projet_toupie;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;


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
    private QTELancer qteLancer; // Instance du QTE
    private ToupiePersonnage attaquant; // Remplacer avec les bons objets
    private ToupiePersonnage cible;
    private ArrayList<PerformanceTip> tip = new ArrayList<>();
    private ArrayList<ForgeDisc> disc = new ArrayList<>();
    private ArrayList<EnergyLayer> layer = new ArrayList<>();
    private ArrayList<ToupiePersonnage> listToupie = new ArrayList<>();
    private ArrayList<ToupieEnnemie> listToupieEnnemie = new ArrayList<>();
    private ArrayList<String> lettre = new ArrayList<>();
    private String lettreActuelle;
    private boolean qteEnCours = false;
    private List<String> sequenceLettres = new ArrayList<>(); // Séquence de lettres à saisir
    private int currentLetterIndex = 0; // Index de la lettre actuelle dans la séquence
    private PauseTransition timer; // Timer pour chaque lettre




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
    @FXML
    private ImageView imgRetour2;
    @FXML
    private Label lblAdversaireValkyrie;
    @FXML
    private Label lblAdversaireAshura;
    @FXML
    private AnchorPane apSelectionAdversaire;
    @FXML
    private Label lblAdversaireKerbeus;
    @FXML
    private Label lblAdversaireSalamander;
    @FXML
    private Label lblAdversaireFafnir;
    @FXML
    private Label lblAdversaireZachilles;
    @FXML
    private ImageView imgMenuCombat;
    @FXML
    private Label lblLancer;
    @FXML
    private ImageView imgStadium;
    @FXML
    private AnchorPane apLancerToupie;


    int choixToupie = 0;
    /*ToupiePersonnage Drain_Fafnir;
    ToupiePersonnage Brave_Valkyrie;
    ToupiePersonnage Kerbeus;*/



    ClasseToupie typeAttaque = new ClasseToupie("Attaque");
    ClasseToupie typeDefense = new ClasseToupie("Défense");
    ClasseToupie typeEndurance = new ClasseToupie("Endurance");
    ClasseToupie equilibre = new ClasseToupie("Equilibre");

    Rotation droite = new Rotation("droite");
    Rotation gauche = new Rotation("gauche");
    Rotation doubleRotation = new Rotation("double-rotation");

    ToupieEnnemie KerbeusE;
    ToupieEnnemie BraveValkyrieE;
    ToupieEnnemie HellSalamanderE;
    ToupieEnnemie DrainFafnirE;
    ToupieEnnemie ZAchillesE;
    ToupieEnnemie BushinAshuraE;




    ToupiePersonnage t = new ToupiePersonnage("null",null,null,null,null,0,0,0,0,0,0,null,"null");
    ToupieEnnemie te = new ToupieEnnemie("null",null,null,null,null,0,0,0,0,null,"null");
    ClasseToupie c;
    Rotation r;
    PerformanceTip pt = new PerformanceTip("null",0,0,0,0,"null");

    EnergyLayer e;
    private ToupiePersonnage toupieJoueur;
    @FXML
    private Label lblQTE;
    @FXML
    private ImageView imgStadium2;
    @FXML
    private AnchorPane apDuelToupie;
    @FXML
    private ImageView imgToupieDuPerso;
    @FXML
    private ImageView imgToupieDeEnnemi;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clearAll();
        visible(apCommencement);



        PerformanceTip Defense = new PerformanceTip("Defense",
                5,
                30,
                20
                ,15
                ,"Performance_Tip/DriverDefense.png");

        PerformanceTip Keep = new PerformanceTip("Keep",
                5,
                25,
                20,
                16
                ,"Performance_Tip/DriverKeep.png");
        PerformanceTip Nothing = new PerformanceTip("Nothing",
                10,
                10,
                30
                ,14
                ,"Performance_Tip/DriverNothing.png");
        PerformanceTip Xtend = new PerformanceTip("Xtend"
                ,20
                ,15
                ,20
                ,13
                ,"Performance_Tip/DriverXtend.png");
        PerformanceTip Operate = new PerformanceTip("Operate"
                ,15
                ,15
                ,25
                ,10,"Performance_Tip/Operate_tip.png");
        PerformanceTip Evolution = new PerformanceTip("Evolution"
                ,30
                ,5
                ,5
                ,12
                ,"Performance_Tip/PerformanceTip_Evolution.png");
        PerformanceTip Drift = new PerformanceTip("Drift"
                ,5
                ,15
                ,40
                ,10
                ,"Performance_Tip/DriverDrift.png");
        PerformanceTip Moment = new PerformanceTip("Moment"
                ,10
                ,30
                ,30
                ,12
                ,"Performance_Tip/DriverMoment.png");


        tip.add(Defense);
        tip.add(Keep);
        tip.add( Nothing);
        tip.add(Xtend);
        tip.add(Operate);
        tip.add(Evolution);
        tip.add(Drift);
        tip.add(Moment);

        ForgeDisc Disk8 = new ForgeDisc("8"
                ,10
                ,10
                ,25
                ,18.5
                ,"Forge_Discs/Disk8.png");
        ForgeDisc Disk11 = new ForgeDisc("11"
                ,20
                ,15
                ,10
                ,31.5
                ,"Forge_Discs/Disk11.png");
        ForgeDisc Disk12 = new ForgeDisc("12"
                ,15
                ,10
                ,20
                ,24.5
                ,"Forge_Discs/Disk12.png");
        ForgeDisc DiskCentral = new ForgeDisc("Central"
                ,10
                ,25
                ,15
                ,23.5
                ,"Forge_Discs/DiskCentral.png");
        ForgeDisc DiskHurricane = new ForgeDisc("Hurricane"
                ,15
                ,30
                ,15
                ,28.5
                ,"Forge_Discs/DiskHurricane.png");
        ForgeDisc Disk2A = new ForgeDisc("2A"
                ,25
                ,10
                ,10
                ,18.5
                ,"Forge_Discs/ForgeDisc_2A.png");
        ForgeDisc Chassis2D = new ForgeDisc("2D",
                30,
                35,
                5,
                27,
                "Forge_Discs/Chassis2D.png");
        ForgeDisc DiskKou = new ForgeDisc("Kou",
                15,
                25,
                20,
                21.5,
                "Forge_Discs/DiscKou.png");
        ForgeDisc DiskGiga = new ForgeDisc("Giga",
                25,
                20,
                30,
                30,
                "Forge_Discs/DiskGiga.png");

        disc.add(Disk8);
        disc.add(Disk11);
        disc.add(Disk12);
        disc.add(DiskCentral);
        disc.add(DiskHurricane);
        disc.add(Disk2A);
        disc.add(Chassis2D);
        disc.add(DiskKou);
        disc.add(DiskGiga);

        GTSystem gtLayerBushin = new GTSystem("Ashura","Ten","Bushin");
        SparkingSystem spBraveValkyrie = new SparkingSystem("Brave","2A","Valkyrie");
        SparkingSystem spLuciferTheEnd2D = new SparkingSystem("The End", "2D", "Lucifer");
        DBSystem DbGiga = new DBSystem("Roar","10");
        DBSystem dbLuciferKou = new DBSystem("Lucifer the End","Kou");


        EnergyLayer LayerKerbeus = new EnergyLayer("Kerbeus", EnergyLayer.SystemeLayer.SINGLE, droite, 30, 60, 40, 33, "Energy_Layer/LayerKerbeus.png");
        EnergyLayer LayerHellSalamander = new EnergyLayer("Hell Salamander", EnergyLayer.SystemeLayer.cho_z, gauche, 45, 45, 60, 62, "Energy_Layer/LayerHellSalamander.png");
        EnergyLayer LayerDrainFafnir = new EnergyLayer("Drain Fafnir", EnergyLayer.SystemeLayer.GOD, gauche, 35, 45, 80, 37, "Energy_Layer/LayerDrainFafnir.png");
        EnergyLayer LayerZAchilles = new EnergyLayer("Z Achilles", EnergyLayer.SystemeLayer.cho_z, droite, 80, 30, 40, 43, "Energy_Layer/LayerZAchilles.png");
        EnergyLayer LayerBraveValkyrie = new EnergyLayer("Brave Valkyrie", EnergyLayer.SystemeLayer.SPARKING, droite, 90, 30, 30, 62, "Energy_Layer/EnergyLayer_BraveValkyrie.png", spBraveValkyrie);

// Layers GT (Bushin Ashura)
        EnergyLayer LayerAshuraBushinChip = new EnergyLayer("Ashura", EnergyLayer.SystemeLayer.GT, droite, 15, 20, 10, 2.9f, "Energy_Layer/GatinkoChipAshura.png", gtLayerBushin);
        EnergyLayer LayerAshuraBushinWeight = new EnergyLayer("Ten", EnergyLayer.SystemeLayer.GT, droite, 5, 15, 10, 4.6f, "Energy_Layer/LayerWeightTen.png", gtLayerBushin);
        EnergyLayer LayerAshuraBushinBase = new EnergyLayer("Bushin", EnergyLayer.SystemeLayer.GT, droite, 10, 40, 15, 7.3f, "Energy_Layer/LayerBaseBushin.png", gtLayerBushin);
        EnergyLayer LayerAshuraBushin = new EnergyLayer("Bushin Ashura", EnergyLayer.SystemeLayer.GT, droite, 30, 70, 35, 20.2f, "", gtLayerBushin);

// Pièces spéciales
        EnergyLayer LayerEndBlade = new EnergyLayer(" The End "
                , EnergyLayer.SystemeLayer.DB
                , droite
                , 95
                , 60
                , 30
                , 30
                , "Energy_Layer/BladeEndCore.png"
                ,dbLuciferKou);
        EnergyLayer LayerLuciferARmor= new EnergyLayer("Lucifer"
                , EnergyLayer.SystemeLayer.DB
                , gauche
                , 70
                , 80
                , 25
                , 25
                , "Energy_Layer/CoreLuciferII.png"
                ,dbLuciferKou);
        EnergyLayer superkingChipLucifer = new EnergyLayer(
                "Lucifer",
                EnergyLayer.SystemeLayer.SPARKING,
                gauche,
                25,  // attaque
                40,  // défense
                30,  // endurance
                3.0f,
                "Energy_Layer/ChipLucifer.png",
                spLuciferTheEnd2D
        );
        EnergyLayer RingTheEnd = new EnergyLayer(
                "The End",
                EnergyLayer.SystemeLayer.SPARKING,
                gauche,
                30,
                50,
                40,
                5.0f,
                "Energy_Layer/RingTheEnd.png",
                spLuciferTheEnd2D
        );

        EnergyLayer LayerBladeRoar = new EnergyLayer("Roar"
                , EnergyLayer.SystemeLayer.DB
                , droite
                , 85
                , 50
                , 35
                , 28
                , "Energy_Layer/BladeRoar.png"
                ,DbGiga);
        EnergyLayer LayerArmor10 = new EnergyLayer(" 10"
                , EnergyLayer.SystemeLayer.DB
                , droite
                , 10
                , 70
                , 45
                , 18
                , "Energy_Layer/Armor10.png"
                ,DbGiga);
        EnergyLayer LayerLuciferTheEnd = new EnergyLayer(
                "Lucifer The End",
                EnergyLayer.SystemeLayer.SPARKING,
                droite,
                35,  // attaque
                80,  // défense
                90,  // endurance
                32.8f,
                "Energy_Layer/LayerLuciferTheEnd.png",
                spLuciferTheEnd2D
        );
        EnergyLayer LayerRoarBahamut = new EnergyLayer(
                "Roar Bahamut",
                EnergyLayer.SystemeLayer.DB,
                gauche,
                30,  // attaque
                90,  // défense
                70,  // endurance
                31.5f,
                "Energy_Layer/LayerRoarBahamut.png",
                DbGiga
        );
        EnergyLayer LayerLuciferTheEndDB = new EnergyLayer(
                "Lucifer The End",
                EnergyLayer.SystemeLayer.DB,
                droite,
                45,  // attaque
                60,  // défense
                65,  // endurance
                24.3f, // poids
                "Energy_Layer/LayerLuciferTheEndDB.png",
                dbLuciferKou
        );
        layer.add(LayerKerbeus);
        layer.add(LayerHellSalamander);
        layer.add(LayerDrainFafnir);
        layer.add(LayerZAchilles);
        layer.add(LayerBraveValkyrie);
        layer.add(LayerAshuraBushinChip);
        layer.add(LayerAshuraBushinWeight);
        layer.add(LayerAshuraBushinBase);
        layer.add(LayerEndBlade);
        layer.add(LayerArmor10);
        layer.add(LayerBladeRoar);
        layer.add(RingTheEnd);
        layer.add(superkingChipLucifer);
        layer.add(LayerLuciferARmor);


        ToupiePersonnage Kerbeus = new ToupiePersonnage("Kerbeus Central Defense"
                ,LayerKerbeus
                ,DiskCentral
                ,Defense,
                typeDefense,
                1500,
                35,
                85,
                60,
                20,
                65,
                droite,
                "Toupie/kerbeus_gpt.png");
        ToupiePersonnage Bushin_Ashura = new ToupiePersonnage("Bushin Ashura Hurricane Keep"
                ,LayerAshuraBushin
                ,DiskHurricane
                ,Keep
                ,typeDefense
                ,1450
                ,45
                ,80
                ,65
                ,25
                ,75
                ,droite
                ,"Toupie/BBGT_Bushin_Ashura_Hurricane_Keep_Ten_Beyblade.png");
        ToupiePersonnage Roar_Bahamut = new ToupiePersonnage("Roar Bahamut"
                ,LayerRoarBahamut
                ,DiskGiga
                ,Moment
                , typeDefense
                ,1800
                ,30
                ,90
                ,70

                ,20
                ,55
                ,gauche
                ,"Toupie/Roar_Bahamut.png");
         ToupiePersonnage Brave_Valkyrie = new ToupiePersonnage("Brave Valkyrie Evolution 2A "
                 ,LayerBraveValkyrie
                 ,Disk2A
                 ,Evolution
                 ,typeAttaque
                 ,1200
                 ,90
                 ,45
                 ,50
                 ,85
                 ,45
                 ,droite
                 ,"Toupie/valkyrie_gpt.png");
        ToupiePersonnage Hell_Salamander = new ToupiePersonnage("HellSalamander 12 Operate"
                ,LayerHellSalamander
                ,Disk12,
                Operate
                , typeEndurance
                ,1350
                ,60
                ,55
                ,85
                ,40
                ,70
                ,gauche
                ,"Toupie/Beyblade_Salamander.png");
         ToupiePersonnage Drain_Fafnir = new ToupiePersonnage("Drain Fafnir 8 Nothing "
                 ,LayerDrainFafnir
                 ,Disk8
                 ,Nothing
                 , typeEndurance
                 ,1400
                 ,50
                 ,40
                 ,90
                 ,30
                 ,80
                 ,gauche
                 ,"Toupie/fafnir_gpt.png");
        ToupiePersonnage Z_Achilles = new ToupiePersonnage("Z Achilles 11 Xtend"
                ,LayerZAchilles
                ,Disk11
                ,Xtend
                , typeAttaque
                ,1250
                ,85
                ,50
                ,60
                ,75
                ,55
                ,droite
                ,"Toupie/ZA_.11.Xt_2.png");
        ToupiePersonnage Lucifer_The_EndDB = new ToupiePersonnage("Lucifer The End"
                ,LayerLuciferTheEndDB
                ,DiskKou
                ,Drift
                , typeEndurance
                ,1700
                ,35
                ,80
                ,90

        ,25
        ,60
        ,droite
        ,"Toupie/BBSK_Lucifer_The_End_Kou_Drift_Beyblade.png");
        ToupiePersonnage Lucifer_The_EndSparking = new ToupiePersonnage("Lucifer The End"
                ,LayerLuciferTheEnd
                ,Chassis2D
                ,Drift
                , typeEndurance
                ,1800
                ,40
                ,85
                ,95

                ,30
                ,65
                ,droite
                ,"Toupie/BBSK_Lucifer_The_End_Kou_Drift_Beyblade.png");
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
        listToupie.add(Roar_Bahamut);
        listToupie.add(Lucifer_The_EndDB);
        listToupie.add(Lucifer_The_EndSparking);


        /*System.out.println("Indice de Kerbeus "+listToupie.indexOf(Kerbeus));
        System.out.println("Indice de Brave Valkyrie   "+listToupie.indexOf(Brave_Valkyrie));
        System.out.println("Indice de Drain Fafnir   "+listToupie.indexOf(Drain_Fafnir));*/

        KerbeusE = new ToupieEnnemie("Kerbeus Central Defense",LayerKerbeus,DiskCentral,Defense, typeDefense,300,2,8,5,droite,"Toupie/kerbeus_gpt.png");
        BraveValkyrieE =new ToupieEnnemie("Brave Valkyrie Evolution 2A ",LayerBraveValkyrie,Disk2A,Evolution, typeAttaque,350,9,3,2,droite,"Toupie/valkyrie_gpt.png");
        HellSalamanderE = new ToupieEnnemie("HellSalamander 12 Operate  ",LayerHellSalamander,Disk12,Operate, typeEndurance,330,4,5,6,gauche,"Toupie/Beyblade_Salamander.png");
        DrainFafnirE =new ToupieEnnemie("Drain Fafnir 8 Nothing ",LayerDrainFafnir,Disk8,Nothing, typeEndurance,335,2,3,9,gauche,"Toupie/fafnir_gpt.png");
        BushinAshuraE = new ToupieEnnemie("Bushin Ashura Hurricane Keep",LayerAshuraBushin,DiskHurricane,Keep, typeDefense,345,3,8,4,droite,"Toupie/BBGT_Bushin_Ashura_Hurricane_Keep_Ten_Beyblade.png");
        ZAchillesE =new ToupieEnnemie("Z Achilles 11 Xtend  ",LayerZAchilles,Disk11,Xtend, typeAttaque,340,7,4,4,droite,"Toupie/ZA_.11.Xt_2.png");

        listToupieEnnemie.add(KerbeusE);
        listToupieEnnemie.add(BraveValkyrieE);
        listToupieEnnemie.add(HellSalamanderE);
        listToupieEnnemie.add(DrainFafnirE);
        listToupieEnnemie.add(BushinAshuraE);
        listToupieEnnemie.add(ZAchillesE);

        System.out.println("Hell Salamander"+listToupieEnnemie.indexOf(HellSalamanderE));
        System.out.println("Kerbeus   "+listToupieEnnemie.indexOf(KerbeusE));
        System.out.println("Brave Valkyrie"+listToupieEnnemie.indexOf(BraveValkyrieE));
        System.out.println("Drain Fafnir  "+listToupieEnnemie.indexOf(DrainFafnirE));
        System.out.println("Bushin Ashura   "+listToupieEnnemie.indexOf(BushinAshuraE));
        System.out.println("Z achilles   "+listToupieEnnemie.indexOf(ZAchillesE));


       apLancerToupie.setOnKeyPressed(this::keyQTE);
        apLancerToupie.setFocusTraversable(true);
        apLancerToupie.requestFocus();










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
            writeRapideFloat(lblAttaqueToupie, listToupie.get(4).getAttaqueToupie());
            writeRapideInt(lblDefenseToupie, listToupie.get(4).getDefenseToupie());
            writeRapideInt(lblEnduranceToupie, listToupie.get(4).getEnduranceToupie());
            writeRapideFloat(lblVieMaxToupie, listToupie.get(4).getVieMaxToupie());
            writeRapideString(lblRotationToupie, String.valueOf(listToupie.get(4).getRotation().getTypeRotation()));
            writeRapideString(lblTypeToupie, String.valueOf(listToupie.get(4).getClasseToupie().getTypeToupie()));
            changeImageViewImg(imgRetour2,"Bouton_Spécial/Toupie_Retour.png");


        }
        if (choixToupie == 2){

            changeImageViewImg(imgToupiePerso,"Toupie/kerbeus_gpt.png");
            visible(apFichePerso);
            changeZone("Toupie/kerbeus_gpt.png",apFichePerso);
            writeRapideString(lblNomToupie, listToupie.get(0).getNomToupie());
            writeRapideFloat(lblAttaqueToupie, listToupie.get(0).getAttaqueToupie());
            writeRapideInt(lblDefenseToupie, listToupie.get(0).getDefenseToupie());
            writeRapideInt(lblEnduranceToupie, listToupie.get(0).getEnduranceToupie());
            writeRapideFloat(lblVieMaxToupie, listToupie.get(0).getVieMaxToupie());
            writeRapideString(lblRotationToupie, String.valueOf(listToupie.get(0).getRotation().getTypeRotation()));
            writeRapideString(lblTypeToupie, String.valueOf(listToupie.get(0).getClasseToupie().getTypeToupie()));
            changeImageViewImg(imgRetour2,"Bouton_Spécial/Toupie_Retour.png");

        }
        if (choixToupie == 3){
            changeImageViewImg(imgToupiePerso,"Toupie/valkyrie_gpt.png");
            visible(apFichePerso);
            changeZone("Toupie/valkyrie_gpt.png",apFichePerso);
            writeRapideString(lblNomToupie, listToupie.get(2).getNomToupie());
            writeRapideFloat(lblAttaqueToupie, listToupie.get(2).getAttaqueToupie());
            writeRapideInt(lblDefenseToupie, listToupie.get(2).getDefenseToupie());
            writeRapideInt(lblEnduranceToupie, listToupie.get(2).getEnduranceToupie());
            writeRapideFloat(lblVieMaxToupie, listToupie.get(2).getVieMaxToupie());
            writeRapideString(lblRotationToupie, String.valueOf(listToupie.get(2).getRotation().getTypeRotation()));
            writeRapideString(lblTypeToupie, String.valueOf(listToupie.get(2).getClasseToupie().getTypeToupie()));
            changeImageViewImg(imgRetour2,"Bouton_Spécial/Toupie_Retour.png");

        }

    }

    @FXML
    public void btnModeCombat(MouseEvent event) {
        clearAll();
        changeImageViewImg(imgMenuCombat , "Environnement/Fond-SelectionToupie2.png");
        visible(apSelectionAdversaire);
        changeZone("Environnement/Fond-SelectionToupie2.png",apSelectionAdversaire);
        writeRapideString(lblAdversaireValkyrie,"Brave Valkyrie");
        writeRapideString(lblAdversaireKerbeus,"Kerbeus");
        writeRapideString(lblAdversaireFafnir,"Fafnir");
        writeRapideString(lblAdversaireAshura,"Bushin Ashura");
        writeRapideString(lblAdversaireSalamander,"Hell Salamander");
        writeRapideString(lblAdversaireZachilles,"Z Achilles");
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
        int nombreAleatoire = (int) (Math.random()*9);
        ForgeDisc selectedDisc = disc.get(nombreAleatoire);
        changeImageViewImg(imgPieceToupie, selectedDisc.getUrlDisc());
        writeRapideInt(lblStatAttaque, selectedDisc.getStatAttaqueDisc());
        writeRapideInt(lblStatDefense, selectedDisc.getStatDefenseDisc());
        writeRapideInt(lblStatEndurance, selectedDisc.getStatEnduranceDisc());
        writeRapideInt(lblPoids, (int) selectedDisc.getPoidsDisc());




    }

    public void affichePerformanceTip(){
        int nombreAleatoire = (int) (Math.random()*8);
        PerformanceTip selectedTip = tip.get(nombreAleatoire);
        changeImageViewImg(imgPieceToupie, selectedTip.getUrlTip());
        writeRapideInt(lblStatAttaque, selectedTip.getStatAttaqueTip());
        writeRapideInt(lblStatDefense, selectedTip.getStatDefenseTip());
        writeRapideInt(lblStatEndurance, selectedTip.getStatEnduranceTip());
        writeRapideInt(lblPoids, (int) selectedTip.getPoidsTip());


    }
    public void afficheEnergyLayer(){
        int nombreAleatoire = (int) (Math.random()*15);
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
        invisible(apSelectionAdversaire);
        invisible(apLancerToupie);
        invisible(apDuelToupie);
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
    public void writeRapideFloat(Label lblTexte, float floatTexte)
    {
        lblTexte.setText(Float.toString(floatTexte));
        return;
    }

    @FXML
    public void btnDetailToupie(MouseEvent event) {
    }

    @FXML
    public void btnRetour2(MouseEvent event) {
        btnRetour(null);
    }

    @FXML
    public void btnAdvFafnir(MouseEvent event) {
        momentLancer();
        demarrerCompteARebours();
    }

    @FXML
    public void btnAdvZachilles(MouseEvent event) {
        momentLancer();
        demarrerCompteARebours();

    }

    @FXML
    public void btnAdvValkyrie(MouseEvent event) {
        momentLancer();
        demarrerCompteARebours();
    }

    @FXML
    public void btnAdvAshura(MouseEvent event) {
        momentLancer();
        demarrerCompteARebours();
    }

    @FXML
    public void btnAdvSalamander(MouseEvent event) {
        momentLancer();
        demarrerCompteARebours();
    }

    @FXML
    public void btnAdvKerbeus(MouseEvent event) {
        momentLancer();
        demarrerCompteARebours();
    }

    public void momentLancer(){
        clearAll();
        changeImageViewImg(imgStadium , "Environnement/Stadium_Beyblade.png");
        visible(apLancerToupie);
        changeZone("Environnement/Stadium_Beyblade.png",apLancerToupie);
    }

    public void demarrerCompteARebours() {
        List<String> etapes = List.of("3", "2", "1", "Hypervitesse !");
        Timeline timeline = new Timeline();

        // Sélection du joueur comme attaquant
        ToupiePersonnage attaquant = this.toupieJoueur; // ou le nom de ton joueur

        // Sélection de la cible ennemie aléatoire
        Random random = new Random();
        ToupieEnnemie cibleEnnemie = listToupieEnnemie.get(random.nextInt(listToupieEnnemie.size()));

        // Cast vers ToupiePersonnage
        ToupiePersonnage cible = (ToupiePersonnage) cibleEnnemie;

        for (int i = 0; i < etapes.size(); i++) {
            final int index = i;

            KeyFrame keyFrame = new KeyFrame(Duration.seconds(i + 1), e -> {
                lblLancer.setText(etapes.get(index));


                if (index == 0){// Lancer le QTE à 2 secondes
                    lancerQTEClavier();
                    boolean reussi = qteLancer.executerQTE();
                    qteLancer.setReussi(reussi); // si tu as une variable "reussi" dans la classe
                    float effet = qteLancer.appliquerEffets(attaquant, cible);


                    if (reussi) {
                        System.out.println("QTE réussi ! Effet bonus : " + effet);

                    } else {
                        System.out.println("QTE échoué... Malus : " + effet);


                    }
                }

            });
            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.setOnFinished(e -> {
            System.out.println("Go !");
            fight();
            System.out.println("Nous sommes bien passé dans apDuelToupie !!");
            // phase suivante
        });

        timeline.play();

    }
    public void fight(){
        clearAll();
        changeImageViewImg(imgStadium2 , "Environnement/Stadium_Beyblade.png");
        visible(apDuelToupie);
        changeZone("Environnement/Stadium_Beyblade.png",apDuelToupie);
    }



    @FXML
    public void keyQTE(KeyEvent event) {
        if (!qteEnCours || currentLetterIndex >= sequenceLettres.size()) return;

        String toucheAppuyee = event.getText().toUpperCase();

        // Vérifier si la touche correspond à la lettre actuelle
        if (toucheAppuyee.equals(sequenceLettres.get(currentLetterIndex))) {
            currentLetterIndex++;

            if (currentLetterIndex >= sequenceLettres.size()) {
                // Toutes les lettres sont réussies
                qteEnCours = false;
                lblQTE.setText("Succès !");
                qteLancer.setReussi(true);
            } else {
                // Passer à la lettre suivante
                afficherLettreActuelle();
                demarrerTimer();
            }
        } else {
            // Échec si mauvaise touche
            qteEnCours = false;
            lblQTE.setText("Raté !");
            qteLancer.setReussi(false);
        }
    }

    public void lancerQTEClavier() {
        List<String> lettres = List.of("A","B","C","D","E","F","G","H","I","J",
                "K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");

        // Générer 3 lettres aléatoires pour la séquence
        sequenceLettres.clear();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            sequenceLettres.add(lettres.get(random.nextInt(lettres.size())));
        }

        currentLetterIndex = 0;
        qteEnCours = true;

        // Afficher la première lettre et démarrer le timer
        afficherLettreActuelle();
        demarrerTimer();
    }
    private void afficherLettreActuelle() {
        if (currentLetterIndex < sequenceLettres.size()) {
            lettreActuelle = sequenceLettres.get(currentLetterIndex);
            lblQTE.setText(lettreActuelle);
        }
    }
    private void demarrerTimer() {
        if (timer != null) timer.stop();

        timer = new PauseTransition(Duration.seconds(1.5));
        timer.setOnFinished(e -> {
            if (qteEnCours) {
                qteEnCours = false;
                lblQTE.setText("Trop tard !");
                qteLancer.setReussi(false);
            }
        });
        timer.play();
    }


}
