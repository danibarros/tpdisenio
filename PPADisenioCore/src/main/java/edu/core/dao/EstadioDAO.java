package edu.core.dao;

import java.util.List;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.Entrada;
import edu.core.entities.Estadio;

public class EstadioDAO extends GenericRepository<Estadio, Integer>{
	
	public List<Estadio> getAllEstadios(){
		String hql = "from Estadio";
		Query query = session.createQuery(hql);
		List<Estadio> result = (List<Estadio>) query.list();
		return result;
	}

	public Estadio getEstadioById(Integer id){
		return (Estadio) session.get(Estadio.class, id);
	}
	
}
