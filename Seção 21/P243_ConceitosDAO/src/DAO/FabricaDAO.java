package DAO;

import DAO.Implementa.VendedorDAO_JDBC;

public class FabricaDAO {
	
	public static VendedorDAO criarVendedorDAO() {
		return new VendedorDAO_JDBC();
	}

}
