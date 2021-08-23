package Entidades;

import Excecao.ExceptionValor;

public class Conta {
	
	private Integer numero;
	private String nome;
	private Double saldo;
	private Double limiteSaque;
	
	public Conta() {
		
	}

	public Conta(Integer numero, String nome, Double saldo, Double limiteSaque) {
		this.numero = numero;
		this.nome = nome;
		this.saldo = saldo;
		this.limiteSaque = limiteSaque;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSaldo() {
		return saldo;
	}

	public Double getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(Double limiteSaque) {
		this.limiteSaque = limiteSaque;
	}
	
	
	public Double saque(Double valor) {
		if(valor >saldo) {
			throw new ExceptionValor("Saldo insuficiente.");
		} else if (valor > limiteSaque) {
			throw new ExceptionValor("O valor não pode ultrapassar o limite de saque: " + String.format("%.2f", getLimiteSaque()));
		}
		return saldo=-valor;
	}
	

}
