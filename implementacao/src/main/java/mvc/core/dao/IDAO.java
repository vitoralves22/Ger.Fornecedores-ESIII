package main.java.mvc.core.dao;

import java.sql.SQLException;
import java.util.List;

import main.java.mvc.model.domain.EntidadeDominio;

public interface IDAO {
    
	public void salvar(EntidadeDominio entidade) throws SQLException;
	public void alterar(EntidadeDominio entidade)throws SQLException;
	public void excluir(EntidadeDominio entidade)throws SQLException;
	public List<EntidadeDominio> consultar(EntidadeDominio entidade)throws SQLException;

}
