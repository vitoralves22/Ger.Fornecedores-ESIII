package test;
import controller.*;

public class TesteControleAtivarInativar {
	
public static void main(String[] args) {
        
        String id = "3";

        Controle controle = new Controle();
        //System.out.println(controleFornecedor.inativarFornecedor(id));
        System.out.println(controle.ativarFornecedor(id));

    }

}
