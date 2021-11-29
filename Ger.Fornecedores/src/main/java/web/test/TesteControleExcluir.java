package web.test;
import core.controle.Fachada;
import dominio.Fornecedor;
import web.controle.*;


public class TesteControleExcluir {
	
	public static void main(String[] args) {

		    int id = 44;
	        Fornecedor fornecedor = new Fornecedor(id);

	        Fachada fachada = new Fachada();
	        System.out.println(fachada.excluir(fornecedor));

    }

}
