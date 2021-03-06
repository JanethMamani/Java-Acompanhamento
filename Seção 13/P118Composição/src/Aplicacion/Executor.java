package Aplicacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import Entidades.Departamento;
import Entidades.HorasContrato;
import Entidades.Trabalhador;
import Enumeradores.WorkerLevel;

public class Executor {
	
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat dia = new SimpleDateFormat("dd/mm/yyyy");
		
		System.out.println("Digite o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Digite os dados do trabalhador: ");
		System.out.print("Nome: ");
		String trabalhadorNome = sc.nextLine();
		System.out.print("N?vel: ");
		String trabalhadorNivel = sc.nextLine();
		System.out.print("Sal?rio Base: ");
		double salarioBase = sc.nextDouble();
		Trabalhador pessoa = new Trabalhador(trabalhadorNome, 
											WorkerLevel.valueOf(trabalhadorNivel),
											salarioBase,
											new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos? ");
		int quantidade = sc.nextInt();
		
		for (int i=1; i<=quantidade; i++) {
			System.out.println("Digite os dados do contrato #" + i + ":");
			System.out.print("Data (dd/mm/yyyy): ");
			Date dataContrato = dia.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorHora = sc.nextDouble();
			System.out.print("Dura??o (horas): ");
			int horas = sc.nextInt();
			HorasContrato novoContrato = new HorasContrato(dataContrato,valorHora,horas);
			pessoa.adicionarContrato(novoContrato);
		}
		
		System.out.println();
		System.out.println("Digite o m?s e ano para calcular o total (MM/YYYY): ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0,2));
		int ano = Integer.parseInt(mesAno.substring(3));
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("Departamento: " + pessoa.getDepart().getNome());
		System.out.println("Total: " + String.format("%.2f", pessoa.ganho(ano, mes)));
		
		sc.close();
	}

}
