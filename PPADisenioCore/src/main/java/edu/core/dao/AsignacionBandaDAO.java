package edu.core.dao;

import org.hibernate.Query;

import edu.core.entities.AsignacionBanda;

public class AsignacionBandaDAO extends GenericRepository<AsignacionBanda, Integer>{

	public AsignacionBanda obtenerBanda(Long idBanda, Long idNoche) {
		String hql = "from banda_noche a where a.noches_noche_id = :idNoche "
				+ "and a.bandas_banda_id = :idBanda";
		Query query = session.createQuery(hql);
		query.setLong("idBanda", idBanda);
		query.setLong("idNoche", idNoche);
		AsignacionBanda asignacion = (AsignacionBanda) query.uniqueResult();
		
		sessionFactory.getCurrentSession().clear();
		
		return (AsignacionBanda) asignacion;
	}
}
