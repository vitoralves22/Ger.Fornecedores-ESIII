package core.business;

import dominio.EntidadeDominio;
import dominio.Fornecedor;

public class ValidarDadosObrigatoriosCnae implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;

        for (int i = 0; i<fornecedor.getCnaes().size(); i++) {
        String cnae = fornecedor.getCnaes().get(i).getCodigo();
           
        	if(cnae == null || cnae.isBlank()){
				return "Cnae(s) obrigatório(s)\n";
			}
        }	
		return null;
		
	}

}
