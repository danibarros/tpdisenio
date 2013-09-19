package edu.core.dao;

import java.util.List;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.Butaca;
import edu.core.entities.Entrada;

public class EntradaDAO extends GenericRepository<Entrada, Integer>{
	
	public List<Entrada> getAllEntradas(){
		String hql = "from Entrada";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Entrada> result = (List<Entrada>) query.list();
		return result;
	}

}
