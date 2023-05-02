package uni;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="AHORRO")
@DiscriminatorValue("AHORRO")
public class Ahorro extends Cuenta {

	@Column(name="interes", nullable=false)
	private Double interes;
	
	// ----------------- Getters & Setters -----------------

	public Double getInteres() {
		return interes;
	}

	public void setInteres(Double interes) {
		this.interes = interes;
	}
	
	// ----------------- HashCode & Equals -----------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(interes);
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
		Ahorro other = (Ahorro) obj;
		return Objects.equals(interes, other.interes);
	}

	@Override
	public String toString() {
		return "Ahorro [interes=" + interes + "]";
	}

}
