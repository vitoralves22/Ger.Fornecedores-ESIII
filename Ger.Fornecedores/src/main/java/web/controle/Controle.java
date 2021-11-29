package web.controle;

/*import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import core.controle.Fachada;
import core.controle.IFachada;
import core.dao.*;
import dominio.*;*/


/*public class Controle{
    
	public static String salvarFornecedor(
        	String nomeFantasia, String razaoSocial, String cnpj, String inscricaoEstadual, String inscricaoMunicipal, String email,
            String tipoEndereco, String cepEndereco, String tipoLogradouro, String logradouroEndereco, String numeroEndereco, String bairroEndereco,
            String complementoEndereco, String cidade, String estadoUf, String paisEndereco, List<String> cnaes,
            List<String> nomeContatos, List<String> dptoContatos, 
            List<String> emailContatos, List<String> dddTelefoneContatos,
            List<String> ddiTelefoneContatos, List<String> numeroTelefoneContatos,
            List<String> dddTelefones, List<String> ddiTelefones, List<String> numeroTelefones,
            List<String> produtos, List<String> servicos,
            List<String> tipoEmpresas, List<String> tipoFornecimentos
            ){
		
		IFachada fachada = new Fachada();
		
		Endereco end = new Endereco();        
        end.setTipo(tipoEndereco);
        end.setCep(cepEndereco);
        end.setTipoLogradouro(tipoLogradouro);
        end.setLogradouro(logradouroEndereco);
        end.setNumero(numeroEndereco);
        end.setBairro(bairroEndereco);
        end.setComplemento(complementoEndereco);
        end.setCidade(cidade);
        end.setEstadoUf(estadoUf);
        end.setPais(paisEndereco);
        
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setEndereco(end);
        fornecedor.setNmFantasia(nomeFantasia);
        fornecedor.setRzSocial(razaoSocial);
        fornecedor.setCnpj(cnpj);
        fornecedor.setInscricaoEstadual(inscricaoEstadual);
        fornecedor.setInscricaoMunicipal(inscricaoMunicipal);   
        fornecedor.setEmail(email);
        fornecedor.getStatus();
        fornecedor.setStatus("Ativo");
        
        List<Empresa> listaEmpresas = new ArrayList<>();
        for (int i=0; i<tipoFornecimentos.size(); i++) {
            listaEmpresas.add(new Empresa(tipoEmpresas.get(i), tipoFornecimentos.get(i) ));
        }
        
        List<Cnae> listaCnaes = new ArrayList<>();
        for (String cnae : cnaes) {
            listaCnaes.add(new Cnae(cnae));
        }
        
        List<Telefone> listaTelefones = new ArrayList<Telefone>();
        for (int i=0; i<numeroTelefones.size(); i++) {
            listaTelefones.add(
                new Telefone(
                    ddiTelefones.get(i),
                    dddTelefones.get(i),
                    numeroTelefones.get(i)
                )
            );
        }
        
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
                        numeroTelefoneContatos.get(i)))
                
            );
        }
        
        List<Produto> listaProdutos = new ArrayList<>();
        for (int i=0; i<produtos.size(); i++) {
            listaProdutos.add(new Produto(produtos.get(i)));
        }
        
        List<Servico> listaServicos = new ArrayList<>();
        for (int i=0; i<servicos.size(); i++) {
            listaServicos.add(new Servico(servicos.get(i)));
        }
        
        fornecedor.setContatos(listaContatos);
        fornecedor.setCnaes(listaCnaes);
        fornecedor.setTelefones(listaTelefones);
        fornecedor.setEmpresas(listaEmpresas);  
        fornecedor.setProdutosOfertados(listaProdutos);
        fornecedor.setServicosOfertados(listaServicos); 
       
        return fachada.salvar(fornecedor);
    }
	
	 public String consultarFornecedor(String idFornecedor) {
	        Fachada fachadaFornecedor = new Fachada();
	        Fornecedor fornecedor = new Fornecedor(Integer.parseInt(idFornecedor));

	        if (fachadaFornecedor.consultar(fornecedor).isEmpty()){
	            return "Nao existe nenhum fornecedor cadastrado com esse ID.";
	        }
	        fornecedor = (Fornecedor) fachadaFornecedor.consultar(fornecedor).get(0);
	        
	        System.out.println(fornecedor);
	        System.out.println(fornecedor.getContatos());
	        System.out.println(fornecedor.getTelefones());
	        System.out.println(fornecedor.getCnaes());
	        System.out.println(fornecedor.getEmpresas());
	        System.out.println(fornecedor.getProdutosOfertados());
	        System.out.println(fornecedor.getServicosOfertados());
	        
	        return fornecedor.toString();
	 }
	 
	 
	 public String excluirFornecedor(String idFornecedor) {
	        Fachada fachadaFornecedor = new Fachada();
	        Fornecedor fornecedor = new Fornecedor(Integer.parseInt(idFornecedor));
	        if (fachadaFornecedor.consultar(fornecedor).isEmpty()){
	            return "Nao existe nenhum fornecedor cadastrado com esse ID.";
	        }
	        return fachadaFornecedor.excluir(fornecedor);
	 }
	 
	 public String ativarFornecedor(String idFornecedor) {
	        Fachada fachadaFornecedor = new Fachada();
	        Fornecedor fornecedor = new Fornecedor(Integer.parseInt(idFornecedor));
	        if (fachadaFornecedor.consultar(fornecedor).isEmpty()){
	            return "Nao existe nenhum fornecedor cadastrado com esse ID.";
	        }
	        return fachadaFornecedor.ativar(fornecedor);
	    }

	 public String inativarFornecedor(String idFornecedor) {
	        Fachada fachadaFornecedor = new Fachada();
	        Fornecedor fornecedor = new Fornecedor(Integer.parseInt(idFornecedor));
	        if (fachadaFornecedor.consultar(fornecedor).isEmpty()){
	            return "Nao existe nenhum fornecedor cadastrado com esse ID.";
	        }
	        return fachadaFornecedor.inativar(fornecedor);
	 }

}*/

