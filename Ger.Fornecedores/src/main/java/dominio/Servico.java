package dominio;

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
	    
	    public Servico(Integer id, String descricao) {
	    	super(id);
	        this.descricao = descricao;
	    }
	    
	    public Servico(Integer id, String descricao, Date dtCadastro, Integer servicoForId) {
	        super(id, dtCadastro, servicoForId);
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
	            "SERVIÇO - ID: 2%s, Descrição: %2s",
	            
	            this.getId(),
	            this.getDescricao()
	        );
	    }

}
