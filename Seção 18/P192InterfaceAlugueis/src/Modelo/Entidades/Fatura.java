package Modelo.Entidades;

public class Fatura {
	
	private Double pagamentoBasico;
	private Double taxa;
	
	public Fatura() {
		
	}
	
	public Fatura(Double pagBasico, Double tax) {
		pagamentoBasico = pagBasico;
		taxa = tax;
	}

	public Double getPagamentoBasico() {
		return pagamentoBasico;
	}

	public void setPagamentoBasico(Double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
	
	public Double getPagamentoTotal() {
		return getPagamentoBasico() + getTaxa();
	}

}
