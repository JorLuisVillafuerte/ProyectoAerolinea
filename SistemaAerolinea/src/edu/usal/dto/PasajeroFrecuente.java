package edu.usal.dto;

public class PasajeroFrecuente {
	private Integer idPasajeroFrecuente;
	private String alianza;
	private String aerolinea;
	private String numero;
	private String categoria;
	public String getAlianza() {
		return alianza;
	}
	public void setAlianza(String alianza) {
		this.alianza = alianza;
	}
	public String getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(String aerolinea) {
		this.aerolinea = aerolinea;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public PasajeroFrecuente(Integer idPasajeroFrecuente, String alianza, String aerolinea, String numero,
			String categoria) {
		super();
		this.idPasajeroFrecuente = idPasajeroFrecuente;
		this.alianza = alianza;
		this.aerolinea = aerolinea;
		this.numero = numero;
		this.categoria = categoria;
	}
	public PasajeroFrecuente() {
		super();
	}
	public Integer getIdPasajeroFrecuente() {
		return idPasajeroFrecuente;
	}
	public void setIdPasajeroFrecuente(Integer idPasajeroFrecuente) {
		this.idPasajeroFrecuente = idPasajeroFrecuente;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aerolinea == null) ? 0 : aerolinea.hashCode());
		result = prime * result + ((alianza == null) ? 0 : alianza.hashCode());
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + ((idPasajeroFrecuente == null) ? 0 : idPasajeroFrecuente.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		PasajeroFrecuente other = (PasajeroFrecuente) obj;
		if (aerolinea == null) {
			if (other.aerolinea != null)
				return false;
		} else if (!aerolinea.equals(other.aerolinea))
			return false;
		if (alianza == null) {
			if (other.alianza != null)
				return false;
		} else if (!alianza.equals(other.alianza))
			return false;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (idPasajeroFrecuente == null) {
			if (other.idPasajeroFrecuente != null)
				return false;
		} else if (!idPasajeroFrecuente.equals(other.idPasajeroFrecuente))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
}