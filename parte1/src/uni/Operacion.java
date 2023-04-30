package uni;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public abstract class Operacion {

	@Id
	@Column
	private String codigo;
	
	@Column
	private String descripcion;
	
	@Column
	private String fechaYHora;

	@Column
	private Double cantidad;

	@ManyToOne
	private Cuenta cuentaOrigen;
	
	// ----------------- Getters & Setters -----------------

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(String fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Cuenta getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(Cuenta cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}
	
	// ----------------- HashCode & Equals -----------------

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, codigo, cuentaOrigen, descripcion, fechaYHora);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Operacion other = (Operacion) obj;
		return Objects.equals(cantidad, other.cantidad) && Objects.equals(codigo, other.codigo)
				&& Objects.equals(cuentaOrigen, other.cuentaOrigen)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(fechaYHora, other.fechaYHora);
	}

	@Override
	public String toString() {
		return "Operacion [codigo=" + codigo + ", descripcion=" + descripcion + ", fechaYHora=" + fechaYHora
				+ ", cantidad=" + cantidad + ", cuentaOrigen=" + cuentaOrigen + "]";
	}
	
}
