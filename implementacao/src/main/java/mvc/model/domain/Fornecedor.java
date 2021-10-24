package main.java.mvc.model.domain;

import java.util.List;

public class Fornecedor extends EntidadeDominio {
    

    private boolean isRascunho;
    private String email;
    private String cnpj;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private String rzSocial;
    private String nmFantasia;

    private List<Empresa> empresas;
    private List<Os> osRegistradas;
    private List<Servico> servicosOfertados;
    private List<Produto> produtosOfertados;
    private Status status;
    private TipoFornecimento tipoFornecimento;
    private List<Contato> contatos;
    private List<Cnae> cnaes;
    private Endereco endereco;

    public Fornecedor() {
        System.out.println("Criando fornecedor com nome fantasia: ");
    }
    
    public Fornecedor(String nmFantasia, String rzSocial, String cnpj, String inscEstadual, String inscMunicipal, String email, Endereco end) {
    	this.nmFantasia = nmFantasia;
    	this.rzSocial = rzSocial;
    	this.cnpj = cnpj;
    	this.inscricaoEstadual = inscEstadual;
    	this.inscricaoMunicipal = inscMunicipal;
    	this.email = email;
    	this.endereco = end;
        System.out.println("Criando fornecedor com nome fantasia: ");
    }

    public String getNmFantasia() {
        return nmFantasia;
    }

    public void salvar() {
    };

    public void alterar() {
    };

    public List<Fornecedor> consultar() {
        return null;
    };

    public void excluir() {
    };

    public void inativar() {
    };

    public void ativar() {
    };

    public void addContato(Contato contato) {
    };

    public void validarCnpj() {
    };

    public void validarListaFornecimento() {
    }

	public boolean isRascunho() {
		return isRascunho;
	}

	public void setRascunho(boolean isRascunho) {
		this.isRascunho = isRascunho;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getRzSocial() {
		return rzSocial;
	}

	public void setRzSocial(String rzSocial) {
		this.rzSocial = rzSocial;
	}

	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}

	public List<Os> getOsRegistradas() {
		return osRegistradas;
	}

	public void setOsRegistradas(List<Os> osRegistradas) {
		this.osRegistradas = osRegistradas;
	}

	public List<Servico> getServicosOfertados() {
		return servicosOfertados;
	}

	public void setServicosOfertados(List<Servico> servicosOfertados) {
		this.servicosOfertados = servicosOfertados;
	}

	public List<Produto> getProdutosOfertados() {
		return produtosOfertados;
	}

	public void setProdutosOfertados(List<Produto> produtosOfertados) {
		this.produtosOfertados = produtosOfertados;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TipoFornecimento getTipoFornecimento() {
		return tipoFornecimento;
	}

	public void setTipoFornecimento(TipoFornecimento tipoFornecimento) {
		this.tipoFornecimento = tipoFornecimento;
	}
	

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public List<Cnae> getCnaes() {
		return cnaes;
	}

	public void setCnaes(List<Cnae> cnaes) {
		this.cnaes = cnaes;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void setNmFantasia(String nmFantasia) {
		this.nmFantasia = nmFantasia;
	}

	
    
	
    
    
    

}
