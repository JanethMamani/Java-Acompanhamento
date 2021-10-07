package DAO;

import java.util.List;

import Entidades.Departamento;

public interface DepartamentoDAO {
	
	void insert(Departamento departamento);
	void uodate(Departamento departamento);
	void deleteById(Integer id);
	Departamento findById(Integer id);
	List<Departamento> findAll();

}
