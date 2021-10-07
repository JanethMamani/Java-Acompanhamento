package DAO.Implementa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import DAO.VendedorDAO;
import Db.DB;
import Db.DBException;
import Entidades.Departamento;
import Entidades.Vendedor;

public class VendedorDAO_JDBC implements VendedorDAO{
	
	private Connection con;
	
	public VendedorDAO_JDBC(Connection con) {
		this.con = con;
	}

	@Override
	public void insert(Vendedor pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vendedor pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor findById(Integer id) {
		PreparedStatement pt = null;
		ResultSet rs = null;
		try {
			pt = con.prepareStatement(
					"SELECT seller.*,department.Name as Departamento "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?");
			
			pt.setInt(1, id);
			rs = pt.executeQuery();
			if(rs.next()) {
				Departamento departamento = instanciarDepartamento(rs);
				Vendedor mercador = instanciarVendedor(rs, departamento);
				return mercador;
			}
			return null;
		} catch (SQLException excep) {
			throw new DBException(excep.getMessage());
		} finally {
			DB.fecharStatement(pt);
			DB.fecharResultSet(rs);
		}
	}
	
	private Vendedor instanciarVendedor(ResultSet rs, Departamento depart) throws SQLException {
		Vendedor mercador = new Vendedor();
		mercador.setId(rs.getInt("Id"));
		mercador.setNome(rs.getString("Name"));
		mercador.setEmail(rs.getString("Email"));
		mercador.setSalarioBase(rs.getDouble("BaseSalary"));
		mercador.setNascimento(rs.getDate("BirthDate"));
		mercador.setDepartamentoDoVendedor(depart);
		return mercador;
	}
	
	private Departamento instanciarDepartamento(ResultSet rs) throws SQLException {
		Departamento departamento = new Departamento();
		departamento.setId(rs.getInt("DepartmentId"));
		departamento.setNome(rs.getString("Departamento"));
		return departamento;
	}

	@Override
	public List<Vendedor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
