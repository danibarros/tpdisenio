package edu.core.dao;

import java.util.List;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.Noche;
import edu.core.entities.Pais;

public class BandaDAO extends GenericRepository<Banda, Integer>{

	public List<Banda> getAllBandas(){
		String hql = "from Banda";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Banda> result = (List<Banda>) query.list();
		return result;
	}
}
