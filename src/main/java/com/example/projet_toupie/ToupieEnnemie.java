package com.example.projet_toupie;

import static com.example.projet_toupie.ToupiePersonnage.toupieAdv;

public class ToupieEnnemie  {


        private String nomToupieEnnemie;
        private EnergyLayer energyLayerEnnemie;
        private ForgeDisc forgeDiscsEnnemie;
        private PerformanceTip performanceTipEnnemie;
        public static  ClasseToupie classeToupieEnnemie = new ClasseToupie("Neutre");
        public ClasseToupie classeToupieEnnemie2 = new ClasseToupie("Neutre");
    private int vieMaxEnnemie;
        private float vieActuelleEnnemie;
        private int attaqueEnnemie;
        private int defenseEnnemie;
        private int enduranceEnnemie;
        public static ToupiePersonnage toupiePersonnage = new ToupiePersonnage(new ClasseToupie("neutre"));

        private int coupCritiqueEnnemie;
        private int nombreBeyPointsEnnemie;
        private int esquiveEnnemie;
        private Rotation rotationEnnemie;
        private String urlToupieEnnemie;
        private Tour tourEnnemie;
        private int toursDeProtectionRestants = 0;
        boolean enModeAttaque = true;
        int compteurTour = 0;
    int nombreAttaquesEvolution;


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

    public float setVieActuelleEnnemie(float vieActuelleEnnemie) {
        this.vieActuelleEnnemie = vieActuelleEnnemie;
        return vieActuelleEnnemie;
    }

    public void setVieMaxEnnemie(int vieMaxEnnemie) {
        this.vieMaxEnnemie = vieMaxEnnemie;
    }

    public void setAttaqueEnnemie(int attaqueEnnemie) {
        this.attaqueEnnemie = attaqueEnnemie;
    }

    public void setDefenseEnnemie(int defenseEnnemie) {
        this.defenseEnnemie = defenseEnnemie;
    }

    public void setEnduranceEnnemie(int enduranceEnnemie) {
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


    public float reduitAttaque(float degat)
    {
        /* FACILE +0.5
        Cette fonction aura pour mission de réduire les dégâts mis en paramètre par rapport à la défense.
        /!\ Vous ne devez pas retourner un entier négatif car cela risquerait de soigner le monstre, si les dégâts
        deviennent négatifs, il faudra alors retourner 0.
        */
        degat = degat - this.defenseEnnemie;
        if (degat < 0){
            degat = 0;
        }
        if (estEnProtectionEnnemie()) {
            degat *= 0.5f;
            System.out.println("Protection active : dégâts réduits !");
        }
        return degat;
    }

    public float perdrePDV( float degat) {
        /* FACILE +0.5
        Cette fonction aura pour mission de faire perdre des points de vie actuels au monstre par rapport au paramètre degat.
        Cette fonction retournera en plus le nombre de dêgats que le monstre a subit au total.
        La formule est : 0.5 * degat + reduitAttaque(degat)
                                         \__ reduitAttaque correspondant à la fonction ci-dessus
        */
        degat = (int)(0.5 * degat + reduitAttaque(degat));
        this.vieActuelleEnnemie -= degat;
        if (vieActuelleEnnemie <= 0){
            vieActuelleEnnemie = 0;
        }
        if (jetEsquive()){
            degat = 0;
        }
        return degat;
    }
    public void gagnerVieEnnemie(float quantite) {
        this.vieActuelleEnnemie += quantite;
        if (this.vieActuelleEnnemie > this.vieMaxEnnemie) {
            this.vieActuelleEnnemie = this.vieMaxEnnemie; // pour ne pas dépasser la vie max
        }
    }
    public void regenererVieParEnduranceEnnemie() {
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
    }


   public float attaqueGlobale() {

       float degat = (float) (this.attaqueEnnemie * 1.5);

       if ("Attaque".equalsIgnoreCase(this.classeToupieEnnemie.getTypeToupie())) {
           if ("Endurance".equalsIgnoreCase(toupiePersonnage.getClasseToupie().getTypeToupie())) {
               degat *= 1.3;
           } else if ("Défense".equalsIgnoreCase(toupiePersonnage.getClasseToupie().getTypeToupie())) {
               degat *= 0.75;
           }
       }
       if (alea() <= getCoupCritiqueEnnemie()){
           degat *= 2;
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


    public float barrageEnnemie(){
        float degats =  (float)(this.attaqueEnnemie * 0.6);
        int chance = alea();
        setCoupCritiqueEnnemie(getCoupCritiqueEnnemie() - 5);
        if (chance < getCoupCritiqueEnnemie()){
            degats *= 1.4;
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
    public void changerModeXtend() {
        compteurTour++;
        if (compteurTour % 3 == 0){
            if (enModeAttaque) {
                this.attaqueEnnemie -= 10;
                this.enduranceEnnemie += 10;
                System.out.println("Z Achilles passe en mode Endurance !");
            } else {
                this.attaqueEnnemie += 10;
                this.enduranceEnnemie -= 10;
                System.out.println("Z Achilles passe en mode Attaque !");
            }
            enModeAttaque = !enModeAttaque;
        }

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


