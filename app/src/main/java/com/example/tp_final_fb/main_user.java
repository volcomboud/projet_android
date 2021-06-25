package com.example.tp_final_fb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class main_user extends AppCompatActivity {

    boolean decimal=false;
    boolean depot=false;
    boolean retrait=false;
    boolean virement=false;
    boolean cheque=false;
    boolean epargne=false;

    short compte_decimal=0;
    static String afficheur="";
    short index_epargne=-1;
    short index_cheque=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);
        ArrayList<Compte> compte_client= getIntent().getExtras().getParcelableArrayList("key");
        if(!compte_client.isEmpty()) {
            for (short i = 0; i < compte_client.size(); i++) {
                System.out.println("\n"+compte_client.get(i).num_compte);

                if (compte_client.get(i).getType()) index_epargne = i;
                else if (!compte_client.get(i).getType())index_cheque = i;
                System.out.println(compte_client.get(i).type_epargne+" index : "+i);
            }
        }
        else{
            RadioGroup rg_operation = (RadioGroup) findViewById(R.id.radioG_operation);
            rg_operation.setEnabled(false);
            Toast.makeText(this, "Compte innaccessible; Contacter Votre administrateur", Toast.LENGTH_SHORT).show();
        }
        if(index_cheque==-1){
            RadioButton rdb_cheque = (RadioButton) findViewById(R.id.radio_cheque);
            rdb_cheque.setEnabled(false);
        }
        if(index_epargne==-1){
            RadioButton rdb_epargne = (RadioButton) findViewById(R.id.radio_epargne);
            rdb_epargne.setEnabled(false);
        }
    }
    public void OnClickSoumettre(View view){
        
    }
    public void OnClickDepot(View view){
        depot=true;
        retrait=false;
        virement=false;
    }
    public void OnClickRetrait(View view){
        depot=false;
        retrait=true;
        virement=false;
    }
    public void OnClickVirement(View view){
        depot=false;
        retrait=false;
        virement=true;
    }
    public void OnClickCheque(View view){
         cheque=true;
         epargne=false;
    }
    public void OnClickEpargne(View view){
        cheque=false;
        epargne=true;
    }
    public void OnClickLogOut(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void OnClickBtn0(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        afficheur+="0";
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn1(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        afficheur+="1";
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn2(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        afficheur+="2";
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn3(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        afficheur+="3";
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn4(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        afficheur+="4";
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn5(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        afficheur+="5";
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn6(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        afficheur+="6";
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn7(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        afficheur+="7";
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn8(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        afficheur+="8";
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn9(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        afficheur+="9";
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtnPoint(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        afficheur+=".";
        decimal=true;
        Button btn_point = (Button) findViewById(R.id.btn_point);
        btn_point.setEnabled(false);
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtnC(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        afficheur="";
        Button btn_point = (Button) findViewById(R.id.btn_point);
        btn_point.setEnabled(true);
        decimal=false;
        affichage.setText(String.valueOf(afficheur));
    }

}