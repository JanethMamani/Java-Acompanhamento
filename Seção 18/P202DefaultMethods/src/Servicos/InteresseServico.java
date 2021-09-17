package Servicos;

import java.security.InvalidParameterException;

public interface InteresseServico {
	
	double getTaxaInteresse();

	default double pagamento(double valor, int meses) {
		if (meses < 1) {
			throw new InvalidParameterException("Meses devem ser maiores que zero");
		}
		return valor * Math.pow(1.0 + getTaxaInteresse() / 100.0, meses);
	}

}
