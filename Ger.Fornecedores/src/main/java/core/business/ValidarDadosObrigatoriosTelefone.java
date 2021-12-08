package core.business;

import dominio.Fornecedor;
import dominio.EntidadeDominio;

public class ValidarDadosObrigatoriosTelefone implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		String verificaDado = new String();
		Fornecedor fornecedor = (Fornecedor)entidade;

        for (int i = 0; i<fornecedor.getTelefones().size(); i++) {
        	String tipoTelefone = fornecedor.getTelefones().get(i).getTipoTelefone();
			String ddi = fornecedor.getTelefones().get(i).getDdi();
        	String ddd = fornecedor.getTelefones().get(i).getDdd();
        	String numero = fornecedor.getTelefones().get(i).getNumero();
        	
			if(tipoTelefone == null || tipoTelefone == ""){
			 	verificaDado += "Tipo Telefone obrigat�rio\n";
		 	}

			if(ddi == null || ddi == ""){
			 	verificaDado += "DDI Telefone obrigat�rio(s)\n";
		 	}

			if(ddd == null || ddd == ""){
			 	verificaDado += "DDD Telefone obrigat�rio(s)\n";
		 	}
			 
			if(numero == null || numero == ""){
			 	verificaDado += "Numero Telefone obrigat�rio(s)\n";
		 	}

			if(verificaDado != ""){
				return verificaDado;
			}
        }
		
		return null;
		
	}

}
