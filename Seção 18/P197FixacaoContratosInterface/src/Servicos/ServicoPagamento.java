package Servicos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Entidades.Contrato;

public class ServicoPagamento {
	
	private int quantParcelas;
	
	SimpleDateFormat dias = new SimpleDateFormat("dd/MM/yyyy");
	
	private Contrato contrato;
	
	private TaxaPagamento taxas;

	public ServicoPagamento(int quantParcelas,Contrato contrato, TaxaPagamento taxas) {
		
		this.quantParcelas = quantParcelas;
		this.taxas = taxas;
		this.contrato = contrato;
	}
	
	public void pagamentoTotal() {
		Double parcelas = contrato.getValor() / quantParcelas;
		
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(contrato.getData());
		int mes = 1 + calendario.get(Calendar.MONTH);
		int dia = calendario.get(Calendar.DAY_OF_MONTH);
		int ano = calendario.get(Calendar.YEAR);
		
		System.out.println("Pagamentos: ");
		for (int i=1; i<=quantParcelas; i++) {
			mes = mes + 1;
			System.out.println(dia + "/" + mes + "/" + ano + " - " + String.format("%.2f", taxas.aplicarTaxa(parcelas, i)));
		}
	}

}
