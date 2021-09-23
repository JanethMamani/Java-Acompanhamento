package Aplicacao;

import java.util.Map;
import java.util.TreeMap;

public class ProgramaGeral {
	
	public static void main(String[] args) {
		
		Map<String, String> cookies = new TreeMap<>();//Ordem alfabetica
		
		cookies.put("Hunter", "X");
		cookies.put("Weapon", "Buster");
		cookies.put("Rank" , "B");
		cookies.put("Anterior", "C");
		
		cookies.remove("Anterior");
		cookies.put("Rank", "S");
		
		System.out.println("Nos cookies:");
		for (String detalhe : cookies.keySet()) {
			System.out.println(detalhe + ": " + cookies.get(detalhe));
		}
		
		System.out.println("Tamanho: " + cookies.size());
		System.out.println("Contem Weapon principal? " + cookies.containsKey("Weapon"));
	}

}
