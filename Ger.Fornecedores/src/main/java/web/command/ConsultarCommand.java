package web.command;

import core.aplicacao.Resultado;
import dominio.EntidadeDominio;

public class ConsultarCommand extends AbstractCommand{

	@Override
	public Resultado executar(EntidadeDominio entidade) {
		

		return fachada.consultar(entidade);
	}

}
