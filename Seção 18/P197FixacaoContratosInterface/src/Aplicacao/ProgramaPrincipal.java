package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entidades.Contrato;
import Servicos.ServicoPagamento;
import Servicos.TaxaPaypal;

public class ProgramaPrincipal {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat formatinho = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.println("Entre os dados do contrato: ");
		System.out.print("Numero: ");
		int numero = sc.nextInt();
		sc.nextLine();
		System.out.print("Data (dd/mm/yyyy): ");
		Date data = formatinho.parse(sc.nextLine());
		System.out.print("Valor do contrato: ");
		Double valor = sc.nextDouble();
		Contrato seuContrato = new Contrato(numero, data, valor);
		
		System.out.print("Dgite o numero de parcelas: ");
		int quantParcel = sc.nextInt();
		sc.nextLine();
		
		//No parametro eu coloquei a taxa Paypal, que pode ser substituida por outro servico
		ServicoPagamento servico = new ServicoPagamento(quantParcel, seuContrato, new TaxaPaypal());
		
		servico.pagamentoTotal();
		
		sc.close();
	
		}

}
