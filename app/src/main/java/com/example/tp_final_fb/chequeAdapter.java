package com.example.tp_final_fb;


import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class chequeAdapter extends ArrayAdapter<Cheque> {
    private ArrayList<Cheque> cheque_list;
    private Context context;

    private int viewRes;
    private Resources res;

    public chequeAdapter(Context context, int textViewResourceId, ArrayList<Cheque> cheque){
        super(context, textViewResourceId, cheque);
        this.cheque_list = cheque;
        this.context = context;
        this.viewRes = textViewResourceId;
        this.res = context.getResources();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View view = convertView;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewRes, parent, false);
        }
        final Cheque cheque = cheque_list.get(position);

         if(cheque != null){
            final TextView num_compte = (TextView) view.findViewById(R.id.num_compte);
            final TextView solde_compte = (TextView) view.findViewById(R.id.solde_compte);
            String numero_compte=res.getString(R.string.num_compte)+cheque.getNum_compte();
            num_compte.setText(numero_compte);
            String solde_comp=res.getString(R.string.solde_compte)+cheque.afficheSolde();
            solde_compte.setText(solde_comp);
        }
         return view;
    }

    @Override
    public int getCount(){
        return cheque_list.size();
    }

}
