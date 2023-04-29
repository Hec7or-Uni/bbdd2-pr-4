package uni;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public abstract class Transferencia extends Operacion {

	@ManyToOne
	private Cuenta cuenta;

	// ----------------- Getters & Setters -----------------
	
	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	// ----------------- HashCode & Equals -----------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cuenta);
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
		Transferencia other = (Transferencia) obj;
		return Objects.equals(cuenta, other.cuenta);
	}

	@Override
	public String toString() {
		return "Transferencia [cuenta=" + cuenta + "]";
	}

}
