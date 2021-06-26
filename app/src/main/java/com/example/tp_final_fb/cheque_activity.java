package com.example.tp_final_fb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class cheque_activity extends AppCompatActivity {

    ArrayList<Cheque> cpt_cheque=new ArrayList<Cheque>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheque);
        cpt_cheque= getIntent().getExtras().getParcelableArrayList("cheque");
        System.out.println(cpt_cheque.get(0).solde_cents);
        chequeAdapter adaptateur= new chequeAdapter(this,R.layout.chequelist_layout,cpt_cheque);
        ListView cheque_liste=(ListView)findViewById(R.id.list);
        cheque_liste.setAdapter(adaptateur);
    }
}