package edu.core.dao;

import java.util.List;

import org.hibernate.Query;

import edu.core.entities.Localidad;
import edu.core.entities.Provincia;
import edu.core.entities.Sector;

public class LocalidadDAO extends GenericRepository<Localidad, Integer>{
	
	public Localidad getLocalidadById(Integer idLocalidad){
		return (Localidad) session.get(Localidad.class, idLocalidad);
	}
	
	public List<Localidad> getAllLocalidades(){
		String hql = " from Localidad";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Localidad> result = (List<Localidad>) query.list();
		return result;
	}
	
}
