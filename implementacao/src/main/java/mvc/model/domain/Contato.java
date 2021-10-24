package main.java.mvc.model.domain;

import java.util.List;

public class Contato extends Pessoa {
	
	private String email;
    private Departamento departamento;
    private Telefone telefone;
    private Fornecedor fornecedor;

    public Contato(String nome, String email, String departamento, Telefone telefone, Fornecedor fornecedor) {
        super(nome);
        this.email = email;
        this.departamento = new Departamento(departamento);
        this.telefone = telefone;
        this.fornecedor = fornecedor;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
    
    

	
	
	

}
