package main.java.mvc.business;

import main.java.mvc.model.domain.EntidadeDominio;

public interface IStrategy {

	public String processar(EntidadeDominio entidade);
	
}
