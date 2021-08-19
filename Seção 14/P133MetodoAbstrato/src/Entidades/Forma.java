package Entidades;

import Entidades.enums.Cor;

public abstract class Forma {
	
	private Cor cores;
	
	public Forma() {
		
	}

	public Forma(Cor cores) {
		this.cores = cores;
	}

	public Cor getCores() {
		return cores;
	}

	public void setCores(Cor cores) {
		this.cores = cores;
	}
	
	public abstract double area();

}
