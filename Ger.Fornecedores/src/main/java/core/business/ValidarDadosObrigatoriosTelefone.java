package core.business;

import dominio.Fornecedor;
import dominio.EntidadeDominio;

public class ValidarDadosObrigatoriosTelefone implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		String verificaDado = new String();
		Fornecedor fornecedor = (Fornecedor)entidade;

        for (int i = 0; i<fornecedor.getTelefones().size(); i++) {

			if(fornecedor.getTelefones().get(i).getTipoTelefone() == null || 
			   fornecedor.getTelefones().get(i).getTipoTelefone() == ""){
			 	verificaDado += "Tipo Telefone invalido\n";
		 	}

			if(fornecedor.getTelefones().get(i).getDdi() == null || 
			   fornecedor.getTelefones().get(i).getDdi() == ""){
			 	verificaDado += "DDI Telefone invalido(s)\n";
		 	}

			if(fornecedor.getTelefones().get(i).getDdd() == null || 
			   fornecedor.getTelefones().get(i).getDdd() == ""){
			 	verificaDado += "DDD Telefone invalido(s)\n";
		 	}
			 
			if(fornecedor.getTelefones().get(i).getNumero() == null || 
			   fornecedor.getTelefones().get(i).getNumero() == ""){
			 	verificaDado += "Numero Telefone invalido(s)\n";
		 	}

			if(verificaDado != ""){
				return verificaDado;
			}
        }
		
		return null;
		
	}

}
