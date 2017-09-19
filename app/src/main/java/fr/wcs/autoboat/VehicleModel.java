package fr.wcs.autoboat;

import android.content.Context;

public class VehicleModel {
    private String marque;
    private String modele;
    protected Context context;

    public VehicleModel(String marque, String modele, Context context) {
        this.marque = marque;
        this.modele = modele;
        this.context = context;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public String getDescription() {
        return context.getString(R.string.msg_marque).toString() + " " + getMarque() + "\n" + context.getString(R.string.msg_model) + " " + getModele();
    }

}
