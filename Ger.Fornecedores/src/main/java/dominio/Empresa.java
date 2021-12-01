package dominio;

import java.sql.Date;
import java.util.Collection;

public class Empresa extends EntidadeDominio {
	
	
    String tipo;
    String tipoFornecimento;
    
    public Empresa() {}
    public Empresa(Integer id) {
    	super(id);
    }
    
    public Empresa(String tipoEmp, String tipoFor) {
    	this.tipo = tipoEmp;
    	this.tipoFornecimento = tipoFor;
    }
    
    public Empresa(Integer id, String tipoEmp, String tipoFor, Date dtCadastro, Integer empresaForId) {
    	super(id, dtCadastro, empresaForId);
    	this.tipo = tipoEmp;
    	this.tipoFornecimento = tipoFor;
    }
    
	private Collection<Fornecedor> fornecedores;

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipoEmpresa) {
		this.tipo = tipoEmpresa;
	}

	public String getTipoFornecimento() {
		return tipoFornecimento;
	}

	public void setTipoFornecimento(String tipoFornecimento) {
		this.tipoFornecimento = tipoFornecimento;
	}
	
	@Override
    public String toString() {
        return String.format(
            "EMPRESA - Tipo da empresa: %2s, Tipo do fornecimento: %2s",
            this.getTipo(),
            this.getTipoFornecimento()
        );
    }
 
	
}
