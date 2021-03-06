package Aplicacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Executor {
	
	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat dia1 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat dia2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date exemploDia1 = dia1.parse("27/07/2021");
		Date exemploDia2 = dia2.parse("27/07/2021 12:48:09");
		
		System.out.println(dia2.format(exemploDia1));
		System.out.println(exemploDia2);
		
		
		Date atual = new Date();
		System.out.println(atual);
	}

}
