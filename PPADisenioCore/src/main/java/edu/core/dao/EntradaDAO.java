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
	
	public int getMaximo(){
		String sql = "Select Max(entrada_id) "
				+ " from ppa_disenio.entradas ";
		Query query = session.createSQLQuery(sql);
		int result;
		if ((Integer) query.list().get(0) != null){
			result = (Integer) query.list().get(0);
		}else{
			result = 0;
		}
		return result;
	}
	
	public void reset(){
		session.clear();
	}

	public List<Integer> getAllButacas(int idNoche) {
		String hql = "select butaca_id from entradas  where butaca_id is not null and Noches_noche_id = :noche_id";
		Query query = session.createSQLQuery(hql);
		query.setInteger("noche_id", idNoche);
		List<Integer> result = (List<Integer>) query.list();
		return result;
	}

}
