package com.example.tp_final_fb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class epargne_activity extends AppCompatActivity {

    ArrayList<Epargne> cpt_epargne=new ArrayList<Epargne>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_epargne);
        cpt_epargne= getIntent().getExtras().getParcelableArrayList("epargne");
        EpargneAdapter adaptateur= new EpargneAdapter(this,R.layout.epargnelist_layout,cpt_epargne);
        ListView epargne_liste=(ListView)findViewById(R.id.liste_epargne);
        epargne_liste.setAdapter(adaptateur);
    }
}