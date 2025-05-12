package com.example.projet_toupie;

import static com.example.projet_toupie.ToupiePersonnage.toupieAdv;

public class ToupieEnnemie  {


        private String nomToupieEnnemie;
        private EnergyLayer energyLayerEnnemie;
        private ForgeDisc forgeDiscsEnnemie;
        private PerformanceTip performanceTipEnnemie;
        public static  ClasseToupie classeToupieEnnemie = new ClasseToupie("Neutre");
        private ClasseToupie classeToupieEnnemie2 = new ClasseToupie("Neutre");
    private int vieMaxEnnemie;
        private float vieActuelleEnnemie;
        private float attaqueEnnemie;
        private float defenseEnnemie;
        private float enduranceEnnemie;
        private   ToupiePersonnage toupiePersonnage ;

        private int coupCritiqueEnnemie;
        private int nombreBeyPointsEnnemie;
        private int esquiveEnnemie;
        private Rotation rotationEnnemie;
        private String urlToupieEnnemie;
        private Tour tourEnnemie;
        private int toursDeProtectionRestants = 0;
        private boolean protectionEnnemie;
        boolean enModeAttaque = true;
        int compteurTour = 0;
        int nombreAttaquesEvolution;
    private float baseAttaque;
    private float baseDefense;
    private float baseEndurance;
    private ZAchilles zAchilles;



    public ToupieEnnemie(String nomToupieEnnemie ,EnergyLayer energyLayerEnnemie, ForgeDisc forgeDiscsEnnemie, PerformanceTip performanceTipEnnemie, ClasseToupie classeToupieEnnemie, int vieMaxEnnemie,float vieActuelleEnnemie, int attaqueEnnemie, int defenseEnnemie, int enduranceEnnemie, int coupCritiqueEnnemie , int esquiveEnnemie, Rotation rotationEnnemie,String urlToupieEnnemiee) {
            this.nomToupieEnnemie = nomToupieEnnemie;
            this.energyLayerEnnemie = energyLayerEnnemie;

            this.forgeDiscsEnnemie = forgeDiscsEnnemie;
            this.performanceTipEnnemie = performanceTipEnnemie;
            this.classeToupieEnnemie = classeToupieEnnemie;
            this.vieMaxEnnemie = vieMaxEnnemie;
            this.vieActuelleEnnemie = vieActuelleEnnemie;
            this.attaqueEnnemie = attaqueEnnemie;
            this.defenseEnnemie = defenseEnnemie;
            this.enduranceEnnemie = enduranceEnnemie;
            this.coupCritiqueEnnemie = coupCritiqueEnnemie;
            this.esquiveEnnemie = esquiveEnnemie;


            this.rotationEnnemie = rotationEnnemie;
            this.urlToupieEnnemie = urlToupieEnnemiee;

        if ("Attaque".equals(this.classeToupieEnnemie2.getTypeToupie())) {
            this.vieActuelleEnnemie += (1.5f * enduranceEnnemie);
            this.vieMaxEnnemie += (1.5f * enduranceEnnemie);
        }
        if ("Défense".equals(this.classeToupieEnnemie2.getTypeToupie())) {
            this.vieActuelleEnnemie += (2f * enduranceEnnemie);
            this.vieMaxEnnemie += (2f * enduranceEnnemie);
        }
        if ("Equilibre".equals(this.classeToupieEnnemie2.getTypeToupie())) {
            this.vieActuelleEnnemie += (2f * enduranceEnnemie);
            this.vieMaxEnnemie += (2f * enduranceEnnemie);
        }
        if ("Endurance".equals(this.classeToupieEnnemie2.getTypeToupie())) {
            this.vieActuelleEnnemie += (3f * enduranceEnnemie);
            this.vieMaxEnnemie += (3f * enduranceEnnemie);
        }
        }

