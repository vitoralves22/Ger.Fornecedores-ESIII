package web.test;
import web.command.ConsultarCommand;
import web.command.ICommand;
import web.command.SalvarCommand;
import web.controle.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.aplicacao.Resultado;
import core.controle.Fachada;
import core.dao.FornecedorDAO;
import dominio.*;

public class TesteControleConsultar {
	
	public static void main(String[] args) throws SQLException {
	
		ICommand command = new ConsultarCommand();
		Fornecedor fornecedor = new Fornecedor("Creusa");
        Resultado resultado = new Resultado();
        List<EntidadeDominio> creusas = new ArrayList<>();       
        
        resultado = command.executar(fornecedor);
        creusas = resultado.getEntidades();
        
       
        
        //System.out.println(resultado.getMsg());
        for(EntidadeDominio creusa : creusas) {
        	Fornecedor f1 = (Fornecedor) creusa;    
        	System.out.print(f1);
        	System.out.print(f1.getContatos());
        	System.out.print(f1.getTelefones());
        	System.out.print(f1.getProdutosOfertados());
        	System.out.print(f1.getServicosOfertados() + "\n");
        }
            
    }

}
