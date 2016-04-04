package com.hannequin.tp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity{
	
	TextView modele;
	TextView marque;
	TextView tel;
	TextView prix;
	TextView etat;
	TextView comm;
	ImageView avatar;
	Button retour;
	Button offre;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite2);
        
        retour = (Button) findViewById(R.id.retour);
        marque = (TextView) findViewById(R.id.marque2);
        modele = (TextView) findViewById(R.id.modele2);   
        tel = (TextView) findViewById(R.id.tel2);
        etat = (TextView) findViewById(R.id.etat2);
        comm = (TextView) findViewById(R.id.comm2);
        avatar = (ImageView) findViewById(R.id.avatar2);
        prix = (TextView) findViewById(R.id.prix2);
        offre = (Button) findViewById(R.id.offre);
        
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Annonce annonce = extras.getParcelable("Annonce");
            marque.setText(annonce.getMarque());
            modele.setText(annonce.getModele());    
            tel.setText(annonce.getTel());
            etat.setText(annonce.getTel());
            comm.setText(annonce.getTel());
            prix.setText(annonce.getTel());
            avatar.setImageResource(annonce.getAvatar());
        }
        else{
        	Toast.makeText(SecondActivity.this, "Désolé je ne retrouve pas les donn�es concernant cette annonce", Toast.LENGTH_SHORT).show();
        }

        retour.setOnClickListener(retourListener);

    }
    
    
    private OnClickListener retourListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent appel = new Intent(SecondActivity.this, MainActivity.class);
	        startActivity(appel);
		}
	  };
}
