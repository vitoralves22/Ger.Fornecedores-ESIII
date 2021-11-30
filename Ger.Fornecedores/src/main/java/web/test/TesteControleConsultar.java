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
		Fornecedor fornecedor = new Fornecedor("rzsocialDaCreusa");
        Resultado resultado = new Resultado();
        List<EntidadeDominio> creusas = new ArrayList<>();       
        
        resultado = command.executar(fornecedor);
        creusas = resultado.getEntidades();
        
        System.out.println(resultado.getMsg());
        for(EntidadeDominio creusa : creusas) {
        	System.out.println(creusa.toString() + "\n");
        }
            
    }

}
