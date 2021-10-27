package ConceitoDAO;

import DB.DB;
import ImplementacaoDAO.DepartamentoDAO_JDBC;
import ImplementacaoDAO.VendedorDAO_JDBC;

public class FabricaDAO {
	
	public static VendedorDAO criarVendedorDAO() {
		return new VendedorDAO_JDBC(DB.getConnection());
	}
	
	public static DepartamentoDAO criarDepartamentoDAO() {
		return new DepartamentoDAO_JDBC(DB.getConnection());
	}

}