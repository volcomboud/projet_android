package com.example.tp_final_fb;


import android.os.Parcelable;

public abstract class Compte implements Parcelable {

    protected int num_nip;
    protected int solde_dollar;
    protected int solde_cents;
    protected int num_compte;
    protected boolean type_epargne;
    private static int compteur_num_compte=1000001;

    Compte(){
        setNumCompte();
    }
    Compte(int nip, int dollar, int cents){
        this();
        this.num_nip=nip;
        this.solde_dollar=dollar;
        this.solde_cents=cents;
        conversionDollars();
    }
     private  void setNumCompte(){
        this.num_compte=compteur_num_compte;
        Compte.compteur_num_compte++;
    }
    protected void conversionDollars(){
        while(solde_cents>=100){
            this.solde_cents-=100;
            this.solde_dollar+=1;
        }
    }
    protected int convertionCents(){
        int tampon=this.solde_dollar;
        if(solde_dollar>0)tampon*=100;
        return tampon+=solde_cents;
    }
    protected void depot(int user_dollars,int user_cents){
        int tampon=convertionCents();
        user_cents+=user_dollars;
            tampon += user_cents;
            this.solde_dollar=0;
            this.solde_cents=tampon;
            conversionDollars();
    }
    protected void retrait(int user_dollars,int user_cents){
        int tampon=convertionCents();
        user_cents+=user_dollars;
        if(tampon>=user_cents) {
            tampon -= user_cents;
            this.solde_dollar=0;
            this.solde_cents=tampon;
            conversionDollars();
        }
    }
//    protected void conversionDollarsPlusPlus(){
//        System.out.println("AVANT CONVERSION);"+solde_cents);
//
//        while(solde_cents>=100){
//            this.solde_cents-=100;
//            this.solde_dollar+=1;
//        }
//
//    }
    protected void afficherSolde(){
        if(solde_cents>9)System.out.println("Le solde du compte : "+this.solde_dollar+","+this.solde_cents);
        else
            System.out.println("Le solde du compte : "+this.solde_dollar+",0"+this.solde_cents);
    }
    protected String afficheSolde(){
        if(solde_cents>9)return "Le solde du compte : "+this.solde_dollar+","+this.solde_cents;
        else return "Le solde du compte : "+this.solde_dollar+",0"+this.solde_cents;
    }
    protected boolean getType(){
        return this.type_epargne;
    }
    protected int comparateurCents(){
        int tampon=convertionCents();
        return tampon;
    }
//    public String toString() {
//        return "Num??ro de compte : "+this.num_compte+"\n"+afficheSolde();
//
//    }
    public int getNum_nip() {
        return num_nip;
    }

    public void setNum_nip(int num_nip) {
        this.num_nip = num_nip;
    }

    public int getSolde_dollar() {
        return solde_dollar;
    }

    public void setSolde_dollar(int solde_dollar) {
        this.solde_dollar = solde_dollar;
    }

    public int getSolde_cents() {
        return solde_cents;
    }

    public void setSolde_cents(int solde_cents) {
        this.solde_cents = solde_cents;
    }

    public int getNum_compte() {
        return num_compte;
    }

    public void setNum_compte(int num_compte) {
        this.num_compte = num_compte;
    }
}
