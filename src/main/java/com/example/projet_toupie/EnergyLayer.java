package com.example.projet_toupie;

import java.util.Objects;

public class EnergyLayer {
    public enum SystemeLayer {
        SINGLE, DUAL, GOD, GT, SPARKING, DB, BU,cho_z,
    }
    private GTSystem gtSystem;
    private DBSystem dbSystem;
    private SparkingSystem sparkingSystem;

    private Rotation rotationLayer;

    private String nomLayer;
    private SystemeLayer systemeLayer;

    private int statAttaqueLayer;
    private int statDefenseLayer;
    private int statEnduranceLayer;
    private double poidsLayer;
    private String urlLayer;

    // Constructeur principal avec toutes les stats
    public EnergyLayer(String nomLayer, SystemeLayer systemeLayer,Rotation rotationLayer, int statAttaqueLayer, int statDefenseLayer, int statEnduranceLayer, double poidsLayer, String urlLayer) {
        this.nomLayer = nomLayer;
        this.systemeLayer = systemeLayer;
        this.rotationLayer = rotationLayer;
        this.statAttaqueLayer = statAttaqueLayer;
        this.statDefenseLayer = statDefenseLayer;
        this.statEnduranceLayer = statEnduranceLayer;
        this.poidsLayer = poidsLayer;
        this.urlLayer = urlLayer;
        this.gtSystem = null;
        this.sparkingSystem = null;
        this.dbSystem = null;
    }

    // Constructeur secondaire pour les comparaisons (par nom uniquement)
    public EnergyLayer(String nomLayer) {
        this.nomLayer = nomLayer;

    }
    public EnergyLayer(String nomLayer, SystemeLayer systemeLayer,Rotation rotationLayer, int statAttaqueLayer, int statDefenseLayer, int statEnduranceLayer, double poidsLayer, String urlLayer, GTSystem gtSystem) {
        this(nomLayer, systemeLayer,rotationLayer, statAttaqueLayer, statDefenseLayer, statEnduranceLayer, poidsLayer, urlLayer);
        this.gtSystem = gtSystem;
        this.sparkingSystem = null;
        this.dbSystem = null;
    }
    public EnergyLayer(String nomLayer, SystemeLayer systemeLayer,Rotation rotationLayer, int statAttaqueLayer, int statDefenseLayer, int statEnduranceLayer, double poidsLayer, String urlLayer, SparkingSystem sparkingSystem) {
        this(nomLayer, systemeLayer,rotationLayer, statAttaqueLayer, statDefenseLayer, statEnduranceLayer, poidsLayer, urlLayer);
        this.gtSystem = null;
        this.sparkingSystem = sparkingSystem;
        this.dbSystem = null;
    }
    public EnergyLayer(String nomLayer, SystemeLayer systemeLayer,Rotation rotationLayer, int statAttaqueLayer, int statDefenseLayer, int statEnduranceLayer, double poidsLayer, String urlLayer, DBSystem dbSystem) {
        this(nomLayer, systemeLayer,rotationLayer, statAttaqueLayer, statDefenseLayer, statEnduranceLayer, poidsLayer, urlLayer);
        this.gtSystem = null;
        this.sparkingSystem = null;
        this.dbSystem = dbSystem;
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
    public SystemeLayer getSystemeLayer() { return systemeLayer; }
    public int getStatAttaqueLayer() { return statAttaqueLayer; }
    public int getStatDefenseLayer() { return statDefenseLayer; }
    public int getStatEnduranceLayer() { return statEnduranceLayer; }
    public double getPoidsLayer() { return poidsLayer; }
    public String getUrlLayer() { return urlLayer; }
}
