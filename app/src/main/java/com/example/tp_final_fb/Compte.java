package com.example.tp_final_fb;

public abstract class Compte {
    protected int num_nip;
    protected int solde_dollar;
    protected int solde_cents;
    private int num_compte;
    private static int compteur_num_compte=1000001;

    Compte(){
        setNumCompte();
    }

    Compte(int nip, int dollar, int cents){
        this();
        this.num_nip=nip;
        this.solde_dollar=dollar;
        this.solde_cents=cents;
        conversionCents();
    }
     private  void setNumCompte(){
        this.num_compte=compteur_num_compte;
        Compte.compteur_num_compte++;
    }
    protected void conversionCents(){
        while(solde_cents>100){
            this.solde_cents-=100;
            this.solde_dollar+=1;
        }
    }
}
