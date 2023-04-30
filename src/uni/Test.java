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

		Cliente c1 = new Cliente();
		c1.setDni("88184985G");
		c1.setNombre("Rance");
		c1.setApellido("Bedle");
		c1.setEmail("rbedle0@bravesites.com");
		c1.setTelefono("+34 935-332-576");
		c1.setDireccion("8230 Elmside Center");
		c1.setEdad(51);
		c1.setFechaNacimiento("12-06-1971");

	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.prueba();
	}
	

}
