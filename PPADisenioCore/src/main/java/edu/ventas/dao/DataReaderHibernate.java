package edu.ventas.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.persistence.HibernateUtil;

import edu.ventas.entities.*;


public class DataReaderHibernate implements DataBaseReader {

	@Override
	public void createBanda(Banda banda) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(banda);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void createButaca(Butaca butaca) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(butaca);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void createCentroDeVenta(CentroDeVenta centroDeVenta) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(centroDeVenta);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void createEntrada(Entrada entrada) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(entrada);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void createEstadio(Estadio estadio) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(estadio);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void createFestival(Festival festival) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(festival);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void createFila(Fila fila) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(fila);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void createLocalidad(Localidad localidad) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(localidad);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void createPais(Pais pais) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(pais);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void createProvincia(Provincia provincia) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(provincia);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void createPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(puntoDeVenta);
		s.flush();
		t.commit();
		s.close();		
	}

	@Override
	public void createSector(Sector sector) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(sector);
		s.flush();
		t.commit();
		s.close();		
	}

	@Override
	public void createVendedor(Vendedor vendedor) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.save(vendedor);
		s.flush();
		t.commit();
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
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		Pais pais = new Pais();
		pais = (Pais) s.get(pais.getClass(),idPais);
		s.close();		
		return pais;
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

	@Override
	public void dropBanda(Banda banda) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.delete(banda);
		s.flush();
		t.commit();
		s.close();		
	}

	@Override
	public void dropButaca(Butaca butaca) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.delete(butaca);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void dropCentroDeVenta(CentroDeVenta centroDeVenta) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.delete(centroDeVenta);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void dropEntrada(Entrada entrada) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.delete(entrada);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void dropEstadio(Estadio estadio) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.delete(estadio);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void dropFestival(Festival festival) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.delete(festival);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void dropFila(Fila fila) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.delete(fila);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void dropLocalidad(Localidad localidad) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.delete(localidad);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void dropPais(Pais pais) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.delete(pais);
		s.flush();
		t.commit();
		s.close();		
	}

	@Override
	public void dropProvincia(Provincia provincia) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.delete(provincia);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void dropPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.delete(puntoDeVenta);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void dropSector(Sector sector) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.delete(sector);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void dropVendedor(Vendedor vendedor) {
		Session s = HibernateUtil.getSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		s.delete(vendedor);
		s.flush();
		t.commit();
		s.close();	
	}

	@Override
	public void setBanda(Banda banda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setButaca(Butaca butaca) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setCentroDeVenta(CentroDeVenta centroDeVenta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEntrada(Entrada entrada) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEstadio(Estadio estadio) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFestival(Festival festival) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setFila(Fila fila) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLocalidad(Localidad localidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPais(Pais pais) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setProvincia(Provincia provincia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPuntoDeVenta(PuntoDeVenta puntoDeVenta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSector(Sector sector) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setVendedor(Vendedor vendedor) {
		// TODO Auto-generated method stub
		
	}

}
