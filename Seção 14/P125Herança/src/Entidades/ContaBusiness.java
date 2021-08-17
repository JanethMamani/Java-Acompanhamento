package Entidades;

public class ContaBusiness extends Conta {
	
	private Double limiteEmprestimo;
	
	public ContaBusiness() {
		super();
	}
	
	public ContaBusiness (Integer num, String cliente, Double valor, Double loanLimit) {
		super(num, cliente, valor);
		limiteEmprestimo = loanLimit;
	}

	public Double getLimiteEmprestimo() {
		return limiteEmprestimo;
	}

	public void setLimiteEmprestimo(Double limiteEmprestimo) {
		this.limiteEmprestimo = limiteEmprestimo;
	}
	
	public void emprestimo(double valor) {
		if(valor<= limiteEmprestimo) {
			saldo += valor - 10.0;
		}
	}
	
	@Override
	public void saque(double valor) {
		super.saque(valor);
		saldo -= 2.0;
	}

}
