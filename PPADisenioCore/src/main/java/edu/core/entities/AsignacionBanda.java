package edu.core.entities;

public class AsignacionBanda {

	private int idAsignacion;
	private Noche noche;
	private Banda banda;
	private int orden;
	
	public int getIdAsignacion() {
		return idAsignacion;
	}
	public void setIdAsignacion(int idAsignacion) {
		this.idAsignacion = idAsignacion;
	}
	public Noche getNoche() {
		return noche;
	}
	public void setNoche(Noche noche) {
		this.noche = noche;
	}
	public Banda getBanda() {
		return banda;
	}
	public void setBanda(Banda banda) {
		this.banda = banda;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int orden) {
		this.orden = orden;
	}
	
}
