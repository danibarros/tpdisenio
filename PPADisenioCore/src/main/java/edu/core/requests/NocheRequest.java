package edu.core.requests;

import java.util.Date;
import java.util.Map;

import edu.core.entities.Banda;
import edu.core.entities.Noche;

public class NocheRequest {

	Noche noche;
	Map<Banda,Integer> bandas;
	
	public Map<Banda, Integer> getBandas() {
		return bandas;
	}
	public void setBandas(Map<Banda, Integer> bandas) {
		this.bandas = bandas;
	}
	public Noche getNoche() {
		return noche;
	}
	public void setNoche(Noche noche) {
		this.noche = noche;
	}
	
}
