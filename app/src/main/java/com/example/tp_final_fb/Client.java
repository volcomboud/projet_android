package com.example.tp_final_fb;

import java.util.ArrayList;

public class Client {
    private String nom;
    private String prenom;
    private String username;
    protected ArrayList<Compte> comptes_client=new ArrayList<Compte>();
    protected boolean admin;

    Client(String nom,  String prenom, String username, boolean admin){
        this.nom=nom;
        this.prenom=prenom;
        this.username=username;
        this.admin=admin;
    }
    Client(String nom,  String prenom, String username, boolean admin, Compte ck){
        this(nom, prenom, username, admin);
        ajouterCompte(ck);
    }

    Client(String nom,  String prenom, String username, boolean admin, Compte ck,Compte ep){
        this(nom, prenom, username, admin);
        this.comptes_client.add(ck);
        this.comptes_client.add(ep);
    }
    void ajouterCompte(Compte compte){
        this.comptes_client.add(compte);
    }
    public String getUsername(){
        return this.username;
    }
    protected boolean getNip(int nip){

        if(!this.comptes_client.isEmpty()) {
            for (int i = 0; i < comptes_client.size(); i++) {
                if (comptes_client.get(i).num_nip == nip) {
                    return true;
                }
            }
        }
        return false;
    }
}
