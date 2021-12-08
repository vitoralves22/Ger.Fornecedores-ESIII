package core.controle;

import core.aplicacao.Resultado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import core.business.IStrategy;
import core.business.ValidadorCnpj;
import core.business.ValidarDadosObrigatoriosFornecimento;
import core.dao.FornecedorDAO;
import core.dao.IDAO;
import dominio.*;

public class Fachada implements IFachada {
	
	private Map<String, IDAO> daos;
	private Map<String, Map<String, List<IStrategy>>> rns;
	private Resultado resultado;
	
	public Fachada() {

        daos = new HashMap<String, IDAO>();
        rns = new HashMap<String, Map<String, List<IStrategy>>>();

        daos.put(Fornecedor.class.getName(), new FornecedorDAO());    

        List<IStrategy> rnsSalvarFornecedor = new ArrayList<IStrategy>();
        rnsSalvarFornecedor.add(new ValidadorCnpj()); 
        //rnsSalvarFornecedor.add(new ValidarDadosObrigatoriosFornecimento());  
        
        List<IStrategy> rnsAlterarFornecedor = new ArrayList<IStrategy>();
        List<IStrategy> rnsExcluirFornecedor = new ArrayList<IStrategy>();

        Map<String, List<IStrategy>> rnsFornecedor = new HashMap<String, List<IStrategy>>();
        rnsFornecedor.put("SALVAR", rnsSalvarFornecedor);
        rnsFornecedor.put("ALTERAR", rnsAlterarFornecedor);
       
        rns.put(Fornecedor.class.getName(), rnsFornecedor);
 
    }
	
	 @Override
	    public Resultado salvar(EntidadeDominio entidade) {
	        resultado = new Resultado();
	        String nomeClasse = entidade.getClass().getName();
	        List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
	        String msg = executarRegras(entidade, "SALVAR");

	        if (msg == null) {
	            IDAO dao = daos.get(nomeClasse);
	            try {
	                dao.salvar(entidade);
	                entidades.add(entidade);
	                resultado.setEntidades(entidades);
	                resultado.setMsg("Salvo com sucesso.");

	            } catch (Exception e) {
	                e.printStackTrace();
	                resultado.setMsg("Não foi possivel registrar!");
	                entidades.add(entidade);
	                resultado.setEntidades(entidades);
	            }
	        } else {
	            resultado.setMsg(msg);
	            entidades.add(entidade);
	            resultado.setEntidades(entidades);
	        }

	        return resultado;
	    }

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		resultado = new Resultado();
        String nomeClasse = entidade.getClass().getName();

        List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
        String msg = executarRegras(entidade, "ALTERAR");

        if (msg == null) {
            IDAO dao = daos.get(nomeClasse);
            try {
                dao.alterar(entidade);

                entidades.add(entidade);
                resultado.setEntidades(entidades);
                resultado.setMsg("Alterado com sucesso.");

            } catch (Exception e) {
                e.printStackTrace();
                resultado.setMsg("Não foi possivel alterar!");

            }
        } else {
            resultado.setMsg(msg);
            entidades.add(entidade);
            resultado.setEntidades(entidades);

        }

        return resultado;
	}

	 @Override
	public Resultado excluir(EntidadeDominio entidade) {
		 resultado = new Resultado();
	        String nomeClasse = entidade.getClass().getName();

	        String msg = executarRegras(entidade, "EXCLUIR");

	        if (msg == null) {
	            IDAO dao = daos.get(nomeClasse);
	            try {
	                dao.excluir(entidade);
	                List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
	                entidades.add(entidade);
	                resultado.setEntidades(entidades);
	                resultado.setMsg("Excluido com sucesso!");

	            } catch (Exception e) {
	                e.printStackTrace();
	                resultado.setMsg("Não foi possivel excluir!");

	            }
	        } else {
	            resultado.setMsg(msg);

	        }

	        return resultado;
	    }

	
	@Override
    public Resultado consultar(EntidadeDominio entidade) {
        resultado = new Resultado();
        String msg = executarRegras(entidade, "CONSULTAR");
        String nomeClasse = entidade.getClass().getName();
        if (msg == null) {
            IDAO dao = daos.get(nomeClasse);
           
            try {
                if (entidade.getId() == null) {
                    resultado.setEntidades(dao.consultar(entidade));
                } else {
                    resultado.setEntidades(new ArrayList<EntidadeDominio>(1));
                    resultado.getEntidades().add(entidade);
                }
            } catch (Exception e) {
                resultado.setMsg("Não foi possível consultar!");
            }
        } else {
            List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
            entidades.add(entidade);
            resultado.setEntidades(entidades);
            resultado.setMsg(msg);
        }
        
        return resultado;  
    }
	
	
	private String executarRegras(EntidadeDominio entidade, String operacao) {
        String nomeClasse = entidade.getClass().getName();
        StringBuilder msg = new StringBuilder();
        
        Map<String, List<IStrategy>> regrasOperacao = rns.get(nomeClasse);
        if (regrasOperacao != null) {
            List<IStrategy> regras = regrasOperacao.get(operacao);
            if (regras != null) {
                for (IStrategy s : regras) {
                    String m = s.processar(entidade);
                    if (m != null) {
                        msg.append(m);
                    }
                }
            }
        }
        
        if (msg.length() > 0) {
            return msg.toString();
        } else {
            return null;
        }
    }

}
