package uni;

import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("TRANSFERENCIA")
public abstract class Transferencia extends Operacion {

	@ManyToOne
	private Cuenta cuentaReceptora;
	
	// ----------------- Getters & Setters -----------------

	public Cuenta getCuentaDestino() {
		return cuentaReceptora;
	}

	public void setCuentaDestino(Cuenta cuentaDestino) {
		this.cuentaReceptora = cuentaDestino;
	}
	
	// ----------------- HashCode & Equals -----------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cuentaReceptora);
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
		return Objects.equals(cuentaReceptora, other.cuentaReceptora);
	}

	@Override
	public String toString() {
		return "Transferencia [cuenta_destino=" + cuentaReceptora + "]";
	}

}
