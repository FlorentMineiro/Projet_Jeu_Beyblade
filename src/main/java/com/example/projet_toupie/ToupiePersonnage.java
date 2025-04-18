package com.example.projet_toupie;

public class ToupiePersonnage {
    private String nomToupie;
    private EnergyLayer energyLayer;
    private ForgeDisc forgeDiscs;
    private PerformanceTip performanceTip;
    private ClasseToupie classeToupie;
    private int vieMax;
    private int vieActuelle;
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

    public int getVieMaxToupie() {


        return vieMax;
    }

    public int getVieActuelle() {
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
    public float attaqueGlobale(ToupieEnnemie toupieEnnemie) {
        // Dégâts de base avec ton multiplicateur standard
        float degat = (float) (1.5 * this.attaque);

        // On récupère les types des deux toupies
        String typePerso = this.classeToupie.getTypeToupie(); // ex: "Attaque"
        String typeEnnemi = toupieEnnemie.getClasseToupieEnnemie().getTypeToupie(); // ex: "Endurance"

        // Bonus/malus en fonction du type
        if ("Attaque".equalsIgnoreCase(typePerso)) {
            if ("Endurance".equalsIgnoreCase(typeEnnemi)) {
                degat *= (float)1.2; // Bonus contre Endurance
            } else if ("Défense".equalsIgnoreCase(typeEnnemi)) {
                degat *= (float)0.8; // Malus contre Défense
            }
        }

        return degat;
    }




    public void setNombreBeyPoints(int nombreBeyPoints) {
        this.nombreBeyPoints = nombreBeyPoints;
    }

    public void setVieActuelle(int vieActuelle) {
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

    public int alea(){
        return (int) (Math.random() * 101);
    }
}
