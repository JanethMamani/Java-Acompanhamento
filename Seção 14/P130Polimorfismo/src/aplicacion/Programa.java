package aplicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Funcionario;
import entidades.Terceirizado;

public class Programa {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> funcionarios = new ArrayList<>();
		
		System.out.print("Entre com o número de funcionarios: ");
		int number = sc.nextInt();
		
		for (int i=1; i<=number; i++) {
			System.out.println("Dados do funcionário #" + i + ":");
			System.out.print("Terceirizado (s/n)? ");
			char letra = sc.next().charAt(0);
			System.out.print("Nome: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Horas: ");
			int horas = sc.nextInt();
			System.out.print("Valor por hora: ");
			double valorHora = sc.nextDouble();
			
			if (letra == 's') {
				System.out.print("Despesa adicional: ");
				double gastoAdicional = sc.nextDouble();
				Funcionario desconheco = new Terceirizado(nome, horas, valorHora, gastoAdicional);
				funcionarios.add(desconheco);
			} else {
				funcionarios.add(new Funcionario(nome, horas, valorHora));
			}
			//Se colocar aqui a lista imprime toda hora no fim de cada funcionario
			}
		System.out.println();
		System.out.println("Pagamentos:");
		for (Funcionario persona: funcionarios) {
			System.out.println(persona.getNome() + " - $ " + String.format("%.2f", persona.pagamento()));
		}
		
		sc.close();

	}

}
