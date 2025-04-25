package com.example.projet_toupie;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;

import java.text.BreakIterator;

public class QTELancer {
    // Durée max pour réussir le QTE (ex: 3 secondes)
    private int tempsMax;
    private boolean reussi;
    private BreakIterator lblQTEMessage;

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

   /* public float appliquerEffets(ToupiePersonnage attaquant, ToupiePersonnage cible) {


        if (reussi) {
            System.out.println("QTE réussi ! Bonus de lancement !");

            switch (attaquant.getClasseToupie().getTypeToupie().toLowerCase()) {
                case "attaque":
                    float effetTotal = attaquant.attaqueGlobale(cible) * 0.35f;
                    attaquant.setVieMax((float) (attaquant.getVieMaxToupie() * 1.1));
                    attaquant.setAttaque(attaquant.attaqueGlobale(cible) + effetTotal);
                    /*Platform.runLater(() -> {

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Bonus de QTE !");
                        alert.setHeaderText(null);
                        alert.setContentText("QTE réussi ! Bonus appliqué !");
                        alert.show(); // 👈 NE BLOQUE PAS LE THREAD


                    });

                    break;


                case "endurance":
                    effetTotal = attaquant.attaqueGlobale(cible) * 0.2f;
                    attaquant.setVieMax((float) (attaquant.getVieMaxToupie() * 1.3));
                    attaquant.setAttaque(attaquant.attaqueGlobale(cible) + effetTotal);
                    /*Platform.runLater(() -> {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Bonus de QTE !");
                        alert.setHeaderText(null);
                        alert.setContentText("QTE réussi ! Bonus appliqué !");
                        alert.show(); // 👈 NE BLOQUE PAS LE THREAD

                    });

                    break;

                case "défense":
                     attaquant.retourneDefense(cible);
                    effetTotal = attaquant.attaqueGlobale(cible) * 0.2f;
                    attaquant.setVieMax((float) (attaquant.getVieMaxToupie() * 1.1));
                    attaquant.setAttaque(attaquant.attaqueGlobale(cible) + effetTotal);
                    /*Platform.runLater(() -> {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Bonus de QTE !");
                        alert.setHeaderText(null);
                        alert.setContentText("QTE réussi ! Bonus appliqué !");
                        alert.show(); // 👈 NE BLOQUE PAS LE THREAD

                    });
                    break;

                default:
                    System.out.println("Pas de Bonus !!");
                    break;
            }

        } else {
            System.out.println("QTE raté... Malus de lancement !");

            switch (attaquant.getClasseToupie().getTypeToupie().toLowerCase()) {
                case "attaque":
                    float effetTotal = attaquant.attaqueGlobale(cible) * 0.2f;
                    attaquant.setVieMax((float) (attaquant.getVieMaxToupie() * 0.75));
                    attaquant.setAttaque(attaquant.attaqueGlobale(cible) - effetTotal);
                    /*Platform.runLater(() -> {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Bonus de QTE !");
                        alert.setHeaderText(null);
                        alert.setContentText("QTE réussi ! Bonus appliqué !");
                        alert.show(); // 👈 NE BLOQUE PAS LE THREAD

                    });

                    break;

                case "endurance":
                    effetTotal = attaquant.attaqueGlobale(cible) * 0.25f;
                    attaquant.setVieMax((float) (attaquant.getVieMaxToupie() * 0.8));
                    attaquant.setAttaque(attaquant.attaqueGlobale(cible) - effetTotal);
                    /*Platform.runLater(() -> {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Bonus de QTE !");
                        alert.setHeaderText(null);
                        alert.setContentText("QTE réussi ! Bonus appliqué !");
                        alert.show(); // 👈 NE BLOQUE PAS LE THREAD

                    });

                    break;

                case "défense":

                    effetTotal = attaquant.attaqueGlobale(cible) * 0.25f;
                    attaquant.setVieMax((float) (attaquant.getVieMaxToupie() * 0.75));
                    attaquant.setAttaque(attaquant.attaqueGlobale(cible) - effetTotal);
                    /*Platform.runLater(() -> {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Bonus de QTE !");
                        alert.setHeaderText(null);
                        alert.setContentText("QTE réussi ! Bonus appliqué !");
                        alert.show(); // 👈 NE BLOQUE PAS LE THREAD

                    });

                    break;

                default:
                    System.out.println("Pas de Bonus !!");
                    break;
            }

        }


        return 0;
    }*/



    public void setReussi(boolean reussi) {
        this.reussi = reussi;
    }

    public boolean isReussi() {
        return reussi;
    }
}
