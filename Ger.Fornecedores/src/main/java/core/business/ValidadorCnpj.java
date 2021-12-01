package core.business;

import dominio.Fornecedor;
import dominio.EntidadeDominio;

public class ValidadorCnpj implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		if(fornecedor.getCnpj() == null || fornecedor.getCnpj().length()!=14){
			return "CPNJ INVALIDO";
		}
		return null;
		
	}

}
