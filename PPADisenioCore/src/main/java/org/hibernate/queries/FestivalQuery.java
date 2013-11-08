package org.hibernate.queries;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;

import edu.core.dao.GenericRepository;
import edu.core.entities.AsignacionBanda;
import edu.core.entities.Butaca;
import edu.core.entities.Festival;

public class FestivalQuery extends GenericRepository<Festival, Integer>{

	public boolean getEstadiosFechas(int idEstadio, Date fecha){
	
		String sql = "Select festival_id "
				+ " from ppa_disenio.festival f, ppa_disenio.estadios e "
				+ " Where e.estadio_id = :idEstadio and "
				+ " f.Estadios_estadio_id = e.estadio_id and "
				+ " f.fecha_inicio between :fecha and INTERVAL (select count(n.noche_id)  "
				+ " from ppa_disenio.noches n where n.festival_festival_id = f.festival_id) DAY + :fecha ";
		Query query = session.createSQLQuery(sql);
		query.setParameter("idEstadio", idEstadio);
		query.setParameter("fecha", fecha);
		List<Festival> result = (List<Festival>) query.list();
		return !result.isEmpty();
	}
}
