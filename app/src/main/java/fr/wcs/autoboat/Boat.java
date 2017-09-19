package fr.wcs.autoboat;

import android.content.Context;

/**
 * Created by apprenti on 18/09/17.
 */

public class Boat extends VehicleModel {
    private String hours;

    public Boat(String marque, String modele, String hours, Context context) {
        super(marque, modele, context);
        this.hours = hours;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\n" + context.getString(R.string.msg_heures) + " " + hours;
    }
}