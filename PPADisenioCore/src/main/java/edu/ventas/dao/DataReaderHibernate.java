package edu.ventas.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.persistence.HibernateUtil;

import edu.ventas.entities.*;


public class DataReaderHibernate implements DataBaseReader {

	@Override
	public void setBanda(Banda banda) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.save(banda);
		s.flush();
		s.close();
	}

	@Override
	public void setButaca(Butaca butaca) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.save(butaca);
		s.flush();
		s.close();
	}

	@Override
	public void setCentroDeVenta(CentroDeVenta centroDeVenta) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.save(centroDeVenta);
		s.flush();
		s.close();
	}

	@Override
	public void setEntrada(Entrada entrada) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.save(entrada);
		s.flush();
		s.close();
	}

	@Override
	public void setEstadio(Estadio estadio) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.save(estadio);
		s.flush();
		s.close();
	}

	@Override
	public void setFestival(Festival festival) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.save(festival);
		s.flush();
		s.close();
	}

	@Override
	public void setFila(Fila fila) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.save(fila);
		s.flush();
		s.close();	
	}

	@Override
	public void setLocalidad(Localidad localidad) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.save(localidad);
		s.flush();
		s.close();	
	}

	@Override
	public void setPais(Pais pais) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.save(pais);
		s.flush();
		s.close();	
	}

	@Override
	public void setProvincia(Provincia provincia) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.save(provincia);
		s.flush();
		s.close();	
	}

	@Override
	public void setPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.save(puntoDeVenta);
		s.flush();
		s.close();	
	}

	@Override
	public void setSector(Sector sector) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.save(sector);
		s.flush();
		s.close();	
	}

	@Override
	public void setVendedor(Vendedor vendedor) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.save(vendedor);
		s.flush();
		s.close();	
	}

	@Override
	public Banda getBanda(int idBanda) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Butaca getButaca(int idButaca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CentroDeVenta getCentroDeVenta(int idCentroDeVenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entrada getEntrada(int idEntrada) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estadio getEstadio(int idEstadio) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Festival getFestival(int idFestival) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fila getFila(int idFila) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Localidad getLocalidad(int idLocalidad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pais getPais(int idPais) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Provincia getProvincia(int idProvincia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PuntoDeVenta getPuntoDeVenta(int idPuntoDeVenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sector getSector(int idSector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendedor getVendedor(int idVendedor) {
		// TODO Auto-generated method stub
		return null;
	}

}
