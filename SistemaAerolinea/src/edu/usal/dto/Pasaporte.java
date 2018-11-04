package edu.usal.dto;

import java.io.Serializable;
import java.sql.Date;

public class Pasaporte implements Serializable{
	
	private static final long serialVersionUID = -1997347584858965258L;
	
	private Integer idPasaporte;
	private String numeroPasaporte;
	private String paisEmision;
	private String autoridadEmision;
	private Date fechaEmision;
	private Date fechaVencimiento;
	
	public String getNumeroPasaporte() {
		return numeroPasaporte;
	}

	public Pasaporte(Integer idPasaporte, String numeroPasaporte, String paisEmision, String autoridadEmision,
			Date fechaEmision, Date fechaVencimiento) {
		super();
		this.idPasaporte = idPasaporte;
		this.numeroPasaporte = numeroPasaporte;
		this.paisEmision = paisEmision;
		this.autoridadEmision = autoridadEmision;
		this.fechaEmision = fechaEmision;
		this.fechaVencimiento = fechaVencimiento;
	}

	public Integer getIdPasaporte() {
		return idPasaporte;
	}

	public void setIdPasaporte(Integer idPasaporte) {
		this.idPasaporte = idPasaporte;
	}

	public String getPaisEmision() {
		return paisEmision;
	}

	public void setPaisEmision(String paisEmision) {
		this.paisEmision = paisEmision;
	}

	public String getAutoridadEmision() {
		return autoridadEmision;
	}

	public void setAutoridadEmision(String autoridadEmision) {
		this.autoridadEmision = autoridadEmision;
	}

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setNumeroPasaporte(String numeroPasaporte) {
		this.numeroPasaporte = numeroPasaporte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autoridadEmision == null) ? 0 : autoridadEmision.hashCode());
		result = prime * result + ((fechaEmision == null) ? 0 : fechaEmision.hashCode());
		result = prime * result + ((fechaVencimiento == null) ? 0 : fechaVencimiento.hashCode());
		result = prime * result + ((idPasaporte == null) ? 0 : idPasaporte.hashCode());
		result = prime * result + ((numeroPasaporte == null) ? 0 : numeroPasaporte.hashCode());
		result = prime * result + ((paisEmision == null) ? 0 : paisEmision.hashCode());
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
		Pasaporte other = (Pasaporte) obj;
		if (autoridadEmision == null) {
			if (other.autoridadEmision != null)
				return false;
		} else if (!autoridadEmision.equals(other.autoridadEmision))
			return false;
		if (fechaEmision == null) {
			if (other.fechaEmision != null)
				return false;
		} else if (!fechaEmision.equals(other.fechaEmision))
			return false;
		if (fechaVencimiento == null) {
			if (other.fechaVencimiento != null)
				return false;
		} else if (!fechaVencimiento.equals(other.fechaVencimiento))
			return false;
		if (idPasaporte == null) {
			if (other.idPasaporte != null)
				return false;
		} else if (!idPasaporte.equals(other.idPasaporte))
			return false;
		if (numeroPasaporte == null) {
			if (other.numeroPasaporte != null)
				return false;
		} else if (!numeroPasaporte.equals(other.numeroPasaporte))
			return false;
		if (paisEmision == null) {
			if (other.paisEmision != null)
				return false;
		} else if (!paisEmision.equals(other.paisEmision))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pasaporte [idPasaporte=" + idPasaporte + ", numeroPasaporte=" + numeroPasaporte + ", paisEmision="
				+ paisEmision + ", autoridadEmision=" + autoridadEmision + ", fechaEmision=" + fechaEmision
				+ ", fechaVencimiento=" + fechaVencimiento + "]";
	}
	
	
	
}
