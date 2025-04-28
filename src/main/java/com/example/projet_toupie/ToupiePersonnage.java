package com.example.projet_toupie;



public class ToupiePersonnage {
    private String nomToupie;
    private EnergyLayer energyLayer;
    private ForgeDisc forgeDiscs;
    private PerformanceTip performanceTip;
    public static  ClasseToupie classeToupie = new ClasseToupie("Neutre");
    private ClasseToupie classeToupie2;
    private static CollectionPieces collectionPieces = new CollectionPieces();


    private float vieMax;
    private float vieActuelle;
    private float attaque;
    private int defense;
    private int endurance;

    private int coupCritique;
    private int nombreBeyPoints;
    private int esquive;
    private Rotation rotation;
    private String urlToupie;
    private Tour tourAllie;

    ToupieEnnemie toupieEnnemie;
    private int toursDeProtectionRestants = 0;


    public ToupiePersonnage(String nomToupie ,EnergyLayer energyLayer, ForgeDisc forgeDiscs, PerformanceTip performanceTip, ClasseToupie classeToupie, int vieMax,int vieActuelle, int attaque, int defense, int endurance,int coupCritique,int esquive, Rotation rotation,String urlToupie) {
        this.nomToupie = nomToupie;
        this.energyLayer = energyLayer;

        this.forgeDiscs = forgeDiscs;
        this.performanceTip = performanceTip;
        this.classeToupie = classeToupie;
        this.vieMax = vieMax;
        this.vieActuelle = vieActuelle;
        this.attaque = attaque;
        this.defense = defense;
        this.endurance = endurance;

        this.coupCritique = coupCritique;
        this.esquive = esquive;
        this.nombreBeyPoints = 1000;
        this.rotation = rotation;
        this.urlToupie = urlToupie;
    }

    public ToupiePersonnage(String nomToupie, ClasseToupie classeToupie, float vieMax, float vieActuelle, float attaque, int defense, int endurance, int coupCritique, int esquive,int nombreBeyPoints) {
        this.nomToupie = nomToupie;
        this.classeToupie = classeToupie;
        this.vieMax = vieMax;
        this.vieActuelle = vieActuelle;
        this.attaque = attaque;
        this.defense = defense;
        this.endurance = endurance;
        this.coupCritique = coupCritique;
        this.esquive = esquive;
        this.nombreBeyPoints = nombreBeyPoints;
    }

    public ToupiePersonnage(ClasseToupie classeToupie2) {
        this.classeToupie2 = classeToupie2;
    }

    public String getNomToupie() {
        return nomToupie;
    }

    public float getVieMaxToupie() {


        return vieMax;
    }

    public Tour getTourAllie() {
        return tourAllie;
    }

