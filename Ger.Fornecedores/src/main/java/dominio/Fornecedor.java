package dominio;

import java.sql.Date;
import java.util.List;

public class Fornecedor extends EntidadeDominio {
    

    private boolean isRascunho;
    private String email;
    private String cnpj;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private String rzSocial;
    private String nmFantasia;
    private String forPesquisa;


    private List<Telefone> telefones;
    private List<Empresa> empresas;
    private List<Os> osRegistradas;
    private List<Servico> servicosOfertados;
    private List<Produto> produtosOfertados;
    private String status;
    private List<Contato> contatos;
    private List<Cnae> cnaes;
    private Endereco endereco;

    public Fornecedor() {}
    public Fornecedor(Integer id){
        super(id);
    }
    
    public Fornecedor(String pesquisa){
        super(pesquisa);
    }
    
    public Fornecedor(String nmFantasia, String rzSocial, String cnpj, String inscEstadual, String inscMunicipal, String email, Endereco end) {
    	this.nmFantasia = nmFantasia;
    	this.rzSocial = rzSocial;
    	this.cnpj = cnpj;
    	this.inscricaoEstadual = inscEstadual;
    	this.inscricaoMunicipal = inscMunicipal;
    	this.email = email;
    	this.endereco = end;    
    	System.out.println("Fornecedor criado com sucesso");
    }
    
    public Fornecedor(String nmFantasia, String rzSocial, String cnpj, String inscEstadual, String inscMunicipal, String email) {
    	this.nmFantasia = nmFantasia;
    	this.rzSocial = rzSocial;
    	this.cnpj = cnpj;
    	this.inscricaoEstadual = inscEstadual;
    	this.inscricaoMunicipal = inscMunicipal;
    	this.email = email; 
    	System.out.println("Fornecedor criado com sucesso");
    }
    
    public Fornecedor(String nmFantasia, String rzSocial, String cnpj, String inscricaoEstadual, String inscricaoMunicipal,
            String email, Endereco endereco, List<Cnae> cnaes, List<Telefone> telefones, List<Contato> contatos,
            List <Empresa> empresas, List<Produto> produtosOfertados, List<Servico> servicosOfertados){
        this.cnpj = cnpj;
        this.rzSocial = rzSocial;
        this.nmFantasia = nmFantasia;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.inscricaoEstadual = inscricaoEstadual;
        this.cnaes = cnaes;
        this.email = email;
        this.telefones = telefones;
        this.contatos = contatos;
        this.endereco = endereco;
        this.empresas = empresas;
        this.produtosOfertados = produtosOfertados;
        this.servicosOfertados = servicosOfertados;
        this.status = "ATIVO";
    }
    
    public Fornecedor(Integer id, String nmFantasia, String rzSocial, String cnpj, String inscricaoEstadual, String inscricaoMunicipal,
            String email, Endereco endereco, List<Cnae> cnaes, List<Telefone> telefones, List<Contato> contatos,
            List <Empresa> empresas, List<Produto> produtosOfertados, List<Servico> servicosOfertados, String status, Date dtCadastro){
    	super(id, dtCadastro);
    	this.cnpj = cnpj;
        this.rzSocial = rzSocial;
        this.nmFantasia = nmFantasia;
        this.inscricaoMunicipal = inscricaoMunicipal;
        this.inscricaoEstadual = inscricaoEstadual;
        this.cnaes = cnaes;
        this.email = email;
        this.telefones = telefones;
        this.contatos = contatos;
        this.endereco = endereco;
        this.empresas = empresas;
        this.produtosOfertados = produtosOfertados;
        this.servicosOfertados = servicosOfertados;
        this.status = status;
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

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}  
	
	
	@Override
    public String toString() {
        return String.format(
            "FORNECEDOR - Nome Fantasia: %2s, Razao Social: %2s CNPJ: %2s,  email: %2s, Status: %2s",
         
            this.getNmFantasia(),
            this.getRzSocial(),
            this.getCnpj(),
            this.getEmail(),
            this.getStatus()
        );
    }
	public String getForPesquisa() {
		return forPesquisa;
	}
	public void setForPesquisa(String forPesquisa) {
		this.forPesquisa = forPesquisa;
	}
	
	
	
	

}
