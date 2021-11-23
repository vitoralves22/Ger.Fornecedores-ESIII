package business;

import model.domain.EntidadeDominio;

public interface IStrategy {

	public String processar(EntidadeDominio entidade);
	
}
