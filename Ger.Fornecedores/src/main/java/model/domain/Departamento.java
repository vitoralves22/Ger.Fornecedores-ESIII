package model.domain;

public class Departamento extends EntidadeDominio {
	
	public Departamento(String descricao) {
		this.descricao = descricao;
	}

    private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
    

}
