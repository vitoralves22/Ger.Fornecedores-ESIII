/*package main.java.mvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.java.mvc.core.dao.*;
import main.java.mvc.model.domain.*;

public class ControleCadastroFornecedor {
	
    
	public static String salvarFornecedor(
	        	String nomeFantasia, String razaoSocial, String cnpj, String inscricaoEstadual, String inscricaoMunicipal, String email,
	            String tipoEndereco, String cepEndereco, String tipoLogradouroEndereco, String logradouroEndereco, String numeroEndereco, String bairroEndereco,
	            String complementoEndereco, String cidadeEndereco, String estadoEndereco, String paisEndereco, List<String> cnaes,
	            List<String> nomeContatos, List<String> dptoContatos, 
	            List<String> emailContatos, List<String> dddTelefoneContatos,
	            List<String> ddiTelefoneContatos, List<String> numeroTelefoneContatos){

	        
	        Fornecedor fornecedor = new Fornecedor();
	        TipoLogradouro tipoLogradouro = new TipoLogradouro(tipoLogradouroEndereco);
	        TipoEndereco tipoEnd = new TipoEndereco(tipoEndereco);	
	        Pais pais = new Pais(paisEndereco);
	        Uf uf = new Uf(estadoEndereco, pais);
	        Cidade cidade = new Cidade(cidadeEndereco,uf);
	        Endereco end = new Endereco(tipoEnd, cepEndereco, tipoLogradouro, logradouroEndereco, numeroEndereco, bairroEndereco, complementoEndereco, cidade, uf, pais);
	        
	        List<Cnae> listaCnaes = new ArrayList<>();
	        for (String cnae : cnaes) {
	            listaCnaes.add(new Cnae(cnae));
	        }
	        
	        List<Contato> listaContatos = new ArrayList<>();
	        for (int i=0; i<nomeContatos.size(); i++) {
	            listaContatos.add(
	                new Contato(
	                    nomeContatos.get(i),
	                    emailContatos.get(i),
	                    dptoContatos.get(i),
	                    new Telefone(
	                        dddTelefoneContatos.get(i),
	                        ddiTelefoneContatos.get(i),
	                        numeroTelefoneContatos.get(i)),
	                    fornecedor)
	            );
	        }
	          
	        end.setDtCadastro(new Date());
	        fornecedor.setCnaes(listaCnaes);
	        fornecedor.setContatos(listaContatos);
	        fornecedor.setEndereco(end);
	        fornecedor.setDtCadastro(new Date());
	        fornecedor.setNmFantasia(nomeFantasia);
	        fornecedor.setRzSocial(razaoSocial);
	        fornecedor.setCnpj(cnpj);
	        fornecedor.setInscricaoEstadual(inscricaoEstadual);
	        fornecedor.setInscricaoMunicipal(inscricaoMunicipal);   
	        fornecedor.setEmail(email);
	        
	        IDAO ContatoDAO;
	        for(Contato contato : listaContatos) {
	            try {
	                ContatoDAO = new ContatoDAO();
	                contato.setDtCadastro(new Date());
	                ContatoDAO.salvar(contato);
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	      
	            
	        IDAO dao = new FornecedorDAO();

	        try {
	            dao.salvar(fornecedor);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	        return ("Fornecedor " + nomeFantasia + " SALVO!");

	    }

}*/


package main.java.mvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import main.java.mvc.core.dao.*;
import main.java.mvc.model.domain.*;


public class ControleCadastroFornecedor {
    
	public static String salvarFornecedor(
        	String nomeFantasia, String razaoSocial, String cnpj, String inscricaoEstadual, String inscricaoMunicipal, String email,
            String tipoEndereco, String cepEndereco, String tipoLogradouroEndereco, String logradouroEndereco, String numeroEndereco, String bairroEndereco,
            String complementoEndereco, String cidadeEndereco, String estadoEndereco, String paisEndereco, List<String> cnaes,
            List<String> nomeContatos, List<String> dptoContatos, 
            List<String> emailContatos, List<String> dddTelefoneContatos,
            List<String> ddiTelefoneContatos, List<String> numeroTelefoneContatos){
		
        /*List<Cnae> listaCnaes = new ArrayList<>();
        for (String cnae : listaCnaesString) {
            listaCnaes.add(new Cnae(cnae));
        }

        IDAO cnaeDAO; 

        for(Cnae cnae : listaCnaes) {
            try {
                cnaeDAO = new CnaeDAO();
                cnae.setDtCadastro(new Date());
                cnaeDAO.salvar(cnae);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
		
		TipoLogradouro tipoLogradouro = new TipoLogradouro(tipoLogradouroEndereco);
        TipoEndereco tipoEnd = new TipoEndereco(tipoEndereco);	
        Pais pais = new Pais(paisEndereco);
        Uf uf = new Uf(estadoEndereco, pais);
        Cidade cidade = new Cidade(cidadeEndereco,uf);
        Endereco end = new Endereco(tipoEnd, cepEndereco, tipoLogradouro, logradouroEndereco, numeroEndereco, bairroEndereco, complementoEndereco, cidade, uf, pais);
        end.setDtCadastro(new Date());
        
        Fornecedor fornecedor = new Fornecedor();
		fornecedor.setDtCadastro(new Date());
		end.setDtCadastro(new Date());
        fornecedor.setEndereco(end);
        fornecedor.setDtCadastro(new Date());
        fornecedor.setNmFantasia(nomeFantasia);
        fornecedor.setRzSocial(razaoSocial);
        fornecedor.setCnpj(cnpj);
        fornecedor.setInscricaoEstadual(inscricaoEstadual);
        fornecedor.setInscricaoMunicipal(inscricaoMunicipal);   
        fornecedor.setEmail(email);
		
        
        List<Telefone> listaTelefones = new ArrayList<>();
        for (int i=0; i<numeroTelefoneContatos.size(); i++) {
            listaTelefones.add(new Telefone(dddTelefoneContatos.get(i), ddiTelefoneContatos.get(i), numeroTelefoneContatos.get(i)));
        }

        
        List<Contato> listaContatos = new ArrayList<>();
        for (int i=0; i<nomeContatos.size(); i++) {
            listaContatos.add(
                new Contato(
                    nomeContatos.get(i),
                    emailContatos.get(i),
                    dptoContatos.get(i),
                    new Telefone(
                        dddTelefoneContatos.get(i),
                        ddiTelefoneContatos.get(i),
                        numeroTelefoneContatos.get(i)), fornecedor)
            );
        }
        
        fornecedor.setContatos(listaContatos);
        
        
        IDAO fornecedorDAO = new FornecedorDAO();

        try {
            fornecedorDAO.salvar(fornecedor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    
        IDAO ContatoDAO;
        for(Contato contato : listaContatos) {
            try {
                ContatoDAO = new ContatoDAO();
                contato.setDtCadastro(new Date());
                ContatoDAO.salvar(contato);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        IDAO telefoneDAO; 

        for(Telefone telefone : listaTelefones) {
            try {
                telefoneDAO = new TelefoneDAO();
                telefone.setDtCadastro(new Date());
                telefoneDAO.salvar(telefone);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


        return ("Fornecedor " + nomeFantasia + " SALVO!");

    }
}
