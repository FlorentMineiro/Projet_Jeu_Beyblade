package com.example.projet_toupie;

import java.util.ArrayList;

public class ToupiePersonnage {
    private String energyLayer;
    private String forgeDiscs;
    private String performanceTip;
    private ClasseToupie classeToupie;
    private int attaque;
    private int defense;
    private int endurance;

    private int coupCritique;
    private int nombreBeyPoints;
    private int esquive;
    private Rotation rotation;
    private ArrayList<String> listToupie;

    public ToupiePersonnage(String energyLayer, String forgeDiscs, String performanceTip,ClasseToupie classeToupie, int endurance, int defense, int attaque , Rotation rotation) {
        this.energyLayer = energyLayer;
        this.forgeDiscs = forgeDiscs;
        this.performanceTip = performanceTip;
        this.classeToupie = classeToupie;

        this.endurance = endurance;
        this.defense = defense;
        this.attaque = attaque;
        this.nombreBeyPoints = 1000;
        this.listToupie = new ArrayList<>();
        this.rotation = rotation;


    }

    public String getEnergyLayer() {
        return energyLayer;
    }

    public String getForgeDiscs() {
        return forgeDiscs;
    }

    public String getPerformanceTip() {
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

    public ArrayList<String> getListToupie() {
        return listToupie;
    }



    public int alea(){
        return (int) (Math.random() * 101);
    }
}
