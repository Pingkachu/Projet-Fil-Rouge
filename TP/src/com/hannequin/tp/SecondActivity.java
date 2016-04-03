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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity{
	
	TextView mTextView;
	EditText mEditText;
	Button mButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite2);
        
        mEditText = (EditText) findViewById(R.id.convert);
        mTextView = (TextView) findViewById(R.id.resultat);
        mButton = (Button) findViewById(R.id.retour);
        

        
        
        
        mEditText.addTextChangedListener(textWatcher);
        mButton.setOnClickListener(retourListener);

    }
    
    //M�thode pour agir sur les editText
    private TextWatcher textWatcher = new TextWatcher() {

      @Override
      public void onTextChanged(CharSequence s, int start, int before, int count) {

      }
  		
      @Override
      public void beforeTextChanged(CharSequence s, int start, int count,
        int after) {
    
      }

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub
		Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String iso = extras.getString("ISO");
            TauxPays tauxPays = extras.getParcelable("tauxPays");
            float convertir = Float.valueOf(mEditText.getText().toString());
            float taux = tauxPays.getTaux();
    		float conversion = convertir*taux;
    		mTextView.setText(Float.toString(conversion)+tauxPays.getMonnaie());
        }
        else{
        	Toast.makeText(SecondActivity.this, "Désolé je ne retrouve pas le pays de conversion", Toast.LENGTH_SHORT).show();
        }
		
	}
    };
    
    
    private OnClickListener retourListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent appel = new Intent(SecondActivity.this, MainActivity.class);
	        startActivity(appel);
		}
	  };
}
