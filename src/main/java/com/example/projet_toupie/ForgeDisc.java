package com.example.projet_toupie;

import java.util.Objects;

public class ForgeDisc {
private String nomDisc;
private int statAttaqueDisc;
private int statDefenseDisc;
private int statEnduranceDisc;
private double poidsDisc;
public String urlDisc;

    public ForgeDisc(String nomDisc, int statAttaqueDisc, int statDefenseDisc, int statEnduranceDisc, double poidsDisc, String urlDisc) {
        this.nomDisc = nomDisc;
        this.statAttaqueDisc = statAttaqueDisc;
        this.statDefenseDisc = statDefenseDisc;
        this.statEnduranceDisc = statEnduranceDisc;
        this.poidsDisc = poidsDisc;
        this.urlDisc = urlDisc;
    }

    public ForgeDisc(String nomDisc) {
        this.nomDisc = nomDisc;
    }

    @Override
        public boolean equals(Object o) {
            if (this == o){
                return true;
            }
            if (o == null || getClass() != o.getClass()){
                return false;
            }
            com.example.projet_toupie.ForgeDisc that = (com.example.projet_toupie.ForgeDisc) o;
            return Objects.equals(nomDisc, that.nomDisc); // Compare par le nom uniquement
        }

        @Override
        public int hashCode() {
            return Objects.hash(nomDisc); // Cohérent avec equals()
        }





        public String getNomTip() { return nomDisc; }
        public int getStatAttaqueDisc() { return statAttaqueDisc; }
        public int getStatDefenseDisc() { return statDefenseDisc; }
        public int getStatEnduranceDisc() { return statEnduranceDisc; }
        public double getPoidsDisc() { return poidsDisc; }
        public String getUrlDisc() { return urlDisc; }
    }


