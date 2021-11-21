package main.java.mvc.controller;

import main.java.mvc.model.domain.EntidadeDominio;

public interface ICommand {
	
	public Object executar(EntidadeDominio entidade);
	
}

