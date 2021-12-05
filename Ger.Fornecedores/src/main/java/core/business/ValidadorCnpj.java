package core.business;

import dominio.Fornecedor;
import dominio.EntidadeDominio;

public class ValidadorCnpj implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		String cnpj = fornecedor.getCnpj().replace("-", "").replace(".", "").replace("/", "");
				
		if(cnpj == null || cnpj.length()!=14){
			return "CPNJ inválido";
		}else {
			return null;
		}
		
	}

}
