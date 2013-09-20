package edu.core.dao;

import java.util.List;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.Fila;
import edu.core.entities.Localidad;
import edu.core.entities.Noche;

public class NocheDAO extends GenericRepository<Noche, Integer> {

	public List<Noche> getNoches(int nochenum) {
		String hql = "select noche from Noche a "
				+ "where a.numero = :nochenum and a.fechaFin is null";
		Query query = session.createQuery(hql);
		query.setInteger("nochenum", nochenum);
		return query.list();
	}
	
	public List<Noche> getAllNoches(){
		String hql = "from Noche";
		Query query = session.createQuery(hql);
		List<Noche> result = (List<Noche>) query.list();
		return result;
	}
	
	public Noche getNocheById(Integer id){
		return (Noche) session.get(Noche.class, id);
	}
	
}
