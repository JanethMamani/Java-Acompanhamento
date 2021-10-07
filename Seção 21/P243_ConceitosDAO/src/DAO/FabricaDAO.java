package DAO;

import DAO.Implementa.VendedorDAO_JDBC;
import Db.DB;

public class FabricaDAO {
	
	public static VendedorDAO criarVendedorDAO() {
		return new VendedorDAO_JDBC(DB.getConnection());
	}

}
