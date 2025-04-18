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
    public void appliquerEffets(ToupiePersonnage toupie, ToupieEnnemie toupieEnnemie) {
        if (reussi) {
            System.out.println("QTE réussi ! Bonus de lancement !");
            toupie.setAttaque((float) ((toupie.attaqueGlobale(toupieEnnemie)) * 1.2));

        } else {
            System.out.println("QTE raté... Malus de lancement !");
            toupie.setAttaque((float) ((toupie.attaqueGlobale(toupieEnnemie)) * 1.2));
        }
    }
}
