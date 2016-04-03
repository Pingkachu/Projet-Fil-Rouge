package com.hannequin.tp;

public enum TauxPays {

	  /*
	   * Objets directement construits de 10 pays 
	   * Chaque objet peut �tre obtenu par la syntaxe suivante:
	   * 
	   * 	TauxPayx fra = TauxPays.FR;
	   * ou
	   * 	TauxPays t = TauxPays.valueOf(TauxPays.class, "FR");	//FR est le nom de l'objet
	   *	String nomPays =  t.getNom());							//t est l'objet FR et 
	   *															//t.getNom() retourne "France"
	   *															//t.getTaux() retourne le taux de change
	   */
	  FR ("FR","France",			"euro" , 			1.0f , 	R.drawable.france),
	  GB ("GB","Grande Bretagne",	"livre" ,			0.775f , R.drawable.angleterre),
	  CA ("CA","Canada",			"dolar canadien" ,	1.473f , 	R.drawable.canada),
	  US ("US","United states",		"dollar", 			1.115f , 	R.drawable.usa),
	  AU ("AU","Australie", 		"dollar australien" ,1.473f , R.drawable.australie),
	  NZ ("NZ","Nouvelle Zelande",	"kiwi" , 			1.652f , R.drawable.nouvellezeland),
	  VN ("VN","Vietnam",			"dong", 			24844.0f , R.drawable.vietnam),
	  JP ("JP","Japon",				"yen", 				126.9f , R.drawable.japon),
	  TN ("TN","Tunisie",			"dinar", 			2.253f , R.drawable.tunisie),
	  ML ("ML","Mali",				"franc CFA", 		655.957f , R.drawable.mali);

	/*
	 * Membre :		 			1) code ISO de chaque pays( 2 lettres majuscules) 
	 * 							2) nom du pays
	 * 							3) nom de la monnaie
	 * 							4) taux de change : 1euro = t nom_monnaie_du_pays
	 * 							5) id de l'image du drapeau fourni avec le sujet du controle
	 */
	  private String name = "";
	  private int drap = 0;
	  private float taux = 1;
	  private String monnaie = "";
	  private String nomISO = "";

/*
 * Constructeur : 			1) code ISO de chaque pays( 2 lettres majuscules) 
 * 							2) nom du pays
 * 							3) nom de la monnaie
 * 							4) taux de change : 1euro = t nom_monnaie_du_pays
 * 							5) id de l'image du drapeau fourni avec le sujet du controle
 */
TauxPays(String niso , String name, String m , float t , int d){
		this.nomISO = niso;
	    this.name = name;
	    this.drap = d;
	    this.taux = t;
	    monnaie = m;
	  }
//*************************************
public String getnomISO(){
			return nomISO;
		}
//*************************************
public int getDrapeau(){
	return drap;
}
//*************************************
public String getMonnaie(){
	return monnaie;
}
//*************************************
public float getTaux(){
	 return taux;
	  }
//*************************************
public String getNom(){
	    return name;
	  }

	}
