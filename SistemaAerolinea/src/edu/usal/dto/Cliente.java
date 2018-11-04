package edu.usal.dto;

import java.sql.Date;

public class Cliente {
	private Integer idCliente;
	private String nombre;
	private String apellido;
	private String dni;
	private Pasaporte pasaporteCliente;
	private String cuit_cuil;
	private Date fechaNac;
	private String email;
	private Telefono telCliente;
	private PasajeroFrecuente pasajeroFrec;
	private Direccion direcCliente;
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Pasaporte getPasaporteCliente() {
		return pasaporteCliente;
	}
	public void setPasaporteCliente(Pasaporte pasaporteCliente) {
		this.pasaporteCliente = pasaporteCliente;
	}
	public String getCuit_cuil() {
		return cuit_cuil;
	}
	public void setCuit_cuil(String cuit_cuil) {
		this.cuit_cuil = cuit_cuil;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Telefono getTelCliente() {
		return telCliente;
	}
	public void setTelCliente(Telefono telCliente) {
		this.telCliente = telCliente;
	}
	public PasajeroFrecuente getPasajeroFrec() {
		return pasajeroFrec;
	}
	public void setPasajeroFrec(PasajeroFrecuente pasajeroFrec) {
		this.pasajeroFrec = pasajeroFrec;
	}
	public Direccion getDirecCliente() {
		return direcCliente;
	}
	public void setDirecCliente(Direccion direcCliente) {
		this.direcCliente = direcCliente;
	}
	public Cliente(Integer idCliente, String nombre, String apellido, String dni, Pasaporte pasaporteCliente,
			String cuit_cuil, Date fechaNac, String email, Telefono telCliente, PasajeroFrecuente pasajeroFrec,
			Direccion direcCliente) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.pasaporteCliente = pasaporteCliente;
		this.cuit_cuil = cuit_cuil;
		this.fechaNac = fechaNac;
		this.email = email;
		this.telCliente = telCliente;
		this.pasajeroFrec = pasajeroFrec;
		this.direcCliente = direcCliente;
	}
	public Cliente() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((cuit_cuil == null) ? 0 : cuit_cuil.hashCode());
		result = prime * result + ((direcCliente == null) ? 0 : direcCliente.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fechaNac == null) ? 0 : fechaNac.hashCode());
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pasajeroFrec == null) ? 0 : pasajeroFrec.hashCode());
		result = prime * result + ((pasaporteCliente == null) ? 0 : pasaporteCliente.hashCode());
		result = prime * result + ((telCliente == null) ? 0 : telCliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (cuit_cuil == null) {
			if (other.cuit_cuil != null)
				return false;
		} else if (!cuit_cuil.equals(other.cuit_cuil))
			return false;
		if (direcCliente == null) {
			if (other.direcCliente != null)
				return false;
		} else if (!direcCliente.equals(other.direcCliente))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fechaNac == null) {
			if (other.fechaNac != null)
				return false;
		} else if (!fechaNac.equals(other.fechaNac))
			return false;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pasajeroFrec == null) {
			if (other.pasajeroFrec != null)
				return false;
		} else if (!pasajeroFrec.equals(other.pasajeroFrec))
			return false;
		if (pasaporteCliente == null) {
			if (other.pasaporteCliente != null)
				return false;
		} else if (!pasaporteCliente.equals(other.pasaporteCliente))
			return false;
		if (telCliente == null) {
			if (other.telCliente != null)
				return false;
		} else if (!telCliente.equals(other.telCliente))
			return false;
		return true;
	}
	
}
