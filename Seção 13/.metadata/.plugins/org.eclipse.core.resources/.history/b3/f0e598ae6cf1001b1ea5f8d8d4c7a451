package Entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Enumeradores.WorkerLevel;

public class Trabalhador {
	
	private String nome;
	private WorkerLevel nivel;
	private Double salarioBase;
	
	private Departamento depart;
	private List<HorasContrato> listaDEcontratos = new ArrayList<>();
	
	
	
	
	public Trabalhador(String nome, WorkerLevel nivel, Double salarioBase, Departamento depart) {
		
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.depart = depart;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public WorkerLevel getNivel() {
		return nivel;
	}
	public void setNivel(WorkerLevel nivel) {
		this.nivel = nivel;
	}
	public Double getSalarioBase() {
		return salarioBase;
	}
	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}
	public Departamento getDepart() {
		return depart;
	}
	public void setDepart(Departamento depart) {
		this.depart = depart;
	}
	public List<HorasContrato> getContratos() {
		return listaDEcontratos;
	}
//_______________________________________________
	
	
	public void adicionarContrato(HorasContrato contrato) {
		listaDEcontratos.add(contrato);
	}
	
	public void removerContrato(HorasContrato contrato) {
		listaDEcontratos.remove(contrato);
	}
	
	public double ganho(int ano, int mes) {
		double soma = salarioBase;
		Calendar calendario = Calendar.getInstance();
		
		for(HorasContrato con : listaDEcontratos) {
			calendario.setTime(con.getData());
			int contrato_ano = calendario.get(Calendar.YEAR);
			int contrato_mes = 1 + calendario.get(Calendar.MONTH);
			if(ano == contrato_ano && mes == contrato_mes) {
				soma += con.totalValor();
			}
		}
		return soma;
	}

}
