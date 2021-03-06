package Entidades;

public class Poupanca extends Conta{
	
	private Double taxaInteresse;
	
	public Poupanca() {
		super();
	}

	public Poupanca(Integer numero, String dono, Double saldo, Double taxaInteresse) {
		super(numero, dono, saldo);
		this.taxaInteresse = taxaInteresse;
	}

	public Double getTaxaInteresse() {
		return taxaInteresse;
	}

	public void setTaxaInteresse(Double taxaInteresse) {
		this.taxaInteresse = taxaInteresse;
	}
	
	public void atualizaSaldo() {
		saldo += saldo*taxaInteresse;
	}
	
	@Override //Fa?a uma copia entao, metodo que prevalece se for chamado esta classe
	public void saque(double valor) {
		saldo -= valor;
	}

}
