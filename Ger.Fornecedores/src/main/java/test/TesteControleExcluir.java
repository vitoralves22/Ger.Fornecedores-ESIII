package test;
import controller.*;

public class TesteControleExcluir {
	
	public static void main(String[] args) {
        
        String id = "2";

        Controle controle = new Controle();
        System.out.println(controle.excluirFornecedor(id));

    }

}
