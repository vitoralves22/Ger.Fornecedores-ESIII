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
		
		List<String> cnpjs = new ArrayList<String>();
		cnpj.setPesquisa(fornecedorAnalisado.getCnpj().toString());
		List<EntidadeDominio> fornecedoresDoBanco = new FornecedorDAO().consultar(cnpj);
		
		for(EntidadeDominio entidades : fornecedoresDoBanco) {
			Fornecedor f = (Fornecedor) entidades;
			if(f.getCnpj().equals(fornecedorAnalisado.getCnpj())) {
				verificaDado = "Cnpj Já Existe";	
				System.out.println("Aqui" + verificaDado);
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
