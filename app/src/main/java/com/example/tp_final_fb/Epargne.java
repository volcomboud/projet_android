package com.example.tp_final_fb;

import android.annotation.SuppressLint;
import android.os.Parcel;

public class Epargne extends Compte {
    private static double taux_interet=1.25;

    Epargne(int nip, int dollar, int cents){
        super(nip, dollar, cents);
        this.type_epargne=true;
    }

     protected void paiementInterets(){
        int tampon=convertionCents();
        tampon*=taux_interet;
        this.solde_dollar=0;
        this.solde_cents=tampon;
        conversionDollars();
    }
    protected Epargne(Parcel in) {
        num_nip = in.readInt();
        solde_dollar = in.readInt();
        solde_cents = in.readInt();
        num_compte = in.readInt();
        type_epargne= in.readByte() != 0;
    }
    public static final Creator<Epargne> CREATOR = new Creator<Epargne>() {
        @Override
        public Epargne createFromParcel(Parcel in) {
            return new Epargne(in);
        }

        @Override
        public Epargne[] newArray(int size) {
            return new Epargne[size];
        }
    };
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(num_nip);
        dest.writeInt(solde_dollar);
        dest.writeInt(solde_cents);
        dest.writeInt(num_compte);
        dest.writeByte((byte) (type_epargne ? 1 : 0));
    }
}
