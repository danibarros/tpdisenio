package edu.core.dao;

import java.util.List;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.Entrada;
import edu.core.entities.Festival;
import edu.core.entities.Fila;

public class FilaDAO extends GenericRepository<Fila, Integer>{

	public List<Fila> getAllFilas(){
		String hql = "from Fila";
		Query query = session.createQuery(hql);
		List<Fila> result = (List<Fila>) query.list();
		return result;
	}
	
	public Fila getFilaById(Integer id){
		return (Fila) session.get(Fila.class, id);
	}
	
	
}
