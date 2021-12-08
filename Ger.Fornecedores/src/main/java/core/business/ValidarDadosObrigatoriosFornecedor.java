package core.business;

import dominio.EntidadeDominio;
import dominio.Fornecedor;


public class ValidarDadosObrigatoriosFornecedor implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		String cnpj = fornecedor.getCnpj();
		String razaoSocial = fornecedor.getRzSocial();
		String nomeFantasia = fornecedor.getNmFantasia();
		String inscMun = fornecedor.getInscricaoMunicipal();
		String inscEst = fornecedor.getInscricaoEstadual();
		
		if (cnpj == null || cnpj.isBlank()) {
			return "CNPJ obrigat�rio";	
		}
		
		if (razaoSocial  == null || razaoSocial.isBlank()) {
			return "Razao social obrigat�rio";	
		}
		
		if (nomeFantasia == null || nomeFantasia.isBlank()) {
			return "Nome Fantasia obrigat�rio";	
		}
		
		if (inscMun == null || inscMun.isBlank()) {
			return "Inscricao Municipal obrigat�rio";	
		}
		
		if (inscEst == null || inscEst.isBlank()) {
			return "Inscricao Estadual obrigat�rio";	
		}
				
		return null;
		
	}

}
