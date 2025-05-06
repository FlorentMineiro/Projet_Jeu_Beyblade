package com.example.projet_toupie;

public class Tour {
    private static int numeroTour = 1;


    public static int getNumeroTour() {
        return numeroTour;
    }

    public static int suivant() {
        numeroTour++;
        return numeroTour;
    }

    public static int reset() {

        numeroTour = 1;
        return numeroTour;
    }

}

