package edu.core.requests;

import edu.core.dao.VendedorDAO;

public class UserValidationRequest {
	private String user;
	private String pass;
	private VendedorDAO vendedorDao;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public VendedorDAO getVendedorDao() {
		return vendedorDao;
	}
	public void setVendedorDao(VendedorDAO vendedorDao) {
		this.vendedorDao = vendedorDao;
	}	
	
}
