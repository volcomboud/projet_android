package com.example.tp_final_fb;

import android.annotation.SuppressLint;
import android.os.Parcel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Cheque extends Compte {

    Cheque(int nip, int dollar, int cents){
        super(nip, dollar, cents);
        this.type_epargne=false;
    }
    protected Cheque(Parcel in) {
        num_nip = in.readInt();
        solde_dollar = in.readInt();
        solde_cents = in.readInt();
        num_compte = in.readInt();
        type_epargne= in.readByte() != 0;
    }
    public static final Creator<Cheque> CREATOR = new Creator<Cheque>() {
        @Override
        public Cheque createFromParcel(Parcel in) {
            return new Cheque(in);
        }

        @Override
        public Cheque[] newArray(int size) {
            return new Cheque[size];
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
