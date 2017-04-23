package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
//	private List <Anagramma> solutions ;
//	private LinkedList <Lettera> lettere ; 
	
	public Model(){  
//		solutions = new ArrayList <Anagramma>();
//		lettere = new LinkedList <Lettera>();
	}

	
	public boolean anagrammaIsCorrect(String anagramma){
		AnagrammaDAO a = new AnagrammaDAO();
		return a.isCorrect(anagramma);
	}
	
	/*
	public List<Anagramma> cercaAnagramma(String parola){
		solutions = new ArrayList <Anagramma>();
		
		Anagramma a = new Anagramma(parola);
		for(int i =0; i < a.getDim(); i++){
			Lettera l = new Lettera(a.getParola().charAt(i),i);
			lettere.add(l);  }    
	
		LinkedList<Lettera> parziale = new LinkedList <Lettera>();
		int step =0;
	
		recursive(parziale, step, solutions);
		return solutions;
	}
	
	public void recursive( LinkedList<Lettera> parziale, int step, List<Anagramma> solutions){
		
		if( parziale.size() == lettere.size()){		
			String s = "";
			for(int i =0; i<parziale.size(); i++){
				s = s + parziale.get(i).getLettera();
			}
			Anagramma completa = new Anagramma(s);
			solutions.add(completa);
			return;
		}
	
		for(Lettera l : lettere){
			if( !parziale.contains(l) ){
				parziale.add(l);
				recursive(parziale, step+1, solutions);
				parziale.remove(l);
			}
		}
	}
	*/
	
	public Set<String> calcolaAnagrammi(String parola){
		Set<String> anagrammi = new HashSet<String>();
		String parziale = "";
		recursive(parziale,parola,0,anagrammi);
		return anagrammi;
	}
	
	private void recursive(String parziale,String parola, int passo, Set<String> anagrammi){
		if(passo == parola.length()){
			anagrammi.add(parziale);
			return;
		}
		
		for(int i = 0; i< parola.length(); i++){
			if(charCounter(parziale, parola.charAt(i))< charCounter(parola, parola.charAt(i))){
				parziale += parola.charAt(i);
				recursive(parziale, parola, passo + 1,anagrammi);
				parziale = parziale.substring(0,parziale.length()-1);
			}
		}
			
	}
	

	private static int charCounter(String string, char c){
		int count = 0;
	    for (int i=0; i < string.length(); i++)
	    {
	        if (string.charAt(i) == c)
	        {
	             count++;
	        }
	    }
	    return count;
	}
}
