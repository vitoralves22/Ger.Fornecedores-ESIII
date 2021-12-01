package core.controle;

import core.aplicacao.Resultado;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import core.business.IStrategy;
import core.business.ValidadorCnpj;
import core.dao.FornecedorDAO;
import core.dao.IDAO;
import dominio.*;

public class Fachada implements IFachada {
	
	private Map<String, IDAO> daos;
	private Map<String, Map<String, List<IStrategy>>> rns;
	private Resultado resultado;
	
	public Fachada() {
        daos = new HashMap<String, IDAO>();
		daos.put(Fornecedor.class.getName(), new FornecedorDAO());
        rns = new HashMap<String, Map<String, List<IStrategy>>>();
		Map<String, List<IStrategy>> rnsSALVAR = new HashMap<String, List<IStrategy>>();
		Map<String, List<IStrategy>> rnsALTERAR = new HashMap<String, List<IStrategy>>();
		Map<String, List<IStrategy>> rnsCONSULTAR = new HashMap<String, List<IStrategy>>();
		Map<String, List<IStrategy>> rnsEXCLUIR = new HashMap<String, List<IStrategy>>();

        ValidadorCnpj vCnpj = new ValidadorCnpj();

        ArrayList<IStrategy> rnsFornecedorSalvar = new ArrayList<IStrategy>();
        rnsFornecedorSalvar.add(vCnpj);
        
        ArrayList<IStrategy> rnsFornecedorAlterar = new ArrayList<IStrategy>();
        rnsFornecedorAlterar.add(vCnpj);
        
        ArrayList<IStrategy> rnsFornecedorConsultar = new ArrayList<IStrategy>();
        
        ArrayList<IStrategy> rnsFornecedorExcluir = new ArrayList<IStrategy>();
        
        
        rnsSALVAR.put(Fornecedor.class.getName(), rnsFornecedorSalvar);
        rnsALTERAR.put(Fornecedor.class.getName(), rnsFornecedorAlterar);
       
        rns.put("SALVAR", rnsSALVAR);
        rns.put("ALTERAR", rnsALTERAR);
        rns.put("CONSULTAR", rnsCONSULTAR);
        rns.put("EXCLUIR", rnsEXCLUIR);
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
		System.out.println("NAOEntronuIF");
        if (msg == null) {
        	System.out.println("AgorS");
            IDAO dao = daos.get(nomeClasse);
            System.out.println(dao.getClass());
            try {
            	System.out.println(entidade.getId());
                if (entidade.getId() == null) {
                	System.out.println("to nu 2 if");
                    resultado.setEntidades(dao.consultar(entidade));
                } else {
                    resultado.setEntidades(new ArrayList<EntidadeDominio>(1));
                    resultado.getEntidades().add(entidade);
                }
            } catch (Exception e) {
                resultado.setMsg("Não foi possível consultar!");
            }
        } else {
        	System.out.println("numdeu:(");
            List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
            entidades.add(entidade);
            resultado.setEntidades(entidades);
            resultado.setMsg(msg);
        }
        
        return resultado;  
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
