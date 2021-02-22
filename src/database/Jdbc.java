package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	public static void main(String[] args) {

		Connection conexion = null;
		Statement sentenciaSQL = null;
		ResultSet resultado = null;

		try {
			Class.forName("org.postgresql.Driver");
			
		   String url = "jdbc:postgresql://localhost:5432/postgres";
			conexion = DriverManager.getConnection(url, "postgres", "santi");
			
			sentenciaSQL = conexion.createStatement(resultado.TYPE_SCROLL_SENSITIVE, resultado.CONCUR_READ_ONLY);
			
			String sqlString = "select * from contacto";
			resultado = sentenciaSQL.executeQuery(sqlString);
			
			while (resultado.next()) {
				System.out.println(resultado.getString("nombre"));
				System.out.println(resultado.getString("email"));
			}
			
			System.out.println("---------------------");
			
			while(resultado.previous()) {
				System.out.println(resultado.getString("nombre"));
				System.out.println(resultado.getString("email"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

}
