package com.example.projet_toupie;

public class ClasseToupie {
    private boolean typeAttaque;
    private boolean typeDefense;
    private boolean typeEndurance;
    private boolean droite;
    private boolean gauche;
    private boolean doubleRotation;
    private int statAttaque;
    private int statDefense;
    private int statEsquive;

    public ClasseToupie(boolean typeAttaque, boolean typeDefense, boolean typeEndurance) {
        this.typeAttaque = typeAttaque;
        this.typeDefense = typeDefense;
        this.typeEndurance = typeEndurance;
    }



    public boolean isTypeAttaque() {
        return typeAttaque;
    }

    public boolean isTypeDefense() {
        return typeDefense;
    }

    public boolean isTypeEndurance() {
        return typeEndurance;
    }

    public int getStatAttaque() {

        return statAttaque;
    }

    public int getStatDefense() {
        return statDefense;
    }

    public int getStatEsquive() {
        return statEsquive;
    }
}
