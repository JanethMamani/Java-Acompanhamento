package Modelo.Servicos;

public class TaxaServicoBrasil {
	
	public double taxaPorPorcentagem(double valor) { //double sempre pede valor, nao aceita nulo
		//Mas ja que aqui sempre vai ter valor mesmo..
		if(valor<=100.0) {
			return valor * 0.2;
		}
		else {
			return valor * 0.15;
		}
	}

}
