package dominio;

import java.util.Date;

public abstract class EntidadeDominio implements IEntidade {
    
	private Integer id;
    private Date dtCadastro;
    private Integer forId;

    public EntidadeDominio() {
        this.dtCadastro = new Date();
    }
    public EntidadeDominio(Integer id) {
        this.id = id;
    }
    public EntidadeDominio(Integer id, Date dtCadastro) {
        this.id = id;
        this.dtCadastro = dtCadastro;
    }
    
    public EntidadeDominio(Integer id, Date dtCadastro, Integer forId) {
    	this.forId = forId;
        this.id = id;
        this.dtCadastro = dtCadastro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
	public Integer getForId() {
		return forId;
	}
	public void setForId(Integer forId) {
		this.forId = forId;
	}  
    
    
    

}
