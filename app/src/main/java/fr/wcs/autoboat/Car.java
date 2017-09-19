package fr.wcs.autoboat;

import android.content.Context;

/**
 * Created by apprenti on 18/09/17.
 */

public class Car extends VehicleModel {

    private String kilometers;

    public Car(String marque, String modele, String kilometers, Context context) {
        super(marque, modele, context);
        this.kilometers = kilometers;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + "\n" + context.getString(R.string.msg_km) + " " + kilometers;
    }
}
