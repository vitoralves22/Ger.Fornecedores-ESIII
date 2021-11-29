package web.command;

import core.aplicacao.Resultado;
import dominio.EntidadeDominio;

public class SalvarCommand extends AbstractCommand {

	@Override
	public Resultado executar(EntidadeDominio entidade) {
		return fachada.salvar(entidade);
	}

}
