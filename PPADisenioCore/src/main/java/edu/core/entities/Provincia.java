package edu.core.entities;

public class Provincia {
	private Long idProvincia ;
	private String nombre ;
	private Pais pais;

	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Long getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
