package main.java.mvc.model.domain;

public class Cidade {
	
	public Cidade(String descricao) {
		this.descricao = descricao;
	}
	
	public Cidade(Uf uf) {
		this.uf = uf;
	}
	
	public Cidade(String descricao, Uf uf) {
		this.descricao = descricao;
		this.uf = uf;
	}
	
    private String descricao;
    private Uf uf;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Uf getUf() {
		return uf;
	}
	public void setUf(Uf uf) {
		this.uf = uf;
	}
    
    
    

}
