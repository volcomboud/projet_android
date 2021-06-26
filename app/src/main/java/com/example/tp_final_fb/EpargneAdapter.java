package com.example.tp_final_fb;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class EpargneAdapter extends ArrayAdapter<Epargne> {
    private ArrayList<Epargne> epargne_list;
    private Context context;

    private int viewRes;
    private Resources res;

    public EpargneAdapter(Context context, int textViewResourceId, ArrayList<Epargne> epargne){
        super(context, textViewResourceId, epargne);
        this.epargne_list = epargne;
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
        final Epargne epargne = epargne_list.get(position);

        if(epargne != null){
            final TextView num_compte = (TextView) view.findViewById(R.id.num_compte);
            final TextView solde_compte = (TextView) view.findViewById(R.id.solde_compte);
            String numero_compte=res.getString(R.string.num_compte)+epargne.getNum_compte();
            num_compte.setText(numero_compte);
            String solde_comp=res.getString(R.string.solde_compte)+epargne.afficheSolde();
            solde_compte.setText(solde_comp);
        }
        return view;
    }

    @Override
    public int getCount(){
        return epargne_list.size();
    }

}
