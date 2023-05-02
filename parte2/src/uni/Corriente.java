package uni;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="CORRIENTE")
@DiscriminatorValue("CORRIENTE")
public class Corriente extends Cuenta {

	@ManyToOne
	@JoinColumn(name="oficina")
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
		result = prime * result + oficina.hashCode();
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
		Corriente other = (Corriente) obj;
		return Objects.equals(oficina, other.oficina);
	}

	@Override
	public String toString() {
		return "Corriente [oficina=" + oficina + "]";
	}

}
