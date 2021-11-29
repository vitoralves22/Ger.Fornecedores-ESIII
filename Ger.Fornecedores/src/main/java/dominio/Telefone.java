package dominio;

import java.sql.Date;

public class Telefone extends EntidadeDominio {
    
	    private String tipoTelefone;
	    private String ddi;
	    private String ddd;
	    private String numero;

	    public Telefone(){}
	    public Telefone(Integer id){
	        super(id);
	    }
	    public Telefone(String ddi, String ddd, String numero) {
	        this.ddi = ddi;
	        this.ddd = ddd;
	        this.numero = numero;
	    }
	    
	    public Telefone(Integer id, String ddi, String ddd, String numero, Date dtCadastro, Integer telefoneForId) {
	        super(id, dtCadastro, telefoneForId);
	        this.ddi = ddi;
	        this.ddd = ddd;
	        this.numero = numero;
	    }
	    

	    public String getTipoTelefone() {
	        return tipoTelefone;
	    }

	    public void setTipoTelefone(String tipoTelefone) {
	        this.tipoTelefone = tipoTelefone;
	    }

	    public String getDdi() {
	        return ddi;
	    }

	    public void setDdi(String ddi) {
	        this.ddi = ddi;
	    }

	    public String getDdd() {
	        return ddd;
	    }

	    public void setDdd(String ddd) {
	        this.ddd = ddd;
	    }

	    public String getNumero() {
	        return numero;
	    }

	    public void setNumero(String numero) {
	        this.numero = numero;
	    }

	    @Override
	    public String toString() {
	        return String.format(
	            "TELEFONE - DDD: %2s, DDI: %2s, Número: %12s\n",
	            this.getDdd(),
	            this.getDdi(),
	            this.getNumero()
	        );
	    }

}
