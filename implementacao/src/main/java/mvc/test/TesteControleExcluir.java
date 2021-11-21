package main.java.mvc.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.mvc.controller.*;

import main.java.mvc.core.dao.FornecedorDAO;
import main.java.mvc.core.dao.IDAO;
import main.java.mvc.model.domain.*;

public class TesteControleExcluir {
	
	public static void main(String[] args) {
        
        String id = "2";

        Controle controle = new Controle();
        System.out.println(controle.excluirFornecedor(id));

    }

}
