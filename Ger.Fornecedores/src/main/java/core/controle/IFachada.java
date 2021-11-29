package core.controle;

import core.aplicacao.Resultado;
import dominio.EntidadeDominio;

public interface IFachada {

    public Resultado salvar(EntidadeDominio entidade);

    public Resultado alterar(EntidadeDominio entidade);

    public Resultado excluir(EntidadeDominio entidade);

    public Resultado consultar(EntidadeDominio entidade);

}
