package com.example.tp_final_fb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

     Database database= new Database();
     static short compteur=0;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnClickSignIn(View view){
        int nip=0;

        if(compteur<3) {
            EditText edit_username = findViewById(R.id.txt_username);
            String username = edit_username.getText().toString();

            EditText edit_nip = findViewById(R.id.txt_nip);
            String temp_nip = edit_nip.getText().toString();

            if (!temp_nip.equals("")) nip = Integer.parseInt(temp_nip);

            if (database.banque.validerUtilisateur(username, nip)) {
                if (database.banque.adminCred(username)) {
                    Intent intent = new Intent(this, Admin.class);
                    Bundle passeur= new Bundle();
                    ArrayList<Cheque> passe_chk=database.banque.passeComptesChk();
                    ArrayList<Epargne> passe_ep=database.banque.passeComptesEp();
                    passeur.putParcelableArrayList("cheque",passe_chk);
                    passeur.putParcelableArrayList("epargne",passe_ep);
                    passeur.putParcelableArrayList("arbre",database.banque.passeClient());

                    intent.putExtras(passeur);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(this, main_user.class);
                    Bundle passeur= new Bundle();
                    ArrayList<Compte> passe=database.banque.passeCompte(username,nip);
                    passeur.putParcelableArrayList("key",passe);
                    intent.putExtras(passeur);
                    startActivity(intent);
                }
            } else {
                Toast.makeText(this, "ACCÈS REFUSÉ", Toast.LENGTH_SHORT).show();
                compteur++;
            }

        }
        else
            Toast.makeText(this, "Veuillez réessayer plus tard", Toast.LENGTH_SHORT).show();

    }

}