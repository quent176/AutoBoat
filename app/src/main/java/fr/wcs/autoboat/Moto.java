package fr.wcs.autoboat;

import android.content.Context;

/**
 * Created by apprenti on 18/09/17.
 */

public class Moto extends VehicleModel {

    private String CV;

    public Moto(String marque, String modele, String CV, Context context) {
        super(marque, modele, context);
        this.CV = CV;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\n" + context.getString(R.string.msg_CV) + " " + CV;
    }
}

