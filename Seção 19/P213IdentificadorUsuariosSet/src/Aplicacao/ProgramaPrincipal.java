package Aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import Entidades.EntradaLog;

public class ProgramaPrincipal {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Entre com o caminho do arquivo: ");
		String caminho = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			
			Set<EntradaLog> usuarios = new HashSet<>();
			String linha = br.readLine();
			while (linha != null) {
				String[] campos = linha.split(" ");
				String username = campos[0];
				Date momento = Date.from(Instant.parse(campos[1]));
				
				usuarios.add(new EntradaLog(username, momento));
				linha = br.readLine();
			}
			System.out.println("Total de usuários: " + usuarios.size());
			
		}catch (IOException excep) {
			System.out.println("Erro: " + excep.getMessage());
		}
		sc.close();
	}

}
