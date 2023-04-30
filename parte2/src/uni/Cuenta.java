package uni;

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="CUENTAS")
public abstract class Cuenta {

	@Id
	@Column(name = "IBAN")
	private String iban;
	
	@Column(name = "fechaCreacion")
	private String fechaCreacion;
	
	@Column(name = "saldo")
	private Double saldo;

	@ManyToMany(mappedBy = "cuentas")
	private Set<Cliente> clientes;

	@OneToMany(mappedBy = "cuentaEmisora")
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

	public Set<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
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
		return Objects.hash(clientes, fechaCreacion, iban, operaciones, saldo);
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
		return Objects.equals(clientes, other.clientes) && Objects.equals(fechaCreacion, other.fechaCreacion)
				&& Objects.equals(iban, other.iban) && Objects.equals(operaciones, other.operaciones)
				&& Objects.equals(saldo, other.saldo);
	}

	@Override
	public String toString() {
		return "Cuenta [iban=" + iban + ", fechaCreacion=" + fechaCreacion + ", saldo=" + saldo + ", clientes="
				+ clientes + ", operaciones=" + operaciones + "]";
	}

}