package com.example.tp_final_fb;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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
    static String cents="";
    static String dollars="";
    short index_epargne=-1;
    short index_cheque=-1;
    int user_cents;
    int user_dollars;
    ArrayList<Compte> compte_client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);
        compte_client= getIntent().getExtras().getParcelableArrayList("key");
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
            RadioButton rdb_virement = (RadioButton) findViewById(R.id.rbtn_virement);
            rdb_virement.setEnabled(false);
        }
        else if(index_epargne==-1){
            RadioButton rdb_epargne = (RadioButton) findViewById(R.id.radio_epargne);
            rdb_epargne.setEnabled(false);
            RadioButton rdb_virement = (RadioButton) findViewById(R.id.rbtn_virement);
            rdb_virement.setEnabled(false);
        }
    }
    public void OnClickSoumettre(View view){
        resetEtatCompte();
        if(virement){
            StringToMoney();
            virements();
        }
        else if(retrait){
            StringToMoney();
            retrait();
        }
        else if(depot){
            StringToMoney();
            depot();
        }
        else
            Toast.makeText(getApplicationContext(), "Sélectionnez une opération", Toast.LENGTH_LONG).show();


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
        if(!decimal&&compte_decimal<2) {
            afficheur += "0";
            dollars += "0";
        }
        else if(decimal&&compte_decimal<2){
            afficheur += "0";
            cents += "0";
            compte_decimal++;
        }
        else fermerClavier();
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn1(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        if(!decimal&&compte_decimal<2) {
            afficheur += "1";
            dollars += "1";
        }

        else if(decimal&&compte_decimal<2){
            afficheur += "1";
            cents += "1";
            compte_decimal++;
        }
        else fermerClavier();
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn2(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        if(!decimal&&compte_decimal<2) {
            afficheur += "2";
            dollars += "2";
        }
        else if(decimal&&compte_decimal<2) {
            afficheur += "2";
            cents += "2";
            compte_decimal++;
        }
        else fermerClavier();
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn3(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        if(!decimal&&compte_decimal<2) {
            afficheur += "3";
            dollars += "3";
        }
        else if(decimal&&compte_decimal<2){
            afficheur += "3";
            cents += "3";
            compte_decimal++;
        }
        else fermerClavier();
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn4(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        if(!decimal&&compte_decimal<2) {
            afficheur += "4";
            dollars += "4";
        }
        else if(decimal&&compte_decimal<2){
            afficheur += "4";
            cents += "4";
            compte_decimal++;
        }
        else fermerClavier();
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn5(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        if(!decimal&&compte_decimal<2) {
            afficheur += "5";
            dollars += "5";
        }
       else if(decimal&&compte_decimal<2){
            afficheur += "5";
            cents += "5";
            compte_decimal++;
        }
        else fermerClavier();
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn6(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        if(!decimal&&compte_decimal<2) {
            afficheur += "6";
            dollars += "6";
        }
        else if(decimal&&compte_decimal<2){
            afficheur += "6";
            cents += "6";
            compte_decimal++;
        }
        else fermerClavier();
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn7(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        if(!decimal&&compte_decimal<2) {
            afficheur += "7";
            dollars += "7";
        }
        else if(decimal&&compte_decimal<2){
            afficheur += "7";
            cents += "7";
            compte_decimal++;
        }
        else fermerClavier();
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn8(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        if(!decimal&&compte_decimal<2) {
            afficheur += "8";
            dollars += "8";
        }
        else if(decimal&&compte_decimal<2){
            afficheur += "8";
            cents += "8";
            compte_decimal++;
        }
        else fermerClavier();
        affichage.setText(String.valueOf(afficheur));
    }
    public void OnClickBtn9(View view){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        if(!decimal&&compte_decimal<2) {
            afficheur += "9";
            dollars += "9";
        }
        else if(decimal&&compte_decimal<2){
            afficheur += "9";
            cents += "9";
            compte_decimal++;
        }
        else fermerClavier();
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
        Clear();
    }
    public void Clear(){
        TextView affichage = findViewById(R.id.txtb_aff_montant);
        afficheur="";
        cents="";
        dollars="";
        Button btn_point = (Button) findViewById(R.id.btn_point);
        btn_point.setEnabled(true);
        radioReset();
        decimal=false;
        cheque=false;
        epargne=false;
        depot=false;
        virement=false;
        retrait=false;
        compte_decimal=0;
        affichage.setText(String.valueOf(afficheur));
        ouvrirClavier();
    }
    private int convertionCents(){
        int tampon=user_dollars;
        if(user_dollars>0)tampon*=100;
        return tampon+=user_cents;
    }
    private void virements(){
       // StringToMoney();
        if(epargne){
            if(compte_client.get(index_epargne).comparateurCents()>=convertionCents()){
                retrait();
                cheque=true;
                epargne=false;
                depot();
                String toast="Virement de "+user_dollars+","+user_cents+" de votre compte épargne vers votre compte chèque";
                Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();
            }
        }
        else if (cheque)
            if(compte_client.get(index_cheque).comparateurCents()>=convertionCents()){
                retrait();
                cheque=false;
                epargne=true;
                depot();
                String toast="Virement de "+user_dollars+","+user_cents+" de votre compte chèque vers votre compte épargne";
                Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();
            }
        else {
                Toast.makeText(getApplicationContext(), "Sélectionner un compte", Toast.LENGTH_LONG).show();
        }
        Clear();
    }
    private void depot(){
        if(epargne){
            compte_client.get(index_epargne).afficherSolde();
            //System.out.println("Le nombre de dollar avant de partir : "+user_dollars);
            compte_client.get(index_epargne).depot(user_dollars*100, user_cents);
            compte_client.get(index_epargne).afficherSolde();
            String toast="Dépot de "+user_dollars+","+user_cents+" sur votre compte épargne";
            if(!virement){
                Clear();
                Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();
            }
        }
        else if (cheque){
            compte_client.get(index_cheque).afficherSolde();
            //System.out.println("Le nombre de dollar avant de partir : "+user_dollars);
            compte_client.get(index_cheque).depot(user_dollars*100, user_cents);
            compte_client.get(index_cheque).afficherSolde();
            String toast="Dépot de "+user_dollars+","+user_cents+" sur votre compte chèque";
            if(!virement){
                Clear();
                Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();
            }
        }
        else
            Toast.makeText(getApplicationContext(),"Sélectionner un compte", Toast.LENGTH_LONG).show();

    }
    private void retrait(){
      //  StringToMoney();
        if(epargne){
            compte_client.get(index_epargne).afficherSolde();
            //System.out.println("Le nombre de dollar avant de partir : "+user_dollars);
            compte_client.get(index_epargne).retrait(user_dollars*100, user_cents);
            compte_client.get(index_epargne).afficherSolde();
            String toast="Retrait de "+user_dollars+","+user_cents+" sur votre compte épargne";
            if(!virement){
                Clear();
                Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();
            }
        }
        else if (cheque){
            compte_client.get(index_cheque).afficherSolde();
            //System.out.println("Le nombre de dollar avant de partir : "+user_dollars);
            compte_client.get(index_cheque).retrait(user_dollars*100, user_cents);
            compte_client.get(index_cheque).afficherSolde();
            String toast="Dépot de "+user_dollars+","+user_cents+" sur votre compte chèque";
            if(!virement){
                Clear();
                Toast.makeText(getApplicationContext(), toast, Toast.LENGTH_LONG).show();
            }
        }
        else
        Toast.makeText(getApplicationContext(),"Sélectionner un compte", Toast.LENGTH_LONG).show();
    }
    private void StringToMoney(){
        user_cents=0;
        user_dollars=0;
        if(!cents.equals("")&&!dollars.equals("")){
            if(!cents.equals(""))user_cents=Integer.parseInt(cents);
            if(!dollars.equals("")) user_dollars=Integer.parseInt(dollars);
        }
        else
        Toast.makeText(getApplicationContext(),"Utiliser le clavier pour entrer une valeur", Toast.LENGTH_LONG).show();
    }
    private void fermerClavier(){
        LinearLayout lay_1 = (LinearLayout) findViewById(R.id.lay_num1);
        lay_1.setEnabled(false);
        LinearLayout lay_2 = (LinearLayout) findViewById(R.id.lay_num2);
        lay_2.setEnabled(false);
        LinearLayout lay_3 = (LinearLayout) findViewById(R.id.lay_num3);
        lay_3.setEnabled(false);
    }
    private void ouvrirClavier(){
        LinearLayout lay_1 = (LinearLayout) findViewById(R.id.lay_num1);
        lay_1.setEnabled(true);
        LinearLayout lay_2 = (LinearLayout) findViewById(R.id.lay_num2);
        lay_2.setEnabled(true);
        LinearLayout lay_3 = (LinearLayout) findViewById(R.id.lay_num3);
        lay_3.setEnabled(true);
    }
    private void radioReset(){
        //RadioGroup.clearCheck()
        RadioGroup rdg_operation=(RadioGroup) findViewById(R.id.radioG_operation);
        rdg_operation.clearCheck();
        RadioGroup rdg_compte=(RadioGroup) findViewById(R.id.radioG_compte);
        rdg_compte.clearCheck();
    }
    @SuppressLint("SetTextI18n")
    public void OnClickEtatDesComptes(View view){
        System.out.println("TU Y ESSSSSSSSSSSS");
        double affi_cheque=0;
        double affi_ep=0;

        if(index_cheque!=-1) {
            TextView cheque = findViewById(R.id.txt_solde_cheque);
            affi_cheque = compte_client.get(index_cheque).comparateurCents() / 100.0;
            cheque.setText("Solde compte Chèque : " + affi_cheque);
            cheque.setTextColor(Color.BLUE);
        }

        if(index_epargne!=-1) {
            TextView epargne = findViewById(R.id.txt_solde_epargne);
            affi_ep = compte_client.get(index_epargne).comparateurCents() / 100.0;
            epargne.setText("Solde compte Épargne : " + affi_ep);
            epargne.setTextColor(Color.BLUE);
        }
    }
    private void resetEtatCompte(){
        TextView cheque = findViewById(R.id.txt_solde_cheque);
        cheque.setText("");

        TextView epargne = findViewById(R.id.txt_solde_epargne);
        epargne.setText("");
    }
}