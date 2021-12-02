package Utilitarios;

import java.util.Calendar;
import java.util.Date;

public class DataUtilid {
	
	public static Date adicionarDias(Date data, int dias) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(data);
		calendario.add(Calendar.DAY_OF_MONTH, dias);
		return calendario.getTime();
	}
	
	public static Date obterDataComDiferenciaDias(int dias) {
		return adicionarDias(new Date(), dias);
	}
	
	public static Date obterData(int dia, int mes, int ano) {
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.DAY_OF_MONTH, dia);
		calendario.set(Calendar.MONTH, mes - 1);
		calendario.set(Calendar.YEAR, ano);
		return calendario.getTime();
	}
	
	public static boolean isMesmaData(Date data1, Date data2) {
		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(data1);
		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(data2);
		return (calendar1.get(Calendar.DAY_OF_MONTH) == calendar2.get(Calendar.DAY_OF_MONTH))
				&& (calendar1.get(Calendar.MONTH) == calendar2.get(Calendar.MONTH))
				&& (calendar1.get(Calendar.YEAR) == calendar2.get(Calendar.YEAR));
	}
	
	public static boolean verificarDiaSemana(Date data, int diaSemana) {
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(data);
		return calendario.get(Calendar.DAY_OF_WEEK) == diaSemana;
	}

}
