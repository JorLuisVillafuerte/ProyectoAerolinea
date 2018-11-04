package edu.usal.dto;

public class Telefono {
	private Integer idTelefono;
	private String numeroPersonal;
	private String numeroCelular;
	private String numeroLaboral;
	public Integer getIdTelefono() {
		return idTelefono;
	}
	public void setIdTelefono(Integer idTelefono) {
		this.idTelefono = idTelefono;
	}
	public String getNumeroPersonal() {
		return numeroPersonal;
	}
	public void setNumeroPersonal(String numeroPersonal) {
		this.numeroPersonal = numeroPersonal;
	}
	public String getNumeroCelular() {
		return numeroCelular;
	}
	public void setNumeroCelular(String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	public String getNumeroLaboral() {
		return numeroLaboral;
	}
	public void setNumeroLaboral(String numeroLaboral) {
		this.numeroLaboral = numeroLaboral;
	}
	public Telefono(Integer idTelefono, String numeroPersonal, String numeroCelular, String numeroLaboral) {
		super();
		this.idTelefono = idTelefono;
		this.numeroPersonal = numeroPersonal;
		this.numeroCelular = numeroCelular;
		this.numeroLaboral = numeroLaboral;
	}
	
	public Telefono(String numeroPersonal, String numeroCelular, String numeroLaboral) {
		super();
		this.numeroPersonal = numeroPersonal;
		this.numeroCelular = numeroCelular;
		this.numeroLaboral = numeroLaboral;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTelefono == null) ? 0 : idTelefono.hashCode());
		result = prime * result + ((numeroCelular == null) ? 0 : numeroCelular.hashCode());
		result = prime * result + ((numeroLaboral == null) ? 0 : numeroLaboral.hashCode());
		result = prime * result + ((numeroPersonal == null) ? 0 : numeroPersonal.hashCode());
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
		Telefono other = (Telefono) obj;
		if (idTelefono == null) {
			if (other.idTelefono != null)
				return false;
		} else if (!idTelefono.equals(other.idTelefono))
			return false;
		if (numeroCelular == null) {
			if (other.numeroCelular != null)
				return false;
		} else if (!numeroCelular.equals(other.numeroCelular))
			return false;
		if (numeroLaboral == null) {
			if (other.numeroLaboral != null)
				return false;
		} else if (!numeroLaboral.equals(other.numeroLaboral))
			return false;
		if (numeroPersonal == null) {
			if (other.numeroPersonal != null)
				return false;
		} else if (!numeroPersonal.equals(other.numeroPersonal))
			return false;
		return true;
	}

}