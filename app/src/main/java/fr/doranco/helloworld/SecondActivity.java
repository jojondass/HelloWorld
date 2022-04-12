package fr.doranco.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private final static String TAG = SecondActivity.class.getSimpleName();

    private Button boutonPrecedent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        boutonPrecedent = findViewById(R.id.btnPrecedent);

        boutonPrecedent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "bouton Précédent cliqué");

                Intent intent = new Intent();

                //Cas 1 : on ne souhaite pas retourner des données de l'activité appelée vers l'activité appelante
//                setResult(Activity.RESULT_OK, intent);
//                finish();

                //Cas 2 : on souhaite retourner des données de l'activité appelée vers l'activité appelante
                String nom = "CAMUS";
                String prenom = "Albert";
                int age = 70;
                intent.putExtra("nom", nom);
                intent.putExtra("prenom", prenom);
                intent.putExtra("age", age);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }
}