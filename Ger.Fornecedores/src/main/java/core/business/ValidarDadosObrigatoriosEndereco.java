package core.business;

import dominio.EntidadeDominio;
import dominio.Fornecedor;


public class ValidarDadosObrigatoriosEndereco implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		if(fornecedor.getEndereco().getTipo() == null || fornecedor.getEndereco().getTipo() == ""){
			return "Tipo Endereço inválido";
		}
		return null;
	}

}
