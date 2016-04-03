package com.hannequin.tp;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.EditText;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.text.Editable;
import android.text.TextWatcher;

public class MainActivity extends Activity {
	
	ListView mListView;
	EditText mEditText;
	Button webSite;
	WebView mWebView;
	
	TauxPays[] liste = { TauxPays.FR, TauxPays.GB, TauxPays.CA, TauxPays.AU, TauxPays.US,
			TauxPays.NZ, TauxPays.JP, TauxPays.VN, TauxPays.TN, TauxPays.ML};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     
         mListView = (ListView) findViewById(R.id.listView);
         webSite = (Button) findViewById(R.id.website);
         mEditText = (EditText) findViewById(R.id.recherche);
                  
         webSite.setOnClickListener(webSiteListener);
         mEditText.addTextChangedListener(textWatcher);
         ItemAdapter adapter = new ItemAdapter(MainActivity.this, liste);
         mListView.setAdapter(adapter);
         mListView.setOnItemClickListener(new OnItemClickListener() {

             public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                     long arg3) {
                 // TODO Auto-generated method stub
            	Intent appel = new Intent(MainActivity.this, SecondActivity.class);
            	appel.putExtra("ISO", ((TauxPays)mListView.getItemAtPosition(position)).getnomISO() );
            	appel.putExtra("tauxPays", (TauxPays)mListView.getItemAtPosition(position) );
 	            startActivity(appel);
             }
         });
     
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
		
	}
    };
    
    
    private OnClickListener webSiteListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String recherche = mEditText.getText().toString();
			Toast.makeText(MainActivity.this, "Connection au site de recherche...", Toast.LENGTH_SHORT).show();
	        setContentView(R.layout.web_activity);
	        mWebView = (WebView) findViewById(R.id.webView);
	        mWebView.loadUrl("http://www.google.com/#q="+recherche);
		}
	  };
}
