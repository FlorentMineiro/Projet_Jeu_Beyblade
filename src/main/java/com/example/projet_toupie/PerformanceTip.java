package com.example.projet_toupie;

import java.util.Objects;

public class PerformanceTip {
    private String nomTip;
    private int statAttaqueTip;
    private int statDefenseTip;
    private int statEnduranceTip;
    private double poidsTip;
    public String urlTip;

    public PerformanceTip(String nomTip, int statAttaqueTip, int statDefenseTip, int statEnduranceTip, double poidsTip, String urlTip) {
        this.nomTip = nomTip;
        this.statAttaqueTip = statAttaqueTip;
        this.statDefenseTip = statDefenseTip;
        this.statEnduranceTip = statEnduranceTip;
        this.poidsTip = poidsTip;
        this.urlTip = urlTip;

    }

    public PerformanceTip(String nomTip) {
        this.nomTip = nomTip;

    }


        @Override
        public boolean equals(Object o) {
            if (this == o){
                return true;
            }
            if (o == null || getClass() != o.getClass()){
                return false;
            }
            PerformanceTip that = (PerformanceTip) o;
            return Objects.equals(nomTip, that.nomTip); // Compare par le nom uniquement
        }

        @Override
        public int hashCode() {
            return Objects.hash(nomTip); // Cohérent avec equals()
        }





    public String getNomTip() { return nomTip; }
    public int getStatAttaqueTip() { return statAttaqueTip; }
    public int getStatDefenseTip() { return statDefenseTip; }
    public int getStatEnduranceTip() { return statEnduranceTip; }
    public double getPoidsTip() { return poidsTip; }
    public String getUrlTip() { return urlTip; }
}
