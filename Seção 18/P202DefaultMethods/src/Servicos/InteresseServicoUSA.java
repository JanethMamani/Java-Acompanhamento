package Servicos;

public class InteresseServicoUSA implements InteresseServico{
	
	private double taxaInteresse;
	
	public InteresseServicoUSA(double taxaInteress) {
		taxaInteresse = taxaInteress;
	}

	@Override
	public double getTaxaInteresse() {
		return taxaInteresse;
	}

}
