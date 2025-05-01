package com.example.projet_toupie;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

import static com.example.projet_toupie.Tour.getNumeroTour;


public class HelloController implements Initializable {


    @FXML
    public AnchorPane apCommencement;
    @FXML
    public AnchorPane apMenuPrincipal;

    @FXML
    private AnchorPane apBoutique;

    private Node zoomableNode;
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
    private QTELancer qteLancer = new QTELancer(3); // Instance du QTE
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
    EnergyLayer e;
    private  ToupiePersonnage toupieJoueur = new ToupiePersonnage("",null,1000,1000,50,50,50,50,50,1000);
    private ToupieEnnemie toupieAdv = new ToupieEnnemie("",null,1000,1000,50,50,50,50,50);
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
    @FXML
    private ProgressBar barreVieToupiePerso;
    @FXML
    private Label lblNombrePVToupiePerso;
    @FXML
    private ProgressBar barrevieToupieEnnemie;
    @FXML
    private Label lblNombrePVToupieEnnemie;
    @FXML
    private Label lblToupieEnnModeCombat;
    @FXML
    private Label lblToupiePersoModeCombat;
    @FXML
    private Label lblTour;
    @FXML
    private Label lblNombreTour;
    @FXML
    private ImageView imgPourEsquiver;
    @FXML
    private ImageView imgPourAttaquer;
    @FXML
    private ImageView imgProtection;
    @FXML
    private ImageView imgRotationSteal;
    @FXML
    private ImageView imgModeSixLames;
    @FXML
    private ImageView imgFond;
    @FXML
    private ImageView imgModeTroisLames;
    @FXML
    private Label lblCombo;
    @FXML
    private Label lblInfo;
    @FXML
    private AnchorPane apCollection;
    String imageName;


    @FXML
    private ImageView imgPiece;


    int choixToupie = 0;
    int choixToupieEnn = 0;
    /*ToupiePersonnage Drain_Fafnir;
    ToupiePersonnage Brave_Valkyrie;
    ToupiePersonnage Kerbeus;*/
    private int nombreAttaquesEvolution = 0;
    int colonne = 0;
    int ligne = 0;




    ClasseToupie typeAttaque = new ClasseToupie("Attaque");
    ClasseToupie typeDefense = new ClasseToupie("Défense");
    ClasseToupie typeEndurance = new ClasseToupie("Endurance");
    ClasseToupie typeEquilibre = new ClasseToupie("Equilibre");

    Rotation droite = new Rotation("droite");
    Rotation gauche = new Rotation("gauche");
    Rotation doubleRotation = new Rotation("double-rotation");

    ToupieEnnemie KerbeusE;
    ToupieEnnemie BraveValkyrieE;
    ToupieEnnemie HellSalamanderE;
    ToupieEnnemie DrainFafnirE;
    ToupieEnnemie ZAchillesE;
    ToupieEnnemie BushinAshuraE;




    ToupiePersonnage t = new ToupiePersonnage("null",null,null,null,null,0,0,0,0,0,0,0,null,"null");
    @FXML
    private GridPane gridCollectionDisc;
    @FXML
    private GridPane gridCollectionLayer;
    @FXML
    private AnchorPane apCollectionSuite;
    @FXML
    private GridPane gridCollectionTip;
    @FXML
    private ImageView imgFondCollectionSuite;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clearAll();
        visible(apCommencement);
        invisibleImage(imgProtection);
        invisibleImage(imgRotationSteal);
        Font policeLuckiestGuy = Font.loadFont(getClass().getResourceAsStream("/fonts/LuckiestGuy-Regular.ttf"), 42);
        lblCombo.setFont(policeLuckiestGuy);



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
        tip.add(Nothing);
        tip.add(Xtend);
        tip.add(Operate);
        tip.add(Evolution);
        tip.add(Drift);


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
        /*EnergyLayer LayerAshuraBushinChip = new EnergyLayer("Ashura", EnergyLayer.SystemeLayer.GT, droite, 15, 20, 10, 2.9f, "Energy_Layer/GatinkoChipAshura.png", gtLayerBushin);
        EnergyLayer LayerAshuraBushinWeight = new EnergyLayer("Ten", EnergyLayer.SystemeLayer.GT, droite, 5, 15, 10, 4.6f, "Energy_Layer/LayerWeightTen.png", gtLayerBushin);
        EnergyLayer LayerAshuraBushinBase = new EnergyLayer("Bushin", EnergyLayer.SystemeLayer.GT, droite, 10, 40, 15, 7.3f, "Energy_Layer/LayerBaseBushin.png", gtLayerBushin);*/
        EnergyLayer LayerAshuraBushin = new EnergyLayer("Bushin Ashura", EnergyLayer.SystemeLayer.GT, droite, 30, 70, 35, 20.2f, "", gtLayerBushin);

// Pièces spéciales
        /*EnergyLayer LayerEndBlade = new EnergyLayer(" The End "
                , EnergyLayer.SystemeLayer.DB
                , droite
                , 95
                , 60
                , 30
                , 30
                , "Energy_Layer/BladeEndCore.png"
                ,dbLuciferKou);*/
        /*EnergyLayer LayerLuciferARmor= new EnergyLayer("Lucifer"
                , EnergyLayer.SystemeLayer.DB
                , gauche
                , 70
                , 80
                , 25
                , 25
                , "Energy_Layer/CoreLuciferII.png"
                ,dbLuciferKou);*/
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

