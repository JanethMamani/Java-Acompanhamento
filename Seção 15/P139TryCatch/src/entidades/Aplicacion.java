package entidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aplicacion {
	
	public static void main(String[] args) {
		
		Metodo1();
		
		System.out.println("Fim do programa!");
		
	}
	
	public static void Metodo1() {
		System.out.println("***METODO1 START***");
		
		Metodo2();
		
		System.out.println("***METODO1 FINAL***");
	}
	
	public static void Metodo2() {
		System.out.println("***METOOD2 START***");
		
		Scanner sc = new Scanner(System.in);
		
		try {
			String[] nomes = sc.nextLine().split(" ");
			int posicao = sc.nextInt();
			System.out.println(nomes[posicao]);
		}
		catch (ArrayIndexOutOfBoundsException limites) {
			System.out.println("Posição inválida!");
		}
		catch (InputMismatchException entradaErro) {
			System.out.println("Entrada invalida!");
			entradaErro.printStackTrace();
		}
		finally {
			System.out.println("Finally executado");
		}
		sc.close();
		
		System.out.println("***METOOD2 FINAL***");
	}

}