    public ToupieEnnemie(String nomToupieEnnemie,ClasseToupie classeToupieEnnemie, int vieMaxEnnemie, float vieActuelleEnnemie, int attaqueEnnemie, int defenseEnnemie, int enduranceEnnemie, int coupCritiqueEnnemie, int esquiveEnnemie) {
        this.nomToupieEnnemie = nomToupieEnnemie;
        this.vieMaxEnnemie = vieMaxEnnemie;
        this.vieActuelleEnnemie = vieActuelleEnnemie;
        this.attaqueEnnemie = attaqueEnnemie;
        this.defenseEnnemie = defenseEnnemie;
        this.enduranceEnnemie = enduranceEnnemie;
        this.coupCritiqueEnnemie = coupCritiqueEnnemie;
        this.esquiveEnnemie = esquiveEnnemie;
        this.classeToupieEnnemie = classeToupieEnnemie;
    }

    public ToupieEnnemie(ClasseToupie classeToupieEnnemie2) {
        this.classeToupieEnnemie2 = classeToupieEnnemie2;
    }

    public ToupieEnnemie() {
        this.attaqueEnnemie = 85;
        this.defenseEnnemie = 50;
        this.enduranceEnnemie = 60;

        this.baseAttaque = this.attaqueEnnemie;
        this.baseDefense = this.defenseEnnemie;
        this.baseEndurance = this.enduranceEnnemie;
    }

