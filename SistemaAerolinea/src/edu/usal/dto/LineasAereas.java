package edu.usal.dto;

import java.util.List;

public class LineasAereas {
	
	private Integer idLineasAereas;
	private String nombreAero;
	private String alianza;
	
	
	public String getNombreAero() {
		return nombreAero;
	}

	public Integer getIdLineasAereas() {
		return idLineasAereas;
	}
	

	public LineasAereas(Integer idLineasAereas, String nombreAero, String alianza) {
		super();
		this.idLineasAereas = idLineasAereas;
		this.nombreAero = nombreAero;
		this.alianza = alianza;
	
	
	}
	
	

	public String getAlianza() {
		return alianza;
	}

	public void setAlianza(String alianza) {
		this.alianza = alianza;
	}

	public void setIdLineasAereas(Integer idLineasAereas) {
		this.idLineasAereas = idLineasAereas;
	}

	public void setNombreAero(String nombreAero) {
		this.nombreAero = nombreAero;
	}
	public void getLineasAereas(Integer idLineasAereas) {
		this.idLineasAereas = idLineasAereas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alianza == null) ? 0 : alianza.hashCode());
		result = prime * result + ((idLineasAereas == null) ? 0 : idLineasAereas.hashCode());
		result = prime * result + ((nombreAero == null) ? 0 : nombreAero.hashCode());
		
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
		LineasAereas other = (LineasAereas) obj;
		if (alianza == null) {
			if (other.alianza != null)
				return false;
		} else if (!alianza.equals(other.alianza))
			return false;
		if (idLineasAereas == null) {
			if (other.idLineasAereas != null)
				return false;
		} else if (!idLineasAereas.equals(other.idLineasAereas))
			return false;
		if (nombreAero == null) {
			if (other.nombreAero != null)
				return false;
		} else if (!nombreAero.equals(other.nombreAero))
			return false;
		return true;
	}
	
	
	
}
