package edu.core.dao;

import java.util.List;

import org.hibernate.Query;

import edu.core.entities.Banda;
import edu.core.entities.Butaca;

public class ButacaDAO extends GenericRepository<Butaca, Integer>{
	
	public List<Butaca> getAllButacas(){
		String hql = "from Butacas";
		Query query = session.createQuery(hql);
		List<Butaca> result = (List<Butaca>) query.list();
		return result;
	}
	
	public Butaca getButacaById(Integer id){
		return (Butaca) session.get(Butaca.class, id);
	}
	
	public Double getPrecioById(Integer id)
	{
		System.out.println("BUTACA NUMERO: "+ id);
		String hql = "select s.precio_base + f.precio_base"
				+ " from Butacas b, Filas f, Sectores s"
				+ " where b.butaca_id = :id"
				+ " and b.Filas_fila_id = f.fila_id"
				+ " and f.Sectores_sector_id = s.sector_id";
		Query query = session.createSQLQuery(hql);
		query.setString("id", id.toString());
		
		
		Double result = (Double) query.list().get(0);
		return result;
	}

}
