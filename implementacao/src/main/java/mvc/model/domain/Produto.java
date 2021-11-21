package main.java.mvc.model.domain;

import java.sql.Date;

public class Produto extends EntidadeDominio {

	 
	    private String descricao;

	    public Produto(){}
	    public Produto(Integer id){
	        super(id);
	    }
	    public Produto(String descricao) {
	        this.descricao = descricao;
	    }
	    public Produto(Integer id, String descricao, Date dtCadastro) {
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
	            "PRODUTO - Descrição: %2s",
	            this.getDescricao()
	        );
	    }
    
    
    
}
