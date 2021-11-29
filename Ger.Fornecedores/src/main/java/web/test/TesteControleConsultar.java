package web.test;
import web.controle.*;
import java.sql.SQLException;
import core.controle.Fachada;
import dominio.*;

public class TesteControleConsultar {
	
	public static void main(String[] args) throws SQLException {

        int id = 4;
        Fornecedor fornecedor = new Fornecedor(id);

        Fachada fachada = new Fachada();
        System.out.println(fachada.consultar(fornecedor));
        

    }

}
