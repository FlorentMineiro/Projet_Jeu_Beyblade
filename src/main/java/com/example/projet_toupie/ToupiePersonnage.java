package com.example.projet_toupie;

import java.util.ArrayList;

public class ToupiePersonnage {
    private EnergyLayer energyLayer;
    private ForgeDisc forgeDiscs;
    private PerformanceTip performanceTip;
    private ClasseToupie classeToupie;
    private int vieMax;
    private int vieActuelle;
    private int attaque;
    private int defense;
    private int endurance;

    private int coupCritique;
    private int nombreBeyPoints;
    private int esquive;
    private Rotation rotation;
    private String urlToupie;

    public ToupiePersonnage(EnergyLayer energyLayer, ForgeDisc forgeDiscs, PerformanceTip performanceTip, ClasseToupie classeToupie, int vieMax, int attaque, int defense, int endurance, Rotation rotation,String urlToupie) {
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

    public int getVieMax() {


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

    public int getAttaque() {

        return attaque;
    }

    public int getDefense() {
        return defense;
    }

    public int getEndurance() {
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

    public void setNombreBeyPoints(int nombreBeyPoints) {
        this.nombreBeyPoints = nombreBeyPoints;
    }

    public int alea(){
        return (int) (Math.random() * 101);
    }
}
