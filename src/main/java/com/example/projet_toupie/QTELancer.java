package com.example.projet_toupie;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuItem;

import java.text.BreakIterator;



public class QTELancer {

    private int tempsMax;
    private boolean reussi;
    private BreakIterator lblQTEMessage;
    private static ToupieEnnemie toupieAdv = new ToupieEnnemie("Inconnu",new ClasseToupie("neutre"),1000,1000,50,50,50,50,50) ;

    public QTELancer(int tempsMax) {
        this.tempsMax = tempsMax;
    }


    public boolean executerQTE() {
        int reaction = (int) (Math.random() * 5); // Simule une réaction entre 0 et 4 secondes
        this.reussi = reaction <= tempsMax; // Réussi si assez rapide
        return this.reussi;
    }




   public  void appliquerEffetQTE(ToupiePersonnage toupieJoueur, boolean reussite) {
       if (reussite) {

           toupieJoueur.augmenterAttaque(10);
           toupieJoueur.augmenterEndurance(10);
           if ("Défense".equalsIgnoreCase(toupieJoueur.getClasseToupie().getTypeToupie())){
               toupieJoueur.augmenterAttaque(7);
               toupieJoueur.augmenterEndurance(7);
               toupieJoueur.augmenterDefense(7);
           }
       } else {

           toupieJoueur.reduireEndurance(10);
           toupieJoueur.reduireAttaque(10);
       }


   }




    public void setReussi(boolean reussi) {
        this.reussi = reussi;
    }

    public boolean isReussi() {
        return reussi;
    }


}
