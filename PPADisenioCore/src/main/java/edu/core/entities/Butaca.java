package edu.core.entities;

public class Butaca {
	
	private int numero;
	private Fila fila;
	private int	idButaca;
	
	public int getIdButaca() {
		return idButaca;
	}

	public void setIdButaca(int idButaca) {
		this.idButaca = idButaca;
	}

	public Butaca(){
		
	}
	
	public Butaca(int numero) {
		this.numero = numero;
	}

	public Fila getFila() {
		return fila;
	}

	public void setFila(Fila fila) {
		this.fila = fila;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

}
