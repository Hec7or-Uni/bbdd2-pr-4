package uni;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public abstract class Cuenta {

	@Id
	@Column
	private String iban;
	
	@Column
	private String fechaCreacion;
	
	@Column
	private Double saldo;
	
	@ManyToMany(cascade = {CascadeType.PERSIST})
	private Set<Cliente> clientes = new HashSet<Cliente>();

	@OneToMany(mappedBy = "cuentaOrigen")
    private Set<Operacion> operaciones;
	
	// ----------------- Getters & Setters -----------------

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public void addCliente(Cliente a) {
		clientes.add(a);
	}
	
	public int totalAsignaturas() {
		return clientes.size();
	}
	
	public void removeAsignatura(Cliente a) {
		clientes.remove(a);
	}

	public Set<Operacion> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(Set<Operacion> operaciones) {
		this.operaciones = operaciones;
	}
	
	// ----------------- HashCode & Equals -----------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (clientes == null) {
			if (other.clientes != null)
				return false;
		} else if (!clientes.equals(other.clientes))
			return false;
		if (fechaCreacion == null) {
			if (other.fechaCreacion != null)
				return false;
		} else if (!fechaCreacion.equals(other.fechaCreacion))
			return false;
		if (iban == null) {
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		if (operaciones == null) {
			if (other.operaciones != null)
				return false;
		} else if (!operaciones.equals(other.operaciones))
			return false;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cuenta [iban=" + iban + ", fechaCreacion=" + fechaCreacion + ", saldo=" + saldo + ", clientes="
				+ clientes + ", operaciones=" + operaciones + "]";
	}

}
