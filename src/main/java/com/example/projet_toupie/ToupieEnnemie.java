package com.example.projet_toupie;

public class ToupieEnnemie extends ToupiePersonnage {


        private String nomToupieEnnemie;
        private EnergyLayer energyLayerEnnemie;
        private ForgeDisc forgeDiscsEnnemie;
        private PerformanceTip performanceTipEnnemie;
        private ClasseToupie classeToupieEnnemie;
        private int vieMaxEnnemie;
        private float vieActuelleEnnemie;
        private int attaqueEnnemie;
        private int defenseEnnemie;
        private int enduranceEnnemie;

        private int coupCritiqueEnnemie;
        private int nombreBeyPointsEnnemie;
        private int esquiveEnnemie;
        private Rotation rotationEnnemie;
        private String urlToupieEnnemie;
        private Tour tourEnnemie;

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

    public ToupieEnnemie() {
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

    public float attaqueGlobale(ToupieEnnemie cible) {
        String typePerso = this.classeToupieEnnemie.getTypeToupie();
        String typeEnnemi = cible.getClasseToupie().getTypeToupie();
        float degat = (float) (this.attaqueEnnemie * 1.5);

        if ("Attaque".equalsIgnoreCase(typePerso)) {
            if ("Endurance".equalsIgnoreCase(typeEnnemi)) {
                degat *= 1.3;
            } else if ("Défense".equalsIgnoreCase(typeEnnemi)) {
                degat *= 0.8;
            }
        }
        if (alea() <= getCoupCritiqueToupie()){
            degat *= 2;
        }


        return degat;
    }

    public float reductionAttaque(ToupieEnnemie attaquant) {
        // Dégâts initiaux reçus (on suppose que l'attaquant attaque à pleine force)
        float degatsRecus = attaquant.attaqueGlobale(this); // appel à attaqueGlobale avec "this" en tant que cible

        // Réduction selon la défense de la toupie actuelle (la cible)
        float facteurDefense = 1 - (this.defenseEnnemie * 0.03f); // chaque point de défense réduit de 2%
        if (facteurDefense < 0.1f) {
            facteurDefense = 0.1f; // limite minimale (ne jamais annuler totalement les dégâts)
        }

        degatsRecus *= facteurDefense;

        // Gestion des types (défense contre autres)
        String typeDefenseur = this.classeToupieEnnemie.getTypeToupie(); // type de la toupie actuelle (défenseur)
        String typeAttaquant = attaquant.getClasseToupie().getTypeToupie(); // type de l'adversaire (attaquant)

        if ("Défense".equalsIgnoreCase(typeDefenseur)) {
            if ("Endurance".equalsIgnoreCase(typeAttaquant)) {
                degatsRecus *= 0.8f; // Bonus de défense contre endurance
            } else if ("Attaque".equalsIgnoreCase(typeAttaquant)) {
                degatsRecus *= 1.2f; // Malus de défense contre attaque
            }
        }
        if (degatsRecus < 0){
            degatsRecus = 0;
        }

        return degatsRecus;
    }
    public float perdPV(ToupieEnnemie attaquant){
        float degatBase = (float) (this.attaqueEnnemie * 1.2);
        float degatTotal = (float) (0.5 * degatBase)+reductionAttaque(attaquant);
        this.vieActuelleEnnemie -= degatTotal;
        if(jetEsquive()){
            degatTotal = 0;
        }

        return degatTotal;

    }
    public float reductionAttaque2(float degat , String attaquant){
        degat -= this.defenseEnnemie;
        if (degat < 0) degat = 0;



        // Avantages/désavantages de type
        if ("Défense".equalsIgnoreCase(String.valueOf(getClasseToupie()))) {
            if ("Endurance".equalsIgnoreCase(attaquant)) {
                degat *= 0.8f;
            } else if ("Attaque".equalsIgnoreCase(attaquant)) {
                degat *= 1.2f;
            }
        }


            return degat;
    }
    public float perdPV2(float degat, String attaquant) {
        if (jetEsquive()) {
            return 0;
        }

        float degatTotal = reductionAttaque2(degat, attaquant); // Ne rien ajouter d’autre
        this.vieActuelleEnnemie -= degatTotal;

        return degatTotal;
    }

    public float retourneDefense(ToupieEnnemie attaquant) {
        float degatSubi = perdPV(attaquant); // La toupie subit l'attaque

        if (degatSubi > 0) {
            float contreDegat = degatSubi * 0.5f; // Par exemple, elle renvoie 50% des dégâts subis
            attaquant.vieActuelleEnnemie -= contreDegat;


        }

        return degatSubi; // On retourne quand même les dégâts que cette toupie a subis
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


