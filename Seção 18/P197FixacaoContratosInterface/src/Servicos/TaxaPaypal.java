package Servicos;

public class TaxaPaypal implements TaxaPagamento{
	
	public double aplicarTaxa(double parcela, int mes) {
		return parcela*1.01 *mes  + parcela*0.02;
	}

}
