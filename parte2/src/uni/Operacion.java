package uni;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "OPERACIONES")
@DiscriminatorColumn(name="tipoOp", 
discriminatorType = DiscriminatorType.STRING)
public abstract class Operacion {

	@Id
	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "cantidad")
	private Double cantidad;
	
	@Column(name = "timestamp")
	private Timestamp fechaYHora;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@ManyToOne
	private Cuenta cuentaEmisora;
	
	// ----------------- Getters & Setters -----------------

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFechaCreacion() {
		return descripcion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.descripcion = fechaCreacion;
	}

	public Timestamp getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(Timestamp fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	public Cuenta getCuentaOrigen() {
		return cuentaEmisora;
	}

	public void setCuentaOrigen(Cuenta cuentaOrigen) {
		this.cuentaEmisora = cuentaOrigen;
	}
	
	// ----------------- HashCode & Equals -----------------

	@Override
	public int hashCode() {
		return Objects.hash(cantidad, codigo, cuentaEmisora, descripcion, fechaYHora);
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
				&& Objects.equals(cuentaEmisora, other.cuentaEmisora)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(fechaYHora, other.fechaYHora);
	}

	@Override
	public String toString() {
		return "Operacion [codigo=" + codigo + ", fechaCreacion=" + descripcion + ", fechaYHora=" + fechaYHora
				+ ", cantidad=" + cantidad + ", cuentaOrigen=" + cuentaEmisora + "]";
	}
	
}
