package uni;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Oficina {

	@Id
	@Column(name = "CODIGO")
	private Integer codigo;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
	@Column(name = "DIRECCION")
	private String direccion;

	@OneToMany(mappedBy = "oficina")
	private Set<Corriente> cuentasCorrientes;

	// ----------------- Getters & Setters -----------------

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<Corriente> getCuentasCorrientes() {
		return cuentasCorrientes;
	}

	public void setCuentasCorrientes(Set<Corriente> cuentasCorrientes) {
		this.cuentasCorrientes = cuentasCorrientes;
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
