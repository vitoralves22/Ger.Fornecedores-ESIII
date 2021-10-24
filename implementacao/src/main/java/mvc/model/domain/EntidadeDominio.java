package main.java.mvc.model.domain;

import java.util.Date;

public abstract class EntidadeDominio {
    
    protected Integer id;
    private Date dtCadastro;

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

}
