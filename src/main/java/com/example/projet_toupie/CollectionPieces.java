package com.example.projet_toupie;

import java.util.ArrayList;

public class CollectionPieces {
    private ArrayList<EnergyLayer> energyLayers = new ArrayList<>();
    private ArrayList<ForgeDisc> forgeDiscs = new ArrayList<>();
    private ArrayList<PerformanceTip> performanceTips = new ArrayList<>();

    public void ajouterEnergyLayer(EnergyLayer layer) {
        energyLayers.add(layer);
    }

    public void ajouterForgeDisc(ForgeDisc disc) {
        forgeDiscs.add(disc);
    }

    public void ajouterPerformanceTip(PerformanceTip tip) {
        performanceTips.add(tip);
    }

    public ArrayList<EnergyLayer> getEnergyLayers() {
        return energyLayers;
    }

    public ArrayList<ForgeDisc> getForgeDiscs() {
        return forgeDiscs;
    }

    public ArrayList<PerformanceTip> getPerformanceTips() {
        return performanceTips;
    }
}
