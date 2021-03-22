package lautaro.prueba.conexion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EliminacionDeClientes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		
		Session miSession=miFactory.openSession();
		
		try {
			miSession.beginTransaction();
			
			miSession.createQuery("delete Cliente where direccion='maria jose'").executeUpdate();
			
			miSession.getTransaction().commit();
			
			System.out.println("Registro eliminado correctamente en BBDD");
			
			miSession.close();
		}finally {
			miFactory.close();
		}

	}

}
