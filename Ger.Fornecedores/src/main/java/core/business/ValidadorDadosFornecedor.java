package core.business;

import dominio.EntidadeDominio;
import dominio.Fornecedor;

public class ValidadorDadosFornecedor implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		String cnpj = fornecedor.getCnpj();
		String razaoSocial = fornecedor.getRzSocial();
		String nomeFantasia = fornecedor.getNmFantasia();
		String inscMun = fornecedor.getInscricaoMunicipal();
		String inscEst = fornecedor.getInscricaoEstadual();
		
		if (cnpj == null || cnpj.isBlank()) {
			return "CNPJ obrigatório<br/>";	
		}
		
		if (razaoSocial  == null || razaoSocial.isBlank()) {
			return "Razao social obrigatório<br/>";	
		}
		
		if (nomeFantasia == null || nomeFantasia.isBlank()) {
			return "Nome Fantasia obrigatório<br/>";	
		}
		
		if (inscMun == null || inscMun.isBlank()) {
			return "Inscricao Municipal obrigatório<br/>";	
		}
		
		if (inscEst == null || inscEst.isBlank()) {
			return "Inscricao Estadual obrigatório<br/>";	
		}
				
		return null;
		
	}

}

