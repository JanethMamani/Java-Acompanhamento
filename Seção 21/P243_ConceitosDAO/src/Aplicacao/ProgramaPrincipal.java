package Aplicacao;

import java.util.List;

import DAO.FabricaDAO;
import DAO.VendedorDAO;
import Entidades.Departamento;
import Entidades.Vendedor;

public class ProgramaPrincipal {
	
	public static void main(String[] args) {
		
		VendedorDAO vendDAO = FabricaDAO.criarVendedorDAO();
		
		
		System.out.println("====Vendedor encontrado por ID====");
		Vendedor mercador = vendDAO.findById(3);
		
		System.out.println(mercador);
		
		System.out.println("====Vendedor encontrado por ID de Departamento====");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> vendedores = vendDAO.findByDepartment(departamento);
		for(Vendedor vend : vendedores) {
			System.out.println(vend);
		}
	}

}
