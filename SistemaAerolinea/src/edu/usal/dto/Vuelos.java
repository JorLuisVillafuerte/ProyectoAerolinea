package edu.usal.dto;

import java.sql.Timestamp;
import java.util.Date;

public class Vuelos {
	private Integer idVuelos;
	private String numVuelo;
	private int cantAsientos;
	private Aeropuerto aerSalida;
	private Aeropuerto aerLlegada;
	private Timestamp fechaSalida;
	private Timestamp fechaLlegada;
	private String tiempoVuelo;
	public String getNumVuelo() {
		return numVuelo;
	}
	public void setNumVuelo(String numVuelo) {
		this.numVuelo = numVuelo;
	}
	public Vuelos(Integer idVuelos, String numVuelo, int cantAsientos, Aeropuerto aerSalida, Aeropuerto aerLlegada,
			Timestamp fechaSalida, Timestamp fechaLlegada, String tiempoVuelo) {
		super();
		this.idVuelos = idVuelos;
		this.numVuelo = numVuelo;
		this.cantAsientos = cantAsientos;
		this.aerSalida = aerSalida;
		this.aerLlegada = aerLlegada;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.tiempoVuelo = tiempoVuelo;
	}
	public Integer getIdVuelos() {
		return idVuelos;
	}
	public void setIdVuelos(Integer idVuelos) {
		this.idVuelos = idVuelos;
	}
	public int getCantAsientos() {
		return cantAsientos;
	}
	public void setCantAsientos(int cantAsientos) {
		this.cantAsientos = cantAsientos;
	}
	public Aeropuerto getAerSalida() {
		return aerSalida;
	}
	public void setAerSalida(Aeropuerto aerSalida) {
		this.aerSalida = aerSalida;
	}
	public Aeropuerto getAerLlegada() {
		return aerLlegada;
	}
	public void setAerLlegada(Aeropuerto aerLlegada) {
		this.aerLlegada = aerLlegada;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Timestamp fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Date getFechaLlegada() {
		return fechaLlegada;
	}
	public void setFechaLlegada(Timestamp fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}
	public String getTiempoVuelo() {
		return tiempoVuelo;
	}
	public void setTiempoVuelo(String tiempoVuelo) {
		this.tiempoVuelo = tiempoVuelo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aerLlegada == null) ? 0 : aerLlegada.hashCode());
		result = prime * result + ((aerSalida == null) ? 0 : aerSalida.hashCode());
		result = prime * result + cantAsientos;
		result = prime * result + ((fechaLlegada == null) ? 0 : fechaLlegada.hashCode());
		result = prime * result + ((fechaSalida == null) ? 0 : fechaSalida.hashCode());
		result = prime * result + ((idVuelos == null) ? 0 : idVuelos.hashCode());
		result = prime * result + ((numVuelo == null) ? 0 : numVuelo.hashCode());
		result = prime * result + ((tiempoVuelo == null) ? 0 : tiempoVuelo.hashCode());
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
		Vuelos other = (Vuelos) obj;
		if (aerLlegada == null) {
			if (other.aerLlegada != null)
				return false;
		} else if (!aerLlegada.equals(other.aerLlegada))
			return false;
		if (aerSalida == null) {
			if (other.aerSalida != null)
				return false;
		} else if (!aerSalida.equals(other.aerSalida))
			return false;
		if (cantAsientos != other.cantAsientos)
			return false;
		if (fechaLlegada == null) {
			if (other.fechaLlegada != null)
				return false;
		} else if (!fechaLlegada.equals(other.fechaLlegada))
			return false;
		if (fechaSalida == null) {
			if (other.fechaSalida != null)
				return false;
		} else if (!fechaSalida.equals(other.fechaSalida))
			return false;
		if (idVuelos == null) {
			if (other.idVuelos != null)
				return false;
		} else if (!idVuelos.equals(other.idVuelos))
			return false;
		if (numVuelo == null) {
			if (other.numVuelo != null)
				return false;
		} else if (!numVuelo.equals(other.numVuelo))
			return false;
		if (tiempoVuelo == null) {
			if (other.tiempoVuelo != null)
				return false;
		} else if (!tiempoVuelo.equals(other.tiempoVuelo))
			return false;
		return true;
	}
	
}
