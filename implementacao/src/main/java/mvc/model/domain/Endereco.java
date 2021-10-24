package main.java.mvc.model.domain;

public class Endereco extends EntidadeDominio {
	
	public Endereco(TipoEndereco tipoEndereco, String cepEndereco,
			TipoLogradouro tipoLogradouroEndereco, String logradouroEndereco, 
			String numeroEndereco, String complementoEndereco, String bairroEndereco,
			Cidade cidadeEndereco) {
	
	this.tipoEndereco = tipoEndereco;
	
	}
	
	/*public Endereco(Cidade cidade, String cepEndereco,
			String logradouro, String numeroEndereco, String complementoEndereco, String bairroEndereco) {
	
	this.cidade = cidade;
	this.cep = cepEndereco;
	this.logradouro = logradouro;
	this.numero = numeroEndereco;
	this.complemento = complementoEndereco;
	this.bairro = bairroEndereco;
	
	}*/
	
	public Endereco(TipoEndereco tipoEndereco, String cepEndereco, TipoLogradouro tipoLogradouro,
			String logradouro, String numeroEndereco, String bairro, String complemento, Cidade cidade, Uf uf, Pais pais) {
	
	this.tipoEndereco = tipoEndereco;
	this.cep = cepEndereco;
	this.tipoLogradouro = tipoLogradouro;
	this.logradouro = logradouro;
	this.numero = numeroEndereco;
	this.complemento = complemento;
	this.bairro = bairro;
	this.cidade = cidade;
	this.cidade.setUf(uf);
	this.cidade.getUf().setPais(pais);
	
	}

    private String cep;
    private String logradouro;
    private String numero;
    private String bairro;
    private String complemento;

    private TipoLogradouro tipoLogradouro;
    private TipoEndereco tipoEndereco;
    private Cidade cidade;
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
	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}
	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}
	public TipoEndereco getTipoEndereco() {
		return tipoEndereco;
	}
	public void setTipoEndereco(TipoEndereco tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
    
    
    
    

}


