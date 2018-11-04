package edu.usal.dto;

import java.util.Date;

public class Ventas {
	
	private Integer idVentas;
	private Cliente cliente;
	private Vuelos vuelo;
	private LineasAereas aerolinea;
	private Date fechaVenta;
	private String formaPago;
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Ventas(Integer idVentas, Cliente cliente, Vuelos vuelo, LineasAereas aerolinea, Date fechaVenta,
			String formaPago) {
		super();
		this.idVentas = idVentas;
		this.cliente = cliente;
		this.vuelo = vuelo;
		this.aerolinea = aerolinea;
		this.fechaVenta = fechaVenta;
		this.formaPago = formaPago;
	}
	public Integer getIdVentas() {
		return idVentas;
	}
	public void setIdVentas(Integer idVentas) {
		this.idVentas = idVentas;
	}
	public Vuelos getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelos vuelo) {
		this.vuelo = vuelo;
	}
	public LineasAereas getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(LineasAereas aerolinea) {
		this.aerolinea = aerolinea;
	}
	public Date getFechaVenta() {
		return fechaVenta;
	}
	public void setFechaVenta(Date fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aerolinea == null) ? 0 : aerolinea.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((fechaVenta == null) ? 0 : fechaVenta.hashCode());
		result = prime * result + ((formaPago == null) ? 0 : formaPago.hashCode());
		result = prime * result + ((idVentas == null) ? 0 : idVentas.hashCode());
		result = prime * result + ((vuelo == null) ? 0 : vuelo.hashCode());
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
		Ventas other = (Ventas) obj;
		if (aerolinea == null) {
			if (other.aerolinea != null)
				return false;
		} else if (!aerolinea.equals(other.aerolinea))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (fechaVenta == null) {
			if (other.fechaVenta != null)
				return false;
		} else if (!fechaVenta.equals(other.fechaVenta))
			return false;
		if (formaPago == null) {
			if (other.formaPago != null)
				return false;
		} else if (!formaPago.equals(other.formaPago))
			return false;
		if (idVentas == null) {
			if (other.idVentas != null)
				return false;
		} else if (!idVentas.equals(other.idVentas))
			return false;
		if (vuelo == null) {
			if (other.vuelo != null)
				return false;
		} else if (!vuelo.equals(other.vuelo))
			return false;
		return true;
	}
	
	
	
}
