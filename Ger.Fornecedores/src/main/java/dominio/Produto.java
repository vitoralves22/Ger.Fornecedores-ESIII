package dominio;

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
	    
	    public Produto(Integer id, String descricao) {
	    	 super(id);
	        this.descricao = descricao;
	    }
	    
	    public Produto(Integer id, String descricao, Date dtCadastro, Integer produtoForId) {
	        super(id, dtCadastro, produtoForId);
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
	            "PRODUTO - ID: %2s, Descrição: %2s",
	            
	            this.getId(),
	            this.getDescricao()
	        );
	    }
    
    
    
}
