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
			return "CNPJ obrigatório";	
		}
		
		if (razaoSocial  == null || razaoSocial.isBlank()) {
			return "Razao social obrigatório";	
		}
		
		if (nomeFantasia == null || nomeFantasia.isBlank()) {
			return "Nome Fantasia obrigatório";	
		}
		
		if (inscMun == null || inscMun.isBlank()) {
			return "Inscricao Municipal obrigatório";	
		}
		
		if (inscEst == null || inscEst.isBlank()) {
			return "Inscricao Estadual obrigatório";	
		}
				
		return null;
		
	}

}
