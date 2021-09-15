package Aplicacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Modelo.Entidades.AluguelCarro;
import Modelo.Entidades.Veiculo;
import Modelo.Servicos.ServicoAluguel;
import Modelo.Servicos.TaxaServicoBrasil;

public class ProgramaPrincipal {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Entre com os dados do aluguel: ");
		System.out.print("Modelo do carro: ");
		String modeloCarro = sc.nextLine();
		System.out.print("Inicio (dd/MM/yyyy hh:ss): ");
		Date inicio = sdf.parse(sc.nextLine());
		System.out.print("Fim (dd/MM/yyyy hh:ss): ");
		Date fim = sdf.parse(sc.nextLine());
		
		AluguelCarro carro = new AluguelCarro(inicio,fim, new Veiculo(modeloCarro));
		
		System.out.print("Entre com o preço por hora: ");
		double precoPorHora = sc.nextDouble();
		System.out.print("Entre com o preço por dia: ");
		double precoPorDia = sc.nextDouble();
		
		ServicoAluguel aluguel = new ServicoAluguel(precoPorDia, precoPorHora, new TaxaServicoBrasil());
		
		aluguel.processoFatura(carro);
		
		System.out.println("Fatura: ");
		System.out.println("Pagamento basico: " + String.format("%.2f", carro.getFatura().getPagamentoBasico()));
		System.out.println("Taxa: " + String.format("%.2f", carro.getFatura().getTaxa()));
		System.out.println("Pagamento total: " + String.format("%.2f", carro.getFatura().getPagamentoTotal()));
		
		sc.close();
	}

}
