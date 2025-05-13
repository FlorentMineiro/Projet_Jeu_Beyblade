package com.example.projet_toupie;

public class CombatController {
    private ToupiePersonnage toupiePersonnage;
    private ToupieEnnemie toupieEnnemie;
    private boolean critiqueForceActive = false;
    private int toursCritiquesRestants = 0;
    private boolean dernierCoupEtaitCritique = false;


    public CombatController(ToupiePersonnage toupiePersonnage, ToupieEnnemie toupieEnnemie) {
        this.toupiePersonnage = toupiePersonnage;
        this.toupieEnnemie = toupieEnnemie;

        // Lier les deux objets pour qu'ils se connaissent
        this.toupiePersonnage.setToupieEnnemie(toupieEnnemie);
        this.toupieEnnemie.setToupiePersonnage(toupiePersonnage);
    }

    public float attaqueJoueur() {
        float degat = toupiePersonnage.attaqueGlobale();  // Avec les bons bonus/malus déjà intégrés
        if (!toupiePersonnage.getRotation().getTypeRotation().equals(toupieEnnemie.getRotationEnnemie().getTypeRotation())){
            degat *= 1.1f;
        }
        return degat; // Et perdrePDV appliquera correctement le coefficient
    }


    public float attaqueAdv() {
        float degat = toupieEnnemie.attaqueGlobale();

        // Application du bonus/malus
        if (!toupieEnnemie.getRotationEnnemie().getTypeRotation().equals(toupiePersonnage.getRotation().getTypeRotation())) {
            degat *= 1.1f;
        }

        // Gestion du critique
        /*boolean estCritique = checkEtDecrementerCritique();
        if (estCritique) {
            degat *= 1.5f; // Exemple de bonus de critique
        }
        if (toursCritiquesRestants == 0 && dernierCoupEtaitCritique) {
            desactiverCritiqueForce();
        }*/

        return degat;
    }
    public float attaqueAdvZAchilles() {
        float degat = toupieEnnemie.attaqueGlobaleSansCritique();

        if (!toupieEnnemie.getRotationEnnemie().getTypeRotation().equals(toupiePersonnage.getRotation().getTypeRotation())) {
            degat *= 1.1f;
        }

        boolean estCritique = false;

        // Gestion critique forcé
        if (critiqueForceActive && checkEtDecrementerCritique()) {
            estCritique = true;
        }
        // Sinon critique normal
        else if (alea() <= toupieEnnemie.getCoupCritiqueEnnemie()) {
            estCritique = true;
        }

        // Si critique, applique le bonus
        if (estCritique) {
            degat *= 1.8f;
            System.out.println("Coup Critique de Z achilles");
        }

        // Fin du mode critique forcé
        if (critiqueForceActive && toursCritiquesRestants <= 0) {
            desactiverCritiqueForce();
        }

        return degat;
    }


    public float perdrePDV(float degat) {
        if (!toupieEnnemie.getRotationEnnemie().getTypeRotation().equals(toupiePersonnage.getRotation().getTypeRotation())){
            degat *= 1.1f;
        }
        return toupiePersonnage.perdrePDV(degat);


    }
    public float perdrePDVEnnemie(float degat) {
        if (!toupiePersonnage.getRotation().getTypeRotation().equals(toupieEnnemie.getRotationEnnemie().getTypeRotation())){
            degat *= 1.1f;
        }

        return toupieEnnemie.perdrePDV(degat);


    }
    public float barrage(){
       return toupiePersonnage.barrage();

    }
    public float barrageEnnemie(){
        return toupieEnnemie.barrageEnnemie();

    }
    public float gagnerVie(float quantite) {
        return toupiePersonnage.gagnerVie(quantite);
    }

    public float gagnerVieEnnemie(float quantite) {
        return toupieEnnemie.gagnerVieEnnemie(quantite);
    }

    public void activerProtection() {
       toupiePersonnage.activerProtection();
    }

    public boolean estEnProtection() {


        return toupiePersonnage.estEnProtection();
    }

