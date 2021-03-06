package Entidades;

public abstract class Conta {
	
	private Integer numero;
	private String dono;
	protected Double saldo; //Visivel para subclasses
	
	public Conta() {
		
	}//Esse construtor elimina a necessidade de um construtor extra na subclasse business hehe
	
	public Conta(Integer numero, String dono, Double saldo) {
		this.numero = numero;
		this.dono = dono;
		this.saldo = saldo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void saque(double valor) {
		saldo -= valor + 5.0;
	}
	
	public void deposito(double valor) {
		saldo += valor;
	}

}
