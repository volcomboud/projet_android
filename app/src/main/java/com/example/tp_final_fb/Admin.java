package com.example.tp_final_fb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {

    ArrayList<Cheque> cpt_cheque=new ArrayList<Cheque>();
    ArrayList<Epargne> cpt_epargne=new ArrayList<Epargne>();
    ArrayList<Client> liste_client=new ArrayList<Client>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        cpt_cheque= getIntent().getExtras().getParcelableArrayList("cheque");
        cpt_epargne=getIntent().getExtras().getParcelableArrayList("epargne");
        liste_client=getIntent().getExtras().getParcelableArrayList("arbre");
    }
    public void onClickpaimentDesInterets(View view){
        for(int i = 0 ;i<cpt_epargne.size();i++) cpt_epargne.get(i).paiementInterets();
        Toast.makeText(getApplicationContext(), "Les intérêts on été payé", Toast.LENGTH_LONG).show();
    }
    public void onClickComptesCheques(View view){
        Intent intent = new Intent(this, cheque_activity.class);
        Bundle passeur= new Bundle();
        passeur.putParcelableArrayList("cheque",cpt_cheque);
        intent.putExtras(passeur);
        startActivity(intent);
    }
    public void onClickComptesEpargne(View view){
        Intent intent = new Intent(this, epargne_activity.class);
        Bundle passeur= new Bundle();
        passeur.putParcelableArrayList("epargne",cpt_epargne);
        intent.putExtras(passeur);
        startActivity(intent);
    }
    public void onClickListeClients(View view){
        Intent intent = new Intent(this, listeclient_activity.class);
        Bundle passeur= new Bundle();
        passeur.putParcelableArrayList("client",liste_client);
        intent.putExtras(passeur);
        startActivity(intent);
    }
}