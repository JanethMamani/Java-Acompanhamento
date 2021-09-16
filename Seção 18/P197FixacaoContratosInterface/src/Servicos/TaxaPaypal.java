package Servicos;

public class TaxaPaypal implements TaxaPagamento{
	
	public double aplicarTaxa(double parcela, int mes) {
		double part1 = parcela + parcela*0.01 *mes;
		return  part1*1.02;
	}

}
