package com.example.projet_toupie;

public class DBSystem {
    private String blade;
    private String core;
    private String armor;

    public DBSystem(String blade, String core) {
        this.blade = blade;
        this.core = core;
        this.armor = armor;
    }

    public String getBlade() {
        return blade;
    }

    public String getCore() {
        return core;
    }

    public String getArmor() {
        return armor;
    }
}
