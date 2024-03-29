package uni;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public abstract class Retirada extends Operacion {

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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(oficina);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Retirada other = (Retirada) obj;
		return Objects.equals(oficina, other.oficina);
	}

	@Override
	public String toString() {
		return "Retirada [oficina=" + oficina + "]";
	}

}
