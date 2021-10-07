package Aplicacao;

import java.util.Date;

import DAO.FabricaDAO;
import DAO.VendedorDAO;
import Entidades.Departamento;
import Entidades.Vendedor;

public class ProgramaPrincipal {
	
	public static void main(String[] args) {
		
		VendedorDAO vendDAO = FabricaDAO.criarVendedorDAO();
		
		Vendedor mercador = vendDAO.findById(3);
		
		System.out.println(mercador);
	}

}
