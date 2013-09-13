package edu.core.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.core.entities.Banda;
import edu.core.entities.Butaca;
import edu.core.entities.Estadio;
import edu.core.entities.Fila;
import edu.core.entities.Noche;
import edu.core.entities.PuntoDeVenta;
import edu.core.entities.Sector;

public class DataReaderHibernate implements DataReaderDAO {

	@Override
	public Map<Integer, Integer> getCategorias(int line, int worksheet) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Butaca> getButacas1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Butaca> getButacas2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Fila> getFilas(List<Butaca> butacas, List<Butaca> butacasX) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sector> getSectores(List<Fila> filas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PuntoDeVenta> getPuntosDeVenta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Banda> getBandas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Noche> getNoches(Set<Banda> bandas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estadio getEstadio(List<Sector> sectores, List<PuntoDeVenta> puntos) {
		// TODO Auto-generated method stub
		return null;
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
		
		
	}

}
