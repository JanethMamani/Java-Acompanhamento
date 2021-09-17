package Aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Entidade.Funcionario;

public class Programa {
	
	public static void main(String[] args) {
		
		List<Funcionario> nomes = new ArrayList<>();
		String caminho = "TestFile.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			String empregado = br.readLine();
			while (empregado != null) {
				String[] emp = empregado.split(" ");//Podia ser ","
				nomes.add(new Funcionario(emp[0], Double.parseDouble(emp[1])));
				empregado = br.readLine();
			}
			Collections.sort(nomes); //Ordenar nomes em ordem alfabetica
			for (Funcionario item : nomes) {
				System.out.println(item.getNome() + " " + item.getSalario());
			}
		}catch (IOException excep) {
			System.out.println("Erro: " + excep.getMessage());
		}
	}

}
