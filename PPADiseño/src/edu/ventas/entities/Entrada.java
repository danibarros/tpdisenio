package edu.ventas.entities;

import java.util.Map;

public class Entrada {
	private Butaca butaca;
	
	private long codigoDeBarra;

	private Noche noche;
	
	private int numeroDeEntrada;
	

	public Entrada(int numeroDeEntrada, Butaca butaca, Noche noche) {
		this.numeroDeEntrada = numeroDeEntrada;
		this.butaca = butaca;
		
		this.noche = noche;
		this.codigoDeBarra=123123;
		
	}

	
	public int calcularPrecioBase(){
		return this.noche.precioDeLaNoche();
	}
	
	public int getNuemroDeEntrada(){
		return this.numeroDeEntrada;
	}
	

	public void setButaca(Butaca butaca) {
		this.butaca = butaca;
	}
	
	public Butaca getButaca() {
		return this.butaca;
	}

	public long getCodigoDeBarra() {
		return codigoDeBarra;
	}

	public void setCodigoDeBarra(long codigoDeBarra) {
		this.codigoDeBarra = codigoDeBarra;
	}

	
	public Noche getNoche() {
		return noche;
	}

	public void setNoche(Noche noche) {
		this.noche = noche;
	}

//	public int getNumeroDeEntrada() { Ya esta arriba
//		return numeroDeEntrada;
//	}

	public void setNumeroDeEntrada(int numeroDeEntrada) {
		this.numeroDeEntrada = numeroDeEntrada;
	}

	
}
