package main.java.mvc.model.domain;

public class Telefone extends EntidadeDominio {
	
	public Telefone(String ddd, String ddi, String numero){
		this.ddd = ddd;
		this.ddi = ddi;
		this.numero = numero;
	}
    
    private String ddd;
    private String ddi;
    private String numero;
    private TipoTelefone tipoTelefone;
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getDdi() {
		return ddi;
	}
	public void setDdi(String ddi) {
		this.ddi = ddi;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public TipoTelefone getTipoTelefone() {
		return tipoTelefone;
	}
	public void setTipoTelefone(TipoTelefone tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}
    
    

}
