package Aplicacao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Db.DB;

public class Programa {
	
	public static void main(String[] args) {
		
		//Recursos externos abertos
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = DB.getConnection();
			
			st = con.createStatement();
			
			rs = st.executeQuery("select * from department");
			
			while(rs.next()) {
				System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
			}
		} catch(SQLException excep) {
			excep.printStackTrace();
		}
		//Fechar recursos
		finally {
			DB.fecharResultSet(rs);
			DB.fecharStatement(st);
			DB.closeConnection();
		}
	}

}
