package Aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import Db.DB;
import Db.DBExcecaoIntegridade;
import Db.DBException;

public class Programa {
	
	public static void main(String[] args) {
		
		Connection con = null;
		
		Statement st = null;
		
		try {
			con = DB.getConnection();
			
			con.setAutoCommit(false);
			
			st = con.createStatement();
			
			int comando1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");
			
			/*int x = 1;
			if(x < 5) {
				throw new SQLException("Fake error");
			}*/
			
			int comando2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");
			
			con.commit(); //Isso vai confirmar as mudanças
			
			System.out.println("Primeiro comando: " + comando1);
			System.out.println("Segundo comando: " + comando2);
			
		} catch(SQLException excep) {
			try {
				con.rollback();
				throw new DBException("Transação rolled back! Parece que: " + excep.getMessage());
			} catch (SQLException rollError) {
				// TODO Auto-generated catch block
				throw new DBException("Erro ao dar rollback! Possivel causa: " + rollError.getMessage());
			}
		} finally {
			DB.fecharStatement(st);
			DB.closeConnection();
		}
	}

}
