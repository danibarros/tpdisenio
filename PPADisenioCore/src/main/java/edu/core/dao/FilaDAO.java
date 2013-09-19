package edu.core.dao;

import java.util.List;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.Entrada;
import edu.core.entities.Fila;

public class FilaDAO extends GenericRepository<Fila, Integer>{

	public List<Fila> getAllFilas(){
		String hql = "from Fila";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Fila> result = (List<Fila>) query.list();
		return result;
	}
	
}
