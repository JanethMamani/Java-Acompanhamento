package Servicos;

import java.util.ArrayList;
import java.util.List;

import Entidades.Departamento;

public class ServicoDepartamento {
	
	public List<Departamento> findAll(){
		List<Departamento> departamentos = new ArrayList<>();
		departamentos.add(new Departamento(1, "Livros"));
		departamentos.add(new Departamento(2, "Computadores"));
		departamentos.add(new Departamento(3, "Eletrônicos"));
		return departamentos;
	}

}
