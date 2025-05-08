package com.example.projet_toupie;



public class ToupiePersonnage {
    private String nomToupie;
    private EnergyLayer energyLayer;
    private ForgeDisc forgeDiscs;
    private PerformanceTip performanceTip;
    public   ClasseToupie classeToupie = new ClasseToupie("Neutre");
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

    ToupieEnnemie toupieEnnemie = new ToupieEnnemie(new ClasseToupie("Neutre"));
    public static ToupieEnnemie toupieAdv = new ToupieEnnemie("",new EnergyLayer(""),new ForgeDisc(""),new PerformanceTip(""),new ClasseToupie("neutre"),1000,1000,50,50,50,50,50,new Rotation("neutre"),"");
    private int toursDeProtectionRestants = 0;
    private boolean reussi;
    private int nombreAttaquesEvolution;


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

        if ("Attaque".equals(this.classeToupie.getTypeToupie())){
            vieActuelle += (1.5f * endurance);
            vieMax += (1.5f * endurance);
        }
        if ("Défense".equals(this.classeToupie.getTypeToupie())){
            vieActuelle += (2f * endurance);
            vieMax += (2f * endurance);
        }
        if ("Equilibre".equals(this.classeToupie.getTypeToupie())){
            vieActuelle += (2f * endurance);
            vieMax += (2f * endurance);
        }
        if ("Endurance".equals(this.classeToupie.getTypeToupie())){
            vieActuelle += (3f * endurance);
            vieMax += (3f * endurance);
        }

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

    public float attaqueGlobale() {

        float degat = (float) (this.attaque * 1.5);
        if (degat < 0){
            degat = 0;
        }

        if ("Attaque".equalsIgnoreCase(this.classeToupie.getTypeToupie())) {
            if ("Endurance".equalsIgnoreCase(toupieEnnemie.getClasseToupieEnnemie().getTypeToupie())) {
                degat *= 1.2;
            } else if ("Défense".equalsIgnoreCase(toupieEnnemie.getClasseToupieEnnemie().getTypeToupie())) {
                degat *= 0.8;
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
    public  void appliquerEffetQTE(boolean reussite) {
        if (reussite) {

           augmenterAttaque(10);
            augmenterEndurance(10);
            if ("Défense".equalsIgnoreCase(getClasseToupie().getTypeToupie())){
               augmenterAttaque(5);
                augmenterEndurance(5);
               augmenterDefense(7);
            }
        } else {

            reduireEndurance(10);
            reduireAttaque(10);
        }


    }

    public boolean isReussi() {
        return reussi;
    }

    public void setReussi(boolean reussi) {
        this.reussi = reussi;
    }


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
           degat *= 0.6f;
           if (degat < 0){
               degat = 0;
           }
           System.out.println("Protection active : dégâts réduits !");
       }


       if (degat < 0){
           degat = 0;
       }
       return degat;
   }

    public float perdrePDV( float degat) {


        degat = (float) (0.5 * degat + reduitAttaque(degat));
        if (jetEsquive()){
            degat = 0;
        }

        if (degat < 0){
            degat = 0;
        }


        this.vieActuelle -= degat;
        if (vieActuelle <= 0){
            vieActuelle = 0;
        }


        return degat;
    }
    public float gagnerVie(float quantite) {
        this.vieActuelle += quantite;
        if (this.vieActuelle > this.vieMax) {
            this.vieActuelle = this.vieMax; // pour ne pas dépasser la vie max
        }
        return this.vieActuelle;
    }
   /* public float regenererVieParEndurance() {
        float regen = 0.15f * this.endurance;
        gagnerVie(regen);
        if ("endurance".equalsIgnoreCase(getClasseToupie().getTypeToupie())){
            if ("défense".equalsIgnoreCase(toupieEnnemie.getClasseToupieEnnemie().getTypeToupie())){
                regen *= 1.15f;
                gagnerVie(regen);
            }
            if ("attaque".equalsIgnoreCase(toupieEnnemie.getClasseToupieEnnemie().getTypeToupie())){
                regen *= 0.85f;
                gagnerVie(regen);
            }

        }
        return gagnerVie(regen);
    }*/
    // Augmente l'attaque de la toupie
    public void augmenterAttaque(int valeur) {
        this.attaque = Math.min(this.attaque + valeur, 100); // limite à 100 si tu veux
    }

    // Réduit l'attaque de la toupie
    public void reduireAttaque(int valeur) {
        this.attaque = Math.max(this.attaque - valeur, 0); // minimum 0
    }

    // Augmente l'endurance de la toupie
    public void augmenterEndurance(int valeur) {
        this.endurance = Math.min(this.endurance + valeur, 100);
    }
    // Augmente l'endurance de la toupie
    public void augmenterDefense(int valeur) {
        this.defense = Math.min(this.defense + valeur, 100);
    }

    // Réduit l'endurance de la toupie
    public void reduireEndurance(int valeur) {
        this.endurance = Math.max(this.endurance - valeur, 0);
    }

    // Vérifie si la toupie possède une pièce particulière
    public boolean possedePiece(String nomPiece) {
        return energyLayer.getNomLayer().contains(nomPiece)
                || forgeDiscs.getNomDisc().contains(nomPiece)
                || performanceTip.getNomTip().contains(nomPiece);
    }

    // Applique une contre-attaque (ex. inflige un peu de dégâts à l'ennemi)
    public void contreAttaque(ToupieEnnemie adversaire) {
        float degats =  attaqueGlobale()/5;
        adversaire.perdrePDV(degats);
        System.out.println(this.nomToupie + " contre-attaque et inflige " + degats + " points !");
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
    public void resetStats() {
        this.vieActuelle = this.vieMax;
        this.toursDeProtectionRestants = 0;
        this.modeSixLames = false;


    }


    public int alea(){
        return (int) (Math.random() * 101);
    }
}
