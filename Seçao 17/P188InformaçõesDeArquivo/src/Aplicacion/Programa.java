package Aplicacion;

import java.io.File;
import java.util.Scanner;

public class Programa {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Entre com o caminho da pasta: ");
		String strCaminho = sc.nextLine();
		
		File caminho = new File(strCaminho);
		
		System.out.println("Qual o Nome: " + caminho.getName());
		System.out.println("Qual caminho? " + caminho.getParent());
		System.out.println("Qual caminho completo? " + caminho.getPath());
		
		
		sc.close();
	}

}
