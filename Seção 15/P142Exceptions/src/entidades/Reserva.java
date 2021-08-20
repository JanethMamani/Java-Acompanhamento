package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
	
	public Reserva(Integer numeroQuarto, Date entrada, Date saida) {
		this.numeroQuarto = numeroQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}
	
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public Date getEntrada() {
		return entrada;
	}
	public Date getSaida() {
		return saida;
	}
	
	public long duracao() {
		long dif = saida.getTime() - entrada.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	public String atualizarDatas(Date entrada, Date saida) {
		Date agora = new Date();
		if (entrada.before(agora) || saida.before(agora)) {
			return "As datas devem ser futuras";
		}
		if(!saida.after(entrada)) {
			return "A data de saida deve ser depois da entrada";
		} 
		this.entrada = entrada;
		this.saida = saida;
		return null;
	}
	@Override
	public String toString() {
		return "Quarto "
				+ numeroQuarto
				+ ", Entrada: "
				+ formato.format(entrada)
				+ ", Saída: "
				+ formato.format(saida)
				+ ", "
				+ duracao()
				+ " noites.";
	}
}
