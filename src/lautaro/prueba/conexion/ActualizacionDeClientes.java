package lautaro.prueba.conexion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ActualizacionDeClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		
		Session miSession=miFactory.openSession();
		
		try {
			
			int ClienteId=3;
			
			miSession.beginTransaction();
			
			Cliente miCliente=miSession.get(Cliente.class, ClienteId);
			
			miCliente.setNombre("Lautaro Nahuel");
			
			miSession.getTransaction().commit();
			
			System.out.println("Registro actualizado correctamente en BBDD");
			
			miSession.close();
		}finally {
			miFactory.close();
		}

	}

}
