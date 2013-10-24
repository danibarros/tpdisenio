package edu.core.entities;

public class AsignacionPuntoVenta {

	private int AsignacioId;
	private Festival festival;
	private PuntoDeVenta puntoVenta;
	
	public int getAsignacioId() {
		return AsignacioId;
	}
	public void setAsignacioId(int asignacioId) {
		AsignacioId = asignacioId;
	}
	public Festival getFestival() {
		return festival;
	}
	public void setFestival(Festival festival) {
		this.festival = festival;
	}
	public PuntoDeVenta getPuntoVenta() {
		return puntoVenta;
	}
	public void setPuntoVenta(PuntoDeVenta puntoVenta) {
		this.puntoVenta = puntoVenta;
	}
	
}
