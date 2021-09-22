package Aplicacao;

import Entidades.Cliente;

public class Programa {
	
	public static void main(String[] args) {
		
		Cliente cliente1 = new Cliente("X", "x@gmail.com");
		Cliente cliente2 = new Cliente("Zero", "zero@gmail.com");
		
		System.out.println(cliente1.hashCode());
		System.out.println(cliente2.hashCode());
		System.out.println(cliente1.equals(cliente2));
		
		String test1 = new String("Sem trato especial");
		String test2 = new String("Sem trato especial");
		
		String test3 = "Com trato especial";
		String test4 = "Com trato especial";
		
		System.out.println(test1 == test2);
		System.out.println(test3 == test4);
	}

}
