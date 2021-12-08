package core.business;

import dominio.Fornecedor;
import dominio.EntidadeDominio;

public class ValidarDadosObrigatoriosTelefone implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		String verificaDado = new String();
		Fornecedor fornecedor = (Fornecedor)entidade;

        for (int i = 0; i<fornecedor.getTelefones().size(); i++) {
			String ddi = fornecedor.getTelefones().get(i).getDdi();
        	String ddd = fornecedor.getTelefones().get(i).getDdd();
        	String numero = fornecedor.getTelefones().get(i).getNumero();

			if(ddi == null || ddi == ""){
			 	verificaDado += "DDI Telefone obrigatório(s)\n";
		 	}

			if(ddd == null || ddd == ""){
			 	verificaDado += "DDD Telefone obrigatório(s)\n";
		 	}
			 
			if(numero == null || numero == ""){
			 	verificaDado += "Numero Telefone obrigatório(s)\n";
		 	}

			if(verificaDado != ""){
				return verificaDado;
			}
        }
		
		return null;
		
	}

}
