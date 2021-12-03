package web.controle;

import core.aplicacao.Resultado;
import dominio.EntidadeDominio;
import dominio.Fornecedor;
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

        vhs.put("/Ger.Fornecedores/AlterarFornecedor", new FornecedorViewHelper());
        vhs.put("/Ger.Fornecedores/ConsultarFornecedor", new FornecedorViewHelper());
        vhs.put("/Ger.Fornecedores/SalvarFornecedor", new FornecedorViewHelper());
        vhs.put("/Ger.Fornecedores/ExcluirFornecedor", new FornecedorViewHelper());
        
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




