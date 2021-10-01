package Aplicacao;

import java.sql.Connection;

import Db.DB;

public class Programa {
	
	public static void main(String[] args) {
		
		Connection con = DB.getConnection();
		DB.closeConnection();
	}

}
