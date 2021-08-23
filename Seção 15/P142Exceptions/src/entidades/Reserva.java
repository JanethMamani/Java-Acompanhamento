package entidades;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import excecoes.ExceptionDominio;

public class Reserva {
	
	private Integer numeroQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
	
	public Reserva(Integer numeroQuarto, Date entrada, Date saida){
		if(!saida.after(entrada)) {
			throw new ExceptionDominio("A data de saida deve ser depois da entrada");
		} 
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
	public void atualizarDatas(Date entrada, Date saida){
		Date agora = new Date();
		if (entrada.before(agora) || saida.before(agora)) {
			throw new ExceptionDominio("As datas devem ser futuras");
		}
		if(!saida.after(entrada)) {
			throw new ExceptionDominio("A data de saida deve ser depois da entrada");
		} 
		this.entrada = entrada;
		this.saida = saida;
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
