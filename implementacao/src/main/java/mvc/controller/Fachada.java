package main.java.mvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.mvc.business.IStrategy;
import main.java.mvc.business.ValidadorCnpj;
import main.java.mvc.core.dao.FornecedorDAO;
import main.java.mvc.core.dao.IDAO;
import main.java.mvc.model.domain.EntidadeDominio;
import main.java.mvc.model.domain.Fornecedor;

public class Fachada implements IFachada {
	private Map<String, IDAO> daos;
	private Map<String, Map<String, List<IStrategy>>> rns;
	
	public Fachada() {
        daos = new HashMap<String, IDAO>();
		daos.put(Fornecedor.class.getName(), new FornecedorDAO());
        rns = new HashMap<String, Map<String, List<IStrategy>>>();
		Map<String, List<IStrategy>> rnsSALVAR = new HashMap<String, List<IStrategy>>();
		Map<String, List<IStrategy>> rnsALTERAR = new HashMap<String, List<IStrategy>>();
		
        ValidadorCnpj vCnpj = new ValidadorCnpj();

        ArrayList<IStrategy> rnsFornecedorSalvar = new ArrayList<IStrategy>();
        rnsFornecedorSalvar.add(vCnpj);
        ArrayList<IStrategy> rnsFornecedorAlterar = new ArrayList<IStrategy>();
        rnsFornecedorAlterar.add(vCnpj);

        rnsSALVAR.put(Fornecedor.class.getName(), rnsFornecedorSalvar);
        rnsALTERAR.put(Fornecedor.class.getName(), rnsFornecedorAlterar);

        rns.put("SALVAR", rnsSALVAR);
        rns.put("ALTERAR", rnsALTERAR);
    }

	@Override
	public String salvar(EntidadeDominio entidade) {
		String nmClasse = entidade.getClass().getName();		
		StringBuilder sb = new StringBuilder();			
		List<IStrategy> regras = rns.get("SALVAR").get(nmClasse);
		
		for(IStrategy s: regras) {
			validaNull(sb, s.processar(entidade));
		}
		
		if(sb.length()==0){			
			IDAO dao = daos.get(nmClasse);
			try {
	            dao.salvar(entidade);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }			
			return "ENTIDADE SALVA COM SUCESSO!";
		}		
		
		return sb.toString();
	}
	

	@Override
	public String alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	 @Override
	public String excluir(EntidadeDominio entidade) {
	    Fornecedor fornecedor = (Fornecedor) entidade;
	    FornecedorDAO fornecedorDAO = new FornecedorDAO();
	    fornecedorDAO.excluir(fornecedor);
	    return null;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		Fornecedor fornecedor = (Fornecedor) entidade;
        IDAO fornecedorDAO = new FornecedorDAO();
        List<EntidadeDominio> listaFornecedores = new ArrayList<EntidadeDominio>();
        
        try {
            listaFornecedores = fornecedorDAO.consultar(fornecedor);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }			
        return listaFornecedores;
	}
	
	public String ativar(EntidadeDominio entidade) {
        Fornecedor fornecedor = (Fornecedor) entidade;
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.ativar(fornecedor);
        return null;
    }

    public String inativar(EntidadeDominio entidade) {
        Fornecedor fornecedor = (Fornecedor) entidade;
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.inativar(fornecedor);
        return null;
    }
	
	private void validaNull(StringBuilder sb, String msg){
		if(msg != null){
			sb.append(msg);
		}
	}

}
