package edu.ventas.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.ventas.entities.Banda;
import edu.ventas.entities.Butaca;
import edu.ventas.entities.Fila;
import edu.ventas.entities.Noche;
import edu.ventas.entities.PuntoDeVenta;
import edu.ventas.entities.Sector;

public interface DataReaderDAO {

	public Map<Integer, Integer> getCategorias(int line, int worksheet);
	public List<Butaca> getButacas(int line);
	public List<Fila> getFilas(List<Butaca> butacas);
	public List<Sector> getSectores(List<Fila> filas);
	public List<PuntoDeVenta> getPuntosDeVenta();
	public Set<Banda> getBandas();
	public List<Noche> getNoches(Set<Banda> bandas);
}
