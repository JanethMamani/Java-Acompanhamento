package Aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Principal {
	
	public static void main(String[] args) {
		
		String caminho = "votacao.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			
			Map<String, Integer> candidatos = new HashMap<>();
			
			String linha = br.readLine();
			while(linha != null) {
				String[] dados = linha.split(",");
				String candidato = dados[0];
				Integer votos = Integer.parseInt(dados[1]);
				
				if (candidatos.containsKey(candidato)) {
					Integer votosTotal = candidatos.get(candidato) + votos;
					candidatos.put(candidato, votosTotal);
				} else {
					candidatos.put(candidato, votos);
				}
				linha = br.readLine();
			}
			for(String lider : candidatos.keySet()) {
				System.out.println(lider + ": " + candidatos.get(lider));
			}
			
		}catch(IOException excep) {
			System.out.println("Erro: " + excep.getMessage());
		}
		
	}

}
