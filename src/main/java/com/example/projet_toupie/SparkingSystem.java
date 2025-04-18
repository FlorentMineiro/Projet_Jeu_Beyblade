package com.example.projet_toupie;

public class SparkingSystem {
    private String ring;
    private String chassis;
    private String superkingChip;

    public SparkingSystem(String ring, String chassis,String superkingChip) {
        this.ring = ring;
        this.chassis = chassis;
        this.superkingChip = superkingChip;
    }

    public String getRing() {
        return ring;
    }

    public String getChassis() {
        return chassis;
    }
}
