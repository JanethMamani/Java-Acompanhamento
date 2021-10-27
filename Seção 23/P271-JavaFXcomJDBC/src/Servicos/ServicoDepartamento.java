package Servicos;

import java.util.List;

import ConceitoDAO.DepartamentoDAO;
import ConceitoDAO.FabricaDAO;
import Entidades.Departamento;

public class ServicoDepartamento {
	
	private DepartamentoDAO dao = FabricaDAO.criarDepartamentoDAO();
	
	public List<Departamento> findAll(){
		return dao.findAll();
	}

}
