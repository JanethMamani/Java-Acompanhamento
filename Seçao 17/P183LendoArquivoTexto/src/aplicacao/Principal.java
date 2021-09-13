package aplicacao;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		
		File arquivo = new File("TestFile.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(arquivo);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		finally {
			if(sc != null) {
				sc.close();
			}
		}
	}

}
//O arquivo est[a na pasta de projeto 