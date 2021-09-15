package Modelo.Entidades;

import java.util.Date;

public class AluguelCarro {
	
	private Date inicio;
	private Date fim;
	
	private Veiculo carro;
	private Fatura fatura;
	public AluguelCarro(Date inicio, Date fim, Veiculo carro) {
		this.inicio = inicio;
		this.fim = fim;
		this.carro = carro;
	}
	public Date getInicio() {
		return inicio;
	}
	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}
	public Date getFim() {
		return fim;
	}
	public void setFim(Date fim) {
		this.fim = fim;
	}
	public Veiculo getCarro() {
		return carro;
	}
	public void setCarro(Veiculo carro) {
		this.carro = carro;
	}
	public Fatura getFatura() {
		return fatura;
	}
	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}

}
