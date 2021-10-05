package Aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Db.DB;

public class Programa {
	
	public static void main(String[] args) {
		
		Connection con = null;
		
		PreparedStatement pt = null;
		
		try {
			con = DB.getConnection();
			pt = con.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ?)");
			pt.setDouble(1, 200.0);
			pt.setInt(2, 2);
			
			int afetados = pt.executeUpdate();
			System.out.println("Feito! Linhas afetados: " + afetados);
		} catch (SQLException excep) {
			excep.printStackTrace();
		} finally {
			DB.fecharStatement(pt);
			DB.closeConnection();
		}
	}

}
