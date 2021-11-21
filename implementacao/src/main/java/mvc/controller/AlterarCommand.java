package main.java.mvc.controller;

import main.java.mvc.model.domain.EntidadeDominio;

public class AlterarCommand implements ICommand {

	@Override
	public Object executar(EntidadeDominio entidade) {
		IFachada fachada = new Fachada();
		return fachada.alterar(entidade);
	}

}
