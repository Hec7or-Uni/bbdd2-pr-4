<<<<<<< HEAD
package uni;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

public class Test {
	EntityManagerFactory entityManagerFactory = 
			Persistence.createEntityManagerFactory("UnidadPersistenciaPractica4");
	EntityManager em = entityManagerFactory.createEntityManager();
	
	public void poblate() {
		
		// ------------------------------
		// CLIENTES
		// ------------------------------
		
		Cliente c1 = new Cliente();
		c1.setDni("88184985G");
		c1.setNombre("Rance");
		c1.setApellido("Bedle");
		c1.setEmail("rbedle0@bravesites.com");
		c1.setTelefono("+34 935-332-576");
		c1.setDireccion("8230 Elmside Center");
		c1.setEdad(51);
		c1.setFechaNacimiento("12-06-1971");
		
		Cliente c2 = new Cliente();
		c2.setDni("35757133A");
		c2.setNombre("Emanuele");
		c2.setApellido("Dawnay");
		c2.setEmail("edawnay1@is.gd");
		c2.setTelefono("+34 408-600-663");
		c2.setDireccion("3 Spohn Alley");
		c2.setEdad(45);
		c2.setFechaNacimiento("15-08-1977");
		
		Cliente c3 = new Cliente();
		c3.setDni("41147501H");
		c3.setNombre("Juliana");
		c3.setApellido("Wickmann");
		c3.setEmail("jwickmann2@goo.ne.jp");
		c3.setTelefono("+34 363-821-663");
		c3.setDireccion("52 Paget Center");
		c3.setEdad(43);
		c3.setFechaNacimiento("09-11-1979");
		
		Cliente c4 = new Cliente();
		c4.setDni("66887091Q");
		c4.setNombre("Antoine");
		c4.setApellido("Raiment");
		c4.setEmail("araiment4@exblog.jp");
		c4.setTelefono("+34 056-558-309");
		c4.setDireccion("85780 Clyde Gallagher Avenue");
		c4.setEdad(42);
		c4.setFechaNacimiento("30-08-1980");
		
        Set<Cliente> pack_clientes_1 = new HashSet<Cliente>();
        pack_clientes_1.addAll(Arrays.asList(new Cliente[] { c1 }));
        
        Set<Cliente> pack_clientes_2 = new HashSet<Cliente>();
        pack_clientes_2.addAll(Arrays.asList(new Cliente[] { c2 }));
        
        Set<Cliente> pack_clientes_3 = new HashSet<Cliente>();
        pack_clientes_3.addAll(Arrays.asList(new Cliente[] { c3 }));
        
        Set<Cliente> pack_clientes_4 = new HashSet<Cliente>();
        pack_clientes_4.addAll(Arrays.asList(new Cliente[] { c1, c3, c4 }));
		
		// ------------------------------
		// OFICINAS
		// ------------------------------
		
		Oficina o1 = new Oficina();
		o1.setCodigo(245);
		o1.setDireccion("7 Anhalt Place");
		o1.setTelefono("+34 202-141-948");
		
		
		Oficina o2 = new Oficina();
		o2.setCodigo(250);
		o2.setDireccion("8 Anhalt Place");
		o2.setTelefono("+34 202-141-949");
		
		// ------------------------------
		// CUENTAS
		// ------------------------------
		
		Corriente cu1 = new Corriente();
		cu1.setFechaCreacion("1989-11-11T14:24:42Z");
		cu1.setIban("CH50 5682 234S RJST SUTP Z");
		cu1.setSaldo(145826.21);
		cu1.setOficina(o1);	// <--- 
		cu1.setClientes(pack_clientes_1);	// <--- SET
		
		Corriente cu2 = new Corriente();
		cu2.setFechaCreacion("2004-06-17T16:45:02Z");
		cu2.setIban("FO20 5755 0074 4797 91");
		cu2.setSaldo(98271.15);
		cu2.setOficina(o1);	// <--- 
		cu2.setClientes(pack_clientes_4);	// <--- SET
		
		Ahorro cu3 = new Ahorro();
		cu3.setFechaCreacion("1964-06-13T06:44:46Z");
		cu3.setIban("GB82 NGSO 1349 7644 9432 24");
		cu3.setSaldo(295971.51);
		cu3.setInteres(0.444);
		cu3.setClientes(pack_clientes_3);	// <--- SET
		
		Ahorro cu4 = new Ahorro();
		cu4.setFechaCreacion("1965-10-08T02:24:54Z");
		cu4.setIban("FI74 9078 9407 6036 45");
		cu4.setSaldo(134630.38);
		cu4.setInteres(0.203);
		cu4.setClientes(pack_clientes_2);	// <--- SET
		
		Corriente cu5 = new Corriente();
		cu5.setFechaCreacion("1986-01-13T16:05:19Z");
		cu5.setIban("BH55 XYLN 0PSK PCO0 FNEP ZT");
		cu5.setSaldo(272926.64);
		cu5.setOficina(o2);	// <--- 
		cu5.setClientes(pack_clientes_4);	// <--- SET
		
		Corriente cu6 = new Corriente();
		cu6.setFechaCreacion("1974-08-12T18:19:19Z");
		cu6.setIban("BE31 2205 7718 0279");
		cu6.setSaldo(273225.80);
		cu6.setOficina(o2);	// <--- 
		cu6.setClientes(pack_clientes_1);	// <--- SET
		
		Set<Corriente> pack_cuentas_1 = new HashSet<Corriente>();
		pack_cuentas_1.addAll(Arrays.asList(new Corriente[] { cu1, cu2 }));
        
        Set<Corriente> pack_cuentas_2 = new HashSet<Corriente>();
        pack_cuentas_2.addAll(Arrays.asList(new Corriente[] { cu5, cu6 }));
		
		// ------------------------------
		
		o1.setCuentasCorrientes(pack_cuentas_1);	// <--- SET
		o2.setCuentasCorrientes(pack_cuentas_2);	// <--- SET
		
		EntityTransaction trans = em.getTransaction();
		trans.begin();
		try {
			em.persist(c1);
			em.persist(c2);
			em.persist(c3);
			em.persist(c4);
			
			em.persist(o1);
			em.persist(o2);
			
			em.persist(cu1);
			em.persist(cu2);
			em.persist(cu3);
			em.persist(cu4);
						
			trans.commit();
		} catch (PersistenceException e) {
			if (trans.isActive()) {
				trans.rollback();
			}
		}
	}
		
	public void query1() {
		String q = "select c.nombre from Cliente c";
		Query query = em.createQuery(q);
		List<String> res = query.getResultList();
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.poblate();
		t.query1();
	}
	

}
=======
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
>>>>>>> d3af92194bdf593ee205f52c0fe032b7b9286f1a
