package main.java.mvc.model.domain;

public enum Status {

    ATIVO("ativo"),
    RASCUNHO("rascunho"),
    INATIVO("inativo");
	
	private String descricao;
	
	Status(String descricao){
		this.descricao = descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
