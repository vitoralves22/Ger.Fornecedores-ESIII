package main.java.mvc.model.domain;

import java.util.Collection;

public class Uf {
	
	public Uf(String sigla, Pais pais) {
		this.sigla = sigla;
		this.pais = pais;
	}

    private String descricao;
    private String sigla;

    private Pais pais;
    private Collection<Cidade> cidades;
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Collection<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(Collection<Cidade> cidades) {
		this.cidades = cidades;
	}
    
    
    
    
    
}
