package edu.core.dao;

import org.hibernate.Query;

import edu.core.entities.AsignacionPuntoVenta;

public class AsignacionPuntoVentaDAO extends GenericRepository<AsignacionPuntoVenta, Integer>{

	public AsignacionPuntoVenta obtenerBanda(Long idPunto, Long idFestival) {
		String hql = "from punto_festival a where a.festival_festival_id = :idFestival "
				+ "and a.punto_venta_puntos_id = :idPunto";
		Query query = session.createQuery(hql);
		query.setLong("idPunto", idPunto);
		query.setLong("idFestival", idFestival);
		AsignacionPuntoVenta asignacion = (AsignacionPuntoVenta) query.uniqueResult();
		
		sessionFactory.getCurrentSession().clear();
		
		return (AsignacionPuntoVenta) asignacion;
	}

}
