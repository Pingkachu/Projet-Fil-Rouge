package com.hannequin.tp;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends ArrayAdapter<Annonce> {
	 
    public ItemAdapter(Context context, Annonce[] resource) {
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
            viewHolder.marque = (TextView) convertView.findViewById(R.id.marque);
            viewHolder.modele = (TextView) convertView.findViewById(R.id.modele);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
        }
 
        Annonce annonce = getItem(position);
        viewHolder.marque.setText(annonce.getMarque());
        viewHolder.modele.setText(annonce.getModele());
        viewHolder.avatar.setImageResource(annonce.getAvatar());
 
        return convertView;
    }
 
    private class ViewHolder{
        public TextView marque = null;
        public TextView modele = null;
        public ImageView avatar = null;
    }
}
