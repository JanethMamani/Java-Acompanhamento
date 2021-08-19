package Aplicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import Entidades.Circulo;
import Entidades.Forma;
import Entidades.Retangulo;
import Entidades.enums.Cor;

public class Pintor {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Forma> formas = new ArrayList<>();
		
		System.out.print("Entre com o nuemro de formas: ");
		int quant = sc.nextInt();
		
		for(int i=1; i<=quant;i++) {
			System.out.println("Dados da forma #" + i + ":");
			System.out.print("Retangulo ou circulo (r/c)? ");
			char opcao = sc.next().charAt(0);
			System.out.print("Cor(PRETO/AZUL/VERMELHO): ");
			Cor cores = Cor.valueOf(sc.next());
			if(opcao == 'r') {
				System.out.print("Altura: ");
				double altura = sc.nextDouble();
				System.out.println("Largura: ");
				double largura = sc.nextDouble();
				formas.add(new Retangulo(cores, altura, largura));
			} else {
				System.out.print("Raio: ");
				double raio = sc.nextDouble();
				formas.add(new Circulo(cores, raio));
			}
		}
		
		System.out.println();
		System.out.println("Areas das formas:");
		for (Forma figura : formas) {
			System.out.println(String.format("%.2f", figura.area()));
		}
		
		sc.close();

	}

}
