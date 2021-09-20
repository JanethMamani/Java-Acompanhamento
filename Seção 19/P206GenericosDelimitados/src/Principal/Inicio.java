package Principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Servicos.ServicoCalculo;

public class Inicio {
	
	public static void main(String[] args) {
		
		List<Integer> produtos = new ArrayList<>();
		
		String caminho = "TestFile.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))){
			String linha = br.readLine();
			while(linha != null) {
				produtos.add(Integer.parseInt(linha));
				linha = br.readLine();
			}
			
			Integer num = ServicoCalculo.max(produtos);
			System.out.println("Maximo: ");
			System.out.println(num);
		} catch (IOException excep) {
			System.out.println("Erro: " + excep.getMessage());
		}
	}

}
