package uni;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public abstract class Cuenta {

	@Id
	@Column(name = "IBAN")
	private Integer iban;
	
	@Column(name = "FECHA_CREACION")
	private String fechaCreacion;
	
	@Column(name = "SALDO")
	private Double saldo;

	@ManyToMany(mappedBy = "cuentas")
	private Set<Cliente> clientes;

	@OneToMany(mappedBy = "cuenta")
    private Set<Operacion> operaciones;

	// ----------------- Getters & Setters -----------------

	public Integer getIban() {
		return iban;
	}

	public void setIban(Integer iban) {
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
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		return true;
	}

	public String toString() {
		return "";
	}

}
