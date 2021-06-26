package com.example.tp_final_fb;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Client implements Parcelable {
    private final String nom;
    private final String prenom;
    private final String username;
    protected ArrayList<Compte> comptes_client=new ArrayList<Compte>();
    protected boolean admin;

    Client(String nom,  String prenom, String username, boolean admin){
        this.nom=nom;
        this.prenom=prenom;
        this.username=username;
        this.admin=admin;
    }
    Client(String nom,  String prenom, String username, boolean admin, Epargne ck){
        this(nom, prenom, username, admin);
        ajouterCompte(ck);
    }
    Client(String nom,  String prenom, String username, boolean admin, Cheque ck){
        this(nom, prenom, username, admin);
        ajouterCompte(ck);
    }

    Client(String nom,  String prenom, String username, boolean admin, Cheque ck,Epargne ep){
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
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
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
    protected ArrayList<Compte> getComptes(){
        return this.comptes_client;
    }

    protected Client(Parcel in) {
        nom = in.readString();
        prenom = in.readString();
        username = in.readString();
        admin= in.readByte() != 0;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeString(prenom);
        dest.writeString(username);
        dest.writeByte((byte) (admin ? 1 : 0));
    }
    public static final Creator<Client> CREATOR = new Creator<Client>() {
        @Override
        public Client createFromParcel(Parcel in) {
            return new Client(in);
        }

        @Override
        public Client[] newArray(int size) {
            return new Client[size];
        }
    };
}
