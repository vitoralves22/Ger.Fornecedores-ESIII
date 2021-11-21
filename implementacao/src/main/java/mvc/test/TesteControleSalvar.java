package main.java.mvc.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.mvc.controller.*;

import main.java.mvc.core.dao.FornecedorDAO;
import main.java.mvc.core.dao.IDAO;
import main.java.mvc.model.domain.*;

public class TesteControleSalvar {
	
	public static void main(String[] args) {
			
			IDAO fornecedorDAO = new FornecedorDAO();
			List<Contato> listaContatos = new ArrayList<>();
	        List<Cnae> listaCnaes = new ArrayList<>();
	        List<Produto> listaProdutos = new ArrayList<>();
	        List<Servico> listaServicos = new ArrayList<>();
	        List<Empresa> listaEmpresas = new ArrayList<>();
	        List<Telefone> listaTelefones = new ArrayList<Telefone>();
	
	        Endereco endereco1 = new Endereco("ViranoAdireita", "cep1", "tipoLog1", "log1", "num1", "bai1", "comple1", "cid1", "est", "pais1");
	        Fornecedor for1 = new Fornecedor("Creusa", "rzsocial1", "22222222555", "insmun1", "insest1", "email1", endereco1);
	        Cnae cnae1 = new Cnae("123");
	        Contato ctt1 = new Contato("fulano1", "email1", "dpto1", new Telefone("11","22","40028922"));
	        Telefone tel1 = new Telefone("11", "11", "111111111");
	        Empresa emp1 = new Empresa("Filial", "Venda");
	        Produto pro1 = new Produto("pneu");
	        Servico ser1 = new Servico("limpeza");
	        
	        Endereco endereco2 = new Endereco("LogoAli", "cep2", "tipoLog2", "log2", "num2", "bai2", "comple2", "cid2", "est", "pais2");
	        Fornecedor for2 = new Fornecedor("Valentin", "rzsocial2", "33333333777", "insmun2", "insest2", "email2", endereco2);   
	        Cnae cnae2 = new Cnae("321");
	        Cnae cnae3 = new Cnae("456");
	        Contato ctt2 = new Contato("fulano2", "email2", "dpto2", new Telefone("22","11","40028922"));
	        Contato ctt3 = new Contato("fulano3", "email3", "dpto3", new Telefone("11","22","40028922"));
	        Contato ctt4 = new Contato("fulano4", "email4", "dpto4", new Telefone("22","11","40028922"));
	        Telefone tel2 = new Telefone("22", "22", "222222222");
	        Telefone tel3 = new Telefone("33", "33", "333333333");
	        Empresa emp2 = new Empresa("Filial", "Venda");
	        Produto pro2 = new Produto("pneu");
	        Servico ser2 = new Servico("limpeza");
	        
	        IFachada fachada = new Fachada();
	        
	        listaContatos.add(ctt1);
	        listaCnaes.add(cnae1);
	        listaEmpresas.add(emp1);
	        listaProdutos.add(pro1);
	        listaServicos.add(ser1);
	        listaTelefones.add(tel1);
	        for1.setContatos(listaContatos);
	        for1.setCnaes(listaCnaes);
	        for1.setEmpresas(listaEmpresas);
	        for1.setProdutosOfertados(listaProdutos);
	        for1.setServicosOfertados(listaServicos);
	        for1.setStatus("Ativo");
	        for1.setTelefones(listaTelefones);
	        fachada.salvar(for1);
	        
	        listaContatos.clear();
	        listaCnaes.clear();
	        listaEmpresas.clear();
	        listaProdutos.clear();
	        listaServicos.clear();
	        listaTelefones.clear();
	        
	        listaContatos.add(ctt2);
	        listaContatos.add(ctt3);
	        listaContatos.add(ctt4);
	        listaCnaes.add(cnae2);
	        listaCnaes.add(cnae3);
	        listaTelefones.add(tel2);
	        listaTelefones.add(tel3);
	        listaEmpresas.add(emp2);
	        listaProdutos.add(pro2);
	        listaServicos.add(ser2);
	        for2.setContatos(listaContatos);
	        for2.setCnaes(listaCnaes);
	        for2.setEmpresas(listaEmpresas);
	        for2.setProdutosOfertados(listaProdutos);
	        for2.setServicosOfertados(listaServicos);
	        for2.setStatus("Ativo");
	        for2.setTelefones(listaTelefones);
	        fachada.salvar(for2);  
		}

}
