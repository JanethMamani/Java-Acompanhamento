package aplicacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Reserva;

public class Executor {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.print("Numero do quarto: ");
		int numero = sc.nextInt();
		System.out.print("Data de entrada (dd/MM/yyyy): ");
		Date entrada = formato.parse(sc.next());
		System.out.print("Data de saida (dd/MM/yyyy): ");
		Date saida = formato.parse(sc.next());
		
		if (!saida.after(entrada)) {
			System.out.println("Erro em fazer a reserva: A data de saida de ser depois da de entrada");
		}
		else {
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("Reseva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com a data de atualização da reserva:");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			entrada = formato.parse(sc.next());
			System.out.print("Datade saída (dd/MM/yyyy): ");
			saida = formato.parse(sc.next());
			
			Date agora = new Date();
			if (entrada.before(agora) || saida.before(agora)) {
				System.out.println("Erro em realizar a reseva: as datas devem ser futuras.");
			}
			else if(!saida.after(entrada)) {
				System.out.println("Erro em realizar reservas: a data de saida deve ser depois da entrada");
			} 
			else {
				reserva.atualizarDatas(entrada, saida);
				System.out.println("Reserva: " + reserva);
			}
		}
		
		sc.close();

	}

}
