package edu.ventas.dao;

import edu.ventas.entities.*;


public interface DataBaseReader {
	
	public void setBanda(Banda banda);
	public void setButaca(Butaca butaca);
	public void setCentroDeVenta(CentroDeVenta centroDeVenta);
	public void setEntrada(Entrada entrada);
	public void setEstadio(Estadio estadio);
	public void setFestival(Festival festival);
	public void setFila(Fila fila);
	public void setLocalidad(Localidad localidad);
	public void setPais(Pais pais);
	public void setProvincia(Provincia provincia);
	public void setPuntoDeVenta(PuntoDeVenta puntoDeVenta);
	public void setSector(Sector sector);
	public void setVendedor(Vendedor vendedor);
	
	public Banda getBanda(int idBanda);
	public Butaca getButaca(int idButaca);
	public CentroDeVenta getCentroDeVenta(int idCentroDeVenta);
	public Entrada getEntrada(int idEntrada);
	public Estadio getEstadio(int idEstadio);
	public Festival getFestival(int idFestival);
	public Fila getFila(int idFila);
	public Localidad getLocalidad(int idLocalidad);
	public Pais getPais(int idPais);
	public Provincia getProvincia(int idProvincia);
	public PuntoDeVenta getPuntoDeVenta(int idPuntoDeVenta);
	public Sector getSector(int idSector);
	public Vendedor getVendedor(int idVendedor);

}