    public float getVieActuelleToupie() {
        return vieActuelle;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public String getUrlToupie() {
        return urlToupie;
    }

    public EnergyLayer getEnergyLayer() {
        return energyLayer;
    }

    public ForgeDisc getForgeDiscs() {
        return forgeDiscs;
    }

    public PerformanceTip getPerformanceTip() {
        return performanceTip;
    }

    public ClasseToupie getClasseToupie() {
        return classeToupie;
    }

    public float getAttaqueToupie() {

        return attaque;
    }

    public int getDefenseToupie() {
        return defense;
    }

    public int getEnduranceToupie() {
        return endurance;
    }

    public int getCoupCritiqueToupie() {

        return coupCritique;
    }

    public int getNombreBeyPoints() {
        return nombreBeyPoints;
    }


    public int getEsquive() {
        return esquive;
    }
    /*public float attaqueGlobale(ToupiePersonnage cible) {
        String typePerso = this.classeToupie.getTypeToupie();
        String typeEnnemi = cible.getClasseToupie().getTypeToupie();
        float degat = (float) (this.attaque * 1.5);

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
    }*/
    public float attaqueGlobale() {

        float degat = (float) (this.attaque * 1.5);

        if ("Attaque".equalsIgnoreCase(this.classeToupie.getTypeToupie())) {
            if ("Endurance".equalsIgnoreCase(toupieEnnemie.getClasseToupieEnnemie().getTypeToupie())) {
                degat *= 1.1;
            } else if ("Défense".equalsIgnoreCase(toupieEnnemie.getClasseToupieEnnemie().getTypeToupie())) {
                degat *= 0.75;
            }
        }
        if (alea() <= getCoupCritiqueToupie()){
            degat *= 1.8;
        }

        return degat;
    }
    public void activerProtection() {
        this.toursDeProtectionRestants = 4;
    }

    public boolean estEnProtection() {


        return this.toursDeProtectionRestants > 0;
    }

    public void reduireProtection() {

        if (toursDeProtectionRestants > 0) {
            toursDeProtectionRestants--;
        }
    }
    public boolean finProtection(){
        return this.toursDeProtectionRestants == 0;
    }
    private boolean modeSixLames = false;

    public void activerModeSixLames() {
        this.modeSixLames = true;
    }

    public void desactiverModeSixLames() {
        this.modeSixLames = false;
    }

    public boolean isModeSixLames() {
        return modeSixLames;
    }
    public float barrage(){
       float degats =  (float)(this.attaque * 0.80);
       int chance = alea();
       setCoupCritique(getCoupCritiqueToupie() - 5);
       if (chance < getCoupCritiqueToupie()){
           degats *= 1.5;
       }


       return degats;

    }
    public CollectionPieces getCollectionPieces() {
        return collectionPieces;
    }




    /* public float reductionAttaque(ToupiePersonnage attaquant) {
        // Dégâts initiaux reçus (on suppose que l'attaquant attaque à pleine force)
        float degatsRecus = attaquant.attaqueGlobale(this); // appel à attaqueGlobale avec "this" en tant que cible

        // Réduction selon la défense de la toupie actuelle (la cible)
        float facteurDefense = 1 - (this.defense * 0.03f); // chaque point de défense réduit de 2%
        if (facteurDefense < 0.1f) {
            facteurDefense = 0.1f; // limite minimale (ne jamais annuler totalement les dégâts)
        }

        degatsRecus *= facteurDefense;

        // Gestion des types (défense contre autres)
        String typeDefenseur = this.classeToupie.getTypeToupie(); // type de la toupie actuelle (défenseur)
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
    public float perdPV(ToupiePersonnage attaquant){
            float degatBase = (float) (this.attaque * 1.2);
            float degatTotal = (float) (0.5 * degatBase)+reductionAttaque(attaquant);
            this.vieActuelle -= degatTotal;
            if(jetEsquive()){
                degatTotal = 0;
            }

            return degatTotal;

    }*/
   public float reduitAttaque(float degat)
   {
        /* FACILE +0.5
        Cette fonction aura pour mission de réduire les dégâts mis en paramètre par rapport à la défense.
        /!\ Vous ne devez pas retourner un entier négatif car cela risquerait de soigner le monstre, si les dégâts
        deviennent négatifs, il faudra alors retourner 0.
        */
       degat = degat - this.defense;
       if ("Défense".equalsIgnoreCase(this.classeToupie.getTypeToupie())){
           if ("Endurance".equalsIgnoreCase(toupieEnnemie.getClasseToupieEnnemie().getTypeToupie())){
               degat -= 0.8*this.defense;
           }
           if ("Attaque".equalsIgnoreCase(toupieEnnemie.getClasseToupieEnnemie().getTypeToupie())){
                degat -= 1.2*defense;
           }

       }
       if (estEnProtection()) {
           degat *= 0.5f;
           System.out.println("Protection active : dégâts réduits !");
       }


       if (degat < 0){
           degat = 0;
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
        degat = (float) (0.5 * degat + reduitAttaque(degat));
        this.vieActuelle-= degat;


        return degat;
    }
    public void gagnerVie(float quantite) {
        this.vieActuelle += quantite;
        if (this.vieActuelle > this.vieMax) {
            this.vieActuelle = this.vieMax; // pour ne pas dépasser la vie max
        }
    }


    /*public float retourneDefense(ToupiePersonnage attaquant) {
        float degatSubi = perdPV(attaquant); // La toupie subit l'attaque

        if (degatSubi > 0) {
            float contreDegat = degatSubi * 0.5f; // Par exemple, elle renvoie 50% des dégâts subis
            attaquant.vieActuelle -= contreDegat;


        }

        return degatSubi; // On retourne quand même les dégâts que cette toupie a subis
    }*/


    public boolean jetEsquive(){
        if (alea() <= esquive){
            return true;
        }
        return false;
    }






    public void setNombreBeyPoints(int nombreBeyPoints) {
        this.nombreBeyPoints = nombreBeyPoints;
    }

    public void setVieActuelle(float vieActuelle) {
        this.vieActuelle = vieActuelle;
    }

    public void setAttaque(float attaque) {
        this.attaque = attaque;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setCoupCritique(int coupCritique) {
        this.coupCritique = coupCritique;
    }

    public void setEsquive(int esquive) {
        this.esquive = esquive;
    }

    public void setVieMax(float vieMax) {
        this.vieMax = vieMax;
    }

    public int alea(){
        return (int) (Math.random() * 101);
    }
}
