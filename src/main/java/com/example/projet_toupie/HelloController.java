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
import java.util.*;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.util.Duration;

import static com.example.projet_toupie.Tour.getNumeroTour;


public class HelloController implements Initializable {


    @FXML
    public AnchorPane apCommencement;
    @FXML
    public AnchorPane apMenuPrincipal;
    private boolean lifeAfterDeathActivated = false;
    private boolean attaqueValkyrieEffectueeCeTour = false;
    private boolean modeAttaqueZActive = false;
    private boolean modeEnduranceZActive = false;
    private boolean modeDefenseZActive = false;
    private boolean zAchillesEstMort = false;



    @FXML
    private AnchorPane apBoutique;
    private boolean combatEnCours = true;
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
    private ArrayList<PerformanceTip> mesTip = new ArrayList<>();
    private ArrayList<ForgeDisc> mesDisc = new ArrayList<>();
    private ArrayList<EnergyLayer> mesLayer = new ArrayList<>();
    private ArrayList<ToupiePersonnage> listToupie = new ArrayList<>();
    private ArrayList<ToupieEnnemie> listToupieEnnemie = new ArrayList<>();
    private ArrayList<String> lettre = new ArrayList<>();
    private String lettreActuelle;
    private boolean qteEnCours = false;
    private List<String> sequenceLettres = new ArrayList<>(); // Séquence de lettres à saisir
    private int currentLetterIndex = 0; // Index de la lettre actuelle dans la séquence
    private PauseTransition timer; // Timer pour chaque lettre


    private CombatController combatController;


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
    private AnchorPane apSelectionAdversaire;
    @FXML
    private Label lblAdversaireKerbeus;
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
    String imageName;
    private ToupiePersonnage toupieSelectionnee;



    int choixToupie = 0;
    int choixToupieEnn = 0;
    /*ToupiePersonnage Drain_Fafnir;
    ToupiePersonnage Brave_Valkyrie;
    ToupiePersonnage Kerbeus;*/
    private int nombreAttaquesEvolution = 0;
    int colonne = 0;
    int ligne = 0;
    int beyReste = 0;
    int beyResteActuel = 0;




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

    EnergyLayer LayerKerbeus;
    EnergyLayer LayerDrainFafnir;
    EnergyLayer LayerBraveValkyrie;

    ForgeDisc Disk8;
    ForgeDisc Disk2A;
    ForgeDisc DiskCentral;

    PerformanceTip Defense;
    PerformanceTip Evolution;
    PerformanceTip Nothing;






    @FXML
    private BorderPane BpCollection;
    @FXML
    private AnchorPane apTop;
    @FXML
    private ImageView imgEnergyLayer1;
    @FXML
    private ImageView imgEnergyLayer3;
    @FXML
    private ImageView imgEnergyLayer2;
    @FXML
    private ImageView imgEnergyLayer5;
    @FXML
    private ImageView imgEnergyLayer4;
    @FXML
    private ImageView imgForgeDisc7;
    @FXML
    private ImageView imgForgeDisc6;
    @FXML
    private ImageView imgForgeDisc5;
    @FXML
    private ImageView imgForgeDisc4;
    @FXML
    private ImageView imgForgeDisc3;
    @FXML
    private ImageView imgForgeDisc2;
    @FXML
    private ImageView imgForgeDisc1;
    @FXML
    private ImageView imgPerformanceTip1;
    @FXML
    private ImageView imgPerformanceTip5;
    @FXML
    private ImageView imgPerformanceTip4;
    @FXML
    private ImageView imgPerformanceTip3;
    @FXML
    private ImageView imgPerformanceTip2;
    @FXML
    private ImageView imgEnergyLayer7;
    @FXML
    private ImageView imgEnergyLayer6;
    @FXML
    private ImageView imgPerformanceTip7;
    @FXML
    private ImageView imgPerformanceTip6;
    @FXML
    private Label lblComboEnnemie;
    @FXML
    private AnchorPane apBurst;
    @FXML
    private ImageView imgGifBurst;
    @FXML
    private ImageView imgRetourDuCombat;
    @FXML
    private ImageView imgSelectionRetour;
    @FXML
    private ImageView imgLogo1;
    @FXML
    private Label lblCombo2;
    @FXML
    private Label lblComboEnnemie2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clearAll();
        clearAllBorder();

        visible(apCommencement);
        invisibleImage(imgProtection);
        invisibleImage(imgRotationSteal);

        Font policeLuckiestGuy = Font.loadFont(getClass().getResourceAsStream("/fonts/LuckiestGuy-Regular.ttf"), 42);
        lblCombo.setFont(policeLuckiestGuy);
        lblComboEnnemie.setFont(policeLuckiestGuy);
        lblComboEnnemie2.setFont(policeLuckiestGuy);
        lblCombo2.setFont(policeLuckiestGuy);



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




        EnergyLayer LayerKerbeus = new EnergyLayer("Kerbeus", droite, 30, 60, 40, 33, "Energy_Layer/LayerKerbeus.png");
        EnergyLayer LayerHellSalamander = new EnergyLayer("Hell Salamander", gauche, 45, 45, 60, 62, "Energy_Layer/LayerHellSalamander.png");
        EnergyLayer LayerDrainFafnir = new EnergyLayer("Drain Fafnir", gauche, 35, 45, 80, 37, "Energy_Layer/LayerDrainFafnir.png");
        EnergyLayer LayerZAchilles = new EnergyLayer("Z Achilles", droite, 80, 30, 40, 43, "Energy_Layer/LayerZAchilles.png");
        EnergyLayer LayerBraveValkyrie = new EnergyLayer("Brave Valkyrie", droite, 90, 30, 30, 62, "Energy_Layer/EnergyLayer_BraveValkyrie.png");

// Layers GT (Bushin Ashura)
        /*EnergyLayer LayerAshuraBushinChip = new EnergyLayer("Ashura", EnergyLayer.SystemeLayer.GT, droite, 15, 20, 10, 2.9f, "Energy_Layer/GatinkoChipAshura.png", gtLayerBushin);
        EnergyLayer LayerAshuraBushinWeight = new EnergyLayer("Ten", EnergyLayer.SystemeLayer.GT, droite, 5, 15, 10, 4.6f, "Energy_Layer/LayerWeightTen.png", gtLayerBushin);
        EnergyLayer LayerAshuraBushinBase = new EnergyLayer("Bushin", EnergyLayer.SystemeLayer.GT, droite, 10, 40, 15, 7.3f, "Energy_Layer/LayerBaseBushin.png", gtLayerBushin);*/
        //EnergyLayer LayerAshuraBushin = new EnergyLayer("Bushin Ashura", droite, 30, 70, 35, 20.2f, "", gtLayerBushin);

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

