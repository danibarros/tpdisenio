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

	public Float getPrecioNocheById(int idNoche) {
		String hql = "select categoria_precio from categorias " 
			+	"where categoria_id = "
			+	"(select MAX(b.Categorias_categoria_id) from Noches n, banda_noche bn,Bandas b "
			+	"where n.noche_id = :nochenum and " 
			+	"bn.Noches_noche_id  = :nochenum and " 
			+	"bn.Bandas_banda_id = b.banda_id)";
		Query query = session.createSQLQuery(hql);
		query.setInteger("nochenum", idNoche);
		return (Float) query.list().get(0);
		
	}
	
}
