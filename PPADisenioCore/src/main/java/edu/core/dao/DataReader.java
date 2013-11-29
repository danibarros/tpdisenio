package edu.core.dao;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.core.entities.Banda;
import edu.core.entities.Butaca;
import edu.core.entities.Categoria;
import edu.core.entities.Estadio;
import edu.core.entities.Fila;
import edu.core.entities.Noche;
import edu.core.entities.PuntoDeVenta;
import edu.core.entities.Sector;

public class DataReader implements DataReaderDAO {

	public Map<Integer, Integer> getCategorias(int line, int worksheet) {
		Map<Integer, Integer> listaCategorias = new HashMap<Integer, Integer>();
		listaCategorias.put(1, 0);
		listaCategorias.put(2, 50);
		listaCategorias.put(3, 100);
		listaCategorias.put(4, 200);
		return listaCategorias;
	}

	public List<Butaca> getButacas1() {
		
		List<Butaca> butacas = new ArrayList<Butaca>();
		for (int i = 1; i <= 40; i++) {
			Butaca butaca = new Butaca(i);
			butacas.add(butaca);
		}
		
		return butacas;
	}

	public List<Butaca> getButacas2() {
		
		List<Butaca> butacas = new ArrayList<Butaca>();
		for (int i = 1; i <= 40; i++) {
			Butaca butaca = new Butaca(i);
			butacas.add(butaca);
		}
		
		return butacas;
	}
	
	public List<Fila> getFilas(List<Butaca> butacas, List<Butaca> butacasX) {
		
		List<Butaca> butacas1 = butacas.subList(0, 5);
		List<Butaca> butacas2 = butacas.subList(5, 12);
		List<Butaca> butacas3 = butacas.subList(12, 20);
		List<Butaca> butacas4 = butacas.subList(20, 30);
		List<Butaca> butacas5 = butacas.subList(30, 40);
		List<Butaca> butacas6 = butacasX.subList(0, 10);
		List<Butaca> butacas7 = butacasX.subList(0, 20);
		List<Butaca> butacas8 = butacasX.subList(20, 40);
		
		Fila fila1 = new Fila(1, butacas1);
		for (Butaca butaca : butacas1) {
			butaca.setFila(fila1);
		}
		Fila fila2 = new Fila(2, butacas2);
		for (Butaca butaca : butacas2) {
			butaca.setFila(fila2);
		}
		Fila fila3 = new Fila(3, butacas3);
		for (Butaca butaca : butacas3) {
			butaca.setFila(fila3);
		}
		Fila fila4 = new Fila(4, butacas4);
		for (Butaca butaca : butacas4) {
			butaca.setFila(fila4);
		}
		Fila fila5 = new Fila(5, butacas5);
		for (Butaca butaca : butacas5) {
			butaca.setFila(fila5);
		}
		Fila fila6 = new Fila(1, butacas6);
		for (Butaca butaca : butacas6) {
			butaca.setFila(fila6);
		}
		Fila fila7 = new Fila(2, butacas7);
		for (Butaca butaca : butacas7) {
			butaca.setFila(fila7);
		}
		Fila fila8 = new Fila(3, butacas8);
		for (Butaca butaca : butacas8) {
			butaca.setFila(fila8);
		}
		List<Fila> filas = new ArrayList<Fila>();
		
		
		filas.add(fila1);
		filas.add(fila2);
		filas.add(fila3);
		filas.add(fila4);
		filas.add(fila5);
		filas.add(fila6);
		filas.add(fila7);
		filas.add(fila8);
		
		return filas;
	}

	public List<Sector> getSectores(List<Fila> filas) {
		List<Fila> filas1 = filas.subList(0, 5);
		List<Fila> filas2 = filas.subList(5, 8);
		Sector sector = new Sector("Sector1", filas1, 50);
		for (Fila fila : filas1) {
			fila.setSector(sector);
		}
		Sector sector2 = new Sector("Sector2", filas2, 25);
		for (Fila fila : filas2) {
			fila.setSector(sector2);
		}
		List<Sector> sectores = new ArrayList<Sector>();
		sectores.add(sector);
		sectores.add(sector2);
		return sectores;
	}
	
	public Estadio getEstadio(List<Sector> sectores,List<PuntoDeVenta> puntos){
		String nombre = "River Plate";
		Estadio estadio = new Estadio(nombre,sectores,puntos);
		
		return estadio;
	}

	public List<PuntoDeVenta> getPuntosDeVenta() {
		PuntoDeVenta puntoDeVenta = new PuntoDeVenta();
		puntoDeVenta.setNombre("Super punto de venta");
		List<PuntoDeVenta> puntosDeVenta = new ArrayList<PuntoDeVenta>();
		puntosDeVenta.add(puntoDeVenta);
		return puntosDeVenta;
	}

	public List<Banda> getBandas() {
		Categoria categoria = new Categoria();
		Banda banda1 = new Banda("las patillas", categoria);
		Banda banda2 = new Banda("ntvg", categoria);
		Banda banda3 = new Banda("metallica", categoria);
		List<Banda> bandas = new ArrayList<Banda>();
		bandas.add(banda1);
		bandas.add(banda2);
		bandas.add(banda3);
		return bandas;
	}

	@Override
	public void setCategorias(Map<Integer, Integer> categorias) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setButacas1(List<Butaca> butacas) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setButacas2(List<Butaca> butacas) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFilas(List<Fila> filas) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSectores(List<Sector> sectores) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPuntosDeVenta(List<PuntoDeVenta> puntosDeVenta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setBandas(Set<Banda> bandas) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNoches(List<Noche> noches) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEstadio(Estadio estadio) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Noche> getNoches(List<Banda> bandas) {
		// TODO Auto-generated method stub
		return null;
	}
	
}