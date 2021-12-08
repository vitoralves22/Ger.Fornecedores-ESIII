package core.business;

import dominio.EntidadeDominio;
import dominio.Fornecedor;

public class ValidadorFornecimento implements IStrategy {
	
	String verificaDado = new String();
	
	void verificarProdutos(Fornecedor fornecedor) {
		for (int i = 0; i<fornecedor.getProdutosOfertados().size(); i++) {
			String descProduto = fornecedor.getProdutosOfertados().get(i).getDescricao();
				if( descProduto == null || descProduto == ""){
						    verificaDado += "Descricao de Produto obrigatória\n";
			    }
			}
	}
	
	void verificarServicos(Fornecedor fornecedor) {
		for (int i = 0; i<fornecedor.getServicosOfertados().size(); i++) {
			String descServico = fornecedor.getServicosOfertados().get(i).getDescricao();
				if( descServico == null || descServico == ""){
						    verificaDado += "Descricao de Servico obrigatória\n";
				}
			}
	}
	
	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		String tipoFornecimento = fornecedor.getEmpresa().getTipoFornecimento();
		
		if(tipoFornecimento=="Produto") {
			verificarProdutos(fornecedor);
			
		}else if(tipoFornecimento=="Servico"){
			verificarServicos(fornecedor);
			
		}else if(tipoFornecimento=="Ambos"){
			verificarProdutos(fornecedor);
			verificarServicos(fornecedor);		
		}else{
			return "Produto(s) ou Servico(s) obrigatório(s)\n";
		}
				
		
    	if(verificaDado != ""){
			return verificaDado;
		}

		return null;
	
	}			
}

