package lautaro.prueba.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;

public class PruebasJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbcUrl="jdbc:mysql://localhost:3306/baseSpring?useSSL=false";
		
		String usuario="root";
		
		String contrasenia="";
		
		try {
			System.out.println("Intentando conectar con la BBDD: " + jdbcUrl);
			
			Connection miConexion=DriverManager.getConnection(jdbcUrl, usuario, contrasenia);
			
			System.out.println("Conexion exitosa");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
