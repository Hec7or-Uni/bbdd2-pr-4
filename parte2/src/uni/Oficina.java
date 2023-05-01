package uni;

import java.util.Objects;
import java.util.Set;
import java.util.HashSet;

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

	/*
	@OneToMany(mappedBy = "oficina", cascade = CascadeType.ALL.ALL)
	private Set<Corriente> cuentasCorrientes = new HashSet<Corriente> ();
	*/
	
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

	/*
	public void addCuentaCorriente(Corriente t) {
		cuentasCorrientes.add(t);
	}
	
	public int totalCuentasCorrientes() {
		return cuentasCorrientes.size();
	}

	public void removeCuentaCorriente(Corriente t) {
		cuentasCorrientes.remove(t);
	}
	*/
	
	// ----------------- HashCode & Equals -----------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
			Oficina other = (Oficina) obj;
			if (codigo == null) {
				if (other.codigo != null)
					return false;
			} else if (!codigo.equals(other.codigo))
				return false;
			/*
			if (cuentasCorrientes == null) {
				if (other.cuentasCorrientes != null)
					return false;
			} else if (!cuentasCorrientes.equals(other.cuentasCorrientes))
				return false;
			*/
			if (direccion == null) {
				if (other.direccion != null)
					return false;
			} else if (!direccion.equals(other.direccion))
				return false;
			if (telefono == null) {
				if (other.telefono != null)
					return false;
			} else if (!telefono.equals(other.telefono))
				return false;
		return true;
	}

	@Override
	public String toString() {
		return "Oficina [codigo=" + codigo + ", telefono=" + telefono + ", direccion=" + direccion + "]";
				//+ ", cuentasCorrientes=" + cuentasCorrientes + "]";
	}
}
