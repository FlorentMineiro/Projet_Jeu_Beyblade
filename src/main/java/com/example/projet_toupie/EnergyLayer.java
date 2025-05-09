package com.example.projet_toupie;

import java.util.Objects;

public class EnergyLayer {


    private Rotation rotationLayer;

    private String nomLayer;


    private int statAttaqueLayer;
    private int statDefenseLayer;
    private int statEnduranceLayer;
    private double poidsLayer;
    private String urlLayer;
    public boolean estDebloqueeLayer;

    // Constructeur principal avec toutes les stats
    public EnergyLayer(String nomLayer,Rotation rotationLayer, int statAttaqueLayer, int statDefenseLayer, int statEnduranceLayer, double poidsLayer, String urlLayer) {
        this.nomLayer = nomLayer;

        this.rotationLayer = rotationLayer;
        this.statAttaqueLayer = statAttaqueLayer;
        this.statDefenseLayer = statDefenseLayer;
        this.statEnduranceLayer = statEnduranceLayer;
        this.poidsLayer = poidsLayer;
        this.urlLayer = urlLayer;

    }

    // Constructeur secondaire pour les comparaisons (par nom uniquement)
    public EnergyLayer(String nomLayer) {
        this.nomLayer = nomLayer;

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnergyLayer that = (EnergyLayer) o;
        return Objects.equals(nomLayer, that.nomLayer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomLayer);
    }

    // Getters
    public String getNomLayer() { return nomLayer; }

    public int getStatAttaqueLayer() { return statAttaqueLayer; }
    public int getStatDefenseLayer() { return statDefenseLayer; }
    public int getStatEnduranceLayer() { return statEnduranceLayer; }
    public double getPoidsLayer() { return poidsLayer; }
    public String getUrlLayer() { return urlLayer; }

    public boolean isEstDebloqueeLayer() {
        return estDebloqueeLayer;
    }
}
