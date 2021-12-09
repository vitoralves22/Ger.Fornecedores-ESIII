package core.business;

import java.util.ArrayList;
import java.util.List;

import core.dao.FornecedorDAO;
import dominio.Contato;
import dominio.EntidadeDominio;
import dominio.Fornecedor;

public class ValidadorDadosContato implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		String verificaDado = new String();
		Fornecedor fornecedor = (Fornecedor)entidade;
		
		List<Contato> contatos = new ArrayList();
		contatos = fornecedor.getContatos();
		int tamanho = contatos.size();
		
		if(tamanho == 0) {
			return "Voce precisa de pelo menos um contato associoado<br/>";
		}else{
			return null;
               
		}
	}
}

		



