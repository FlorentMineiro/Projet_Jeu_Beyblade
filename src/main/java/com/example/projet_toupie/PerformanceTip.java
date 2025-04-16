package com.example.projet_toupie;

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

    public String getNomTip() { return nomTip; }
    public int getStatAttaqueTip() { return statAttaqueTip; }
    public int getStatDefenseTip() { return statDefenseTip; }
    public int getStatEnduranceTip() { return statEnduranceTip; }
    public double getPoidsTip() { return poidsTip; }
    public String getUrlTip() { return urlTip; }
}
