package edu.ventas.entities;

public class Entrada {
	private Butaca butaca;
	private long codigoDeBarra;
	private Festival festival;
	private Noche noche;
	private int numeroDeEntrada;
	public Butaca getButaca() {
		return butaca;
	}
	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
	}
	public long getCodigoDeBarra() {
		return codigoDeBarra;
	}
	public void setCodigoDeBarra(long codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}
	public Festival getFestival() {
		return festival;
	}
	public void setFestival(Festival festival) {
		this.festival = festival;
	}
	public Noche getNoche() {
		return noche;
	}
	public void setNoche(Noche noche) {
		this.noche = noche;
	}
	public int getNumeroDeEntrada() {
		return numeroDeEntrada;
	}
	public void setNumeroDeEntrada(int numeroDeEntrada) {
		this.numeroDeEntrada = numeroDeEntrada;
	}

}
