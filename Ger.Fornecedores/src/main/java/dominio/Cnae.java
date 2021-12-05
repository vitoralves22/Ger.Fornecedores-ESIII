package dominio;

import java.sql.Date;

public class Cnae extends EntidadeDominio {
	
	private String codigo;
	
	public Cnae() {}
    public Cnae(Integer id){
        super(id);
    }
    public Cnae(String codigo) {
        this.codigo = codigo;
    }
    public Cnae(Integer id, String codigo, Date dtCadastro, Integer forId) {
        super(id, dtCadastro, forId);
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public String toString() {
        return String.format(
            "CNAE - ID: %2s, Código: %2s\n",
            this.getId(),
            this.getCodigo()
        );
    }
}

