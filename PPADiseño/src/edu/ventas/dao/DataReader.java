package edu.ventas.dao;

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
import edu.ventas.entities.Fila;
import edu.ventas.entities.Noche;
import edu.ventas.entities.PuntoDeVenta;
import edu.ventas.entities.Sector;

public class DataReader implements DataReaderDAO {

	public Map<Integer, Integer> getCategorias(int line, int worksheet) {
		Map<Integer, Integer> listaCategorias = new HashMap<Integer, Integer>();
		listaCategorias.put(1, 0);
		listaCategorias.put(2, 50);
		listaCategorias.put(3, 100);
		listaCategorias.put(4, 200);
		return listaCategorias;
	}

	public List<Butaca> getButacas(int line) {
		Butaca butaca = new Butaca(true, 1);
		Butaca butaca2 = new Butaca(true, 2);
		Butaca butaca3 = new Butaca(true, 3);
		Butaca butaca4 = new Butaca(true, 4);
		List<Butaca> butacas = new ArrayList<Butaca>();
		butacas.add(butaca);
		butacas.add(butaca2);
		butacas.add(butaca3);
		butacas.add(butaca4);
		return butacas;
	}

	public List<Fila> getFilas(List<Butaca> butacas) {
		List<Butaca> butacas1 = butacas.subList(0, 5);
		List<Butaca> butacas2 = butacas.subList(5, butacas.size());
		Fila fila = new Fila(1, butacas1);
		Fila fila2 = new Fila(2, butacas2);
		List<Fila> filas = new ArrayList<Fila>();
		filas.add(fila);
		filas.add(fila2);
		return filas;
	}

	public List<Sector> getSectores(List<Fila> filas) {
		List<Fila> filas1 = filas.subList(0, filas.size() / 2);
		List<Fila> filas2 = filas.subList(filas.size() / 2 + 1, filas.size());
		Sector sector = new Sector("Sector1", filas1, 50, 'A');
		Sector sector2 = new Sector("Sector2", filas2, 25, 'B');
		List<Sector> sectores = new ArrayList<Sector>();
		sectores.add(sector);
		sectores.add(sector2);
		return sectores;
	}

	public List<PuntoDeVenta> getPuntosDeVenta(List<Fila> filas) {
		PuntoDeVenta puntoDeVenta = new PuntoDeVenta();
		List<PuntoDeVenta> puntosDeVenta = new ArrayList<PuntoDeVenta>();
		puntosDeVenta.add(puntoDeVenta);
		return puntosDeVenta;
	}

	public List<PuntoDeVenta> getPuntosDeVenta() {
		PuntoDeVenta puntoDeVenta = new PuntoDeVenta();
		List<PuntoDeVenta> puntosDeVenta = new ArrayList<PuntoDeVenta>();
		puntosDeVenta.add(puntoDeVenta);
		return puntosDeVenta;
	}

	public Set<Banda> getBandas() {
		Banda banda1 = new Banda("las patillas", 1);
		Banda banda2 = new Banda("ntvg", 2);
		Banda banda3 = new Banda("metallica", 4);
		Set<Banda> bandas = new HashSet<Banda>();
		bandas.add(banda1);
		bandas.add(banda2);
		bandas.add(banda3);
		return bandas;
	}

	public List<Noche> getNoches(Set<Banda> bandas) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		String input;
		input = "1818-11-11";
		try {
			date = format.parse(input);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Noche noche1 = new Noche(1, bandas, date);
		List<Noche> noches = new ArrayList<Noche>();
		noches.add(noche1);
		return noches;
	}
}