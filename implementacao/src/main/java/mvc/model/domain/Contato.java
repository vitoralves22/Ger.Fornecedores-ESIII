package main.java.mvc.model.domain;

import java.sql.Date;
import java.util.List;

public class Contato extends EntidadeDominio {

	private String nome;
    private String departamento;
    private String email;
    private Telefone telefone;
    private int teste;
    
    
    public Contato() {}
    public Contato(Integer id){
        super(id);
    }
    public Contato(String nome, String departamento, String email, Telefone telefone) {
        this.nome = nome;
        this.departamento = departamento;
        this.email = email;
        this.telefone = telefone;
    }
    public Contato(Integer id, String nome, String departamento, String email, Telefone telefone, Date dtCadastro) {
        super(id, dtCadastro);
        this.nome = nome;
        this.departamento = departamento;
        this.email = email;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
    
    

    public int getTeste() {
		return teste;
	}
	public void setTeste(int teste) {
		this.teste = teste;
	}
	@Override
    public String toString() {
        return String.format(
            "CONTATO - Nome: %2s, email: %2s, Dpto: %2s, tel: %2s\n",
            this.getNome(),
            this.getDepartamento(),
            this.getEmail(),
            this.getTelefone(),
            this.getTelefone()
        );
    }
}