import core.aplicacao.Resultado;
import dominio.EntidadeDominio;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import web.command.ICommand;
import web.command.*;
import web.viewHelper.*;

public class Controle extends jakarta.servlet.http.HttpServlet {

    private static Map<String, ICommand> commands;
    private static Map<String, IViewHelper> vhs;

    public Controle() {
        commands = new HashMap<>();

        commands.put("ALTERAR", new AlterarCommand());
        commands.put("CONSULTAR", new ConsultarCommand());
        commands.put("SALVAR", new SalvarCommand());
        commands.put("EXCLUIR", new ExcluirCommand());

        vhs = new HashMap<>();

        vhs.put("/FornecedorCRUD/AlterarFornecedor", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/AlterarEmpresa", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/AlterarEndereco", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/AlterarContato", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/AlterarTelefone", new ViewHelperFornecedor());

        vhs.put("/FornecedorCRUD/ConsultarFornecedor", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/ConsultarEmpresa", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/ConsultarEndereco", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/ConsultarContato", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/ConsultarTelefone", new ViewHelperFornecedor());

        vhs.put("/FornecedorCRUD/SalvarFornecedor", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/SalvarEmpresa", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/SalvarEndereco", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/SalvarContato", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/SalvarTelefone", new ViewHelperFornecedor());

        vhs.put("/FornecedorCRUD/ExcluirFornecedor", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/ExcluirEmpresa", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/ExcluirEndereco", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/ExcluirContato", new ViewHelperFornecedor());
        vhs.put("/FornecedorCRUD/ExcluirTelefone", new ViewHelperFornecedor());
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();

        String operacao = request.getParameter("OPERACAO");

        IViewHelper vh = vhs.get(uri);

        EntidadeDominio entidade = vh.getEntidade(request);

        ICommand command = commands.get(operacao);

        Resultado resultado = command.executar(entidade);

        vh.setView(resultado, request, response);

    }

}
