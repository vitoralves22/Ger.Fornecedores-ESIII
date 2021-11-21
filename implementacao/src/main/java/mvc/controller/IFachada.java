package main.java.mvc.controller;

import java.util.List;

import main.java.mvc.model.domain.EntidadeDominio;

public interface IFachada{
	public String salvar (EntidadeDominio entidade);
	public String alterar (EntidadeDominio entidade);
	public String excluir (EntidadeDominio entidade);
	public List<EntidadeDominio> consultar(EntidadeDominio entidade);
}