        /*EnergyLayer LayerBladeRoar = new EnergyLayer("Roar"
                , EnergyLayer.SystemeLayer.DB
                , droite
                , 85
                , 50
                , 35
                , 28
                , "Energy_Layer/BladeRoar.png"
                ,DbGiga);*/
        /*EnergyLayer LayerArmor10 = new EnergyLayer(" 10"
                , EnergyLayer.SystemeLayer.DB
                , droite
                , 10
                , 70
                , 45
                , 18
                , "Energy_Layer/Armor10.png"
                ,DbGiga);*/
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
        /*EnergyLayer LayerLuciferTheEndDB = new EnergyLayer(
                "Lucifer The End",
                EnergyLayer.SystemeLayer.DB,
                droite,
                45,  // attaque
                60,  // défense
                65,  // endurance
                24.3f, // poids
                "Energy_Layer/LayerLuciferTheEndDB.png",
                dbLuciferKou
        );*/
        layer.add(LayerKerbeus);
        layer.add(LayerHellSalamander);
        layer.add(LayerDrainFafnir);
        layer.add(LayerZAchilles);
        layer.add(LayerBraveValkyrie);




        layer.add(RingTheEnd);
        layer.add(superkingChipLucifer);



        ToupiePersonnage Kerbeus = new ToupiePersonnage("Kerbeus Central Defense"
                ,LayerKerbeus
                ,DiskCentral
                ,Defense,
                typeDefense,
                1500,
                1500,
                35,
                85,
                60,
                20,
                65,
                droite,
                "Toupie/kerbeus_gpt.png");
        /*ToupiePersonnage Bushin_Ashura = new ToupiePersonnage("Bushin Ashura Hurricane Keep"
                ,LayerAshuraBushin
                ,DiskHurricane
                ,Keep
                ,typeDefense
                ,1450
                ,1450
                ,45
                ,80
                ,65
                ,25
                ,75
                ,droite
                ,"Toupie/BBGT_Bushin_Ashura_Hurricane_Keep_Ten_Beyblade.png");*/
        /*ToupiePersonnage Roar_Bahamut = new ToupiePersonnage("Roar Bahamut"
                ,LayerRoarBahamut
                ,DiskGiga
                ,Moment
                , typeDefense
                ,1800
                ,1800
                ,30
                ,90
                ,70

                ,20
                ,55
                ,gauche
                ,"Toupie/Roar_Bahamut.png");*/
         ToupiePersonnage Brave_Valkyrie = new ToupiePersonnage("Brave Valkyrie Evolution 2A "
                 ,LayerBraveValkyrie
                 ,Disk2A
                 ,Evolution
                 ,typeAttaque
                 ,1200
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
                , typeEquilibre
                ,1250
                ,1250
                ,85
                ,50
                ,60
                ,75
                ,55
                ,droite
                ,"Toupie/ZA_.11.Xt_2.png");
        /*ToupiePersonnage Lucifer_The_EndDB = new ToupiePersonnage("Lucifer The End"
                ,LayerLuciferTheEndDB
                ,DiskKou
                ,Drift
                , typeEndurance
                ,1700
                ,1700
                ,35
                ,80
                ,90

        ,25
        ,60
        ,droite
        ,"Toupie/BBSK_Lucifer_The_End_Kou_Drift_Beyblade.png");*/
        ToupiePersonnage Lucifer_The_EndSparking = new ToupiePersonnage("Lucifer The End"
                ,LayerLuciferTheEnd
                ,Chassis2D
                ,Drift
                , typeEndurance
                ,1800
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

        listToupie.add(Brave_Valkyrie);
        listToupie.add(Hell_Salamander);
        listToupie.add(Drain_Fafnir);
        listToupie.add(Z_Achilles);


        listToupie.add(Lucifer_The_EndSparking);



      System.out.println("Indice de Kerbeus "+listToupie.indexOf(Kerbeus));
        System.out.println("Indice de Brave Valkyrie   "+listToupie.indexOf(Brave_Valkyrie));
        System.out.println("Indice de Drain Fafnir   "+listToupie.indexOf(Drain_Fafnir));
        System.out.println("Indice de Z Achilles "+listToupie.indexOf(Z_Achilles));
        System.out.println("Indice de Hell Salamander  "+listToupie.indexOf(Hell_Salamander));
        System.out.println("Indice de Lucifer the end   "+listToupie.indexOf(Lucifer_The_EndSparking));

        KerbeusE = new ToupieEnnemie("Kerbeus Central Defense"
                ,LayerKerbeus
                ,DiskCentral
                ,Defense
                , typeDefense,

                2000,
                2000,
                35,
                85,
                60,
                20,
                65,
                droite
                ,"Toupie/kerbeus_gpt.png");
        BraveValkyrieE =new ToupieEnnemie("Brave Valkyrie Evolution 2A "
                ,LayerBraveValkyrie
                ,Disk2A
                ,Evolution
                , typeAttaque
                ,
                1700
                ,
                1700
                ,90
                ,45
                ,50
                ,85
                ,45
                ,droite
                ,"Toupie/valkyrie_gpt.png");
        HellSalamanderE = new ToupieEnnemie("HellSalamander 12 Operate"
                ,LayerHellSalamander
                ,Disk12,Operate
                , typeEquilibre
                ,
                1750
                ,1750
                ,60
                ,55
                ,85
                ,40
                ,70
                ,gauche
                ,"Toupie/Beyblade_Salamander.png");
        DrainFafnirE =new ToupieEnnemie("Drain Fafnir 8 Nothing "
                ,LayerDrainFafnir
                ,Disk8
                ,Nothing
                , typeEndurance
                ,1900
                ,1900
                ,50
                ,40
                ,90
                ,30
                ,80
                ,gauche
                ,"Toupie/fafnir_gpt.png");
        BushinAshuraE = new ToupieEnnemie("Bushin Ashura Hurricane Keep"
                ,LayerAshuraBushin
                ,DiskHurricane
                ,Keep
                , typeDefense
                ,1950
                ,1950
                ,45
                ,80
                ,65
                ,25
                ,75
                ,droite
                ,"Toupie/BBGT_Bushin_Ashura_Hurricane_Keep_Ten_Beyblade.png");
        ZAchillesE =new ToupieEnnemie("Z Achilles 11 Xtend"
                ,LayerZAchilles
                ,Disk11
                ,Xtend
                , typeEquilibre
                ,1750
                ,1750
                ,85
                ,50
                ,60
                ,75
                ,55
                ,droite
                ,"Toupie/ZA_.11.Xt_2.png");

        listToupieEnnemie.add(KerbeusE);
        listToupieEnnemie.add(BraveValkyrieE);
        listToupieEnnemie.add(HellSalamanderE);
        listToupieEnnemie.add(DrainFafnirE);
        listToupieEnnemie.add(BushinAshuraE);
        listToupieEnnemie.add(ZAchillesE);




       /*apLancerToupie.setOnKeyPressed(this::keyQTE);
        apLancerToupie.setFocusTraversable(true);
        apLancerToupie.requestFocus();*/
        System.out.println("Hell Salamander"+listToupieEnnemie.indexOf(HellSalamanderE));
        System.out.println("Kerbeus   "+listToupieEnnemie.indexOf(KerbeusE));
        System.out.println("Brave Valkyrie"+listToupieEnnemie.indexOf(BraveValkyrieE));
        System.out.println("Drain Fafnir  "+listToupieEnnemie.indexOf(DrainFafnirE));
        System.out.println("Bushin Ashura   "+listToupieEnnemie.indexOf(BushinAshuraE));
        System.out.println("Z achilles   "+listToupieEnnemie.indexOf(ZAchillesE));










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
    public void visibleImage(ImageView  label){
        label.setVisible(true);

    }
    public void invisibleImage(ImageView label){
       label.setVisible(false);

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
        writeRapideInt(lblBeyPoint,toupieJoueur.getNombreBeyPoints());


    }

    @FXML
    public void btnFichePerso(MouseEvent event) {
        clearAll();
        if (choixToupie == 1){
            writeRapideString(lblNomToupie, listToupie.get(3).getNomToupie());
            changeImageViewImg(imgToupiePerso,"Toupie/fafnir_gpt.png");
            visible(apFichePerso);
            changeZone("Toupie/fafnir_gpt.png",apFichePerso);
            writeRapideFloat(lblAttaqueToupie, listToupie.get(3).getAttaqueToupie());
            writeRapideInt(lblDefenseToupie, listToupie.get(3).getDefenseToupie());
            writeRapideInt(lblEnduranceToupie, listToupie.get(3).getEnduranceToupie());
            writeRapideFloat(lblVieMaxToupie, listToupie.get(3).getVieMaxToupie());
            writeRapideString(lblRotationToupie, String.valueOf(listToupie.get(3).getRotation().getTypeRotation()));
            writeRapideString(lblTypeToupie, String.valueOf(listToupie.get(3).getClasseToupie().getTypeToupie()));
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
            writeRapideString(lblNomToupie, listToupie.get(1).getNomToupie());
            writeRapideFloat(lblAttaqueToupie, listToupie.get(1).getAttaqueToupie());
            writeRapideInt(lblDefenseToupie, listToupie.get(1).getDefenseToupie());
            writeRapideInt(lblEnduranceToupie, listToupie.get(1).getEnduranceToupie());
            writeRapideFloat(lblVieMaxToupie, listToupie.get(1).getVieMaxToupie());
            writeRapideString(lblRotationToupie, String.valueOf(listToupie.get(1).getRotation().getTypeRotation()));
            writeRapideString(lblTypeToupie, String.valueOf(listToupie.get(1).getClasseToupie().getTypeToupie()));
            changeImageViewImg(imgRetour2,"Bouton_Spécial/Toupie_Retour.png");

        }

    }
    @FXML
    public void btnCollectionToupie(MouseEvent event) {
        clearAll();
        visible(apCollection);

        if (choixToupie == 1){
            remplacerCadenasParImage(gridCollectionDisc,0,0,"Forge_Discs/Disk8.png");

        }
        if (choixToupie == 2){
            String imagePath = "Forge_Discs/DiskCentral.png";
            Image newImage = new Image(getClass().getResourceAsStream(imagePath));
            ImageView newImageView = new ImageView(newImage);
            gridCollectionDisc.add(newImageView,0,0);

        }
        if (choixToupie == 3){
            String imagePath = "Forge_Discs/ForgeDisc_2A.png";
            Image newImage = new Image(getClass().getResourceAsStream(imagePath));
            ImageView newImageView = new ImageView(newImage);
            gridCollectionDisc.add(newImageView,0,0);

        }


    }
    public void remplacerCadenasParImage(GridPane gridCible, int targetRow, int targetColumn, String nomImage) {
        // Chemin vers le dossier contenant les images
        String cheminBase = "/fr/menu/collection/"; // Adaptez selon votre structure
        Image nouvelleImage = new Image(getClass().getResourceAsStream(cheminBase + nomImage));
        ImageView nouvelleImageView = new ImageView(nouvelleImage);

        // Configuration de la taille si nécessaire
        nouvelleImageView.setFitWidth(100);
        nouvelleImageView.setFitHeight(100);
        nouvelleImageView.setPreserveRatio(true);

        // Suppression des éléments existants dans la cellule cible
        gridCible.getChildren().removeIf(node ->
                GridPane.getRowIndex(node) != null &&
                        GridPane.getColumnIndex(node) != null &&
                        GridPane.getRowIndex(node) == targetRow &&
                        GridPane.getColumnIndex(node) == targetColumn
        );

        // Ajout de la nouvelle image
        gridCible.add(nouvelleImageView, targetColumn, targetRow);
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
        changeImageViewImg(imgInvocation, "Environnement/Fond-Invocation.png");
        visible(apInvocation);
        changeZone("Environnement/Fond-Invocation.png", apInvocation);

        if (toupieJoueur.getNombreBeyPoints() >= 700) {

            invoquerPiece();

            toupieJoueur.setNombreBeyPoints(toupieJoueur.getNombreBeyPoints() - 700);
            writeRapideInt(lblBeyPoint, toupieJoueur.getNombreBeyPoints());

        } else {


            clearAll();
            //toupieJoueur.setNombreBeyPoints(t.getNombreBeyPoints());
            changeImageViewImg(imgFond,"Environnement/fond-boutique_2.png");
            visible(apBoutique);
            changeZone("Environnement/fond-boutique_2.png",apBoutique);
            changeImageViewImg(imgCoffre,"Bouton_Spécial/toupie-invocation.png");
            changeImageViewImg(imgRetour,"Bouton_Spécial/Toupie_Retour.png");
            changeImageViewImg(imgLogo,"Logo/Logo_BeyPoint.png");
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Pas Assez de BeyPoints");
            a.setContentText(null);
            a.setHeaderText("Il vous manque " + (700 - toupieJoueur.getNombreBeyPoints()) + " BeyPoints");
            a.showAndWait();

        }
    }


    public void invoquerPiece() {
        Random random = new Random();
        int pieceType = random.nextInt(3); // 0 = EnergyLayer, 1 = ForgeDisc, 2 = PerformanceTip

        switch (pieceType) {
            case 0:
                EnergyLayer newLayer = layer.get(random.nextInt(layer.size())); // Choix aléatoire dans la liste
                toupieJoueur.getCollectionPieces().ajouterEnergyLayer(newLayer);
                afficherInfoPiece("Energy Layer", newLayer.getNomLayer());
                changeImageViewImg(imgPieceToupie, newLayer.getUrlLayer());
                writeRapideInt(lblStatAttaque, newLayer.getStatAttaqueLayer());
                writeRapideInt(lblStatDefense, newLayer.getStatDefenseLayer());
                writeRapideInt(lblStatEndurance, newLayer.getStatEnduranceLayer());
                writeRapideInt(lblPoids, (int) newLayer.getPoidsLayer());
                break;

            case 1:
                ForgeDisc newDisc = disc.get(random.nextInt(disc.size()));
                toupieJoueur.getCollectionPieces().ajouterForgeDisc(newDisc);
                afficherInfoPiece("Forge Disc", newDisc.getNomDisc());
                changeImageViewImg(imgPieceToupie, newDisc.getUrlDisc());
                writeRapideInt(lblStatAttaque, newDisc.getStatAttaqueDisc());
                writeRapideInt(lblStatDefense, newDisc.getStatDefenseDisc());
                writeRapideInt(lblStatEndurance, newDisc.getStatEnduranceDisc());
                writeRapideInt(lblPoids, (int) newDisc.getPoidsDisc());
                break;

            case 2:
                PerformanceTip newTip = tip.get(random.nextInt(tip.size()));
                toupieJoueur.getCollectionPieces().ajouterPerformanceTip(newTip);
                afficherInfoPiece("Performance Tip", newTip.getNomTip());
                changeImageViewImg(imgPieceToupie, newTip.getUrlTip());
                writeRapideInt(lblStatAttaque, newTip.getStatAttaqueTip());
                writeRapideInt(lblStatDefense, newTip.getStatDefenseTip());
                writeRapideInt(lblStatEndurance, newTip.getStatEnduranceTip());
                writeRapideInt(lblPoids, (int) newTip.getPoidsTip());
                break;
        }
    }
    public void afficherInfoPiece(String type, String nom) {


       lblInfo.setText(nom + " (" + type + ")");
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
        invisible(apCollection);
        invisible(apCollectionSuite);

    }



    @FXML
    public void btnRetour(MouseEvent mouseEvent) {
        clearAll();
        changeImageViewImg(imgFond,"Environnement/Ecran_d'accueil_3.png");
        visible(apMenuPrincipal);
        changeZone("Environnement/Ecran_d'accueil_3.png",apMenuPrincipal);
    }
public void retourMenu(){
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
    @FXML
    public void btnSuivant2(MouseEvent event) {
        clearAll();
        visible(apCollectionSuite);
    }
    @FXML
    public void btnPrecedent(MouseEvent event) {
        clearAll();
        visible(apCollection);
    }

    @FXML
    public void btnRetour3(MouseEvent event) {
        clearAll();
        visible(apFichePerso);
    }

    @FXML
    public void btnRetour4(MouseEvent event) {
        clearAll();
        visible(apFichePerso);
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
    public void btnRetour2(MouseEvent event) {
        btnRetour(null);
    }

    @FXML
    public void btnAdvFafnir(MouseEvent event) {
        momentLancer();
        if (choixToupie == 1){
            demarrerCompteARebours(listToupie.get(3).getNomToupie(),listToupieEnnemie.get(3).getNomToupieEnnemie());

        }
        if (choixToupie == 2){
            demarrerCompteARebours(listToupie.get(0).getNomToupie(),listToupieEnnemie.get(3).getNomToupieEnnemie());

        }
        if (choixToupie == 3){
            demarrerCompteARebours(listToupie.get(3).getNomToupie(),listToupieEnnemie.get(3).getNomToupieEnnemie());

        }
        toupieAdv = listToupieEnnemie.get(3);

        initialiserCombat("Toupie/fafnir_gpt.png",3);
        //choixToupieEnn = 1;
    }

    @FXML
    public void btnAdvZachilles(MouseEvent event) {
        momentLancer();
        if (choixToupie == 1){
            demarrerCompteARebours(listToupie.get(3).getNomToupie(),listToupieEnnemie.get(5).getNomToupieEnnemie());

        }
        if (choixToupie == 2){
            demarrerCompteARebours(listToupie.get(0).getNomToupie(),listToupieEnnemie.get(5).getNomToupieEnnemie());

        }
        if (choixToupie == 3){
            demarrerCompteARebours(listToupie.get(1).getNomToupie(),listToupieEnnemie.get(5).getNomToupieEnnemie());

        }
        toupieAdv = listToupieEnnemie.get(5);
        initialiserCombat("Toupie/ZA_.11.Xt_2.png",5);
        //choixToupieEnn = 2;


    }

    @FXML
    public void btnAdvValkyrie(MouseEvent event) {
        momentLancer();
        if (choixToupie == 1){
            demarrerCompteARebours(listToupie.get(3).getNomToupie(),listToupieEnnemie.get(2).getNomToupieEnnemie());

        }
        if (choixToupie == 2){
            demarrerCompteARebours(listToupie.get(0).getNomToupie(),listToupieEnnemie.get(2).getNomToupieEnnemie());

        }
        if (choixToupie == 3){
            demarrerCompteARebours(listToupie.get(1).getNomToupie(),listToupieEnnemie.get(2).getNomToupieEnnemie());

        }

        toupieAdv = listToupieEnnemie.get(1);

        initialiserCombat("Toupie/valkyrie_gpt.png",1);
        //choixToupieEnn = 3;


    }

    @FXML
    public void btnAdvAshura(MouseEvent event) {
        momentLancer();
        if (choixToupie == 1){
            demarrerCompteARebours(listToupie.get(3).getNomToupie(),listToupieEnnemie.get(4).getNomToupieEnnemie());

        }
        if (choixToupie == 2){
            demarrerCompteARebours(listToupie.get(0).getNomToupie(),listToupieEnnemie.get(4).getNomToupieEnnemie());

        }
        if (choixToupie == 3){
            demarrerCompteARebours(listToupie.get(1).getNomToupie(),listToupieEnnemie.get(4).getNomToupieEnnemie());

        }
        toupieAdv = listToupieEnnemie.get(4);
        initialiserCombat("Toupie/BBGT_Bushin_Ashura_Hurricane_Keep_Ten_Beyblade.png",4);
        //choixToupieEnn = 4;

    }

    @FXML
    public void btnAdvSalamander(MouseEvent event) {
        momentLancer();
        if (choixToupie == 1){
            demarrerCompteARebours(listToupie.get(3).getNomToupie(),listToupieEnnemie.get(2).getNomToupieEnnemie());

        }
        if (choixToupie == 2){
            demarrerCompteARebours(listToupie.get(0).getNomToupie(),listToupieEnnemie.get(2).getNomToupieEnnemie());

        }
        if (choixToupie == 3){
            demarrerCompteARebours(listToupie.get(1).getNomToupie(),listToupieEnnemie.get(2).getNomToupieEnnemie());

        }
        toupieAdv = listToupieEnnemie.get(2);
        initialiserCombat("Toupie/Beyblade_Salamander.png",2);
        //choixToupieEnn = 5;

    }

    @FXML
    public void btnAdvKerbeus(MouseEvent event) {
        momentLancer();
        if (choixToupie == 1){
            demarrerCompteARebours(listToupie.get(3).getNomToupie(),listToupieEnnemie.get(0).getNomToupieEnnemie());


        }
        if (choixToupie == 2){

            demarrerCompteARebours(listToupie.get(0).getNomToupie(),listToupieEnnemie.get(0).getNomToupieEnnemie());
            //btnProtection(null);


        }
        if (choixToupie == 3){
            demarrerCompteARebours(listToupie.get(1).getNomToupie(),listToupieEnnemie.get(0).getNomToupieEnnemie());

        }
        toupieAdv = listToupieEnnemie.get(0);

        initialiserCombat("Toupie/kerbeus_gpt.png",0);
        //choixToupieEnn = 6;

    }
    public void initialiserCombat(String imgToupie,int indiceToupieEnn){

        changeImageViewImg(imgToupieDeEnnemi,imgToupie);
        writeRapideFloat(lblNombrePVToupieEnnemie,listToupieEnnemie.get(indiceToupieEnn).getVieActuelleEnnemie());
        writeRapideString(lblToupieEnnModeCombat,listToupieEnnemie.get(indiceToupieEnn).getNomToupieEnnemie());
        invisibleImage(imgProtection);
        invisibleImage(imgRotationSteal);
        invisibleImage(imgModeSixLames);
        invisibleImage(imgModeTroisLames);

        if (choixToupie == 1){
            affichageCombatGenerique("Toupie/fafnir_gpt.png",
                    listToupie.get(3).getVieActuelleToupie(),
                    listToupie.get(3).getNomToupie()
                    );
            visibleImage(imgRotationSteal);

        }
        if (choixToupie == 2){

            affichageCombatGenerique("Toupie/kerbeus_gpt.png",
                    listToupie.get(0).getVieActuelleToupie(),
                    listToupie.get(0).getNomToupie()
                    );
            visibleImage(imgProtection);



        }
        if (choixToupie == 3){
            affichageCombatGenerique("Toupie/valkyrie_gpt.png"
                    ,listToupie.get(1).getVieActuelleToupie()
                    ,listToupie.get(1).getNomToupie()
            );
            visibleImage(imgModeSixLames);
            invisibleImage(imgProtection);

        }


    }


    public void momentLancer(){
        clearAll();
        changeImageViewImg(imgStadium , "Environnement/Stadium_Beyblade.png");
        visible(apLancerToupie);
        changeZone("Environnement/Stadium_Beyblade.png",apLancerToupie);
    }




    public void demarrerCompteARebours(String nomJoueur, String nomAdversaire) {
        List<String> etapes = List.of("3", "2", "1", "Hypervitesse !");
        Timeline timeline = new Timeline();

        // --- Initialisation du QTE ---
        sequenceLettres.clear();
        List<String> lettres = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z");
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            sequenceLettres.add(lettres.get(random.nextInt(lettres.size())));
        }

        currentLetterIndex = 0;
        qteEnCours = false;
        qteLancer = new QTELancer(sequenceLettres.size());

        for (int i = 0; i < etapes.size(); i++) {
            final int index = i;
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(i + 1), e -> {
                lblLancer.setText(etapes.get(index));

                if (index == etapes.size() - 1) {
                    PauseTransition attenteAvantQTE = new PauseTransition(Duration.seconds(1));
                    attenteAvantQTE.setOnFinished(ev -> {
                        qteEnCours = true;
                        afficherLettreActuelle();
                        demarrerTimer();
                    });
                    attenteAvantQTE.play();
                }
            });
            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.setOnFinished(e -> {
            // Le QTE peut durer jusqu'à 2s x 4 lettres = 8s, donc délai suffisant ici
            PauseTransition suite = new PauseTransition(Duration.seconds(9));
            suite.setOnFinished(ev -> {
                qteEnCours = false;

                // Appliquer les effets QTE
                ToupiePersonnage toupieJoueur = listToupie.get(choixToupie - 1);
                qteLancer.appliquerEffetQTE(toupieJoueur, qteLancer.isReussi());

                // ✅ Afficher les résultats avant de continuer
                String message;
                if (qteLancer.isReussi()) {
                    message = "QTE Réussi !\n\n"
                            + "Attaque +10\n"
                            + "Endurance +10\n";
                    if ("Défense".equalsIgnoreCase(toupieJoueur.getClasseToupie().getTypeToupie())) {
                        message += "Bonus Défenseur :\nAttaque +5, Endurance +5, Défense +7";
                    }
                } else {
                    message = "QTE Raté...\n\n"
                            + "Attaque -10\n"
                            + "Endurance -10";
                }

                String finalMessage = message;
                Platform.runLater(() -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Résultat du QTE");
                    alert.setHeaderText("Effets appliqués à votre toupie");
                    alert.setContentText(finalMessage);

                    alert.showAndWait(); // attend que le joueur ferme l'alerte

                    // Initialiser les toupies après la fermeture de l'alerte
                    initialiserToupies(nomJoueur, nomAdversaire);

                    PauseTransition pause = new PauseTransition(Duration.seconds(1));
                    pause.setOnFinished(ev2 -> fight());
                    pause.play();
                });

            });
            suite.play();
        });

        timeline.play();
    }




    @Deprecated
    public void keyQTE(KeyEvent event) {
        if (!qteEnCours || currentLetterIndex >= sequenceLettres.size()) return;

        String toucheAppuyee = event.getText().toUpperCase();

        if (toucheAppuyee.equals(sequenceLettres.get(currentLetterIndex))) {
            currentLetterIndex++;

            if (currentLetterIndex >= sequenceLettres.size()) {
                qteEnCours = false;
                lblQTE.setText("Succès !");
                qteLancer.setReussi(true); // ✅ Marque comme réussi
            } else {
                afficherLettreActuelle();
                demarrerTimer();
            }
        } else {
            qteEnCours = false;
            lblQTE.setText("Raté !");
            qteLancer.setReussi(false); // ✅ Marque comme raté
        }
    }



    private void afficherLettreActuelle() {
        if (currentLetterIndex < sequenceLettres.size()) {
            lblQTE.setText(sequenceLettres.get(currentLetterIndex));
        }
    }

    private void demarrerTimer() {
        if (timer != null) timer.stop();

        timer = new PauseTransition(Duration.seconds(2));
        timer.setOnFinished(e -> {
            currentLetterIndex++;
            if (currentLetterIndex < sequenceLettres.size()) {
                afficherLettreActuelle();
                demarrerTimer();
            } else {
                qteEnCours = false;
                lblQTE.setText(qteLancer.isReussi() ? "Succès !" : "Raté !");
            }
        });
        timer.play();
    }






    public void fight(){
        clearAll();


        changeImageViewImg(imgStadium2 , "Environnement/Stadium_Beyblade.png");
        visible(apDuelToupie);
        changeZone("Environnement/Stadium_Beyblade.png",apDuelToupie);

    }
    public void initialiserToupies(String nomJoueur, String nomAdversaire) {
        for (ToupiePersonnage toupie : listToupie) {
            if (toupie.getNomToupie().equalsIgnoreCase(nomJoueur)) {
                this.toupieJoueur = toupie;
                break;
            }
        }

        for (ToupieEnnemie toupie : listToupieEnnemie) {
            if (toupie.getNomToupieEnnemie().equalsIgnoreCase(nomAdversaire)) {
                this.toupieAdv = toupie;
                break;
            }
        }
        /*if (toupieJoueur.isReussi()){
            toupieJoueur.appliquerEffetQTE(toupieJoueur.isReussi());
        }else {
            toupieJoueur.setReussi(false);
            toupieJoueur.appliquerEffetQTE(toupieJoueur.isReussi());
        }*/

        //fight();
    }








    public void vitaMajJoueur() {
        writeRapideFloat(lblNombrePVToupiePerso,toupieJoueur.getVieActuelleToupie() );


    }
    public void vitaMajAdv() {

        writeRapideFloat(lblNombrePVToupieEnnemie,toupieAdv.getVieActuelleEnnemie());

    }

    public void affichageCombatGenerique(String imageToupie, float vie, String nom) {
        int nombreTour = 1;
        changeImageViewImg(imgToupieDuPerso, imageToupie);
        writeRapideFloat(lblNombrePVToupiePerso, vie);
        writeRapideString(lblToupiePersoModeCombat, nom);
        changeImageViewImg(imgPourAttaquer, "Bouton-Combat/Bouton-attaque.png");
        changeImageViewImg(imgPourEsquiver, "Bouton-Combat/Bouton-esquive.png");
        changeImageViewImg(imgProtection,"Bouton-Combat/Bouton-protection.png");
        changeImageViewImg(imgRotationSteal,"Bouton-Combat/Bouton-RotationSteal.png");
        lblTour.setVisible(true);
        writeRapideInt(lblNombreTour, nombreTour);

    }

    @FXML
    public void btnClickAttaque(MouseEvent event) {
        int nombre_A = alea();
        float pourcentageJoueur = toupieJoueur.getVieActuelleToupie() / toupieJoueur.getVieMaxToupie();
        float pourcentageAdv= toupieAdv.getVieActuelleEnnemie() / toupieAdv.getVieMaxEnnemie();
        if (toupieAdv.getVieActuelleEnnemie() > 0 && toupieJoueur.getVieActuelleToupie() > 0) {
            float degat = toupieAdv.attaqueGlobale();
            if (toupieJoueur.isModeSixLames()) {
                int nombreCoups;
                if (nombre_A < 8) {
                    nombreCoups = 5;
                } else if (nombre_A < 25) {
                    nombreCoups = 4;
                } else if (nombre_A < 45) {
                    nombreCoups = 3;
                } else if (nombre_A < 75) {
                    nombreCoups = 2;
                } else {
                    nombreCoups = 1;
                }

                for (int i = 0; i < nombreCoups; i++) {
                     degat = toupieJoueur.barrage();

                    // BOOST Evolution
                    if ("Evolution".equalsIgnoreCase(toupieJoueur.getPerformanceTip().getNomTip())) {
                        nombreAttaquesEvolution++;
                        float bonus = 1.0f + 0.02f * nombreAttaquesEvolution;
                        degat *= bonus;
                    }

                    toupieAdv.perdrePDV(degat);

                }
                afficherCombo(nombreCoups);
                barreVieToupiePerso.setProgress(pourcentageJoueur);
                vitaMajAdv();
            } else {
                 degat = toupieJoueur.attaqueGlobale();

                // BOOST Evolution
                if ("Evolution".equalsIgnoreCase(toupieJoueur.getPerformanceTip().getNomTip())) {
                    nombreAttaquesEvolution++;
                    float bonus = 1.0f + 0.05f * nombreAttaquesEvolution;
                    degat *= bonus;
                }

                toupieAdv.perdrePDV(degat);
                barreVieToupiePerso.setProgress(pourcentageJoueur);
                vitaMajAdv();
            }


            if (toupieAdv.getVieActuelleEnnemie() != 0) {
                attaqueAdverse();
                barrevieToupieEnnemie.setProgress(pourcentageAdv);
                vitaMajJoueur();
            }
        }

        if (toupieJoueur.getVieActuelleToupie() <= 0 && toupieAdv.getVieActuelleEnnemie() > 0) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Dommage");
            a.setContentText(null);
            a.setHeaderText("Vous avez Perdu !");
            a.showAndWait();
            toupieJoueur.setVieActuelle(0);
            retourMenu();
            reinitialisation();
            reinitialisationBarre();
            writeRapideInt(lblNombreTour, 1);
            nombreAttaquesEvolution = 0; // Reset Evolution
        }

        if (toupieJoueur.getVieActuelleToupie() > 0 && toupieAdv.getVieActuelleEnnemie() <= 0) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Félicitation ");
            a.setContentText("Votre Récompense :" + toupieJoueur.getNombreBeyPoints() + " BeyPoints");
            a.setHeaderText("Vous avez Gagné !");
            a.showAndWait();
            toupieJoueur.setVieActuelle(0);
            retourMenu();
            reinitialisation();
            reinitialisationBarre();
            toupieJoueur.setNombreBeyPoints(toupieJoueur.getNombreBeyPoints() + 1000);
            writeRapideInt(lblBeyPoint, toupieJoueur.getNombreBeyPoints());
            writeRapideInt(lblNombreTour, 1);
            nombreAttaquesEvolution = 0; // Reset Evolution
        }
        toupieJoueur.regenererVieParEndurance();
        barreVieToupiePerso.setProgress(pourcentageJoueur);
        vitaMajJoueur();
        System.out.println("Votre adversaire a gagné des pv");
    }


    private void afficherCombo(int nombreCoups) {
        lblCombo.setText(nombreCoups + " Coups !");
        lblCombo.setVisible(true);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> lblCombo.setVisible(false))
        );
        timeline.setCycleCount(1);
        timeline.play();
    }

    public void attaqueAdverse() {
        int chanceEnn = alea();

        float pourcentageJoueur = toupieJoueur.getVieActuelleToupie() / toupieJoueur.getVieMaxToupie();
        float pourcentageAdv = toupieJoueur.getVieActuelleToupie() / toupieJoueur.getVieMaxToupie();
        float degats = toupieAdv.attaqueGlobale();

        if ("Drain Fafnir".equalsIgnoreCase(toupieAdv.getEnergyLayerEnnemie().getNomLayer())) {
            int chance = alea();
            if (chance < 40) {
                volRotationEnnemie();


                barrevieToupieEnnemie.setProgress(pourcentageAdv);
                System.out.println("Absorption réussi");
            } else {
                appliquerDegatsSurJoueur(degats);

                barreVieToupiePerso.setProgress(pourcentageJoueur);
                vitaMajJoueur();
                System.out.println("Absorption échouée");
            }
        } else if (toupieAdv.isModeSixLamesEnnemie()) {


            barreVieToupiePerso.setProgress(pourcentageJoueur);
            vitaMajJoueur();



        }else {
            appliquerDegatsSurJoueur(degats);
            barreVieToupiePerso.setProgress(pourcentageJoueur);
            vitaMajJoueur();

        }
        toupieAdv.regenererVieParEnduranceEnnemie();
        barrevieToupieEnnemie.setProgress(pourcentageAdv);
        vitaMajAdv();
        System.out.println("Vous avez gagne des pv");


        writeRapideInt(lblNombreTour, Tour.suivant());
    }
    private void appliquerDegatsSurJoueur(float degats) {
        if ("kerbeus".equalsIgnoreCase(toupieJoueur.getEnergyLayer().getNomLayer())) { // Si on joue Kerbeus
            if (toupieJoueur.estEnProtection()) { // protection active
                degats *= 0.4; // exemple : réduire les dégâts
            }
            toupieJoueur.reduireProtection();
            if (toupieJoueur.finProtection()) {
                visibleImage(imgProtection); // la protection est finie, on ré-affiche
            }
        }
        toupieJoueur.perdrePDV(degats);

        float pourcentageJoueur = toupieJoueur.getVieActuelleToupie() / toupieJoueur.getVieMaxToupie();
        barreVieToupiePerso  .setProgress(pourcentageJoueur);
        vitaMajJoueur();
    }


    public void protectionEnnemie(){
        toupieAdv.activerProtectionEnnemie();
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Augmentation de défense");
        a.setHeaderText("Pendant 3 tours les dégâts adverses seront réduits");
        a.setContentText(null);
        a.showAndWait();
    }
    public float volRotationEnnemie() {
        float degatsSubis = (float) (toupieAdv.getVieMaxEnnemie() * 0.2);

        toupieAdv.gagnerVieEnnemie(degatsSubis);
        toupieAdv.regenererVieParEnduranceEnnemie();
        vitaMajAdv();


        float pourcentageAdv = toupieAdv.getVieActuelleEnnemie() / toupieAdv.getVieMaxEnnemie();
        barrevieToupieEnnemie.setProgress(pourcentageAdv);






        return degatsSubis;
    }



    public void reinitialisation(){
        toupieJoueur.setVieActuelle(toupieJoueur.getVieMaxToupie());
        toupieAdv.setVieActuelleEnnemie(toupieAdv.getVieMaxEnnemie());
    }
    public void reinitialisationBarre(){
        barrevieToupieEnnemie.setProgress(toupieAdv.getVieMaxEnnemie());
        barreVieToupiePerso.setProgress(toupieJoueur.getVieMaxToupie());
    }
    @FXML
    public void btnEsquive(MouseEvent event) {
        float pourcentageJoueur = toupieJoueur.getVieActuelleToupie()/toupieJoueur.getVieMaxToupie();
        if (alea() < toupieJoueur.getEsquive()){
            toupieJoueur.perdrePDV(0);
            toupieAdv.setVieActuelleEnnemie((float) (0.95 * toupieAdv.getVieActuelleEnnemie()));
            toupieAdv.getVieActuelleEnnemie() ;
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setTitle(null);
            a.setHeaderText("Esquive Réussi");
            a.setContentText(null);
            a.showAndWait();
            vitaMajJoueur();
            vitaMajAdv();

        }else {
            toupieJoueur.perdrePDV(toupieAdv.attaqueGlobale());
            barreVieToupiePerso.setProgress(pourcentageJoueur);
            vitaMajJoueur();
            vitaMajAdv();
        }

        toupieJoueur.regenererVieParEndurance();
        barreVieToupiePerso.setProgress(pourcentageJoueur);
        vitaMajJoueur();

    }
    @FXML
    public void btnProtection(MouseEvent event) {
        float pourcentageJoueur = toupieJoueur.getVieActuelleToupie() / toupieJoueur.getVieMaxToupie();
        toupieJoueur.activerProtection();
        invisibleImage(imgProtection);



        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Augmentation de défense");
        a.setHeaderText("Pendant 3 tours les dégâts adverses seront réduits");
        a.setContentText(null);
        a.showAndWait();

        toupieJoueur.regenererVieParEndurance();
        barreVieToupiePerso.setProgress(pourcentageJoueur);
        vitaMajJoueur();
    }



    @FXML
    public void btnRotationSteal(MouseEvent event) {
        float pourcentageJoueur = toupieJoueur.getVieActuelleToupie() / toupieJoueur.getVieMaxToupie();

        if ("Drain Fafnir".equalsIgnoreCase(toupieJoueur.getEnergyLayer().getNomLayer())) {

            float degatsSubis = (float) (toupieJoueur.getVieMaxToupie() * 0.2);
            toupieJoueur.gagnerVie(degatsSubis);
            vitaMajJoueur();





            if (toupieJoueur.getVieActuelleToupie() > toupieJoueur.getVieMaxToupie()){
                toupieJoueur.setVieActuelle(toupieJoueur.getVieMaxToupie());
                writeRapideFloat(lblNombrePVToupiePerso, toupieJoueur.getVieActuelleToupie());
            }


            System.out.println("Drain Fafnir a absorbé " + (degatsSubis * 0.2f) + " PV après avoir subi " + degatsSubis + " dégâts !");
        }
        toupieJoueur.regenererVieParEndurance();
        barreVieToupiePerso.setProgress(pourcentageJoueur);
        vitaMajJoueur();
    }
    @FXML
    public void btnModeTroislames(MouseEvent event) {
        float pourcentageJoueur = toupieJoueur.getVieActuelleToupie() / toupieJoueur.getVieMaxToupie();
        visibleImage(imgModeSixLames);
        invisibleImage(imgModeTroisLames);
        toupieJoueur.desactiverModeSixLames();
        toupieJoueur.perdrePDV(toupieAdv.attaqueGlobale());
        toupieJoueur.regenererVieParEndurance();
        barreVieToupiePerso.setProgress(pourcentageJoueur);
        vitaMajJoueur();
    }

    @FXML
    public void btnModeSixLames(MouseEvent event) {
        float pourcentageJoueur = toupieJoueur.getVieActuelleToupie() / toupieJoueur.getVieMaxToupie();
        if ("Brave Valkyrie".equalsIgnoreCase(toupieJoueur.getEnergyLayer().getNomLayer())) {
            visibleImage(imgModeTroisLames);
            invisibleImage(imgModeSixLames);
            toupieJoueur.activerModeSixLames();
            toupieJoueur.regenererVieParEndurance();
            barreVieToupiePerso.setProgress(pourcentageJoueur);
            vitaMajJoueur();
        } else {

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Mode 6 Lames");
            a.setHeaderText(null);
            a.setContentText("Le mode 6 lames est uniquement disponible pour Brave Valkyrie !");
            a.showAndWait();
        }
    }





    public int alea(){
        int alea = (int) (Math.random() * 101);
        return alea;
    }



}
