package com.example.projet_toupie;

public class QTELancer {
    // Durée max pour réussir le QTE (ex: 3 secondes)
    private int tempsMax;
    private boolean reussi;

    public QTELancer(int tempsMax) {
        this.tempsMax = tempsMax;
    }

    // Simulation du QTE (ex: bouton appuyé dans le bon timing)
    public boolean executerQTE() {
        int reaction = (int) (Math.random() * 5); // Simule une réaction entre 0 et 4 secondes
        this.reussi = reaction <= tempsMax; // Réussi si assez rapide
        return this.reussi;
    }

    public boolean estReussi() {
        return reussi;
    }

    // Bonus/Malus appliqués selon le résultat
    public float appliquerEffets(ToupiePersonnage attaquant, ToupiePersonnage cible) {
        float bonusMalus = 0;

        if (reussi) {
            System.out.println("QTE réussi ! Bonus de lancement !");
            if ("attaque".equalsIgnoreCase(attaquant.getClasseToupie().getTypeToupie()))
               bonusMalus = (float) (attaquant.attaqueGlobale(cible) * 1.4);
            else {
                bonusMalus = (float) (attaquant.attaqueGlobale(cible) * 1.3);
            }
            if ("endurance".equalsIgnoreCase(attaquant.getClasseToupie().getTypeToupie())){
                attaquant.setVieMax((float) (attaquant.getVieMaxToupie() * 1.3));
            }else {
                attaquant.setVieMax((float) (attaquant.getVieMaxToupie() * 1.2));
            }
            if ("defense".equalsIgnoreCase(attaquant.getClasseToupie().getTypeToupie())) {
                bonusMalus = (float) (attaquant.retourneDefense(cible)* 2.4);
            }


        } else {
            System.out.println("QTE raté... Malus de lancement !");
            if ("attaque".equalsIgnoreCase(attaquant.getClasseToupie().getTypeToupie())){
               bonusMalus = (float) ((attaquant.attaqueGlobale(cible)) * 0.85);
            }else {
                bonusMalus = (float) ((attaquant.attaqueGlobale(cible) * 0.8));
            }
            if ("endurance".equalsIgnoreCase(attaquant.getClasseToupie().getTypeToupie())){
                attaquant.setVieMax((float) (attaquant.getVieMaxToupie() * 0.85));
            }else {
                attaquant.setVieMax((float) (attaquant.getVieMaxToupie() * 0.8));
            }
        }
        return bonusMalus;
    }

    public void setReussi(boolean reussi) {
        this.reussi = reussi;
    }

    public boolean isReussi() {
        return reussi;
    }
}
