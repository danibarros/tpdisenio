package edu.ventas.entities;

public class Provincia {
	private int idProvincia ;
	private Pais  Pais ;
	private String nombre ;
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public Pais getPais() {
		return Pais;
	}
	public void setPais(Pais pais) {
		Pais = pais;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
