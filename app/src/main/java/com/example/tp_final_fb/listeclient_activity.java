package com.example.tp_final_fb;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class listeclient_activity extends AppCompatActivity {

    ArrayList<Client> liste_client=new ArrayList<Client>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeclient);
        liste_client= getIntent().getExtras().getParcelableArrayList("client");
        ClientAdapter adaptateur= new ClientAdapter(this,R.layout.clientliste_layout,liste_client);
        ListView client_liste=(ListView)findViewById(R.id.liste_client);
        client_liste.setAdapter(adaptateur);
    }
}