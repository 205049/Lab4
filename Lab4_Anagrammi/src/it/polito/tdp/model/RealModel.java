package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.db.AnagrammiDAO;

public class RealModel {

	private List<String> permutazioni;
	//private char[] ptemp;
	
	//private int n;
	
	AnagrammiDAO db;

	public RealModel() {
		super();
		permutazioni = new LinkedList<String>();
		
		//ptemp = new char[];
		
		db = new AnagrammiDAO();
	}
	
	//SOSTITUIRE LA RICORSIONE CON UNA VERSIONE ITERATIVA
	public List<String> permuta(String finale){
		permuta("", finale);
		
		return permutazioni;
	}
	
	public void permuta(String originale, String finale) {
		 
		if(finale.length()<=1)
			permutazioni.add(originale+finale);
		else{
			for(int i=0; i < finale.length(); i++) {
				String nuova = finale.substring(0,i) + finale.substring(i+1);
				permuta(originale + finale.charAt(i), nuova);
			}
		}
	}
	
	//public String parolaEsistente(String p){
		//return db.parolaEsistente(p);
	//}
	
	public String cerca(String nome){
		return db.cerca(nome);
	}
	
	public static void main(String [] args){
		RealModel am = new RealModel();
		Parola p = new Parola("eat");
		System.out.println(am.permuta("eat"));
		List<String> perm = new LinkedList<String>(am.permuta("eat"));
    	
		String res = "";
    	for(String s: perm){
    		if(am.cerca(s) != null){
    			res += (s + "\n");
    		} else if(am.cerca(s) == null){
    			res += (s + "NON VALIDA\n");
    		}
    	}
    	System.out.println(res);
    	
    	String s = "cane";
    	System.out.println(s.substring(0,0));
    	System.out.println(s.substring(1));
	}
	
}
