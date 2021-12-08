package web.command;

import dominio.EntidadeDominio;
import core.controle.IFachada;
import core.controle.Fachada;
import web.command.ICommand;

public abstract class AbstractCommand implements ICommand {

		protected IFachada fachada = new Fachada();
	
}
