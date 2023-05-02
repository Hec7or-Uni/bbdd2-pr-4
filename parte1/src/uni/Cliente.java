package uni;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Cliente {

	@Id
	@Column
	private String dni;
	
	@Column
	private String nombre;
	
	@Column
	private String apellido;

	@Column
	private String email;
	
	@Column
	private String telefono;
	
	@Column
	private String fechaNacimiento;

	@Column
	private String direccion;

	@Column
	private int edad;
	
	@ManyToMany(mappedBy = "clientes", cascade = {CascadeType.ALL})
	private Set<Cuenta> cuentas = new HashSet<Cuenta>();

	// ----------------- Getters & Setters -----------------

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void addCuenta(Cuenta a) {
		cuentas.add(a);
	}
	
	public int totalCuenta() {
		return cuentas.size();
	}
	
	public void removeCuenta(Cuenta a) {
		cuentas.remove(a);
	}
	
	// ----------------- HashCode & Equals -----------------

	@Override
	public int hashCode() {
		return Objects.hash(apellido, direccion, dni, edad, email, fechaNacimiento, nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(apellido, other.apellido)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(dni, other.dni) && edad == other.edad
				&& Objects.equals(email, other.email) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion
				+ ", edad=" + edad + "]";
	}

}
