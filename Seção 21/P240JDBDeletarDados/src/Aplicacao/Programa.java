package Aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Db.DB;
import Db.DBExcecaoIntegridade;

public class Programa {
	
	public static void main(String[] args) {
		
		Connection con = null;
		
		PreparedStatement pt = null;
		
		try {
			con = DB.getConnection();
			pt = con.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "Id = ?");
					
			pt.setInt(1, 2);
			
			int afetados = pt.executeUpdate();
			System.out.println("Feito! Linhas afetados: " + afetados);
		} catch (SQLException excep) {
			throw new DBExcecaoIntegridade(excep.getMessage());
		} finally {
			DB.fecharStatement(pt);
			DB.closeConnection();
		}
	}

}
