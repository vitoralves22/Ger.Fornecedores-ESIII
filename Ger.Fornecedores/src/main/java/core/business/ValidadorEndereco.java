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
			return "Tipo do endereco obrigat�rio<br/>";
		}
		
		if ( tipoLogradouro== null ||tipoLogradouro.isBlank()) {
			return "Tipo do logradouro obrigat�rio<br/>";	
		}
		
		if (logradouro == null || logradouro.isBlank()) {
			return "Logradouro obrigat�rio<br/>";	
		}
		
		if (numero == null || numero.isBlank()) {
			return "N�mero obrigat�rio<br/>";	
		}

		if (bairro == null || bairro.isBlank()) {
			return "Bairro obrigat�rio<br/>";	
		}
		
		if (cidade == null|| cidade.isBlank()) {
			return "Cidade obrigat�ria<br/>";	
		}

		if (estado == null || estado.isBlank()) {
			return "Estado obrigat�rio<br/>";	
		}
		
		if (pais == null || pais.isBlank()) {
			return "Pa�s obrigat�rio<br/>";	
		}

		if (cep == null || cep.isBlank()) {
			return "CEP obrigat�rio<br/>";	
		
		}else {
			return null;
		}	
	}
}