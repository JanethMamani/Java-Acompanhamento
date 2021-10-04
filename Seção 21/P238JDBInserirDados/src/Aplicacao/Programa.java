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
		
		//Recursos externos abertos
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection con = null;
		PreparedStatement pt = null;
		try {
			con = DB.getConnection();
			
			pt = con.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			pt.setString(1, "Carl Purple");
			pt.setString(2, "carl@gmail.com");
			pt.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
			pt.setDouble(4, 3000.0);
			pt.setInt(5, 4);
			
			int alteradas = pt.executeUpdate();
			
			if(alteradas > 0) {
				ResultSet rs = pt.getGeneratedKeys();
				while (rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Feito! Id = " + id);
				}
			} else {
				System.out.println("Sem linhas afetafas.");
			}
			
		} catch(SQLException excep) {
			excep.printStackTrace();
		} catch(ParseException erroData) {
			erroData.printStackTrace();
		} finally {
			DB.fecharStatement(pt);
			DB.closeConnection();//Conexão fecha por ultimo
			
		}
	}

}
