package uni;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public abstract class Transferencia extends Operacion {

	@ManyToOne
	private Cuenta cuentaDestino;
	
	// ----------------- Getters & Setters -----------------

	public Cuenta getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(Cuenta cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	
	// ----------------- HashCode & Equals -----------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cuentaDestino);
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
		return Objects.equals(cuentaDestino, other.cuentaDestino);
	}

	@Override
	public String toString() {
		return "Transferencia [cuenta_destino=" + cuentaDestino + "]";
	}

}
