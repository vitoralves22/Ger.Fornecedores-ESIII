package main.java.mvc.model.domain;

public class TipoLogradouro {
    
	public TipoLogradouro(String nome) {
		this.nome = nome;
	}
    private String nome;
    private String descricao;
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
    
    

}
