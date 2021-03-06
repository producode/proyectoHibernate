package lautaro.prueba.conexion;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GuardaClientePrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		
		Session miSession=miFactory.openSession();
		
		try {
			Cliente cliente1= new Cliente("Josue", "Garcia", "Maria jose");
			
			miSession.beginTransaction();
			
			miSession.save(cliente1);
			
			miSession.getTransaction().commit();
			
			System.out.println("Registro insertado correctamente en BBDD");
			
			//Lectura de registro
			miSession.beginTransaction();
			
			System.out.println("Lectura de registro con ID: " + cliente1.getId());
			
			Cliente clienteInsertado = miSession.get(Cliente.class, cliente1.getId());
			
			System.out.println("Registro: " + clienteInsertado);
			
			miSession.getTransaction().commit();
			
			System.out.println("Terminado");
			
			miSession.close();
		}finally {
			miFactory.close();
		}

	}

}
