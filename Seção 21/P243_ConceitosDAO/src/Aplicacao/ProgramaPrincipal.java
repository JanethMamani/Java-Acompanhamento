package Aplicacao;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import DAO.FabricaDAO;
import DAO.VendedorDAO;
import Entidades.Departamento;
import Entidades.Vendedor;

public class ProgramaPrincipal {
	
	public static void main(String[] args) {
		
		VendedorDAO vendDAO = FabricaDAO.criarVendedorDAO();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("====Vendedor encontrado por ID====");
		Vendedor mercador = vendDAO.findById(3);
		
		System.out.println(mercador);
		
		System.out.println("====Vendedor encontrado por ID de Departamento====");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> vendedores = vendDAO.findByDepartment(departamento);
		for(Vendedor vend : vendedores) {
			System.out.println(vend);
		}
		
		System.out.println("===Vendedor ordenado pelo findAll===");
		vendedores = vendDAO.findAll();
		for(Vendedor merc : vendedores) {
			System.out.println(merc);
		}
		
		System.out.println("===Vendedor função Insert===");
		Vendedor novato = new Vendedor(null, "Aria", "aria@gmail.com", new Date(), 4000.0, departamento);
		vendDAO.insert(novato);
		System.out.println("Inserido! Novo id = " + novato.getId());
		
		System.out.println("===Vendedor função update===");
		mercador = vendDAO.findById(1);
		mercador.setNome("Anzu Mazaki");
		vendDAO.update(mercador);
		System.out.println("Update completo");
		
		System.out.println("===Vendedor função delete====");
		System.out.print("Digite o id: ");
		int id = sc.nextInt();
		vendDAO.deleteById(id);
		System.out.println("Delete Completo!");
		
		sc.close();
	}

}