    public void reduireProtection() {

       toupiePersonnage.reduireProtection();
    }
    public boolean finProtection(){
        return toupiePersonnage.finProtection();
    }


    public void activerModeSixLames() {
       toupiePersonnage.activerModeSixLames();
    }

    public void desactiverModeSixLames() {
        toupiePersonnage.desactiverModeSixLames();
    }

    public boolean isModeSixLames() {
        return toupiePersonnage.isModeSixLames();
    }
   /* public void resetStats() {
        toupiePersonnage.resetStats();


    }*/
    public void resetStatsEnnemie() {
        toupieEnnemie.resetStats();


    }
    public void activerProtectionEnnemie() {
       toupieEnnemie.activerProtectionEnnemie();
    }

    public boolean estEnProtectionEnnemie() {


        return toupieEnnemie.estEnProtectionEnnemie();
    }

    public void reduireProtectionEnnemie() {

        toupieEnnemie.reduireProtectionEnnemie();
    }
    public void activerModeSixLamesEnnemi() {
        toupieEnnemie.activerModeSixLamesEnnemi();
    }

    public void desactiverModeSixLamesEnnemi() {
        toupieEnnemie.desactiverModeSixLamesEnnemi();
    }

    public boolean isModeSixLamesEnnemi() {
        return toupieEnnemie.isModeSixLamesEnnemi();
    }
    // Méthodes dans CombatController pour gérer les modes de toupie ennemie
    private boolean modeAttaqueZActive = false;
    private boolean modeDefenseZActive = false;
    private boolean modeEnduranceZActive = false;


    public void activerModeAttaqueZ() {
        this.modeAttaqueZActive = true;
        this.modeDefenseZActive = false;
        this.modeEnduranceZActive = false;
    }
    public void activerModeDefenseZ() {
        this.modeAttaqueZActive = false;
        this.modeDefenseZActive = true;
        this.modeEnduranceZActive = false;
    }
    public void activerModeEnduranceZ() {
        this.modeAttaqueZActive = false;
        this.modeDefenseZActive = false;
        this.modeEnduranceZActive = true;
    }

    public boolean isModeAttaqueZ() {
        return this.modeAttaqueZActive;
    }
    public boolean isModeDéfenseZ() {
        return this.modeDefenseZActive;
    }

    public boolean isModeEnduranceZ() {
        return this.modeEnduranceZActive;
    }



    public void desactiverModeAttaqueZ() {
        modeAttaqueZActive = false;
    }


    public void desactiverModeDefenseZ() {
        modeDefenseZActive = false;
    }

    public void desactiverModeEnduranceZ() {
        modeEnduranceZActive = false;
    }
    public void  desactiverModesZ(){
        toupieEnnemie.desactiverModeEnduranceZ();
        toupieEnnemie.desactiverModeDefenseZ();
        toupieEnnemie.desactiverModeAttaqueZ();
        toupieEnnemie.resetStats();
    }





    public void resetStatsSansChangerMode() {
        toupieEnnemie.setAttaqueEnnemie(toupieEnnemie.getAttaqueEnnemie());
        toupieEnnemie.setDefenseEnnemie(toupieEnnemie.getDefenseEnnemie());
        // Pas de modification de vie ni des flags de mode
    }

        // [...] Variables existantes



        // Méthode pour activer le mode critique
        public void activerModeCritiqueTemporaire(int tours) {
            this.toursCritiquesRestants = tours;
            this.critiqueForceActive = true;
        }


    // Vérifie si un critique doit être déclenché
        public boolean checkEtDecrementerCritique() {
            if (toursCritiquesRestants > 0) {
                dernierCoupEtaitCritique = true;
                toursCritiquesRestants--;
                return true;
            }
            dernierCoupEtaitCritique = false;
            return false;
        }
    public void desactiverCritiqueForce() {
        this.critiqueForceActive = false;
        this.dernierCoupEtaitCritique = false;
    }



    // Getter pour l'UI
        public boolean dernierCoupEtaitCritique() {
            return dernierCoupEtaitCritique;
        }

        // Méthode d'attaque modifiée







    public int alea(){
        return  (int) (Math.random()*101);
    }

}


