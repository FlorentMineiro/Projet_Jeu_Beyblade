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
    public boolean possedeDejaEnergyLayer(EnergyLayer layer) {
        for (EnergyLayer l : energyLayers) {
            if (l.getNomLayer().equals(layer.getNomLayer())) {
                return true;
            }
        }
        return false;
    }
    public boolean possedeDejaForgeDiscs(ForgeDisc disc ) {
        for (ForgeDisc f : forgeDiscs) {
            if (f.getNomDisc().equals(disc.getNomDisc())) {
                return true;
            }
        }
        return false;
    }
    public boolean possedeDejaPerformanceTip(PerformanceTip tip) {
        for (PerformanceTip p : performanceTips) {
            if (p.getNomTip().equals(tip.getNomTip())) {
                return true;
            }
        }
        return false;
    }

}
