package edu.core.dao;

import java.util.List;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.Butaca;

public class ButacaDAO extends GenericRepository<Butaca, Integer>{
	
	public List<Butaca> getAllButacas(){
		String hql = "from Butaca";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Butaca> result = (List<Butaca>) query.list();
		return result;
	}

}
