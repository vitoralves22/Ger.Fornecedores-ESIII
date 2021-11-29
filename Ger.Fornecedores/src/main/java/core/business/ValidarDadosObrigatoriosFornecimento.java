package core.business;

import dominio.EntidadeDominio;
import dominio.Fornecedor;


public class ValidarDadosObrigatoriosFornecimento implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		String verificaDado = new String();
		Fornecedor fornecedor = (Fornecedor)entidade;

		for (int i = 0; i<fornecedor.getProdutosOfertados().size(); i++) {

			if(fornecedor.getProdutosOfertados().get(i).getDescricao() == null || 
			   fornecedor.getProdutosOfertados().get(i).getDescricao() == ""){
			 	verificaDado += "Codigo de Produto invalido\n";
		 	}

			if(fornecedor.getProdutosOfertados().get(i).getDescricao() == null || 
			   fornecedor.getProdutosOfertados().get(i).getDescricao() == ""){
			    verificaDado += "Descricao de Produto invalida\n";
		    }
        }

        for (int i = 0; i<fornecedor.getServicosOfertados().size(); i++) {

			if(fornecedor.getServicosOfertados().get(i).getDescricao() == null || 
			   fornecedor.getServicosOfertados().get(i).getDescricao() == ""){
			 	verificaDado += "Codigo de Servico invalido\n";
		 	}

			if(fornecedor.getServicosOfertados().get(i).getDescricao() == null || 
			   fornecedor.getServicosOfertados().get(i).getDescricao() == ""){
			    verificaDado += "Descricao de Servico invalida\n";
		    }
        }

		if(verificaDado != ""){
			return verificaDado;
		}

		return null;
		
	}

}
