package lautaro.prueba.conexion;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConsultaClientes {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Cliente.class).buildSessionFactory();
		
		Session miSession=miFactory.openSession();
		
		try {
			miSession.beginTransaction();
			
			//mostrar todos los clientes
			
			List<Cliente> listaClientes = miSession.createQuery("FROM Cliente").getResultList();
			
			recorreClientesConsultados(listaClientes);
			
			//consulta clientes con apellido rabon
			listaClientes=miSession.createQuery("from Cliente cl where cl.apellido='rabon'").getResultList();
					
			recorreClientesConsultados(listaClientes);
			
			//consulta cliente con apellido gonzalez o que vive en Maria jose
			
			listaClientes=miSession.createQuery("from Cliente cl where cl.apellido='gonzalez'" +
			" or cl.direccion='maria jose'").getResultList();
			
			recorreClientesConsultados(listaClientes);
			
			miSession.getTransaction().commit();
			
			miSession.close();
			
		}finally {
			miFactory.close();
		}
	}

	private static void recorreClientesConsultados(List<Cliente> listaClientes) {
		for (Cliente unCliente:listaClientes) {
			System.out.println(unCliente);
		}
	}

}
