package uni;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public abstract class Operacion {

	@Id
	@Column(name = "CODIGO")
	private String codigo;
	
	@Column(name = "DESCRIPCION")
	private String fechaCreacion;
	
	@Column(name = "FECHA_Y_HORA")
	private String fechaYHora;

	@Column(name = "CANTIDAD")
	private Double cantidad;

	@ManyToOne
	private Cuenta cuenta;
	
	// ----------------- Getters & Setters -----------------

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	// ----------------- HashCode & Equals -----------------

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, codigo, cuenta, fechaCreacion, fechaYHora);
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
				&& Objects.equals(cuenta, other.cuenta) && Objects.equals(fechaCreacion, other.fechaCreacion)
				&& Objects.equals(fechaYHora, other.fechaYHora);
	}

	@Override
	public String toString() {
		return "Operacion [codigo=" + codigo + ", fechaCreacion=" + fechaCreacion + ", fechaYHora=" + fechaYHora
				+ ", cantidad=" + cantidad + ", cuenta=" + cuenta + "]";
	}
	
}
