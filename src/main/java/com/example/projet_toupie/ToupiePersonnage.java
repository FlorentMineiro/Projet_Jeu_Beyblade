package com.example.projet_toupie;

public class ToupiePersonnage {
    private String nomToupie;
    private EnergyLayer energyLayer;
    private ForgeDisc forgeDiscs;
    private PerformanceTip performanceTip;
    private ClasseToupie classeToupie;
    private float vieMax;
    private float vieActuelle;
    private float attaque;
    private int defense;
    private int endurance;

    private int coupCritique;
    private int nombreBeyPoints;
    private int esquive;
    private Rotation rotation;
    private String urlToupie;
    private Tour tourAllie;

    ToupieEnnemie toupieEnnemie;


    public ToupiePersonnage(String nomToupie ,EnergyLayer energyLayer, ForgeDisc forgeDiscs, PerformanceTip performanceTip, ClasseToupie classeToupie, int vieMax,int vieActuelle, int attaque, int defense, int endurance,int coupCritique,int esquive, Rotation rotation,String urlToupie) {
        this.nomToupie = nomToupie;
        this.energyLayer = energyLayer;

        this.forgeDiscs = forgeDiscs;
        this.performanceTip = performanceTip;
        this.classeToupie = classeToupie;
        this.vieMax = vieMax;
        this.vieActuelle = vieActuelle;
        this.attaque = attaque;
        this.defense = defense;
        this.endurance = endurance;

        this.coupCritique = coupCritique;
        this.esquive = esquive;
        this.nombreBeyPoints = 1000;
        this.rotation = rotation;
        this.urlToupie = urlToupie;
    }

    public ToupiePersonnage() {
        this.nomToupie = "Inconnue";

        this.classeToupie = null;
        this.vieMax = 1000;
        this.attaque = 50;
        this.defense = 50;
    }

    public String getNomToupie() {
        return nomToupie;
    }

    public float getVieMaxToupie() {


        return vieMax;
    }

    public Tour getTourAllie() {
        return tourAllie;
    }

