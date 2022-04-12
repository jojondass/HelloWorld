package fr.doranco.helloworld;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button boutonSuivant, boutonDemarrerSonnerie, boutonArreterSonnerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boutonSuivant = findViewById(R.id.btnSuivant);
        boutonDemarrerSonnerie = findViewById(R.id.btnStartSonnerie);
        boutonArreterSonnerie = findViewById(R.id.btnStopSonnerie);

        boutonSuivant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "bouton Suivant cliqué");

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                //Cas 1 : on ne souhaite pas retourner des données de l'activité appelée vers l'activité appelante
//                startActivity(intent);

                //Cas 2 : on souhaite retourner des données de l'activité appelée vers l'activité appelante
                startActivityForResult(intent, 1);
            }
        });

        boutonDemarrerSonnerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SonnerieService.class);
                startService(intent);
            }
        });

        boutonArreterSonnerie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SonnerieService.class);
                stopService(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String nom = data.getStringExtra("nom");
                String prenom = data.getStringExtra("prenom");
                int age = data.getIntExtra("age", 0);
                Log.i(TAG, "Nom = " + nom + "/ Prénom = " + prenom + " / age = " + age);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                Log.i(TAG, "Pas de données à afficher");
            }
        }
    }
}