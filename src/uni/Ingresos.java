package uni;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public abstract class Ingresos extends Operacion {

	@ManyToOne
	private Oficina oficina;

	// ----------------- Getters & Setters -----------------

	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

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
