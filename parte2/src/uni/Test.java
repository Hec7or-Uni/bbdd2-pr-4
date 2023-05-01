package uni;

import java.sql.Timestamp;
import java.time.Instant;
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
		Instant i= Instant.now();
		c1.setFechaNacimiento(Date.from(i));
		
		Cliente c2 = new Cliente();
		c2.setDni("35757133A");
		c2.setNombre("Emanuele");
		c2.setApellido("Dawnay");
		c2.setEmail("edawnay1@is.gd");
		c2.setTelefono("+34 408-600-663");
		c2.setDireccion("3 Spohn Alley");
		c2.setEdad(45);
		i = Instant.now();
		c2.setFechaNacimiento(Date.from(i));
		
		Cliente c3 = new Cliente();
		c3.setDni("41147501H");
		c3.setNombre("Juliana");
		c3.setApellido("Wickmann");
		c3.setEmail("jwickmann2@goo.ne.jp");
		c3.setTelefono("+34 363-821-663");
		c3.setDireccion("52 Paget Center");
		c3.setEdad(43);
		i = Instant.now();
		c3.setFechaNacimiento(Date.from(i));
		
		Cliente c4 = new Cliente();
		c4.setDni("66887091Q");
		c4.setNombre("Antoine");
		c4.setApellido("Raiment");
		c4.setEmail("araiment4@exblog.jp");
		c4.setTelefono("+34 056-558-309");
		c4.setDireccion("85780 Clyde Gallagher Avenue");
		c4.setEdad(42);
		i = Instant.now();
		c4.setFechaNacimiento(Date.from(i));
		
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
		i = Instant.now();
		cu1.setFechaCreacion(Timestamp.from(i));
		cu1.setIban("CH50 5682 234S RJST SUTP Z");
		cu1.setSaldo(145826.21);
		cu1.setOficina(o1);	// <--- 
		cu1.setInteres(null);
		//cu1.addCliente(c1);	// <--- SET
		
		Corriente cu2 = new Corriente();
		i = Instant.now();
		cu2.setFechaCreacion(Timestamp.from(i));
		cu2.setIban("FO20 5755 0074 4797 91");
		cu2.setSaldo(98271.15);
		cu2.setOficina(o1);	// <--- 
		/*
		cu2.addCliente(c1);	// <--- SET
		cu2.addCliente(c3);
		cu2.addCliente(c4);
		*/
		
		Ahorro cu3 = new Ahorro();
		i = Instant.now();
		cu3.setFechaCreacion(Timestamp.from(i));
		cu3.setIban("GB82 NGSO 1349 7644 9432 24");
		cu3.setSaldo(295971.51);
		cu3.setInteres(0.444);
		//cu3.addCliente(c3);	// <--- SET
		
		Ahorro cu4 = new Ahorro();
		i = Instant.now();
		cu4.setFechaCreacion(Timestamp.from(i));
		cu4.setIban("FI74 9078 9407 6036 45");
		cu4.setSaldo(134630.38);
		cu4.setInteres(0.203);
		//cu4.addCliente(c2);	// <--- SET
		
		Corriente cu5 = new Corriente();
		i = Instant.now();
		cu5.setFechaCreacion(Timestamp.from(i));
		cu5.setIban("BH55 XYLN 0PSK PCO0 FNEP ZT");
		cu5.setSaldo(272926.64);
		cu5.setOficina(o2);	// <--- 
		/*
		cu5.addCliente(c1);	// <--- SET
		cu5.addCliente(c3);
		cu5.addCliente(c4);
		*/
		
		Corriente cu6 = new Corriente();
		i = Instant.now();
		cu6.setFechaCreacion(Timestamp.from(i));
		cu6.setIban("BE31 2205 7718 0279");
		cu6.setSaldo(273225.80);
		cu6.setOficina(o2);	// <--- 
		//cu6.addCliente(c1);	// <--- SET
		
		Set<Corriente> pack_cuentas_1 = new HashSet<Corriente>();
		pack_cuentas_1.addAll(Arrays.asList(new Corriente[] { cu1, cu2 }));
        
		Set<Corriente> pack_cuentas_2 = new HashSet<Corriente>();
		pack_cuentas_2.addAll(Arrays.asList(new Corriente[] { cu5, cu6 }));
		
		// ------------------------------
		
		/*
		o1.addCuentaCorriente(cu1);
		o1.addCuentaCorriente(cu2);
		o2.addCuentaCorriente(cu5);
		o2.addCuentaCorriente(cu6);
		*/
		
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
		String q = "select c from Cliente c";
		Query query = em.createQuery(q);
		List<String> res = query.getResultList();
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.poblate();
		//t.query1();
	}

}