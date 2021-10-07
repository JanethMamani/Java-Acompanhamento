package DAO;

import java.util.List;

import Entidades.Vendedor;

public interface VendedorDAO {
	
	void insert(Vendedor pessoa);
	void update(Vendedor pessoa);
	void deleteById(Integer id);
	Vendedor findById(Integer id);
	List<Vendedor> findAll();

}
