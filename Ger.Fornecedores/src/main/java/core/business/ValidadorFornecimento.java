package core.business;

import dominio.EntidadeDominio;
import dominio.Fornecedor;

public class ValidadorFornecimento implements IStrategy {
	

	
	
	public String processar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor)entidade;
		
		int qntdProdutos = fornecedor.getProdutosOfertados().size();
		int qntdServicos = fornecedor.getServicosOfertados().size();
		
		if(qntdProdutos == 0 && qntdServicos == 0) {
			return "Voce precisa cadastrar pelos menos um produto ou serviço<br/>";
		}else {
			return null;
		}
			
	
		
	
	}			
}
