package it.polito.tdp.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.db.AnagrammiDAO;

public class RealModel {

	List<String> soluzioni;

	public RealModel() {
		soluzioni = new ArrayList<String>();
	}
	
	public List<String> permuta(String p){
		
		soluzioni.clear();
		
		List<Character> array = new ArrayList<Character>();
		cerca(p,  array, 0);
		return soluzioni;
	}

	private void cerca(String p, List<Character> array, int liv) {

		char[] temp = p.toCharArray();
		
		if(liv == p.length()){
			
			String nuova = ""; //String.valueOf(array);
			for(Character c: array)
				nuova += c;	
			
			soluzioni.add(nuova);
			return;
		}
		
		for(int k=0; k<p.length(); k++){
			
			if(!array.contains(Character.valueOf(temp[k]))){
				
				array.add(Character.valueOf(temp[k]));
				
				cerca(p, array, liv+1);
				
				array.remove(Character.valueOf(temp[k]));
				
			}
		}
		
	}

	public String cercaDAO(String s) {
		AnagrammiDAO dao = new AnagrammiDAO();
		return dao.parolaEsistente(s);
	}
}
