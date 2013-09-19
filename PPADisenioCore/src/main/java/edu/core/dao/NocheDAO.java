package edu.core.dao;

import java.util.List;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.Noche;

public class NocheDAO extends GenericRepository<Noche, Integer>{
	
	public List<Noche> getNoches(int nochenum){
		String hql = "select noche from Noche a "
				+ "where a.numero = :nochenum and a.fechaFin is null";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger("nochenum", nochenum);
		return query.list();
	}
}
