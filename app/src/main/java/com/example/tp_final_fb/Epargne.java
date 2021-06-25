package com.example.tp_final_fb;

public class Epargne extends Compte {
    private static double taux_interet=1.25;

    Epargne(int nip, int dollar, int cents){
        super(nip, dollar, cents);
    }
    void  paiementInterets(){
        this.solde_dollar*=taux_interet;
        this.solde_cents*=taux_interet;
        while(solde_cents>100){
            this.solde_cents-=100;
            this.solde_dollar+=1;
        }
    }
}
