package com.example.tp_final_fb;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ClientAdapter extends ArrayAdapter<Client> {
    private ArrayList<Client> clients_list;
    private Context context;

    private int viewRes;
    private Resources res;

    public ClientAdapter(Context context, int textViewResourceId, ArrayList<Client> clients){
        super(context, textViewResourceId, clients);
        this.clients_list = clients;
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
        final Client client = clients_list.get(position);

        if(client != null){
            final TextView username = (TextView) view.findViewById(R.id.username);
            final TextView prenom = (TextView) view.findViewById(R.id.prenom);
            final TextView nom = (TextView) view.findViewById(R.id.nom);

            String nom_utilisateur=res.getString(R.string.username)+client.getUsername();
            username.setText(nom_utilisateur);

            String pre_nom=res.getString(R.string.prenom)+client.getPrenom();
            prenom.setText(pre_nom);

            String nom_pre=res.getString(R.string.nom)+client.getNom();
            nom.setText(nom_pre);
        }
        return view;
    }

    @Override
    public int getCount(){
        return clients_list.size();
    }

}