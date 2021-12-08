package core.business;

import dominio.EntidadeDominio;
import dominio.Fornecedor;


public class ValidarDadosObrigatoriosContato implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		String verificaDado = new String();
		Fornecedor fornecedor = (Fornecedor)entidade;

        for (int i = 0; i<fornecedor.getContatos().size(); i++) {
            if(fornecedor.getContatos().get(i).getNome() == null || 
			   fornecedor.getContatos().get(i).getNome() == "") {
				verificaDado += "Nome de contato(s) obrigatório(s)\n";
			}

			if(fornecedor.getContatos().get(i).getEmail() == null || 
			   fornecedor.getContatos().get(i).getEmail() == "") {
				verificaDado += "Email de contato(s) obrigatório(s)\n";
		 	}

			if(fornecedor.getContatos().get(i).getDepartamento() == null || 
			   fornecedor.getContatos().get(i).getDepartamento() == "") {
				verificaDado += "Departamento de contato(s) obrigatório(s)\n";
			}

			if(fornecedor.getContatos().get(i).getTelefone().getTipoTelefone() == null || 
			   fornecedor.getContatos().get(i).getTelefone().getTipoTelefone() == ""){
				verificaDado += "Tipo Telefone de contato(s) obrigatório(s)\n";
		 	}

			if(fornecedor.getContatos().get(i).getTelefone().getDdi() == null || 
			fornecedor.getContatos().get(i).getTelefone().getDdi() == ""){
				verificaDado += "DDI Telefone de contato(s) obrigatório(s)\n";
		 	}

			if(fornecedor.getContatos().get(i).getTelefone().getDdd() == null || 
			fornecedor.getContatos().get(i).getTelefone().getDdd() == ""){
				verificaDado += "DDD Telefone de contato(s)  obrigatório(s)\n";
		 	}
			 
			if(fornecedor.getContatos().get(i).getTelefone().getNumero() == null || 
			fornecedor.getContatos().get(i).getTelefone().getNumero() == ""){
				verificaDado += "Número Telefone de contato(s) obrigatório(s)\n";
		 	}

			if(verificaDado != ""){
				 return verificaDado;
			 }

        }
		
		return null;
		
	}

}
