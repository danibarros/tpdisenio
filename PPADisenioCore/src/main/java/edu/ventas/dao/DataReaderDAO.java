package edu.ventas.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.ventas.entities.Banda;
import edu.ventas.entities.Butaca;
import edu.ventas.entities.Estadio;
import edu.ventas.entities.Fila;
import edu.ventas.entities.Noche;
import edu.ventas.entities.PuntoDeVenta;
import edu.ventas.entities.Sector;

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
