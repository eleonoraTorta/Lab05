package it.polito.tdp.anagrammi.model;

public class Lettera {
	
	private char lettera;
	private int indice;
	/**
	 * @param lettera
	 * @param indice
	 */
	public Lettera(char lettera, int indice) {
		super();
		this.lettera = lettera;
		this.indice = indice;
	}
	/**
	 * @return the lettera
	 */
	public char getLettera() {
		return lettera;
	}
	/**
	 * @param lettera the lettera to set
	 */
	public void setLettera(char lettera) {
		this.lettera = lettera;
	}
	/**
	 * @return the indice
	 */
	public int getIndice() {
		return indice;
	}
	/**
	 * @param indice the indice to set
	 */
	public void setIndice(int indice) {
		this.indice = indice;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Lettera [lettera=" + lettera + ", indice=" + indice + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + indice;
		result = prime * result + lettera;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lettera other = (Lettera) obj;
		if (indice != other.indice)
			return false;
		if (lettera != other.lettera)
			return false;
		return true;
	}


}
