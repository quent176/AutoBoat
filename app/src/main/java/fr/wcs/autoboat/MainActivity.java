package fr.wcs.autoboat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView marque;
    TextView modele;
    TextView nbkilometres;
    TextView nbheures;
    TextView nbCV;
    Button envoyer;
    Spinner spinner;
    int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marque = (TextView) findViewById(R.id.edit_marque);
        modele = (TextView) findViewById(R.id.edit_modele);
        nbkilometres = (TextView) findViewById(R.id.edit_kilometre);
        nbheures = (TextView) findViewById(R.id.edit_nbheures);
        nbCV = (TextView) findViewById(R.id.edit_nbCV);
        envoyer = (Button) findViewById(R.id.button_send);

        nbkilometres.setVisibility(View.GONE);
        nbheures.setVisibility(View.GONE);
        nbCV.setVisibility(View.GONE);
        envoyer.setEnabled(false);

        spinner = (Spinner) findViewById(R.id.list_vehicletype);

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.type_arrays, android.R.layout.simple_spinner_item);

// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    nbkilometres.setVisibility(View.GONE);
                    nbheures.setVisibility(View.GONE);
                    nbCV.setVisibility(View.GONE);
                    envoyer.setEnabled(false);
                    type = i;
                }
                if (i == 1) {
                    nbkilometres.setVisibility(View.VISIBLE);
                    nbheures.setVisibility(View.GONE);
                    nbCV.setVisibility(View.GONE);
                    envoyer.setEnabled(true);
                    type = i;

                }
                if (i == 2) {
                    nbkilometres.setVisibility(View.GONE);
                    nbheures.setVisibility(View.VISIBLE);
                    nbCV.setVisibility(View.GONE);
                    envoyer.setEnabled(true);
                    type = i;
                }
                if (i == 3) {
                    nbkilometres.setVisibility(View.GONE);
                    nbheures.setVisibility(View.GONE);
                    nbCV.setVisibility(View.VISIBLE);
                    envoyer.setEnabled(true);
                    type = i;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        envoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(MainActivity.this, VehicleActivity.class);
                intent.putExtra("type", type);
                intent.putExtra("marque", marque.getText().toString());
                intent.putExtra("modele", modele.getText().toString());
                intent.putExtra("nbheures", nbheures.getText().toString());
                intent.putExtra("nbkilometres", nbkilometres.getText().toString());
                intent.putExtra("nbCV", nbCV.getText().toString());
                startActivity(intent);

            }

    });

}

}
