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
	@Column(name = "DNI")
	private String dni;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "APELLIDO")
	private String apellido;

	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "TELEFONO")
	private String telefono;
	
	@Column(name = "FECHA_NACIMIENTO")
	private String fechaNacimiento;

	@Column(name = "DIRECCION")
	private String direccion;

	@Column(name = "EDAD")
	private int edad;

	@ManyToMany
	@JoinTable(name = "Tienen",
			joinColumns = @JoinColumn(name = "DNI"),
			inverseJoinColumns = @JoinColumn(name = "IBAN"))
	private Set<Cuenta> cuentas;
	
//	@ManyToMany(cascade = {CascadeType.PERSIST})
//	private Set<Cuenta> cuentas = new HashSet<Cuenta>();

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

	public void addCuenta(Cuenta c) {
		cuentas.add(c);
	}
	
	public int totalCuentas() {
		return cuentas.size();
	}
	
	public void removeCuenta(Cuenta c) {
		cuentas.remove(c);
	}
	
	// ----------------- HashCode & Equals -----------------

	@Override
	public int hashCode() {
		return Objects.hash(apellido, cuentas, direccion, dni, edad, email, fechaNacimiento, nombre, telefono);
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
		return Objects.equals(apellido, other.apellido) && Objects.equals(cuentas, other.cuentas)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(dni, other.dni) && edad == other.edad
				&& Objects.equals(email, other.email) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion
				+ ", edad=" + edad + ", cuentas=" + cuentas + "]";
	}

}
