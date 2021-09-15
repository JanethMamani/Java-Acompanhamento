package Servicos;

import java.text.SimpleDateFormat;

import Entidades.Contrato;

public class ServicoPagamento {
	
	private int quantParcelas;
	
	SimpleDateFormat dias = new SimpleDateFormat("dd/mm/yyyy");
	
	private Contrato contrato;
	
	private TaxaPagamento taxas;

	public ServicoPagamento(int quantParcelas,Contrato contrato, TaxaPagamento taxas) {
		
		this.quantParcelas = quantParcelas;
		this.taxas = taxas;
		this.contrato = contrato;
	}
	
	public void pagamentoTotal() {
		Double parcelas = contrato.getValor() / quantParcelas;
		
		System.out.println("Pagamentos: ");
		for (int i=1; i<=quantParcelas; i++) {
			System.out.println(contrato.getData() + "-" + taxas.aplicarTaxa(parcelas, i));
		}
	}

}
