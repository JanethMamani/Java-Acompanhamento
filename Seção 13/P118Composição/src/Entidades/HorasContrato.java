package Entidades;

import java.util.Date;

public class HorasContrato {
	
	private Date data;
	private Double valorHora;
	private Integer horas;
	
	public HorasContrato(Date enterData, Double enterValorHora, Integer enterHoras) {
		data = enterData;
		valorHora = enterValorHora;
		horas = enterHoras;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setValor(Double valor) {
		valorHora = valor;
	}
	
	public Double getValor() {
		return valorHora;
	}
	
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	
	public Integer getHoras() {
		return horas;
	}
	
	
	public Double totalValor() {
		return valorHora * horas;
	}

}