                gauche,
                25,  // attaque
                40,  // défense
                30,  // endurance
                3.0f,
                "Energy_Layer/ChipLucifer.png"
        );
        EnergyLayer RingTheEnd = new EnergyLayer(
                "The End",

                gauche,
                30,
                50,
                40,
                5.0f,
                "Energy_Layer/RingTheEnd.png"

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

                droite,
                35,  // attaque
                80,  // défense
                90,  // endurance
                32.8f,
                "Energy_Layer/LayerLuciferTheEnd.png"

        );
        EnergyLayer LayerRoarBahamut = new EnergyLayer(
                "Roar Bahamut",

                gauche,
                30,  // attaque
                90,  // défense
                70,  // endurance
                31.5f,
                "Energy_Layer/LayerRoarBahamut.png"

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
                1400,
                1400,
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

                1900,
                1900,
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
        /*BushinAshuraE = new ToupieEnnemie("Bushin Ashura Hurricane Keep"

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
                ,"Toupie/BBGT_Bushin_Ashura_Hurricane_Keep_Ten_Beyblade.png");*/
        ZAchillesE =new ToupieEnnemie("Z Achilles 11 Xtend"
                ,LayerZAchilles
                ,Disk11
                ,Xtend
                , typeEquilibre
                ,1650
                ,1650
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
        //listToupieEnnemie.add(BushinAshuraE);
        listToupieEnnemie.add(ZAchillesE);




       /*apLancerToupie.setOnKeyPressed(this::keyQTE);
        apLancerToupie.setFocusTraversable(true);
        apLancerToupie.requestFocus();*/
        System.out.println("Hell Salamander"+listToupieEnnemie.indexOf(HellSalamanderE));
        System.out.println("Kerbeus   "+listToupieEnnemie.indexOf(KerbeusE));
        System.out.println("Brave Valkyrie E"+listToupieEnnemie.indexOf(BraveValkyrieE));
        System.out.println("Drain Fafnir  "+listToupieEnnemie.indexOf(DrainFafnirE));

        System.out.println("Z achilles   "+listToupieEnnemie.indexOf(ZAchillesE));

        for (EnergyLayer e : layer){
            mesLayer.add(e);
        }
       for (ForgeDisc f : disc){
            mesDisc.add(f);
            }
        for (PerformanceTip p : tip){
            mesTip.add(p);
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

        toupieSelectionnee = new ToupiePersonnage("Drain Fafnir 8 Nothing "
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
                ,"Toupie/fafnir_gpt.png"

        );

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

        toupieSelectionnee = new ToupiePersonnage("Kerbeus Central Defense"
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
                "Toupie/kerbeus_gpt.png"

        );

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

        toupieSelectionnee = new ToupiePersonnage("Brave Valkyrie Evolution 2A "
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
                ,"Toupie/valkyrie_gpt.png"

        );
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
    public void visibleBorder(BorderPane bpCourant ){
        bpCourant.setVisible(true);
    }
    public void invisibleBorder(BorderPane bpCourant ){
        bpCourant.setVisible(false);
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
        visible(apFichePerso);


        if (choixToupie == 1){
            writeRapideString(lblNomToupie, listToupie.get(3).getNomToupie());
            changeImageViewImg(imgToupiePerso,"Toupie/fafnir_gpt.png");
            visible(apFichePerso);
            changeZone("Toupie/fafnir_gpt.png",apFichePerso);
            writeRapideFloat(lblAttaqueToupie, listToupie.get(3).getAttaqueToupie());
            writeRapideFloat(lblDefenseToupie, listToupie.get(3).getDefenseToupie());
            writeRapideFloat(lblEnduranceToupie, listToupie.get(3).getEnduranceToupie());
            writeRapideFloat(lblVieMaxToupie, listToupie.get(3).getVieMaxToupie());
            writeRapideString(lblRotationToupie, listToupie.get(3).getRotation().getTypeRotation());
            writeRapideString(lblTypeToupie, String.valueOf(listToupie.get(3).getClasseToupie().getTypeToupie()));
            changeImageViewImg(imgRetour2,"Bouton_Spécial/Toupie_Retour.png");


        }
        if (choixToupie == 2){

            changeImageViewImg(imgToupiePerso,"Toupie/kerbeus_gpt.png");
            visible(apFichePerso);
            changeZone("Toupie/kerbeus_gpt.png",apFichePerso);
            writeRapideString(lblNomToupie, listToupie.get(0).getNomToupie());
            writeRapideFloat(lblAttaqueToupie, listToupie.get(0).getAttaqueToupie());
            writeRapideFloat(lblDefenseToupie, listToupie.get(0).getDefenseToupie());
            writeRapideFloat(lblEnduranceToupie, listToupie.get(0).getEnduranceToupie());
            writeRapideFloat(lblVieMaxToupie, listToupie.get(0).getVieMaxToupie());
            writeRapideString(lblRotationToupie,listToupie.get(0).getRotation().getTypeRotation());
            writeRapideString(lblTypeToupie, String.valueOf(listToupie.get(0).getClasseToupie().getTypeToupie()));
            changeImageViewImg(imgRetour2,"Bouton_Spécial/Toupie_Retour.png");

        }
        if (choixToupie == 3){
            changeImageViewImg(imgToupiePerso,"Toupie/valkyrie_gpt.png");
            visible(apFichePerso);
            changeZone("Toupie/valkyrie_gpt.png",apFichePerso);
            writeRapideString(lblNomToupie, listToupie.get(1).getNomToupie());
            writeRapideFloat(lblAttaqueToupie, listToupie.get(1).getAttaqueToupie());
            writeRapideFloat(lblDefenseToupie, listToupie.get(1).getDefenseToupie());
            writeRapideFloat(lblEnduranceToupie, listToupie.get(1).getEnduranceToupie());
            writeRapideFloat(lblVieMaxToupie, listToupie.get(1).getVieMaxToupie());
            writeRapideString(lblRotationToupie, listToupie.get(1).getRotation().getTypeRotation());
            writeRapideString(lblTypeToupie, String.valueOf(listToupie.get(1).getClasseToupie().getTypeToupie()));
            changeImageViewImg(imgRetour2,"Bouton_Spécial/Toupie_Retour.png");

        }

    }
    @FXML
    public void btnCollectionToupie(MouseEvent event) {
        clearAll();
        clearAllBorder();

        visibleBorder(BpCollection);
        visible(apTop);
        if (choixToupie == 1){
            changeImageViewImg(imgEnergyLayer1,"Energy_Layer/LayerDrainFafnir.png");
            changeImageViewImg(imgForgeDisc1,"Forge_Discs/Disk8.png");
            changeImageViewImg(imgPerformanceTip1,"Performance_Tip/DriverNothing.png");
        }
        if (choixToupie == 2){
            changeImageViewImg(imgEnergyLayer1,"Energy_Layer/LayerKerbeus.png");
            changeImageViewImg(imgForgeDisc1,"Forge_Discs/DiskCentral.png");
            changeImageViewImg(imgPerformanceTip1,"Performance_Tip/DriverDefense.png");
        }

        if (choixToupie == 3){
            changeImageViewImg(imgEnergyLayer1,"Energy_Layer/EnergyLayer_BraveValkyrie.png");
            changeImageViewImg(imgForgeDisc1,"Forge_Discs/ForgeDisc_2A.png");
            changeImageViewImg(imgPerformanceTip1,"Performance_Tip/PerformanceTip_Evolution.png");
        }








    }


    @FXML
    public void btnModeCombat(MouseEvent event) {
        clearAll();
        changeImageViewImg(imgMenuCombat , "Environnement/Fond-SelectionToupie2.png");
        visible(apSelectionAdversaire);
        changeZone("Environnement/Fond-SelectionToupie2.png",apSelectionAdversaire);
        writeRapideString(lblAdversaireValkyrie,listToupieEnnemie.get(1).getNomToupieEnnemie());
        writeRapideString(lblAdversaireKerbeus,listToupieEnnemie.get(0).getNomToupieEnnemie());
        writeRapideString(lblAdversaireFafnir,listToupieEnnemie.get(3).getNomToupieEnnemie());


        writeRapideString(lblAdversaireZachilles,listToupieEnnemie.get(4).getNomToupieEnnemie());
    }

    @FXML
    public void btnCoffreToupie(MouseEvent mouseEvent) {
        clearAll();
        changeImageViewImg(imgInvocation, "Environnement/Fond-Invocation.png");
        visible(apInvocation);
        changeZone("Environnement/Fond-Invocation.png", apInvocation);

        if (toupieJoueur.getNombreBeyPoints() >= 700) {
            beyReste = beyResteActuel;
            invoquerPiece();

            toupieJoueur.setNombreBeyPoints(toupieJoueur.getNombreBeyPoints() - 700);
            beyReste = toupieJoueur.getNombreBeyPoints();
            writeRapideInt(lblBeyPoint, beyReste);


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
            beyReste = toupieJoueur.getNombreBeyPoints();

        }
        beyResteActuel = beyReste;
    }


    public void invoquerPiece() {
        Random random = new Random();
        int pieceType = random.nextInt(3); // 0 = EnergyLayer, 1 = ForgeDisc, 2 = PerformanceTip

        switch (pieceType) {
            case 0:
                EnergyLayer newLayer = layer.get(random.nextInt(layer.size()));

                if (!toupieJoueur.getCollectionPieces().possedeDejaEnergyLayer(newLayer)) {
                    toupieJoueur.getCollectionPieces().ajouterEnergyLayer(newLayer);
                    afficherInfoPiece("Energy Layer", newLayer.getNomLayer());
                    changeImageViewImg(imgPieceToupie, newLayer.getUrlLayer());
                    writeRapideInt(lblStatAttaque, newLayer.getStatAttaqueLayer());
                    writeRapideInt(lblStatDefense, newLayer.getStatDefenseLayer());
                    writeRapideInt(lblStatEndurance, newLayer.getStatEnduranceLayer());
                    writeRapideInt(lblPoids, (int) newLayer.getPoidsLayer());
                    List<ImageView> energyLayerSlots = Arrays.asList(
                            imgEnergyLayer2, imgEnergyLayer3, imgEnergyLayer4,
                            imgEnergyLayer5, imgEnergyLayer6, imgEnergyLayer7
                    );
                    afficherImageDansCaseDisponible(energyLayerSlots, newLayer.getUrlLayer());
                } else {
                    afficherInfoPiece("Déjà obtenu", newLayer.getNomLayer());
                    // Optionnel : tu peux afficher un effet visuel ici (ex: glow rouge)
                }
                break;


            case 1:
                ForgeDisc newDisc = disc.get(random.nextInt(disc.size()));

                if (!toupieJoueur.getCollectionPieces().possedeDejaForgeDiscs(newDisc)) {
                    toupieJoueur.getCollectionPieces().ajouterForgeDisc(newDisc);
                    afficherInfoPiece("Forge Disc", newDisc.getNomDisc());
                    changeImageViewImg(imgPieceToupie, newDisc.getUrlDisc());
                    writeRapideInt(lblStatAttaque, newDisc.getStatAttaqueDisc());
                    writeRapideInt(lblStatDefense, newDisc.getStatDefenseDisc());
                    writeRapideInt(lblStatEndurance, newDisc.getStatEnduranceDisc());
                    writeRapideInt(lblPoids, (int) newDisc.getPoidsDisc());
                    List<ImageView> ForgeDiscsSlots = Arrays.asList(
                            imgForgeDisc2, imgForgeDisc3, imgForgeDisc4,
                            imgForgeDisc5, imgForgeDisc6, imgForgeDisc7
                    );
                    afficherImageDansCaseDisponible(ForgeDiscsSlots, newDisc.getUrlDisc());
                } else {
                    afficherInfoPiece("Déjà obtenu", newDisc.getNomDisc());
                }
                break;


            case 2:
                PerformanceTip newTip = tip.get(random.nextInt(tip.size()));

                if (!toupieJoueur.getCollectionPieces().possedeDejaPerformanceTip(newTip)) {
                    toupieJoueur.getCollectionPieces().ajouterPerformanceTip(newTip);
                    afficherInfoPiece("Performance Tip", newTip.getNomTip());
                    changeImageViewImg(imgPieceToupie, newTip.getUrlTip());
                    writeRapideInt(lblStatAttaque, newTip.getStatAttaqueTip());
                    writeRapideInt(lblStatDefense, newTip.getStatDefenseTip());
                    writeRapideInt(lblStatEndurance, newTip.getStatEnduranceTip());
                    writeRapideInt(lblPoids, (int) newTip.getPoidsTip());
                    List<ImageView> performanceTipSlots = Arrays.asList(
                            imgPerformanceTip2, imgPerformanceTip3, imgPerformanceTip4,
                            imgPerformanceTip5, imgPerformanceTip6, imgPerformanceTip7
                    );
                    afficherImageDansCaseDisponible(performanceTipSlots, newTip.getUrlTip());
                } else {
                    afficherInfoPiece("Déjà obtenu", newTip.getNomTip());
                }
                break;

        }
    }
    private void afficherImageDansCaseDisponible(List<ImageView> listeImages, String urlImagePiece) {
        for (ImageView imageView : listeImages) {
            Image imageActuelle = imageView.getImage();
            if (imageActuelle != null && imageActuelle.getUrl() != null &&
                    imageActuelle.getUrl().contains("Bouton_Spécial/cadenas.png")) {
                changeImageViewImg(imageView, urlImagePiece);
                break;
            }
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

        invisible(apTop);
        invisible(apBurst);




    }
    public void clearAllBorder(){
        invisibleBorder(BpCollection);
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

    visible(apMenuPrincipal);

}
    @FXML
    public void btnRetourDuCombat(MouseEvent event) {
        retourMenu();
    }

    @FXML
    public void btnSelectionRetour(MouseEvent event) {
        retourMenu();
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
    @Deprecated
    public void btnSuivant2(MouseEvent event) {
        clearAll();

    }


    @FXML
    public void btnRetour3(MouseEvent event) {
        clearAll();
        clearAllBorder();
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
    public void writeRapideRotation(Label lblTexte, Rotation rotationTexte)
    {
        lblTexte.setText(rotationTexte.getTypeRotation());
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
            demarrerCompteARebours(listToupie.get(1).getNomToupie(),listToupieEnnemie.get(3).getNomToupieEnnemie());

        }
        toupieAdv = listToupieEnnemie.get(3);

        initialiserCombat("Toupie/fafnir_gpt.png",3);
        combatController = new CombatController(toupieJoueur, toupieAdv);

    }

    @FXML
    public void btnAdvZachilles(MouseEvent event) {
        momentLancer();
        if (choixToupie == 1){
            demarrerCompteARebours(listToupie.get(3).getNomToupie(),listToupieEnnemie.get(4 ).getNomToupieEnnemie());

        }
        if (choixToupie == 2){
            demarrerCompteARebours(listToupie.get(0).getNomToupie(),listToupieEnnemie.get(4).getNomToupieEnnemie());

        }
        if (choixToupie == 3){
            demarrerCompteARebours(listToupie.get(1).getNomToupie(),listToupieEnnemie.get(4).getNomToupieEnnemie());

        }
       resetModesZAchilles();

        toupieAdv = listToupieEnnemie.get(4);

        initialiserCombat("Toupie/ZA_.11.Xt_2.png",4);
        combatController = new CombatController(toupieJoueur, toupieAdv);



    }
    private void resetModesZAchilles() {
        modeAttaqueZActive = false;
        modeEnduranceZActive = false;
        modeDefenseZActive = false;
        lifeAfterDeathActivated = false;
        zAchillesEstMort = false;
    }


    @FXML
    public void btnAdvValkyrie(MouseEvent event) {
        momentLancer();
        if (choixToupie == 1){
            demarrerCompteARebours(listToupie.get(3).getNomToupie(),listToupieEnnemie.get(1).getNomToupieEnnemie());

        }
        if (choixToupie == 2){
            demarrerCompteARebours(listToupie.get(0).getNomToupie(),listToupieEnnemie.get(1).getNomToupieEnnemie());

        }
        if (choixToupie == 3){
            demarrerCompteARebours(listToupie.get(1).getNomToupie(),listToupieEnnemie.get(1).getNomToupieEnnemie());

        }

        toupieAdv = listToupieEnnemie.get(1);

        initialiserCombat("Toupie/valkyrie_gpt.png",1);
        combatController = new CombatController(toupieJoueur, toupieAdv);



    }



    @Deprecated
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
        combatController = new CombatController(toupieJoueur, toupieAdv);


    }
    public void initialiserCombat(String imgToupie, int indiceToupieEnn) {


        toupieJoueur.resetStats();
        listToupieEnnemie.get(indiceToupieEnn).resetStats();

        toupieAdv = listToupieEnnemie.get(indiceToupieEnn);

        changeImageViewImg(imgToupieDeEnnemi, imgToupie);
        writeRapideFloat(lblNombrePVToupieEnnemie, toupieAdv.getVieMaxEnnemie());
        writeRapideString(lblToupieEnnModeCombat, toupieAdv.getNomToupieEnnemie());

        invisibleImage(imgProtection);
        invisibleImage(imgRotationSteal);
        invisibleImage(imgModeSixLames);
        invisibleImage(imgModeTroisLames);

        // Réafficher l'image de la toupie du joueur selon le choix
        if (choixToupie == 1) {
            toupieJoueur = listToupie.get(3);
            affichageCombatGenerique("Toupie/fafnir_gpt.png", toupieJoueur.getVieMaxToupie(), toupieJoueur.getNomToupie());
            visibleImage(imgRotationSteal);
        }
        if (choixToupie == 2) {
            toupieJoueur = listToupie.get(0);
            affichageCombatGenerique("Toupie/kerbeus_gpt.png", toupieJoueur.getVieMaxToupie(), toupieJoueur.getNomToupie());
            visibleImage(imgProtection);
        }
        if (choixToupie == 3) {
            toupieJoueur = listToupie.get(1);
            affichageCombatGenerique("Toupie/valkyrie_gpt.png", toupieJoueur.getVieMaxToupie(), toupieJoueur.getNomToupie());
            visibleImage(imgModeSixLames);
        }

        // Mise à jour des barres de vie
        barreVieToupiePerso.setProgress(1.0);
        barrevieToupieEnnemie.setProgress(1.0);
        writeRapideInt(lblNombreTour, Tour.reset());
    }



    public void momentLancer(){
        clearAll();
        changeImageViewImg(imgStadium , "Environnement/Stadium_Beyblade.png");
        visible(apLancerToupie);
        changeZone("Environnement/Stadium_Beyblade.png",apLancerToupie);
    }




    public void demarrerCompteARebours(String nomJoueur, String nomAdversaire) {
        List<String> etapes = List.of("3", "2", "1", "Hypervitesse !");
        lblQTE.setText("...");

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
                        lblQTE.setFocusTraversable(true);
                        lblQTE.requestFocus();
                    });
                    attenteAvantQTE.play();
                }
            });
            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.setOnFinished(e -> {
            // Le QTE peut durer jusqu'à 2s x 4 lettres = 8s, donc délai suffisant ici
            PauseTransition suite = new PauseTransition(Duration.seconds(7));
            suite.setOnFinished(ev -> {
                qteEnCours = false;

                // Appliquer les effets QTE
                ToupiePersonnage toupieJoueur = toupieSelectionnee;
                qteLancer.appliquerEffetQTE(toupieJoueur, qteLancer.isReussi());

                // ✅ Afficher les résultats avant de continuer
                String message;
                if (qteLancer.isReussi()) {
                    toupieJoueur.setAttaque(Math.min(100,toupieJoueur.getAttaqueToupie() + 10));
                    toupieJoueur.setEndurance(Math.min(100,toupieJoueur.getEnduranceToupie() + 10));
                    toupieJoueur.mettreAJourVieMax();

                    //toupieJoueur.mettreAJourVieMax();
                    message = "QTE Réussi !\n\n"
                            + "Attaque +10\n"
                            + "Endurance +10\n";
                    if ("Kerbeus Central Defense".equals(toupieJoueur.getNomToupie())) {
                        toupieJoueur.setAttaque(Math.min(100,toupieJoueur.getAttaqueToupie() + 5));
                        toupieJoueur.setEndurance(Math.min(100,toupieJoueur.getEnduranceToupie() + 5));
                        toupieJoueur.setDefense(Math.min(100,toupieJoueur.getDefenseToupie() + 7));
                        toupieJoueur.mettreAJourVieMax();
                        //toupieJoueur.setVieActuelle(toupieJoueur.getVieActuelleToupie() + 10);
                       // toupieJoueur.mettreAJourVieMax();
                        message = "QTE Réussi !\n\n"
                                + "Attaque +5\n"
                                + "Endurance +5\n"
                                +"Défense + 7 \n";
                    }
                } else {
                    toupieJoueur.setAttaque(Math.max(0,toupieJoueur.getAttaqueToupie() - 10));
                    toupieJoueur.setEndurance(Math.max(0,toupieJoueur.getEnduranceToupie() - 10));
                    toupieJoueur.mettreAJourVieMax();

                    //toupieJoueur.mettreAJourVieMax();
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
                    //initialiserToupies(nomJoueur, nomAdversaire);

                    PauseTransition pause = new PauseTransition(Duration.seconds(1));
                    pause.setOnFinished(ev2 -> fight());
                    pause.play();
                });

            });
            suite.play();
        });

        timeline.play();
    }





    @FXML
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

        timer = new PauseTransition(Duration.seconds(1.5));
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
        float pourcentageAdv = toupieAdv.getVieActuelleEnnemie() / toupieAdv.getVieMaxEnnemie();

        if (toupieAdv.getVieActuelleEnnemie() > 0 && toupieJoueur.getVieActuelleToupie() > 0) {
            float degat = 0;

            // ATTAQUE DU JOUEUR
            if (combatController.isModeSixLames()) {
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
                    float coup = combatController.barrage();

                    // BOOST Evolution
                    if ("Evolution".equalsIgnoreCase(toupieJoueur.getPerformanceTip().getNomTip())) {
                        nombreAttaquesEvolution++;
                        float bonus = 1.0f + 0.02f * nombreAttaquesEvolution;
                        coup *= bonus;
                    }

                    degat += coup; // Cumul des dégâts
                }

                afficherCombo(nombreCoups);
            } else {
                degat = combatController.attaqueJoueur();

                // BOOST Evolution
                if ("Evolution".equalsIgnoreCase(toupieJoueur.getPerformanceTip().getNomTip())) {
                    nombreAttaquesEvolution++;
                    float bonus = 1.0f + 0.05f * nombreAttaquesEvolution;
                    degat *= bonus;
                }
            }

            // 🔥 Infliger les dégâts à l'ennemi et déclencher les effets
            infligerDegatsEtGererModeEnnemi(degat);




               // attaqueAdverse();




                // Mise à jour UI

               majVieJoueur();


        }

       animationOuNon();
    }
    public void animationOuNon() {
        if (!combatEnCours) return; // Ne pas vérifier si combat terminé

        PauseTransition pauseFin = new PauseTransition(Duration.seconds(0.5));
        pauseFin.setOnFinished(e -> checkFinCombat());
        pauseFin.play();
    }

    private void gererChangementModeToupieEnnemi() {
        String nomLayer = toupieAdv.getEnergyLayerEnnemie().getNomLayer();

        if (nomLayer == null) return;

        nomLayer = nomLayer.toLowerCase();

        if (nomLayer.contains("z achilles")) {
            gererChangementModeEnnemiZAchilles();
        } else if (nomLayer.contains("fafnir")) {
            gererChangementFafnir();
        } else if (nomLayer.contains("brave valkyrie")) {
            gererChangementValkyrie();
        } else if (nomLayer.contains("kerbeus")) {
            gererChangementKerbeus();
        }
    }
    private void infligerDegatsEtGererModeEnnemi(float degat) {
        combatController.perdrePDVEnnemie(degat);
       // gererChangementModeEnnemiZAchilles();
        majVieEnnemi();
        finDeTour();

    }




    private void afficherCombo(int nombreCoups) {
        Platform.runLater(() -> {
            lblCombo.setText(nombreCoups + " Coups !");
            lblCombo.setVisible(true);
            lblCombo.toFront();

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(1), e -> lblCombo.setVisible(false))
            );
            timeline.setCycleCount(1);
            timeline.play();
        });

    }
    private void afficherComboEsquive() {
        Platform.runLater(() -> {
            lblCombo2.setText("Esquive Réussi !");
            lblCombo2.setVisible(true);
            lblCombo2.toFront();

            // ✅ Appliquer un style : police Regular, taille 13px
            lblCombo2.setStyle("-fx-font-size: 15px; -fx-font-weight: normal;");

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(1), e -> lblCombo2.setVisible(false))
            );
            timeline.setCycleCount(1);
            timeline.play();
        });
    }

    public void affBurst(Runnable onAnimationFinished) {
        clearAll();
        clearAllBorder();
        visible(apBurst);

        // Durée estimée de l'animation d'explosion (ajuster selon le besoin)
        PauseTransition pause = new PauseTransition(Duration.seconds(2.5));
        pause.setOnFinished(e -> onAnimationFinished.run());
        pause.play();

    }
    @FXML
    public void btnGif(MouseEvent event) {
        if (toupieJoueur.getVieActuelleToupie() <= 0 & toupieAdv.getVieActuelleEnnemie() > 0){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Dommage");
            a.setHeaderText("Vous avez Perdu ! \n en vous prenant un burst ");
            a.setContentText("Perte de beyPoints : -"+500 + "beyPoint");
            a.showAndWait();

            clearAll();
            clearAllBorder();
            visible(apMenuPrincipal);
        }

        if (toupieJoueur.getVieActuelleToupie() > 0 & toupieAdv.getVieActuelleEnnemie() < 0){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Wouah !! Burst ");
            a.setHeaderText("Vous avez Gagné \n en éclatant la toupie adverse \n Vous recevez un bonus  !");
            toupieJoueur.setNombreBeyPoints(toupieJoueur.getNombreBeyPoints() + 1500);

            a.setContentText("Votre Récompense :" + toupieJoueur.getNombreBeyPoints() + " BeyPoints");
            a.showAndWait();

            clearAll();
            clearAllBorder();
            visible(apMenuPrincipal);
        }


    }
    private void afficherComboEnnemie(int nombreCoups) {
        Platform.runLater(() ->{
            lblComboEnnemie.setText(nombreCoups + " Coups !");
            lblComboEnnemie.setVisible(true);
            lblComboEnnemie.toFront();

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(1), e -> lblComboEnnemie.setVisible(false))
            );
            timeline.setCycleCount(1);
            timeline.play();
        });
       
    }
    private void afficherComboEnnemie() {
        Platform.runLater(() ->{
            lblComboEnnemie.setText("Kerbeus Contre-Attaque !");
            lblComboEnnemie.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");


            lblComboEnnemie.setVisible(true);

            lblComboEnnemie.toFront();

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(1.5), e -> lblComboEnnemie.setVisible(false))
            );
            timeline.setCycleCount(1);
            timeline.play();
        });

    }
    private void afficherComboEnnemieCritique() {
        Platform.runLater(() ->{
            lblComboEnnemie2.setText("Critique !");
            lblComboEnnemie2.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");


            lblComboEnnemie2.setVisible(true);

            lblComboEnnemie2.toFront();

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(1.5), e -> lblComboEnnemie2.setVisible(false))
            );
            timeline.setCycleCount(1);
            timeline.play();
        });

    }
    private void afficherComboEnnemieEsquive() {
        Platform.runLater(() ->{
            lblComboEnnemie2.setText("Esquive Réussi");
            lblComboEnnemie2.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");


            lblComboEnnemie2.setVisible(true);

            lblComboEnnemie2.toFront();

            Timeline timeline = new Timeline(
                    new KeyFrame(Duration.seconds(1.5), e -> lblComboEnnemie2.setVisible(false))
            );
            timeline.setCycleCount(1);
            timeline.play();
        });

    }

    //public void attaqueAdverse() {


        /*gererChangementFafnir();

        gererChangementValkyrie();
        gererChangementKerbeus();
        gererChangementModeEnnemiZAchilles();*/

        //System.out.println("Grâce au principe de régénération d'endurance : Votre adversaire à gagner des pv");
       // animationOuNon();



    //}
    private void gererChangementFafnir() {
        int chance = alea();
        float degats = combatController.attaqueAdv();
        float pourcentageAdv = toupieAdv.getVieActuelleEnnemie() / toupieAdv.getVieMaxEnnemie();

        if ("Drain Fafnir".equalsIgnoreCase(toupieAdv.getEnergyLayerEnnemie().getNomLayer())) {

            if (chance < 34) {
                float absorb = volRotationEnnemie();
                if (absorb > 0) {

                    majVieEnnemi();
                    System.out.println("Absorption réussie !");
                    return;
                } else {
                    System.out.println("Absorption impossible à cause de la rotation");
                }
            }





            appliquerDegatsSurJoueur(degats);
            System.out.println("Fafnir subit les dégâts");
        }
    }

    private void gererChangementValkyrie() {
        int chance = alea();
        float degats = combatController.attaqueAdv();


            // Attaque de Valkyrie
            if ("Brave Valkyrie".equalsIgnoreCase(toupieAdv.getEnergyLayerEnnemie().getNomLayer())) {
                if (Tour.getNumeroTour() % 3 == 0) {
                    combatController.activerModeSixLamesEnnemi();
                    if (combatController.isModeSixLamesEnnemi()) {
                        // Calcul du nombre de coups en fonction du hasard
                        int nombreCoups = (chance < 15) ? 5 : (chance < 45) ? 4 : (chance < 75) ? 3 : 2;
                        for (int i = 0; i < nombreCoups; i++) {
                            float degat = combatController.barrageEnnemie();
                            if ("Evolution".equalsIgnoreCase(toupieJoueur.getPerformanceTip().getNomTip())) {
                                nombreAttaquesEvolution++;
                                float bonus = 1.0f + 0.02f * nombreAttaquesEvolution;
                                degat *= bonus;
                            }
                            combatController.perdrePDV(degat);
                            if (toupieAdv.getVieActuelleEnnemie() <= 0 || toupieJoueur.getVieActuelleToupie() <= 0) {
                                checkFinCombat();
                                return;
                            }
                        }
                        Alert a = new Alert(Alert.AlertType.WARNING);
                        a.setTitle("Changement de mode");
                        a.setHeaderText("Brave Valkyrie passe en mode 6 lames");
                        a.setContentText("Plusieurs coups vont être lancés !");
                        a.showAndWait();
                        afficherComboEnnemie(nombreCoups);
                    }
                } else {
                    combatController.desactiverModeSixLamesEnnemi();
                    if ("Evolution".equalsIgnoreCase(toupieJoueur.getPerformanceTip().getNomTip())) {
                        nombreAttaquesEvolution++;
                        float bonus = 1.0f + 0.02f * nombreAttaquesEvolution;
                        degats *= bonus;
                    }
                    appliquerDegatsSurJoueur(degats);
                }
            }

    }

    private void verifierEtChangerModeValkyrie() {
        if (!"Brave Valkyrie".equalsIgnoreCase(toupieAdv.getEnergyLayerEnnemie().getNomLayer())) return;

        if (Tour.getNumeroTour() % 3 == 0) {
            combatController.activerModeSixLamesEnnemi();
            if (combatController.isModeSixLamesEnnemi()) {
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("Changement de mode");
                a.setHeaderText("Brave Valkyrie passe en mode 6 lames !");
                a.setContentText("Elle prépare une série de coups !");
                a.showAndWait();
            }
        } else {
            combatController.desactiverModeSixLamesEnnemi();
        }
    }
    private void attaquerAvecValkyrieSiModeActif() {
        if (!"Brave Valkyrie".equalsIgnoreCase(toupieAdv.getEnergyLayerEnnemie().getNomLayer())) return;
        if (!combatController.isModeSixLamesEnnemi() || attaqueValkyrieEffectueeCeTour) return;

        attaqueValkyrieEffectueeCeTour = true; // ✅ Empêche d'attaquer plusieurs fois dans le même tour

        int chance = alea();
        int nombreCoups;

        if (chance < 15) nombreCoups = 5;
        else if (chance < 45) nombreCoups = 4;
        else if (chance < 75) nombreCoups = 3;
        else nombreCoups = 2;

        for (int i = 0; i < nombreCoups; i++) {
            float degat = combatController.barrageEnnemie();

            if ("Evolution".equalsIgnoreCase(toupieJoueur.getPerformanceTip().getNomTip())) {
                nombreAttaquesEvolution++;
                float bonus = 1.0f + 0.02f * nombreAttaquesEvolution;
                degat *= bonus;
            }

            combatController.perdrePDV(degat);

            if (toupieAdv.getVieActuelleEnnemie() <= 0 || toupieJoueur.getVieActuelleToupie() <= 0) {
                checkFinCombat();
                return;
            }
        }

        afficherComboEnnemie(nombreCoups);
    }

    private void gererChangementKerbeus() {
        float degatsJoueur = combatController.attaqueJoueur();
        float degats = combatController.attaqueAdv();
        int chance = alea();  // Générer un nombre aléatoire pour l'esquive

        if ("Kerbeus".equalsIgnoreCase(toupieAdv.getEnergyLayerEnnemie().getNomLayer())) {



            if (Tour.getNumeroTour() % 4 == 0) {
                combatController.activerProtectionEnnemie();
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("Changement de mode pour Kerbeus");
                a.setHeaderText("Kerbeus reçoit une augmentation de défense pendant 3 tours");
                a.setContentText("Réduction de dégâts de 60%");
                a.showAndWait();
            }

            if (combatController.estEnProtectionEnnemie()) {
                degatsJoueur *= 0.60f;  // Réduit les dégâts infligés par le joueur

                if (chance < 50) {
                    combatController.perdrePDV(0.2f * toupieJoueur.getVieActuelleToupie());  // Kerbeus inflige des dégâts à la toupie du joueur
                    degatsJoueur *= 0.9f;  // Réduit légèrement les dégâts
                    afficherComboEnnemie();
                    System.out.println("Kerbeus active sa propulsion enchaînée !");
                }

                combatController.reduireProtectionEnnemie();  // Réduit la protection à la fin du tour
            }

            appliquerDegatsSurJoueur(degats);
        }
    }

    private void gererChangementKerbeus2(){
        float degatsJoueur = combatController.attaqueJoueur();
        float degats = combatController.attaqueAdv();
        int chance = alea();
        if ("Kerbeus".equalsIgnoreCase(toupieAdv.getEnergyLayerEnnemie().getNomLayer())) {

            if (Tour.getNumeroTour() % 4 == 0) {
                combatController.activerProtectionEnnemie();
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setTitle("Changement de mode pour Kerbeus");
                a.setHeaderText("Kerbeus reçoit une augmentation de défense \n Pendant 3 tours");
                a.setContentText("Réduction de dégâts de 60 % ");
                a.showAndWait();
            }

            if (combatController.estEnProtectionEnnemie()) {
                degatsJoueur *= 0.60f;

                if (chance < 50) {
                    combatController.perdrePDV(0.2f * toupieJoueur.getVieActuelleToupie());
                    degatsJoueur *= 0.9f;
                    afficherComboEnnemie();
                    System.out.println("Kerbeus active sa propulsion enchaînée !");
                }

                combatController.reduireProtectionEnnemie();
            }


            //appliquerRegenerationFinDeTour();
            //writeRapideInt(lblNombreTour, Tour.suivant());
            return;
        }
    }




    private void gererChangementModeEnnemiZAchilles() {
        float vieActuelle = toupieAdv.getVieActuelleEnnemie();
        float vieMax = toupieAdv.getVieMaxEnnemie();
        int chance = alea();  // Générer un nombre aléatoire pour l'esquive

        if (zAchillesEstMort || vieActuelle <= 0) return;

        String nomToupieTip = toupieAdv.getPerformanceTipEnnemie().getNomTip();
        if (!nomToupieTip.contains("Xtend")) return;



        // Life After Death (si applicable)
        if (vieActuelle <= 1 && !lifeAfterDeathActivated) {
            lifeAfterDeathActivated = true;
            toupieAdv.setVieActuelleEnnemie(1);

            combatController.desactiverModesZ();
            combatController.activerModeEnduranceZ();

            toupieAdv.setDefenseEnnemie(toupieAdv.getDefenseEnnemie() + 25);
            toupieAdv.setAttaqueEnnemie(toupieAdv.getAttaqueEnnemie() - 10);

            modeAttaqueZActive = false;
            modeDefenseZActive = false;
            modeEnduranceZActive = true;

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Double Activation");
            a.setHeaderText("Life After Death + Mode Endurance !");
            a.setContentText("PV bloqués à 1, Défense +25 / Attaque -10");
            a.showAndWait();

            Platform.runLater(() -> {
                majVieEnnemi();
                checkFinCombat();
            });

            return; // Attente du prochain tour
        }

        // Modes de Z Achilles et gestion des dégâts
        if (vieActuelle <= 0.1f * vieMax && !modeEnduranceZActive && !lifeAfterDeathActivated) {
            combatController.desactiverModeAttaqueZ();
            combatController.desactiverModeDefenseZ();
            combatController.activerModeEnduranceZ();

            toupieAdv.setDefenseEnnemie(toupieAdv.getDefenseEnnemie() + 25);
            toupieAdv.setAttaqueEnnemie(toupieAdv.getAttaqueEnnemie() - 10);

            modeAttaqueZActive = false;
            modeDefenseZActive = false;
            modeEnduranceZActive = true;

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Mode Endurance Activé");
            a.setHeaderText("Z Achilles devient ultra résistant !");
            a.setContentText("Défense +25 / Attaque -10");
            a.showAndWait();
        }

        // Mode Attaque ou Défense (selon les conditions)
        else if (vieActuelle <= 0.6f * vieMax && !modeAttaqueZActive && !modeEnduranceZActive) {
            combatController.resetStatsSansChangerMode();
            combatController.desactiverModeDefenseZ();
            combatController.desactiverModeEnduranceZ();
            combatController.activerModeAttaqueZ();

            toupieAdv.setDefenseEnnemie(toupieAdv.getDefenseEnnemie() - 15);
            toupieAdv.setAttaqueEnnemie(toupieAdv.getAttaqueEnnemie() + 15);

            modeAttaqueZActive = true;
            modeDefenseZActive = false;
            modeEnduranceZActive = false;

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mode Attaque");
            alert.setHeaderText("Z Achilles devient hyper agressif !");
            alert.setContentText("Attaque +15 / Défense -15 \n(Coups Critiques pendant 3 tours)");
            alert.showAndWait();

            combatController.activerModeCritiqueTemporaire(3);
        }

        // Mode Défense par défaut
        else if (!modeDefenseZActive && !modeEnduranceZActive && !modeAttaqueZActive) {
            combatController.resetStatsSansChangerMode();
            combatController.desactiverModeAttaqueZ();
            combatController.desactiverModeEnduranceZ();
            combatController.activerModeDefenseZ();

            toupieAdv.setDefenseEnnemie(toupieAdv.getDefenseEnnemie() + 15);
            toupieAdv.setAttaqueEnnemie(toupieAdv.getAttaqueEnnemie() - 15);

            modeAttaqueZActive = false;
            modeEnduranceZActive = false;
            modeDefenseZActive = true;
        }

        // Attaque de Z Achilles
        float degat = combatController.attaqueAdvZAchilles();
        appliquerDegatsSurJoueur(degat);

        if (toupieAdv.getVieActuelleEnnemie() <= 0) {
            zAchillesEstMort = true;
            toupieAdv.setVieActuelleEnnemie(0);
            checkFinCombat();
        }
    }





    private void gererChangementModeEnnemiZAchilles2() {
        // ▼▼ Blocage complet si Z Achilles est déjà mort ▼▼
        float vieActuelle = toupieAdv.getVieActuelleEnnemie();
        float vieMax = toupieAdv.getVieMaxEnnemie();

        if (zAchillesEstMort || vieActuelle <= 0) return;

        String nomToupieTip = toupieAdv.getPerformanceTipEnnemie().getNomTip();
        if (!nomToupieTip.contains("Xtend")) return;

        // ▼ LIFE AFTER DEATH ▼
        if (vieActuelle <= 1 && !lifeAfterDeathActivated) {
            lifeAfterDeathActivated = true;
            toupieAdv.setVieActuelleEnnemie(1);

            combatController.desactiverModesZ();
            combatController.activerModeEnduranceZ();

            toupieAdv.setDefenseEnnemie(toupieAdv.getDefenseEnnemie() + 25);
            toupieAdv.setAttaqueEnnemie(toupieAdv.getAttaqueEnnemie() - 10);

            modeAttaqueZActive = false;
            modeDefenseZActive = false;
            modeEnduranceZActive = true;

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Double Activation");
            a.setHeaderText("Life After Death + Mode Endurance !");
            a.setContentText("PV bloqués à 1, Défense +25 / Attaque -10");
            a.showAndWait();

            Platform.runLater(() -> {
                majVieEnnemi();
                checkFinCombat();
            });

            return; // Pas d’attaque, on attend le prochain tour
        }

        // ▼ MODE ENDURANCE ▼
        if (vieActuelle <= 0.1f * vieMax && !modeEnduranceZActive && !lifeAfterDeathActivated) {
            combatController.desactiverModeAttaqueZ();
            combatController.desactiverModeDefenseZ();
            combatController.activerModeEnduranceZ();

            toupieAdv.setDefenseEnnemie(toupieAdv.getDefenseEnnemie() + 25);
            toupieAdv.setAttaqueEnnemie(toupieAdv.getAttaqueEnnemie() - 10);

            modeAttaqueZActive = false;
            modeDefenseZActive = false;
            modeEnduranceZActive = true;

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Mode Endurance Activé");
            a.setHeaderText("Z Achilles devient ultra résistant !");
            a.setContentText("Défense +25 / Attaque -10");
            a.showAndWait();
        }

        // ▼ MODE ATTAQUE ▼
        else if (vieActuelle <= 0.6f * vieMax && !modeAttaqueZActive && !modeEnduranceZActive) {
            combatController.resetStatsSansChangerMode();
            combatController.desactiverModeDefenseZ();
            combatController.desactiverModeEnduranceZ();
            combatController.activerModeAttaqueZ();

            toupieAdv.setDefenseEnnemie(toupieAdv.getDefenseEnnemie() - 15);
            toupieAdv.setAttaqueEnnemie(toupieAdv.getAttaqueEnnemie() + 15);

            modeAttaqueZActive = true;
            modeDefenseZActive = false;
            modeEnduranceZActive = false;

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mode Attaque");
            alert.setHeaderText("Z Achilles devient hyper agressif !");
            alert.setContentText("Attaque +15 / Défense -15 \n(Coups Critiques pendant 3 tours)");
            alert.showAndWait();

            combatController.activerModeCritiqueTemporaire(3);
        }

        // ▼ MODE DÉFENSE PAR DÉFAUT ▼
        else if (!modeDefenseZActive && !modeEnduranceZActive && !modeAttaqueZActive) {
            combatController.resetStatsSansChangerMode();
            combatController.desactiverModeAttaqueZ();
            combatController.desactiverModeEnduranceZ();
            combatController.activerModeDefenseZ();

            toupieAdv.setDefenseEnnemie(toupieAdv.getDefenseEnnemie() + 15);
            toupieAdv.setAttaqueEnnemie(toupieAdv.getAttaqueEnnemie() - 15);

            modeAttaqueZActive = false;
            modeEnduranceZActive = false;
            modeDefenseZActive = true;

            // Alert désactivé ici volontairement
        }

        // ▼▼▼ ATTAQUE ▼▼▼
        float degat = combatController.attaqueAdvZAchilles();
        float attaque = combatController.perdrePDV(degat);
        appliquerDegatsSurJoueur(attaque / 1.5f);
        //combatController.checkEtDecrementerCritique();

        // ▼▼▼ Check si Z Achilles meurt ▼▼▼
        if (toupieAdv.getVieActuelleEnnemie() <= 0) {
            zAchillesEstMort = true;
            toupieAdv.setVieActuelleEnnemie(0);
            checkFinCombat();
        }
    }








    private void majVieJoueur() {
        float pourcentageJoueur = toupieJoueur.getVieActuelleToupie() / toupieJoueur.getVieMaxToupie();

        barreVieToupiePerso.setProgress(pourcentageJoueur);
        vitaMajJoueur();
    }
    private void majVieEnnemi() {
        float pourcentageAdv = toupieAdv.getVieActuelleEnnemie() / toupieAdv.getVieMaxEnnemie();
        barrevieToupieEnnemie.setProgress(pourcentageAdv);
        vitaMajAdv();
    }
    /*private void appliquerRegenerationFinDeTour() {

        majVieJoueur();
        majVieEnnemi(); // méthode à créer aussi si nécessaire
    }*/
    public void finDeTour() {

        attaqueValkyrieEffectueeCeTour = false;

        gererChangementModeToupieEnnemi(); // Ajout ici pour centraliser les changements de mode
        writeRapideInt(lblNombreTour, Tour.suivant());
        checkFinCombat();
    }




    private void appliquerDegatsSurJoueur(float degats) {
        if ("kerbeus".equalsIgnoreCase(toupieJoueur.getEnergyLayer().getNomLayer())) { // Si on joue Kerbeus

            if (combatController.estEnProtection()) { // protection active

                degats = 0.6f * degats ; // exemple : réduire les dégâts
                if ( degats < 0){
                    degats = 0;
                }
            }
            combatController.reduireProtection();
            if (combatController.finProtection()) {
                visibleImage(imgProtection); // la protection est finie, on ré-affiche
            }
        }
        combatController.perdrePDV(degats );



        majVieJoueur();
        checkFinCombat();
    }


    public void finCombat(boolean victoire, boolean burst) {
        if (!combatEnCours) return;
        combatEnCours = false;

        Runnable finDeCombat = () -> {
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);

                // ▼▼▼ RÉTABLIR LA LOGIQUE DE MESSAGE ▼▼▼
                if (victoire) {
                    alert.setTitle("Félicitations !");
                    alert.setHeaderText(burst ? "Victoire par Burst !" : "Vous avez Gagné !");
                    int gain = burst ? 1500 : 1000;
                    toupieJoueur.setNombreBeyPoints(toupieJoueur.getNombreBeyPoints() + gain);
                    alert.setContentText("BeyPoints gagnés : +" + gain +
                            "\nTotal actuel : " + toupieJoueur.getNombreBeyPoints());

                } else {
                    alert.setTitle("Dommage...");
                    alert.setHeaderText(burst ? "Défaite par Burst !" : "Vous avez Perdu !");
                    int perte = burst ? 500 : 0;
                    int nouvelleValeur = Math.max(0, toupieJoueur.getNombreBeyPoints() - perte);
                    toupieJoueur.setNombreBeyPoints(nouvelleValeur);
                    alert.setContentText("BeyPoints perdus : " + (burst ? "-500" : "0") +
                            "\nTotal actuel : " + nouvelleValeur);
                }

                alert.showAndWait();
                writeRapideInt(lblBeyPoint, toupieJoueur.getNombreBeyPoints());
                resetCombat();
                visible(apMenuPrincipal);
            });
        };

        if (burst) {
            affBurst(() -> Platform.runLater(finDeCombat));
        } else {
            Platform.runLater(finDeCombat);
        }
        checkFinCombat();
    }


    private void resetCombat() {
        combatEnCours = true; // Réactiver pour le prochain combat
        clearAll();
        // Réinitialiser les stats des toupies si nécessaire
        toupieJoueur.resetStats();
        toupieAdv.resetStats();
    }

    public void checkFinCombat() {
        if (lifeAfterDeathActivated && toupieAdv.getVieActuelleEnnemie() <= 0) {
            finCombat(true, false); // ▼ Fin normale sans burst
            lifeAfterDeathActivated = false; // ▼ Réinitialisation pour le prochain combat
            return;
        }
        if (combatController.isModeEnduranceZ() && toupieAdv.getVieActuelleEnnemie() == 1) {
            return; // Empêche la fin du combat tant que le mode est actif
        }
        if (toupieJoueur.getVieActuelleToupie() <= 0 && toupieAdv.getVieActuelleEnnemie() > 0) {
            // Défaite du joueur
            int chance = alea();
            boolean burst = (chance < 20); // 20% de chance de burst
            finCombat(false, burst); // Appel avec burst calculé

        } else if (toupieJoueur.getVieActuelleToupie() > 0 && toupieAdv.getVieActuelleEnnemie() <= 0) {
            // Victoire du joueur
            int chance = alea();
            boolean burst = (chance < 20); // 20% de chance de burst
            finCombat(true, burst); // Appel avec burst calculé
        }
    }




    public float volRotationEnnemie() {
        float degatsSubis = (float) (toupieAdv.getVieMaxEnnemie() * 0.2);

        if (toupieAdv.getRotationEnnemie().getTypeRotation().equalsIgnoreCase(toupieJoueur.getRotation().getTypeRotation())) {


            System.out.println("Impossible d'absorber les toupies de même rotation");
            return 0;

        }

        combatController.gagnerVieEnnemie(degatsSubis);

        majVieEnnemi();



        return degatsSubis;
    }




    @FXML
    public void btnEsquive(MouseEvent event) {
        float pourcentageJoueur = toupieJoueur.getVieActuelleToupie()/toupieJoueur.getVieMaxToupie();
        if (alea() < toupieJoueur.getEsquive()){
            combatController.perdrePDVEnnemie(toupieAdv.getVieActuelleEnnemie() * 0.05f);


            afficherComboEsquive();


        }else {
            combatController.perdrePDV(combatController.attaqueAdv());

        }


        majVieEnnemi();
        majVieJoueur();
        writeRapideInt(lblNombreTour,Tour.suivant());
        checkFinCombat();

    }
    @FXML
    public void btnProtection(MouseEvent event) {

        combatController.activerProtection();
        invisibleImage(imgProtection);



        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Augmentation de défense");
        a.setHeaderText("Pendant 3 tours les dégâts adverses seront réduits");
        a.setContentText(null);
        a.showAndWait();


        majVieJoueur();
    }



    @FXML
    public void btnRotationSteal(MouseEvent event) {
        if ("Drain Fafnir".equalsIgnoreCase(toupieJoueur.getEnergyLayer().getNomLayer())) {

            if (toupieJoueur.getRotation().getTypeRotation().equalsIgnoreCase(toupieAdv.getRotationEnnemie().getTypeRotation())) {
                invisibleImage(imgRotationSteal);
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Rotation identique");
                alert.setHeaderText("Absorption impossible !");
                alert.setContentText("Fafnir ne peut voler l'endurance qu'à une toupie de rotation opposée.");
                alert.showAndWait();
                return;
            }

            // ✅ Rotation opposée → absorption
            float pvAbsorbes = (float) (toupieJoueur.getVieMaxToupie() * 0.2);
            combatController.gagnerVie(pvAbsorbes);

            if (toupieJoueur.getVieActuelleToupie() > toupieJoueur.getVieMaxToupie()) {
                toupieJoueur.setVieActuelle(toupieJoueur.getVieMaxToupie());
            }

            System.out.println("Drain Fafnir a absorbé " + pvAbsorbes + " PV !");
        }



        // Enchaînements ennemis
      verifierEtChangerModeValkyrie();
        attaquerAvecValkyrieSiModeActif();
        gererChangementKerbeus2();
        gererChangementModeEnnemiZAchilles2();

        // ✅ Mettre à jour uniquement après tous les changements
        float nouveauPourcentage = toupieJoueur.getVieActuelleToupie() / toupieJoueur.getVieMaxToupie();
        barreVieToupiePerso.setProgress(nouveauPourcentage);

        writeRapideFloat(lblNombrePVToupiePerso, toupieJoueur.getVieActuelleToupie());

        majVieJoueur();
        writeRapideInt(lblNombreTour,Tour.suivant());

       checkFinCombat();
    }



    @FXML
    public void btnModeTroislames(MouseEvent event) {
        float pourcentageJoueur = toupieJoueur.getVieActuelleToupie() / toupieJoueur.getVieMaxToupie();
        visibleImage(imgModeSixLames);
        invisibleImage(imgModeTroisLames);
        combatController.desactiverModeSixLames();
        combatController.perdrePDV(combatController.attaqueAdv());

        majVieJoueur();
    }

    @FXML
    public void btnModeSixLames(MouseEvent event) {
        float pourcentageJoueur = toupieJoueur.getVieActuelleToupie() / toupieJoueur.getVieMaxToupie();
        if ("Brave Valkyrie".equalsIgnoreCase(toupieJoueur.getEnergyLayer().getNomLayer())) {
            visibleImage(imgModeTroisLames);
            invisibleImage(imgModeSixLames);
            combatController.activerModeSixLames();

            majVieJoueur();
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
