package com.hannequin.tp;

/*
 * Projet qui nécessite un web service sur un serveur glassfish par exemple.
 * Servlet nommée Servlet1/foixDeux (ou une autre à adapter)
 * n et m sont des réels issus de zones de saisies de l'IHM (activité principale)
 * Les requêtes doivent être de la forme:
 * METHODE GET:
 * http://xxx.xxx.xxx.xxx/cheminDuServlet/nomServlet?a=n&b=m
 * METHODE POST
 * http://xxx.xxx.xxx.xxx/cheminDuServlet/nomServlet
 * 
 * Corps de la requête =>		a=n&b=m
 * 
 * Attention , à adapter aux versions du sdk utilisées
 * 
 * Les tests doivent être faits avec un smartphone matériel 
 * Possibilité de visualiser les requêtes avec wireshark (téléchargement gratuit)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;
import org.json.JSONArray;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Classe qui récupère les données
public class Annonce  {
	private String marque;
	private String modele;
	private String etat;
	private double prix;
	private int tel;
	private	String comm;
	private String date;
	private int avatar;
	
public int getAvatar() {
	return R.drawable.portable;
}

public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getComm() {
		return comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

public static ArrayList<Annonce> getAnnonces()
{
	ArrayList<Annonce> annonces = null;
	try {
        // Encodage des paramètres de la requête
        String donnees = URLEncoder.encode("start", "ISO-8859-1")+ "="+URLEncoder.encode("1", "ISO-8859-1");
        donnees += "&"+URLEncoder.encode("end", "ISO-8859-1")+ "=" + URLEncoder.encode("8", "ISO-8859-1");
        
        // On a envoyé les données à une adresse distante
        String demapi = Annonce.GET("http://filrouge.pierrrec.com/annonces.php?"+donnees);
        Log.i("demapi", "result request : "+demapi);
        JSONObject info = new JSONObject(demapi);
        JSONArray array = new JSONArray(info.getString("annonces"));
        for (int i = 0; i < array.length(); i++) {
            // On récupère un objet JSON du tableau
            JSONObject obj = new JSONObject(array.getString(i));
            // On fait le lien Personne - Objet JSON
            Annonce annonce = new Annonce();
            annonce.setMarque(obj.getString("marque"));
            annonce.setModele(obj.getString("modele"));
            annonce.setEtat(obj.getString("etat"));
            annonce.setPrix(obj.getDouble("prix"));
            annonce.setTel(obj.getInt("telephone"));
            annonce.setComm(obj.getString("commentaire"));
            annonce.setDate(obj.getString("date_annonce"));
            
            // On ajoute la personne à la liste
            annonces.add(annonce);
           
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
	return annonces;
}
	
	  public static String GET(String url){
	      InputStream inputStream = null;
	      String result = "";
	      try {

	          // create HttpClient
	          HttpClient httpclient = new DefaultHttpClient();

	          // make GET request to the given URL
	          HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

	          // receive response as inputStream
	          inputStream = httpResponse.getEntity().getContent();

	          // convert inputstream to string
	          if(inputStream != null)
	              result = convertInputStreamToString(inputStream);
	          else
	              result = "Did not work!";

	      } catch (Exception e) {
	          Log.d("InputStream", e.getLocalizedMessage());
	      }

	      return result;
	  }

	  private static String convertInputStreamToString(InputStream inputStream) throws IOException{
	      BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
	      String line = "";
	      String result = "";
	      while((line = bufferedReader.readLine()) != null)
	          result += line;

	      inputStream.close();
	      return result;

	  }
}