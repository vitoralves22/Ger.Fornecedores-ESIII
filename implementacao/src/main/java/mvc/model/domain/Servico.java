package main.java.mvc.model.domain;

import java.sql.Date;

public class Servico extends EntidadeDominio {

	    private String descricao;

	    public Servico(){}
	    public Servico(Integer id){
	        super(id);
	    }
	    public Servico(String descricao) {
	        this.descricao = descricao;
	    }
	    public Servico(Integer id, String descricao, Date dtCadastro) {
	        super(id, dtCadastro);
	        this.descricao = descricao;
	    }

	    public String getDescricao() {
	        return descricao;
	    }

	    public void setDescricao(String descricao) {
	        this.descricao = descricao;
	    }

	    @Override
	    public String toString() {
	        return String.format(
	            "SERVI�O - Descri��o: %2s",
	            this.getDescricao()
	        );
	    }

}
