package Aplicacion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Programa {
	
	public static void main(String[] args) {
		
		//String[] nomes = new String[] {"X", "Zero", "Axl"};
		String[] nomes = new String[] {"Iris"};
		
		String caminho = "Hunters.txt";
		//Retire o parametro true se quiser apena criar o arquivo o recrair
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminho, true))){
			for(String linha : nomes) {
				bw.write(linha);
				bw.newLine();
			}
		}
		catch (IOException excep) {
			excep.printStackTrace();
		}
		
	}

}
