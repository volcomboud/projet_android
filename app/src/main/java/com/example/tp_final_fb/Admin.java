package com.example.tp_final_fb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

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

        if(!cpt_cheque.isEmpty())System.out.println(cpt_cheque.get(0).num_compte);
        if(!cpt_epargne.isEmpty())System.out.println(cpt_epargne.get(0).num_nip);
        if(!liste_client.isEmpty())System.out.println(liste_client.get(1).admin);
    }
}