    public Tour getTourEnnemie() {
        return tourEnnemie;
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

    public float getVieActuelleEnnemie() {
        return vieActuelleEnnemie;
    }

    public float getAttaqueEnnemie() {
        return attaqueEnnemie;
    }

    public float getDefenseEnnemie() {
        return defenseEnnemie;
    }

    public float getEnduranceEnnemie() {
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

    public float setVieActuelleEnnemie(float vieActuelleEnnemie) {
        this.vieActuelleEnnemie = vieActuelleEnnemie;
        return vieActuelleEnnemie;
    }

    public void setVieMaxEnnemie(int vieMaxEnnemie) {
        this.vieMaxEnnemie = vieMaxEnnemie;
    }

    public void setAttaqueEnnemie(float attaqueEnnemie) {
        this.attaqueEnnemie = attaqueEnnemie;
    }

    public void setDefenseEnnemie(float defenseEnnemie) {
        this.defenseEnnemie = defenseEnnemie;
    }

    public void setEnduranceEnnemie(float enduranceEnnemie) {
        this.enduranceEnnemie = enduranceEnnemie;
    }

    public void setCoupCritiqueEnnemie(int coupCritiqueEnnemie) {
        this.coupCritiqueEnnemie = coupCritiqueEnnemie;
    }

    public void setEsquiveEnnemie(int esquiveEnnemie) {
        this.esquiveEnnemie = esquiveEnnemie;
    }

    public void setNombreBeyPointsEnnemie(int nombreBeyPointsEnnemie) {
        this.nombreBeyPointsEnnemie = nombreBeyPointsEnnemie;
    }

    public void setEnergyLayerEnnemie(EnergyLayer energyLayerEnnemie) {
        this.energyLayerEnnemie = energyLayerEnnemie;
    }

    public void setForgeDiscsEnnemie(ForgeDisc forgeDiscsEnnemie) {
        this.forgeDiscsEnnemie = forgeDiscsEnnemie;
    }

    public void setPerformanceTipEnnemie(PerformanceTip performanceTipEnnemie) {
        this.performanceTipEnnemie = performanceTipEnnemie;
    }

    public static void setClasseToupieEnnemie(ClasseToupie classeToupieEnnemie) {
        ToupieEnnemie.classeToupieEnnemie = classeToupieEnnemie;
    }

    public void setToupiePersonnage(ToupiePersonnage toupiePersonnage) {
        this.toupiePersonnage = toupiePersonnage;
    }

    public float coefficientReduction(float degatBase, ToupiePersonnage toupiePersonnage) {
        float coef = 1.0f;

        // Réduction de base selon la défense
        coef -= 0.7f * (this.defenseEnnemie / 100f);

        // Avantages/désavantages entre types
        if ("Défense".equalsIgnoreCase(this.classeToupieEnnemie.getTypeToupie())) {
            if ("Endurance".equalsIgnoreCase(toupiePersonnage.getClasseToupie().getTypeToupie())) {
                coef += 0.15f; // Endurance > Défense
            }
            if ("Attaque".equalsIgnoreCase(toupiePersonnage.getClasseToupie().getTypeToupie())) {
                coef -= 0.15f; // Défense > Attaque
            }
        }

        // Protection active ?
        if (estEnProtectionEnnemie()) {
            coef *= 0.6f;
            System.out.println("Protection active : dégâts réduits !");
        }

        if (coef < 0.1f) coef = 0.1f; // Minimum 10% de dégâts

        return coef;
    }


    public float perdrePDV(float degat) {
        float coef = coefficientReduction(degat, this.toupiePersonnage);
        float degatFinal = degat * coef;

        /*if (jetEsquive()) {
            degatFinal = 0;
            System.out.println("Esquive !");
        }*/

        if (degatFinal < 5 && degatFinal > 0) {
            degatFinal = 5;
        }

        this.vieActuelleEnnemie -= degatFinal;
        if (vieActuelleEnnemie < 0) vieActuelleEnnemie = 0;

        return degatFinal;
    }
    public float gagnerVieEnnemie(float quantite) {
        this.vieActuelleEnnemie += quantite;
        if (this.vieActuelleEnnemie > this.vieMaxEnnemie) {
            this.vieActuelleEnnemie = this.vieMaxEnnemie; // pour ne pas dépasser la vie max
        }
        return  this.vieActuelleEnnemie;
    }
    /*public float regenererVieParEnduranceEnnemie() {
        float regen = 0.2f * this.enduranceEnnemie;
        gagnerVieEnnemie(regen);
        if ("endurance".equalsIgnoreCase(getClasseToupieEnnemie().getTypeToupie())){
            if ("défense".equalsIgnoreCase(toupiePersonnage.getClasseToupie().getTypeToupie())){
                regen *= 1.3f;
                gagnerVieEnnemie(regen);
            }
            if ("attaque".equalsIgnoreCase(toupiePersonnage.getClasseToupie().getTypeToupie())){
                regen *= 0.7f;
                gagnerVieEnnemie(regen);
            }

        }
        return gagnerVieEnnemie(regen);
    }*/


   public float attaqueGlobale() {

       float degat =  (this.attaqueEnnemie * 1.5f);
       if (degat < 0 ){
           degat = 0;
       }

       if ("Attaque".equalsIgnoreCase(this.classeToupieEnnemie.getTypeToupie())) {
           if ("Endurance".equalsIgnoreCase(toupiePersonnage.getClasseToupie().getTypeToupie())) {
               degat *= 1.2f;
           } else if ("Défense".equalsIgnoreCase(toupiePersonnage.getClasseToupie().getTypeToupie())) {
               degat *= 0.8f;
           }
           else if ("Equilibre".equalsIgnoreCase(toupiePersonnage.getClasseToupie().getTypeToupie())){
               degat = this.attaqueEnnemie * 1.5f;
           }
       }
       if (alea() <= getCoupCritiqueEnnemie()){
           degat *= 1.8f;
       }


       return degat;
   }
    public void activerProtectionEnnemie() {
        this.toursDeProtectionRestants = 4;
    }

    public boolean estEnProtectionEnnemie() {


        return this.toursDeProtectionRestants > 0;
    }

    public void reduireProtectionEnnemie() {

        if (toursDeProtectionRestants > 0) {
            toursDeProtectionRestants--;
        }
    }

    public boolean isProtectionEnnemie() {
        return protectionEnnemie;
    }

    public void setProtectionEnnemie(boolean protectionEnnemie) {
        this.protectionEnnemie = protectionEnnemie;
    }

    public boolean finProtectionEnnemie(){
        return this.toursDeProtectionRestants == 0;
    }


    private int compteurCoupsValkyrie = 0;
    private boolean modeSixLames = false;
    public void activerModeSixLamesEnnemi() {
        this.modeSixLames = true;
    }

    public void desactiverModeSixLamesEnnemi() {
        this.modeSixLames = false;
    }

    public boolean isModeSixLamesEnnemi() {
        return modeSixLames;
    }
    private boolean modeAttaqueZ = false;
    private boolean modeDéfenseZ = false;
    private boolean modeEnduranceZ = false;

    public void activerModeAttaqueZ(){
        this.modeAttaqueZ = true;
    }
    public void activerModeDefenseZ(){
        this.modeDéfenseZ = true;
    }
    public void activerModeEnduranceZ(){
        this.modeEnduranceZ = true;
    }

    public void desactiverModeAttaqueZ(){
        this.modeAttaqueZ = false;
    }
    public void desactiverModeDefenseZ(){
        this.modeDéfenseZ = false;
    }
    public void desactiverModeEnduranceZ(){
        this.modeEnduranceZ = false;
    }

    public boolean isModeAttaqueZ() {
        return modeAttaqueZ;
    }

    public boolean isModeDéfenseZ() {
        return modeDéfenseZ;
    }

    public boolean isModeEnduranceZ() {
        return modeEnduranceZ;
    }
    public void resetStat(){
        this.attaqueEnnemie = baseAttaque;
        this.defenseEnnemie = baseDefense;
        this.enduranceEnnemie = baseEndurance;
    }

    public float barrageEnnemie(){
        float degats =  (float)(this.attaqueEnnemie * 0.6f);
        int chance = alea();
        setCoupCritiqueEnnemie(getCoupCritiqueEnnemie() - 5);
        if (chance < getCoupCritiqueEnnemie()){
            degats *= 1.4f;
        }


        return degats;

    }
    public void activerBalanceBreakerSalamanderEnn() {
        compteurTour++;
        if (compteurTour % 3 == 0) {
            if (enModeAttaque) {
                // Switch vers mode défense
                this.attaqueEnnemie = (int)(this.attaqueEnnemie / 1.4); // réinitialiser l’attaque boostée
                this.defenseEnnemie = (int)(this.defenseEnnemie * 1.4);
                enModeAttaque = false;
                System.out.println("Salmander passe en Mode Défense !");
            } else {
                // Switch vers mode attaque
                this.defenseEnnemie = (int)(this.defenseEnnemie / 1.4); // réinitialiser la défense boostée
                this.attaqueEnnemie = (int)(this.attaqueEnnemie * 1.4);
                enModeAttaque = true;
                System.out.println("Salamander passe en Mode Attaque !");
            }
        }
    }
    private int tourRestantCritique = 0;

    public void activerModeCritiqueTemporaire(int tours) {
        this.tourRestantCritique = tours;
        setCoupCritiqueEnnemie(100);
    }
    public boolean isModeCritiqueActif() {
        return tourRestantCritique > 0;
    }

    public void decrementerCritique() {
        if (tourRestantCritique > 0) {
            tourRestantCritique--;
            if (tourRestantCritique == 0) {
                setCoupCritiqueEnnemie(75);
            }
        }
    }
    public void resetStats() {
        this.vieActuelleEnnemie = this.vieMaxEnnemie;




        // Remise du taux critique seulement pour Z Achilles
        if ("z achilles".equalsIgnoreCase(this.getEnergyLayerEnnemie().getNomLayer())) {
            this.setCoupCritiqueEnnemie(75);
            this.modeDéfenseZ = false;
            this.modeAttaqueZ = false;

            this.modeEnduranceZ = false;
            this.tourRestantCritique = 0;
        }
        if ("Brave Valkyrie".equalsIgnoreCase(this.getEnergyLayerEnnemie().getNomLayer())){
            this.modeSixLames = false;

        }
        if ("Kerbeus".equalsIgnoreCase(this.getEnergyLayerEnnemie().getNomLayer())){
            this.toursDeProtectionRestants = 0;

        }
    }


    public ZAchilles getZAchilles() {
        return zAchilles;
    }

    public void setZAchilles(ZAchilles zAchilles) {
        this.zAchilles = zAchilles;
    }







    public boolean jetEsquive(){
        if (alea() <= esquiveEnnemie){
            return true;
        }
        return false;
    }

    public int alea(){
            return (int) (Math.random() * 101);
        }
    }


