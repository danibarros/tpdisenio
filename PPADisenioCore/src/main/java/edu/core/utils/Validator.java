package edu.core.utils;

import edu.core.entities.Vendedor;
import edu.core.requests.UserValidationRequest;

public class Validator {

	public boolean validateUser(UserValidationRequest request){
		Vendedor vendedor = request.getVendedorDao().getVendedorByUser(request.getUser());
		if (vendedor != null && vendedor.getContrasenia().equals(request.getPass())){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isNumeric(String cadena){
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
}
