package main.java.mvc.model.domain;

import java.util.Collection;

public class Pessoa extends EntidadeDominio {
	
    private String nome;
    
    private Collection<Usuario> usuarios;
    
    public Pessoa(String nome) {
    	this.nome = nome;
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Collection<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
    
    

}
