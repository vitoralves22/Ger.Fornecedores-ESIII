package web.command;

import core.aplicacao.Resultado;
import dominio.EntidadeDominio;

public class ExcluirCommand extends AbstractCommand{

	@Override
	public Resultado executar(EntidadeDominio entidade) {
		return fachada.excluir(entidade);
	}

}
