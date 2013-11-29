package edu.core.dao;

import java.util.List;

import org.hibernate.Query;

import edu.core.entities.Fila;
import edu.core.entities.Localidad;
import edu.core.entities.Sector;

public class LocalidadDAO extends GenericRepository<Localidad, Integer>{
	
	public List<Localidad> getAllLocalidades(){
		String hql = " from Localidad";
		Query query = session.createQuery(hql);
		List<Localidad> result = (List<Localidad>) query.list();
		return result;
	}
	
	public Localidad getLocalidadById(Integer id){
		return (Localidad) session.get(Localidad.class, id);
	}
	
	
}
