package com.example.tp_final_fb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
            System.out.println(nip);
            System.out.println(username);

            if (database.banque.validerUtilisateur(username, nip)) {
                if (database.banque.adminCred(username)) {
                    Intent intent = new Intent(this, Admin.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(this, main_user.class);
                    startActivity(intent);
                }
            } else
                Toast.makeText(this, "ACCÈS REFUSÉ", Toast.LENGTH_SHORT).show();

        }
        else
            Toast.makeText(this, "Veuillez réessayer plus tard", Toast.LENGTH_SHORT).show();
        compteur++;

    }

}