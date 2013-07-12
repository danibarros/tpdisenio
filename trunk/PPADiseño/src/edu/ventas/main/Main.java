package edu.ventas.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.ventas.entities.Banda;
import edu.ventas.entities.Butaca;
import edu.ventas.entities.Estadio;
import edu.ventas.entities.Festival;
import edu.ventas.entities.Fila;
import edu.ventas.entities.Noche;
import edu.ventas.entities.PuntoDeVenta;
import edu.ventas.entities.Sector;
import edu.ventas.entities.Vendedor;

public class Main {

	public static void main(String[] args) throws ParseException, IOException {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Map<Integer, Integer> listaCategorias = new HashMap<Integer, Integer>();

		listaCategorias.put(1, 0);
		listaCategorias.put(2, 50);
		listaCategorias.put(3, 100);
		listaCategorias.put(4, 200);

		Butaca butaca = new Butaca(true, 1);
		Butaca butaca2 = new Butaca(true, 2);
		Butaca butaca3 = new Butaca(true, 3);
		Butaca butaca4 = new Butaca(true, 4);
		List<Butaca> butacas = new ArrayList<Butaca>();
		List<Butaca> butacas2 = new ArrayList<Butaca>();
		butacas.add(butaca);
		butacas.add(butaca2);
		butacas2.add(butaca3);
		butacas2.add(butaca4);

		Fila fila = new Fila(1, butacas);
		Fila fila2 = new Fila(2, butacas2);
		List<Fila> filas = new ArrayList<Fila>();
		filas.add(fila);
		List<Fila> filas2 = new ArrayList<Fila>();
		filas2.add(fila2);

		Sector sector = new Sector("Sector1", filas, 50, 'A');
		Sector sector2 = new Sector("Sector2", filas2, 25, 'B');
		List<Sector> sectores = new ArrayList<Sector>();
		sectores.add(sector);
		sectores.add(sector2);

		PuntoDeVenta puntoDeVenta = new PuntoDeVenta();
		List<PuntoDeVenta> puntosDeVenta = new ArrayList<PuntoDeVenta>();
		puntosDeVenta.add(puntoDeVenta);

		Banda banda1 = new Banda("las patillas", 1);
		Banda banda2 = new Banda("ntvg", 2);
		Banda banda3 = new Banda("metallica", 4);
		Set<Banda> bandas = new HashSet<Banda>();
		bandas.add(banda1);
		bandas.add(banda2);
		bandas.add(banda3);

		Estadio estadio = new Estadio(sectores, puntosDeVenta);

		Date date;
		String input;
		input = "1818-11-11";
		date = format.parse(input);
		Noche noche1 = new Noche(1, bandas, date);

		List<Noche> noches = new ArrayList<Noche>();
		noches.add(noche1);

		Festival festival = new Festival("River Plate", estadio, noches);

		Vendedor unVendedor = new Vendedor();

		BufferedReader lee = new BufferedReader(
				new InputStreamReader(System.in));
		String apeYNom;
		int edad;
		int numeroDeNoche = 0;
		boolean invalido = true;
		Noche nocheElegida = null;
		char colorSectorElegido = '0';
		int numeroFila = 0;
		int numeroButaca = 0;
		Butaca butacaElegida = null;

		System.out.println("Ingrese su nombre y apellido");
		apeYNom = lee.readLine();

		System.out.println("Ingrese su edad");
		edad = Integer.parseInt(lee.readLine());

		System.out.println("Ingrese numero de noche");
		while (numeroDeNoche == 0 || invalido == true) {

			numeroDeNoche = Integer.parseInt(lee.readLine());
			if (festival.getNoches().size() >= numeroDeNoche) {
				nocheElegida = festival.getNoches().get(numeroDeNoche - 1);
				invalido = false;
			} else {
				invalido = true;
				System.out
						.println("Ingrese una noche existente en el sistema...");
			}

		}

		invalido = true;

		Sector sectorElegido = null;
		System.out.println("Ingrese sector");
		while (colorSectorElegido == '0' || invalido == true) {

			String aux = lee.readLine();
			colorSectorElegido = aux.charAt(0);
			for (Sector sectorRecorrido : estadio.getSectores()) {
				if (sectorRecorrido.getUbicacion() == colorSectorElegido) {
					sectorElegido = sectorRecorrido;
					invalido = false;
					break;
				} else {
					invalido = true;
					System.out
							.println("Ingrese un sector existente en el sistema...");
					break;
				}
			}

		}

		System.out.println("Ingrese numero de fila");
		invalido = true;
		Fila filaElegida = null;
		while (numeroFila == 0 || invalido == true) {

			numeroFila = Integer.parseInt(lee.readLine());
			if (sectorElegido.getFilas().size() >= numeroFila) {
				filaElegida = sectorElegido.getFilas().get(numeroFila - 1);
				invalido = false;
			} else {
				invalido = true;
				System.out
						.println("Ingrese una fila existente en el sistema...");
			}
		}

		System.out.println("Ingrese numero butaca");
		invalido = true;
		while (numeroButaca == 0 || invalido == true) {

			numeroButaca = Integer.parseInt(lee.readLine());
			if (filaElegida.getButacas().size() >= numeroButaca) {
				butacaElegida = filaElegida.getButacas().get(numeroButaca - 1);
				invalido = false;
			} else {
				invalido = true;
				System.out
						.println("Ingrese una butaca existente en el sistema...");
			}
		}

		if (unVendedor.vender(apeYNom, edad, butacaElegida, filaElegida,
				sectorElegido, festival, nocheElegida, listaCategorias)) {
			System.out.println("Se realizo la venta");

		} else {
			System.out.println("No se vendio nada");
		}

	}
}
