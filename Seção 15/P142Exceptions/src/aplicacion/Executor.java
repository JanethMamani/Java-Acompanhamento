package aplicacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entidades.Reserva;
import excecoes.ExceptionDominio;

public class Executor {

	public static void main(String[] args){
		
		try {
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
			
			System.out.print("Numero do quarto: ");
			int numero = sc.nextInt();
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			Date entrada = formato.parse(sc.next());
			System.out.print("Data de saida (dd/MM/yyyy): ");
			Date saida = formato.parse(sc.next());
			Reserva reserva = new Reserva(numero, entrada, saida);
			System.out.println("Reseva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com a data de atualização da reserva:");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			entrada = formato.parse(sc.next());
			System.out.print("Data de saída (dd/MM/yyyy): ");
			saida = formato.parse(sc.next());
			
			reserva.atualizarDatas(entrada, saida);
			System.out.println("Reserva: "+ reserva);
			
			sc.close();
		}
		catch (ParseException naoData) {
			System.out.println("Formato de data invalido.");
		}
		catch (ExceptionDominio antData){
			System.out.println("Erro na reserva: " + antData.getMessage());
		}
		catch(RuntimeException caracter){
			System.out.println("Atenção no caracter digitado! Deu erro!");
		}

	}

}
