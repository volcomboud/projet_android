package com.example.tp_final_fb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;

public class Guichet {

    private NavigableMap<String, Client >  arbre_client= new TreeMap<String, Client>();
    private ArrayList<Cheque> cpt_cheque=new ArrayList<Cheque>();
    private ArrayList<Epargne> cpt_epargne=new ArrayList<Epargne>();

    Guichet(){

    }
    protected boolean validerUtilisateur(String username, int nip){
       if(!arbre_client.isEmpty()) {
           if (this.arbre_client.get(username) != null) {
               //Iterator<NavigableMap.Entry<String, Client> > itr= this.arbre_client.entrySet().iterator();
               if (Objects.requireNonNull(this.arbre_client.get(username)).getNip(nip)) return true;
           }
       }
        return false;
    }
    protected ArrayList<Compte> passeCompte(String username, int nip){
        ArrayList<Compte> passeur=new ArrayList<Compte>();
        passeur= Objects.requireNonNull(this.arbre_client.get(username)).comptes_client;
        return passeur;
    }
   protected void ajouterClient(Client client){
        this.arbre_client.put(client.getUsername(), client);
    }
    protected boolean adminCred(String username){
        if(Objects.requireNonNull(this.arbre_client.get(username)).admin)return true;
        else return false;
    }
    protected void ajouterCheque(Cheque cheque){
        this.cpt_cheque.add(cheque);
    }
    protected void ajouterEpargne(Epargne epargne){
        this.cpt_epargne.add(epargne);
    }

}
