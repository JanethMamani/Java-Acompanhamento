package Principal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Entidades.Produto;
import Servicos.ServicoCalculo;

public class Inicio {
	
	public static void main(String[] args) {
		
		List<Produto> produtos = new ArrayList<>();
		
		String caminho = "TestFile.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))){
			String linha = br.readLine();
			while(linha != null) {
				String[] campos = linha.split(",");
				produtos.add(new Produto(campos[0], Double.parseDouble(campos[1])));
				linha = br.readLine();
			}
			
			Produto num = ServicoCalculo.max(produtos);
			System.out.println("Maximo: ");
			System.out.println(num);
		} catch (IOException excep) {
			System.out.println("Erro: " + excep.getMessage());
		}
	}

}