    public float getVieActuelleToupie() {
        return vieActuelle;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public String getUrlToupie() {
        return urlToupie;
    }

    public EnergyLayer getEnergyLayer() {
        return energyLayer;
    }

    public ForgeDisc getForgeDiscs() {
        return forgeDiscs;
    }

    public PerformanceTip getPerformanceTip() {
        return performanceTip;
    }

    public ClasseToupie getClasseToupie() {
        return classeToupie;
    }

    public float getAttaqueToupie() {

        return attaque;
    }

    public int getDefenseToupie() {
        return defense;
    }

    public int getEnduranceToupie() {
        return endurance;
    }

    public int getCoupCritiqueToupie() {

        return coupCritique;
    }

    public int getNombreBeyPoints() {
        return nombreBeyPoints;
    }

    public int getEsquive() {
        return esquive;
    }
    public float attaqueGlobale(ToupiePersonnage cible) {
        String typePerso = this.classeToupie.getTypeToupie();
        String typeEnnemi = cible.getClasseToupie().getTypeToupie();
        float degat = (float) (this.attaque * 1.5);

        if ("Attaque".equalsIgnoreCase(typePerso)) {
            if ("Endurance".equalsIgnoreCase(typeEnnemi)) {
                degat *= 1.3;
            } else if ("Défense".equalsIgnoreCase(typeEnnemi)) {
                degat *= 0.8;
            }
        }
        if (alea() <= getCoupCritiqueToupie()){
            degat *= 2;
        }


        return degat;
    }
    public float attaqueGlobale(String typeEnnemi) {
        String typePerso = this.classeToupie.getTypeToupie();
        float degat = (float) (this.attaque * 1.5);

        if ("Attaque".equalsIgnoreCase(typePerso)) {
            if ("Endurance".equalsIgnoreCase(typeEnnemi)) {
                degat *= 1.3;
            } else if ("Défense".equalsIgnoreCase(typeEnnemi)) {
                degat *= 0.8;
            }
        }
        if (alea() <= getCoupCritiqueToupie()){
            degat *= 2;
        }

        return degat;
    }


    public float reductionAttaque(ToupiePersonnage attaquant) {
        // Dégâts initiaux reçus (on suppose que l'attaquant attaque à pleine force)
        float degatsRecus = attaquant.attaqueGlobale(this); // appel à attaqueGlobale avec "this" en tant que cible

        // Réduction selon la défense de la toupie actuelle (la cible)
        float facteurDefense = 1 - (this.defense * 0.03f); // chaque point de défense réduit de 2%
        if (facteurDefense < 0.1f) {
            facteurDefense = 0.1f; // limite minimale (ne jamais annuler totalement les dégâts)
        }

        degatsRecus *= facteurDefense;

        // Gestion des types (défense contre autres)
        String typeDefenseur = this.classeToupie.getTypeToupie(); // type de la toupie actuelle (défenseur)
        String typeAttaquant = attaquant.getClasseToupie().getTypeToupie(); // type de l'adversaire (attaquant)

        if ("Défense".equalsIgnoreCase(typeDefenseur)) {
            if ("Endurance".equalsIgnoreCase(typeAttaquant)) {
                degatsRecus *= 0.8f; // Bonus de défense contre endurance
            } else if ("Attaque".equalsIgnoreCase(typeAttaquant)) {
                degatsRecus *= 1.2f; // Malus de défense contre attaque
            }
        }
        if (degatsRecus < 0){
            degatsRecus = 0;
        }

        return degatsRecus;
    }
    public float perdPV(ToupiePersonnage attaquant){
            float degatBase = (float) (this.attaque * 1.2);
            float degatTotal = (float) (0.5 * degatBase)+reductionAttaque(attaquant);
            this.vieActuelle -= degatTotal;
            if(jetEsquive()){
                degatTotal = 0;
            }

            return degatTotal;

    }
    public float reductionAttaque2(float degat,String attaquant) {
        // Réduction de base
        degat -= this.defense;
        if (degat < 0) degat = 0;



        // Avantages/désavantages de type
        if ("Défense".equalsIgnoreCase(String.valueOf(getClasseToupie()))) {
            if ("Endurance".equalsIgnoreCase(attaquant)) {
                degat *= 0.8f;
            } else if ("Attaque".equalsIgnoreCase(attaquant)) {
                degat *= 1.2f;
            }
        }

        return degat;
    }

    public float perdPV2(float degat , String attaquant) {
        if (jetEsquive()) {
            return 0;
        }

        float degatBase = (float) (this.attaque * 1.2);
        float degatTotal = (float) (0.5 * degatBase) + reductionAttaque2(degat,attaquant);
        this.vieActuelle -= degatTotal;

        return degatTotal;
    }

    public float retourneDefense(ToupiePersonnage attaquant) {
        float degatSubi = perdPV(attaquant); // La toupie subit l'attaque

        if (degatSubi > 0) {
            float contreDegat = degatSubi * 0.5f; // Par exemple, elle renvoie 50% des dégâts subis
            attaquant.vieActuelle -= contreDegat;


        }

        return degatSubi; // On retourne quand même les dégâts que cette toupie a subis
    }


    public boolean jetEsquive(){
        if (alea() <= esquive){
            return true;
        }
        return false;
    }






    public void setNombreBeyPoints(int nombreBeyPoints) {
        this.nombreBeyPoints = nombreBeyPoints;
    }

    public void setVieActuelle(float vieActuelle) {
        this.vieActuelle = vieActuelle;
    }

    public void setAttaque(float attaque) {
        this.attaque = attaque;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setCoupCritique(int coupCritique) {
        this.coupCritique = coupCritique;
    }

    public void setEsquive(int esquive) {
        this.esquive = esquive;
    }

    public void setVieMax(float vieMax) {
        this.vieMax = vieMax;
    }

    public int alea(){
        return (int) (Math.random() * 101);
    }
}
