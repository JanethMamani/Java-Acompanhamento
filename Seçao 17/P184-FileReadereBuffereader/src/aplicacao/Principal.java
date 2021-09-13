package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {
	
	public static void main(String[] args) {
		String caminho = "TestFile.txt";
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(caminho);
			br = new BufferedReader(fr);
			
			String linha = br.readLine();
			
			while(linha != null) {
				System.out.println(linha);
				linha = br.readLine();
			}
		}
		catch (IOException excep) {
			System.out.println("Erro: " + excep.getMessage());
		}
		finally {//Isso é didatico
			try {
				if(br != null) {
					br.close();
				}
				if(fr != null) {
					fr.close();
				}
			}
			catch (IOException excep) {
				excep.printStackTrace();
			}
		}
	}

}

