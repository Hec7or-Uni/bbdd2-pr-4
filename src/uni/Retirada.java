package uni;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public abstract class Retirada extends Operacion {

	@ManyToOne
	private Oficina oficina;

	// ----------------- Getters & Setters -----------------
	
	// ----------------- HashCode & Equals -----------------

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

	public String toString() {
		return "";
	}

}
