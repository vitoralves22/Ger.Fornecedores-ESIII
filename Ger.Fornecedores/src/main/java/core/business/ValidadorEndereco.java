package core.business;

import dominio.EntidadeDominio;
import dominio.Fornecedor;

public class ValidadorEndereco implements IStrategy {
	public String processar(EntidadeDominio entidade) {
		
		Fornecedor fornecedor = (Fornecedor)entidade;
		String tipoEndereco = fornecedor.getEndereco().getTipo();
		String tipoLogradouro = fornecedor.getEndereco().getTipoLogradouro();
		String logradouro = fornecedor.getEndereco().getLogradouro();
		String numero = fornecedor.getEndereco().getNumero() ;
		String bairro = fornecedor.getEndereco().getBairro();
		String cidade = fornecedor.getEndereco().getCidade();
		String estado = fornecedor.getEndereco().getEstadoUf();
		String pais = fornecedor.getEndereco().getPais();
		String cep = fornecedor.getEndereco().getCep();
		
		
		if ( tipoEndereco  == null || tipoEndereco.isBlank()){
			return "Tipo do endereco obrigatório";
		}
		
		if ( tipoLogradouro== null ||tipoLogradouro.isBlank()) {
			return "Tipo do logradouro obrigatório";	
		}
		
		if (logradouro == null || logradouro.isBlank()) {
			return "Logradouro obrigatório";	
		}
		
		if (numero == null || numero.isBlank()) {
			return "Número obrigatório";	
		}

		if (bairro == null || bairro.isBlank()) {
			return "Bairro obrigatório";	
		}
		
		if (cidade == null|| cidade.isBlank()) {
			return "Cidade obrigatória";	
		}

		if (estado == null || estado.isBlank()) {
			return "Estado obrigatório";	
		}
		
		if (pais == null || pais.isBlank()) {
			return "País obrigatório";	
		}

		if (cep == null || cep.isBlank()) {
			return "CEP obrigatório";	
		
		}else {
			return null;
		}	
	}
}