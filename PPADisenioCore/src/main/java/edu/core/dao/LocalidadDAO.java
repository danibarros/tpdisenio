package edu.core.dao;

import edu.core.entities.Localidad;
import edu.core.entities.Provincia;

public class LocalidadDAO extends GenericRepository<Localidad, Integer>{
	
	public Localidad getLocalidadById(Integer idLocalidad){
		return (Localidad) session.get(Localidad.class, idLocalidad);
	}

}
