package web.command;

import core.aplicacao.Resultado;
import dominio.EntidadeDominio;

public interface ICommand {
	
	public Resultado executar(EntidadeDominio entidade);
	
}

