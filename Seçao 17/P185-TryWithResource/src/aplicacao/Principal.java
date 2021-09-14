package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
	
	public static void main(String[] args) {
		String caminho = "TestFile.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))){
			String linha = br.readLine();
			
			while(linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
		}
		catch (IOException excep) {
			System.out.println("Erro: " + excep.getMessage());
		}
		
	}

}

