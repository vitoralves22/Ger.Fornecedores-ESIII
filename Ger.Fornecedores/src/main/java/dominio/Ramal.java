package dominio;

public class Ramal extends Telefone{
	
	public Ramal(String ddd, String ddi, String numero, String codigo) {
		super(ddd, ddi, numero);
		this.codigo = codigo;
	}
	

    private String codigo;
    private String descricao;
    
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
    
    
}
