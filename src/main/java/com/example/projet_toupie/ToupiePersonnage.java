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

    ToupieEnnemie toupieEnnemie;


    public ToupiePersonnage(String nomToupie ,EnergyLayer energyLayer, ForgeDisc forgeDiscs, PerformanceTip performanceTip, ClasseToupie classeToupie, int vieMax, int attaque, int defense, int endurance, Rotation rotation,String urlToupie) {
        this.nomToupie = nomToupie;
        this.energyLayer = energyLayer;

        this.forgeDiscs = forgeDiscs;
        this.performanceTip = performanceTip;
        this.classeToupie = classeToupie;
        this.vieMax = vieMax;
        this.attaque = attaque;
        this.defense = defense;
        this.endurance = endurance;
        this.coupCritique = coupCritique;
        this.esquive = esquive;
        this.nombreBeyPoints = 1000;
        this.rotation = rotation;
        this.urlToupie = urlToupie;
    }

    public String getNomToupie() {
        return nomToupie;
    }

    public float getVieMaxToupie() {


        return vieMax;
    }

    public float getVieActuelle() {
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

    public int getCoupCritique() {
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
        float degat = 1.5f * this.attaque;

        if ("Attaque".equalsIgnoreCase(typePerso)) {
            if ("Endurance".equalsIgnoreCase(typeEnnemi)) {
                degat *= 1.2f;
            } else if ("Défense".equalsIgnoreCase(typeEnnemi)) {
                degat *= 0.8f;
            }
        }

        return degat;
    }

    public float reductionAttaque(ToupiePersonnage attaquant) {
        // Dégâts initiaux reçus (on suppose que l'attaquant attaque à pleine force)
        float degatsRecus = attaquant.attaqueGlobale(this); // appel à attaqueGlobale avec "this" en tant que cible

        // Réduction selon la défense de la toupie actuelle (la cible)
        float facteurDefense = 1 - (this.defense * 0.02f); // chaque point de défense réduit de 2%
        if (facteurDefense < 0.1f) facteurDefense = 0.1f; // limite minimale (ne jamais annuler totalement les dégâts)

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

        return degatsRecus;
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
        return (int) (Math.random() * 11);
    }
}
