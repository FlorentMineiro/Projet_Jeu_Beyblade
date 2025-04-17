package com.example.projet_toupie;

public class ClasseToupie {

    private String typeToupie;

    private int statAttaque;
    private int statDefense;
    private int statEsquive;

    public ClasseToupie(String typeToupie) {

        this.typeToupie = typeToupie;
    }

    public String getTypeToupie() {
        return typeToupie;
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
