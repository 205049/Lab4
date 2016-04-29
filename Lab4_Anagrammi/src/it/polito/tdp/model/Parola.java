package it.polito.tdp.model;

import java.util.LinkedList;
import java.util.List;

public class Parola {
	
	private String parola;
	private List<Character> listaCaratteri;
	private List<Integer> posizioni;
	
	private int N;
	
	public Parola(String parola) {
		super();
		this.parola = parola;
		posizioni = new LinkedList<Integer>();
		for(int i=0; i<N; i++){ 
			posizioni.add(i);
		}
		
		N = parola.length();
		
		listaCaratteri = new LinkedList<Character>();
		for(int i=0; i<N; i++){
			listaCaratteri.add(parola.charAt(i));
		}
	}
	
	public int length(){
		return parola.length();
	}

	public String toString() {
		String res = "";
		for(Character ch: listaCaratteri){
			res += ch;
		}
		return res;
	}

	public List<Character> getListaCaratteri() {
		return listaCaratteri;
	}

	public String getParola() {
		return parola;
	}
	
	public void remove(Character c){
		listaCaratteri.remove(c);
	}

	/*public void set(Integer pos, Character temp) {
		if(listaCaratteri[pos] == null)
			listaCaratteri[pos] = temp;
	}

	public void delete(Integer fatto) {
		if(listaCaratteri[fatto] != null)
			 posizioni.remove(fatto);
	}
	
	
	public static void main(String [] args){
		Parola p = new Parola("eat");
		System.out.println(p.toString());
	}*/

	
	
}
