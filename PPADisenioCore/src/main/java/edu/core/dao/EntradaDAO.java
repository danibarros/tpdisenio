package edu.core.dao;

import java.util.List;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.Butaca;
import edu.core.entities.Categoria;
import edu.core.entities.Entrada;

public class EntradaDAO extends GenericRepository<Entrada, Integer>{
	
	public List<Entrada> getAllEntradas(){
		String hql = "from Entrada";
		Query query = session.createQuery(hql);
		List<Entrada> result = (List<Entrada>) query.list();
		return result;
	}
	
	public Entrada getEntradaById(Integer id){
		return (Entrada) session.get(Entrada.class, id);
	}

}
