package Entidades;

import java.util.Date;

public class Contrato {
	
	private int numero;
	private Date data;
	private Double valor;
	
	public Contrato(int numero, Date data, Double valor) {
		this.numero = numero;
		this.data = data;
		this.valor = valor;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
