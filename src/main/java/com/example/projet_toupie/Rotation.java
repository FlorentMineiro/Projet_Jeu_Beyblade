package com.example.projet_toupie;

public class Rotation {
    private String typeRotation;
    private int statAttaque_v2;
    private int statDefense_v2;
    private int statEsquive_v2;


    public Rotation(String typeRotation) {
        this.typeRotation = typeRotation;
    }

    public String getTypeRotation() {
        return typeRotation;
    }

    public int getStatAttaque_v2() {
        return statAttaque_v2;
    }

    public void setStatAttaque_v2(int statAttaque_v2) {
        this.statAttaque_v2 = statAttaque_v2;
    }

    public int getStatDefense_v2() {
        return statDefense_v2;
    }

    public void setStatDefense_v2(int statDefense_v2) {
        this.statDefense_v2 = statDefense_v2;
    }

    public int getStatEsquive_v2() {
        return statEsquive_v2;
    }

    public void setStatEsquive_v2(int statEsquive_v2) {
        this.statEsquive_v2 = statEsquive_v2;
    }
}
