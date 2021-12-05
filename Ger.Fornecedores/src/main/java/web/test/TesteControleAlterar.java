package web.test;

import java.util.ArrayList;
import java.util.List;

import core.dao.FornecedorDAO;
import core.dao.IDAO;
import dominio.Cnae;
import dominio.Contato;
import dominio.Empresa;
import dominio.Endereco;
import dominio.Fornecedor;
import dominio.Produto;
import dominio.Servico;
import dominio.Telefone;
import web.command.AlterarCommand;
import web.command.ICommand;
import web.command.SalvarCommand;

public class TesteControleAlterar {
	
	public static void main(String[] args) {
		
		IDAO fornecedorDAO = new FornecedorDAO();
		List<Contato> listaContatos = new ArrayList<>();
        List<Cnae> listaCnaes = new ArrayList<>();
        List<Produto> listaProdutos = new ArrayList<>();
        List<Servico> listaServicos = new ArrayList<>();
        List<Telefone> listaTelefones = new ArrayList<Telefone>();

        Endereco endereco1 = new Endereco("ViranoAdireita", "cep1", "tipoLog1", "log1", "num1", "bai1", "comple1", "cid1", "RJ", "pais1");
        Fornecedor for1 = new Fornecedor("CreusaAlterada", "rzsocialDaCreusa", "22222222555", "insmun1", "insest1", "email1", endereco1);
        Cnae cnae1 = new Cnae("123");
        Contato ctt1 = new Contato("fulano1ALTERADO", "email1", "dpto1", new Telefone("11","22","40028922"));
        Telefone tel1 = new Telefone("11", "11", "111111111");
        Empresa emp1 = new Empresa("Filial", "Venda");
        Produto pro1 = new Produto("pneu");
        Servico ser1 = new Servico("limpeza");
        for1.setId(1);
        
        Endereco endereco2 = new Endereco("LogoAli", "cep2", "tipoLog2", "log2", "num2", "bai2", "comple2", "cid2", "SP", "pais2");
        Fornecedor for2 = new Fornecedor("ValentinAlterado", "xhongas", "33333333777", "insmun2", "insest2", "email2", endereco2);   
        Cnae cnae2 = new Cnae("321");
        Cnae cnae3 = new Cnae("456");
        Contato ctt2 = new Contato("fulano2AAAAA", "email2", "dpto2", new Telefone("22","11","40028922"));
        Contato ctt3 = new Contato("fulano3EEEE", "email3", "dpto3", new Telefone("11","22","40028922"));
        Contato ctt4 = new Contato("fulano4III", "email4", "dpto4", new Telefone("22","11","40028922"));
        Telefone tel2 = new Telefone("22", "22", "222222222");
        Telefone tel3 = new Telefone("33", "33", "333333333");
        Empresa emp2 = new Empresa("Filial", "Venda");
        Produto pro2 = new Produto("pneu");
        Servico ser2 = new Servico("limpeza");
        for2.setId(2);
        
        ICommand command = new AlterarCommand();
        
        listaContatos.add(ctt1);
        listaCnaes.add(cnae1);
        listaProdutos.add(pro1);
        listaServicos.add(ser1);
        listaTelefones.add(tel1);
        for1.setContatos(listaContatos);
        for1.setCnaes(listaCnaes);      
        for1.setProdutosOfertados(listaProdutos);
        for1.setServicosOfertados(listaServicos);
        for1.setStatus("Ativo");
        for1.setTelefones(listaTelefones);
        for1.setEmpresa(emp1);
        command.executar(for1);
        
        listaContatos.clear();
        listaCnaes.clear();
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
        listaProdutos.add(pro2);
        listaServicos.add(ser2);
        for2.setContatos(listaContatos);
        for2.setCnaes(listaCnaes);
        for2.setProdutosOfertados(listaProdutos);
        for2.setServicosOfertados(listaServicos);
        for2.setStatus("Ativo");
        for2.setTelefones(listaTelefones);
        for2.setEmpresa(emp2);
        command.executar(for2);  
	}
}