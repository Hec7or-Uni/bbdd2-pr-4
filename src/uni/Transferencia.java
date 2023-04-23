package uni;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public abstract class Transferencia extends Operacion {

	@ManyToOne
	private Cuenta cuenta;

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
