package edu.ventas.dao;

import edu.ventas.entities.*;


public interface DataBaseReader {
	
	public void createBanda(Banda banda);
	public void createButaca(Butaca butaca);
	public void createCentroDeVenta(CentroDeVenta centroDeVenta);
	public void createEntrada(Entrada entrada);
	public void createEstadio(Estadio estadio);
	public void createFestival(Festival festival);
	public void createFila(Fila fila);
	public void createLocalidad(Localidad localidad);
	public void createPais(Pais pais);
	public void createProvincia(Provincia provincia);
	public void createPuntoDeVenta(PuntoDeVenta puntoDeVenta);
	public void createSector(Sector sector);
	public void createVendedor(Vendedor vendedor);
	
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

	public void dropBanda(Banda banda);
	public void dropButaca(Butaca butaca);
	public void dropCentroDeVenta(CentroDeVenta centroDeVenta);
	public void dropEntrada(Entrada entrada);
	public void dropEstadio(Estadio estadio);
	public void dropFestival(Festival festival);
	public void dropFila(Fila fila);
	public void dropLocalidad(Localidad localidad);
	public void dropPais(Pais pais);
	public void dropProvincia(Provincia provincia);
	public void dropPuntoDeVenta(PuntoDeVenta puntoDeVenta);
	public void dropSector(Sector sector);
	public void dropVendedor(Vendedor vendedor);
}
