package fr.wcs.autoboat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VehicleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);

        final int type;
        final String marque;
        final String modele;
        final String nbheures;
        final String nbkilometres;
        final String nbCV;
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            type = bundle.getInt("type");
            marque = bundle.getString("marque");
            modele = bundle.getString("modele");
            nbheures = bundle.getString("nbheures");
            nbkilometres = bundle.getString("nbkilometres");
            nbCV = bundle.getString("nbCV");

        } else {
            type = 0;
            marque = "";
            modele = "";
            nbheures = "";
            nbkilometres = "";
            nbCV = "";
        }

        TextView description = (TextView) findViewById(R.id.box_description);

        if (type == 1){
            Car voiture = new Car(marque, modele, nbkilometres, getApplicationContext());
            description.setText(voiture.getDescription());
        }

        else if (type == 2){
            Boat bateau = new Boat(marque, modele, nbheures, getApplicationContext());
            description.setText(bateau.getDescription());
        }

        else if (type == 3){
            Moto lamoto = new Moto(marque, modele, nbCV, getApplicationContext());
            description.setText(lamoto.getDescription());
        }

    }
}
