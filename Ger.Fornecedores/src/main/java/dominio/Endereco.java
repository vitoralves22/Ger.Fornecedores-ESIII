package dominio;

public class Endereco extends EntidadeDominio {
	
	
	
	public Endereco(String tipoEndereco, String cepEndereco, String tipoLogradouro,
			String logradouro, String numeroEndereco, String bairro, String complemento, String cidade, String uf, String pais) {
	
	this.tipo = tipoEndereco;
	this.cep = cepEndereco;
	this.tipoLogradouro = tipoLogradouro;
	this.logradouro = logradouro;
	this.numero = numeroEndereco;
	this.complemento = complemento;
	this.bairro = bairro;
	this.cidade = cidade;
	this.estadoUf = uf;
	this.pais = pais;
	}
	
	public Endereco(){
	
	}

    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;
    private String tipoLogradouro;
    private String tipo;
    private String cidade;
    private String estadoUf;
    private String pais;
    
    
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstadoUf() {
		return estadoUf;
	}

	public void setEstadoUf(String estadoUf) {
		this.estadoUf = estadoUf;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
	
	
	
	
    
    
    
    

}


