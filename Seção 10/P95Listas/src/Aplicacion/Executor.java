package Aplicacion;

import java.util.ArrayList;
import java.util.List;

public class Executor {
	
	public static void main(String[] args) {
		
		List<String> hunters = new ArrayList<>();
		
		hunters.add("X");
		hunters.add("Zero");
		hunters.add("Axl");
		hunters.add("Iris");
		hunters.add(3,"Alia");
		
		for (String nome: hunters) {
			System.out.println(nome);
		}
		
		System.out.println(hunters.size());
	}
	

}
