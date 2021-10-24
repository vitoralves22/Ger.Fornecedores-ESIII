package main.java.mvc.model.domain;

import java.util.Collection;

public class Pais {
	
	public Pais(String descricao) {
		this.descricao = descricao;
	}

    private String descricao;

    private Collection<Uf> ufs;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Collection<Uf> getUfs() {
		return ufs;
	}

	public void setUfs(Collection<Uf> ufs) {
		this.ufs = ufs;
	}
    
    
    
    
}
