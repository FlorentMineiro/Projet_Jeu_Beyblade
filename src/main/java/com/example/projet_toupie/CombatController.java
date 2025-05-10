package com.example.projet_toupie;

public class CombatController {
    private ToupiePersonnage toupiePersonnage;
    private ToupieEnnemie toupieEnnemie;

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
        return toupieEnnemie.perdrePDV(degat); // Et perdrePDV appliquera correctement le coefficient
    }


    public float attaqueAdv() {
        float degat = toupieEnnemie.attaqueGlobale();  // Avec les bons bonus/malus déjà intégrés
        if (!toupieEnnemie.getRotationEnnemie().getTypeRotation().equals(toupiePersonnage.getRotation().getTypeRotation())){
            degat *= 1.1f;
        }
        return toupiePersonnage.perdrePDV(degat); // Et perdrePDV appliquera correctement le coefficient
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
    public void activerModeAttaqueZ() {
        if (!toupieEnnemie.isModeAttaqueZ()) {  // Vérifie si le mode n'est pas déjà activé
            toupieEnnemie.activerModeAttaqueZ();
            toupieEnnemie.desactiverModeDefenseZ();
            toupieEnnemie.desactiverModeEnduranceZ();
        }
    }

    public void activerModeDefenseZ() {
        if (!toupieEnnemie.isModeDéfenseZ()) {  // Vérifie si le mode n'est pas déjà activé
            toupieEnnemie.activerModeDefenseZ();
            toupieEnnemie.desactiverModeAttaqueZ();
            toupieEnnemie.desactiverModeEnduranceZ();
        }
    }

    public void activerModeEnduranceZ() {
        if (!toupieEnnemie.isModeEnduranceZ()) {  // Vérifie si le mode n'est pas déjà activé
            toupieEnnemie.activerModeEnduranceZ();
            toupieEnnemie.desactiverModeAttaqueZ();
            toupieEnnemie.desactiverModeDefenseZ();
        }
    }

    public void desactiverModeAttaqueZ() {
        if (toupieEnnemie.isModeAttaqueZ()) {
            toupieEnnemie.desactiverModeAttaqueZ();
        }
    }

    public void desactiverModeDefenseZ() {
        if (toupieEnnemie.isModeDéfenseZ()) {
            toupieEnnemie.desactiverModeDefenseZ();
        }
    }

    public void desactiverModeEnduranceZ() {
        if (toupieEnnemie.isModeEnduranceZ()) {
            toupieEnnemie.desactiverModeEnduranceZ();
        }
    }
    public void  desactiverModesZ(){
        toupieEnnemie.desactiverModeEnduranceZ();
        toupieEnnemie.desactiverModeDefenseZ();
        toupieEnnemie.desactiverModeAttaqueZ();
        toupieEnnemie.resetStats();
    }

    public boolean isModeAttaqueZ() {
        return toupieEnnemie.isModeAttaqueZ();
    }

    public boolean isModeDéfenseZ() {
        return toupieEnnemie.isModeDéfenseZ();
    }

    public boolean isModeEnduranceZ() {
        return toupieEnnemie.isModeEnduranceZ();
    }

    public void activerModeCritiqueTemporaire(int tours) {
        toupieEnnemie.activerModeCritiqueTemporaire(tours);
    }
    public void resetStatsSansChangerMode() {
        toupieEnnemie.setAttaqueEnnemie(toupieEnnemie.getAttaqueEnnemie());
        toupieEnnemie.setDefenseEnnemie(toupieEnnemie.getDefenseEnnemie());
        // Pas de modification de vie ni des flags de mode
    }


    public void decrementerCritique() {
       toupieEnnemie.decrementerCritique();
    }

    public int alea(){
        return  (int) (Math.random()*101);
    }

}


