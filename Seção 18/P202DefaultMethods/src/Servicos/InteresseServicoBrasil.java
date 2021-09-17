package Servicos;

public class InteresseServicoBrasil implements InteresseServico{
	
	private double taxaInteresse;
	
	public InteresseServicoBrasil(double taxaInteress) {
		taxaInteresse = taxaInteress;
	}

	@Override
	public double getTaxaInteresse() {
		return taxaInteresse;
	}
}
