package web.command;

import core.aplicacao.Resultado;
import dominio.EntidadeDominio;

public class AlterarCommand extends AbstractCommand{

	@Override
    public Resultado executar(EntidadeDominio entidade) {
        return fachada.alterar(entidade);
    }

}
