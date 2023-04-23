package uni;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Corriente extends Cuenta {

	@Column(name = "OFICINA")
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
		String res = super.toString();
		res += "Oficina: " + oficina + System.getProperty("line.separator");
		return res;
	}

}
