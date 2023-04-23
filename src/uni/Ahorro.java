package uni;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Ahorro extends Cuenta {

	@Column(name = "Interes")
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
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

	public String toString() {
		String res = super.toString();
		res += "Interes: " + interes + System.getProperty("line.separator");
		return res;
	}

}
