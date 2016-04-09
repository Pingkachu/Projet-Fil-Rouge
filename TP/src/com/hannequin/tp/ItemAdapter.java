package com.hannequin.tp;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ItemAdapter extends BaseAdapter {
	
	// Une liste de personnes
	private List<Annonce> mListA;
	    	
	//Le contexte dans lequel est présent notre adapter
	private Context mContext;
	    	
	//Un mécanisme pour gérer l'affichage graphique depuis un layout XML
	private LayoutInflater mInflater;
	 
    public ItemAdapter(Context context, List<Annonce> aListA) {
		// TODO Auto-generated constructor stub
    	  mContext = context;
    	  mListA = aListA;
    	  mInflater = LayoutInflater.from(mContext);
	}
    
    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
 
        if(convertView == null){
        	return parent;
        }
 
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.marque = (TextView) convertView.findViewById(R.id.marque);
            viewHolder.modele = (TextView) convertView.findViewById(R.id.modele);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
 
        Annonce annonce = (Annonce) getItem(position);
        viewHolder.marque.setText(annonce.getMarque());
        viewHolder.modele.setText(annonce.getModele());
        viewHolder.avatar.setImageResource(annonce.getAvatar());
 
        return convertView;
    }
    

public View getView(int position, View convertView, ViewGroup parent) {
  LinearLayout layoutItem;
  //(1) : Réutilisation des layouts
  if (convertView == null) {
  	//Initialisation de notre item à partir du  layout XML "personne_layout.xml"
    layoutItem = (LinearLayout) mInflater.inflate(R.layout.annonce, parent, false);
  } else {
  	layoutItem = (LinearLayout) convertView;
  }
  
  //(2) : Récupération des TextView de notre layout      
  TextView tvMarque = (TextView)layoutItem.findViewById(R.id.marque);
  TextView tvModele = (TextView)layoutItem.findViewById(R.id.modele);
  ImageView ImAvatar = (ImageView)layoutItem.findViewById(R.id.avatar);
  
  //(3) : Renseignement des valeurs       
  tvMarque.setText(mListA.get(position).getMarque());
  tvModele.setText(mListA.get(position).getModele());
  ImAvatar.setImageResource(mListA.get(position).getAvatar());
  
  //(4) Changement de la couleur du fond de notre item
  if (mListA.get(position).genre == Personne.MASCULIN) {
    layoutItem.setBackgroundColor(Color.BLUE);
  } else {
  	layoutItem.setBackgroundColor(Color.MAGENTA);
  }

  //On retourne l'item créé.
  return layoutItem;
}

 
    private class ViewHolder{
        public TextView marque = null;
        public TextView modele = null;
        public ImageView avatar;
    }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mListA.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return mListA.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
}
