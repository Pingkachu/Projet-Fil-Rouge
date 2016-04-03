package com.hannequin.tp;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends ArrayAdapter<TauxPays> {
	 
    public ItemAdapter(Context context, TauxPays[] resource) {
		super(context, 0 , resource);
		// TODO Auto-generated constructor stub
	}
    
    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
 
        if(convertView == null){
        	return parent;
        }
 
        ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        if(viewHolder == null)
        {
            viewHolder = new ViewHolder();
            viewHolder.nomPays = (TextView) convertView.findViewById(R.id.nomPays);
            viewHolder.monnaie = (TextView) convertView.findViewById(R.id.monnaie);
            viewHolder.drapeau = (ImageView) convertView.findViewById(R.id.drapeau);
            convertView.setTag(viewHolder);
        }
 
        TauxPays pays = getItem(position);
        viewHolder.nomPays.setText(pays.getNom());
        viewHolder.monnaie.setText(pays.getMonnaie());
        viewHolder.drapeau.setImageResource(pays.getDrapeau());
 
        return convertView;
    }
 
    private class ViewHolder{
        public TextView nomPays;
        public TextView monnaie;
        public ImageView drapeau;
    }
}
