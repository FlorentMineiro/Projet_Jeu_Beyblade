package com.example.projet_toupie;

public class ModeZAchilles {

    private boolean modeAttaqueZ = false;
    private boolean modeDéfenseZ = false;
    private boolean modeEnduranceZ = false;

    private void activerModeAttaqueZ(){
        this.modeAttaqueZ = true;
    }
    private void activerModeDefenseZ(){
        this.modeDéfenseZ = true;
    }
    private void activerModeEnduranceZ(){
        this.modeEnduranceZ = true;
    }

    private void desactiverModeAttaqueZ(){
        this.modeAttaqueZ = false;
    }
    private void desactiverModeDefenseZ(){
        this.modeDéfenseZ = false;
    }
    private void desactiverModeEnduranceZ(){
        this.modeEnduranceZ = false;
    }

    public boolean isModeAttaqueZ() {
        return modeAttaqueZ;
    }

    public boolean isModeDéfenseZ() {
        return modeDéfenseZ;
    }

    public boolean isModeEnduranceZ() {
        return modeEnduranceZ;
    }
}
