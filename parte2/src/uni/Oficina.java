package uni;

import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="OFICINAS")
public class Oficina {

	@Id
	@Column(name = "codigo")
	private Integer codigo;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "direccion")
	private String direccion;

	@OneToMany(mappedBy = "oficina", cascade = CascadeType.ALL.ALL)
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
		return Objects.hash(codigo, cuentasCorrientes, direccion, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Oficina other = (Oficina) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(cuentasCorrientes, other.cuentasCorrientes)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Oficina [codigo=" + codigo + ", telefono=" + telefono + ", direccion=" + direccion
				+ ", cuentasCorrientes=" + cuentasCorrientes + "]";
	}
}
