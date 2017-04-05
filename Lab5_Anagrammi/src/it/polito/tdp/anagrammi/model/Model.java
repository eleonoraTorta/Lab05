package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {
	
	public Model(){  
	
	}
	
	private List <Anagramma> solutions ;
	private LinkedList <Lettera> lettere = new LinkedList<Lettera>(); 
	
	
	public boolean anagrammaIsCorrect(String anagramma){
		AnagrammaDAO a = new AnagrammaDAO();
		return a.isCorrect(anagramma);
	}
	
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
}
