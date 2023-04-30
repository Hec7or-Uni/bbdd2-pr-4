package uni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

public class Test {
	EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("UnidadPersistenciaPractica4");
	// EntityManager em = entityManagerFactory.createEntityManager();
	
	public void prueba() {

		/*
		Cliente c1 = new Cliente();
		c1.setApellido("Perez");
		*/

	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.prueba();
	}
	

}
