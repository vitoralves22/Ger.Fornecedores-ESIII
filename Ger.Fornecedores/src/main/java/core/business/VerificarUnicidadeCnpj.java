package core.business;

import dominio.Fornecedor;

import java.util.ArrayList;
import java.util.List;

import core.dao.FornecedorDAO;
import dominio.EntidadeDominio;

public class VerificarUnicidadeCnpj implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		String verificaDado = new String();
		Fornecedor fornecedorAnalisado = (Fornecedor)entidade;
		Fornecedor cnpj = new Fornecedor();
		
		
		cnpj.setPesquisa(fornecedorAnalisado.getCnpj().toString());
		List<EntidadeDominio> fornecedoresDoBanco = new FornecedorDAO().consultar(cnpj);
		
		for(EntidadeDominio fornecedores : fornecedoresDoBanco) {
			Fornecedor f = (Fornecedor) fornecedores;
			if(f.getCnpj().equals(fornecedorAnalisado.getCnpj())) {
				verificaDado = "Cnpj Já Existe<br/>";	
				break;
			}
		}
			
		if (verificaDado != "") {
			return verificaDado;
		}else{
			return null;
		}
	}

}
