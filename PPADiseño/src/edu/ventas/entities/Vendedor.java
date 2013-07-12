package edu.ventas.entities;

import java.util.Map;

public class Vendedor {

	public boolean vender(String nombre, int edad, Butaca butaca, Fila fila,
			Sector sector, Festival festival, Noche noche,
			Map<Integer, Integer> listaCategorias) {

		if (butaca.isDisponible() == true) {

			System.out.println("butaca disponible");

			int numeroEntrada = this.generarCodigo();

			Entrada entrada = new Entrada(numeroEntrada, butaca, fila, sector,
					123123, festival, noche, listaCategorias);
			butaca.setDisponible(false);

			double precioFinal = this.realizarDescuento(edad, entrada);

			System.out.println(entrada.getNumeroDeEntrada() + ", "
					+ entrada.getCodigoDeBarra() + ", " + precioFinal);

			return true;
		} else {

			System.out.println("butaca no disponible");
			return false;
		}

	}

	private double realizarDescuento(int edad, Entrada entrada) {
		if (edad < 18 & entrada.calcularPrecioBase() > 100) {
			return entrada.getPrecio() * 0.8;

		} else if (edad < 18 & entrada.calcularPrecioBase() > 50
				& entrada.calcularPrecioBase() < 100) {
			return entrada.getPrecio() - 10;

		} else if (edad > 65) {
			return entrada.getPrecio() * 0.85;

		} else {
			return entrada.getPrecio();
		}

	}

	private int generarCodigo() {
		int numero = (int) Math.floor(Math.random() * (1 - 10000 + 1) + 10000);
		return numero;
	}

}
