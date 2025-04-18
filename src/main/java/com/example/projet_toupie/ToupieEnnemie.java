package com.example.projet_toupie;

public class ToupieEnnemie {


        private String nomToupieEnnemie;
        private EnergyLayer energyLayerEnnemie;
        private ForgeDisc forgeDiscsEnnemie;
        private PerformanceTip performanceTipEnnemie;
        private ClasseToupie classeToupieEnnemie;
        private int vieMaxEnnemie;
        private int vieActuelle;
        private int attaqueEnnemie;
        private int defenseEnnemie;
        private int enduranceEnnemie;

        private int coupCritiqueEnnemie;
        private int nombreBeyPointsEnnemie;
        private int esquiveEnnemie;
        private Rotation rotationEnnemie;
        private String urlToupieEnnemie;

        public ToupieEnnemie(String nomToupieEnnemie ,EnergyLayer energyLayerEnnemie, ForgeDisc forgeDiscsEnnemie, PerformanceTip performanceTipEnnemie, ClasseToupie classeToupieEnnemie, int vieMaxEnnemie, int attaqueEnnemie, int defenseEnnemie, int enduranceEnnemie, Rotation rotationEnnemie,String urlToupieEnnemiee) {
            this.nomToupieEnnemie = nomToupieEnnemie;
            this.energyLayerEnnemie = energyLayerEnnemie;

            this.forgeDiscsEnnemie = forgeDiscsEnnemie;
            this.performanceTipEnnemie = performanceTipEnnemie;
            this.classeToupieEnnemie = classeToupieEnnemie;
            this.vieMaxEnnemie = vieMaxEnnemie;
            this.attaqueEnnemie = attaqueEnnemie;
            this.defenseEnnemie = defenseEnnemie;
            this.enduranceEnnemie = enduranceEnnemie;


            this.rotationEnnemie = rotationEnnemie;
            this.urlToupieEnnemie = urlToupieEnnemiee;
        }

    public String getNomToupieEnnemie() {
        return nomToupieEnnemie;
    }

    public EnergyLayer getEnergyLayerEnnemie() {
        return energyLayerEnnemie;
    }

    public ForgeDisc getForgeDiscsEnnemie() {
        return forgeDiscsEnnemie;
    }

    public PerformanceTip getPerformanceTipEnnemie() {
        return performanceTipEnnemie;
    }

    public ClasseToupie getClasseToupieEnnemie() {
        return classeToupieEnnemie;
    }

    public int getVieMaxEnnemie() {
        return vieMaxEnnemie;
    }

    public int getVieActuelle() {
        return vieActuelle;
    }

    public int getAttaqueEnnemie() {
        return attaqueEnnemie;
    }

    public int getDefenseEnnemie() {
        return defenseEnnemie;
    }

    public int getEnduranceEnnemie() {
        return enduranceEnnemie;
    }

    public int getCoupCritiqueEnnemie() {
        return coupCritiqueEnnemie;
    }

    public int getNombreBeyPointsEnnemie() {
        return nombreBeyPointsEnnemie;
    }

    public int getEsquiveEnnemie() {
        return esquiveEnnemie;
    }

    public Rotation getRotationEnnemie() {
        return rotationEnnemie;
    }

    public String getUrlToupieEnnemie() {
        return urlToupieEnnemie;
    }

    public int alea(){
            return (int) (Math.random() * 101);
        }
    }


