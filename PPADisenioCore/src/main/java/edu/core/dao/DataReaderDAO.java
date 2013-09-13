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

public interface DataReaderDAO {

	public Map<Integer, Integer> getCategorias(int line, int worksheet);
	public List<Butaca> getButacas1();
	public List<Butaca> getButacas2();
	public List<Fila> getFilas(List<Butaca> butacas, List<Butaca> butacasX);
	public List<Sector> getSectores(List<Fila> filas);
	public List<PuntoDeVenta> getPuntosDeVenta();
	public Set<Banda> getBandas();
	public List<Noche> getNoches(Set<Banda> bandas);
	public Estadio getEstadio(List<Sector> sectores,List<PuntoDeVenta> puntos);
	
	public void setCategorias(Map<Integer, Integer> categorias);
	public void setButacas1(List<Butaca> butacas);
	public void setButacas2(List<Butaca> butacas);
	public void setFilas(List<Fila> filas);
	public void setSectores(List<Sector> sectores);
	public void setPuntosDeVenta(List<PuntoDeVenta> puntosDeVenta);
	public void setBandas(Set<Banda> bandas);
	public void setNoches(List<Noche> noches);
	public void setEstadio(Estadio estadio);
}
