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
			return "CNPJ obrigat�rio<br/>";	
		}
		
		if (razaoSocial  == null || razaoSocial.isBlank()) {
			return "Razao social obrigat�rio<br/>";	
		}
		
		if (nomeFantasia == null || nomeFantasia.isBlank()) {
			return "Nome Fantasia obrigat�rio<br/>";	
		}
		
		if (inscMun == null || inscMun.isBlank()) {
			return "Inscricao Municipal obrigat�rio<br/>";	
		}
		
		if (inscEst == null || inscEst.isBlank()) {
			return "Inscricao Estadual obrigat�rio<br/>";	
		}
				
		return null;
		
	}

}

