package main.java.mvc.business;

import main.java.mvc.model.domain.Fornecedor;
import main.java.mvc.model.domain.EntidadeDominio;

public class ValidadorCnpj implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		if(fornecedor.getCnpj() == null || fornecedor.getCnpj().length()!=11){
			return "CPNJ INVALIDO";
		}
		return null;
		
	}

}
