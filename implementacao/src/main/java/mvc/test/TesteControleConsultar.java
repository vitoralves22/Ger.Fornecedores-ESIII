package main.java.mvc.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.java.mvc.controller.*;

import main.java.mvc.core.dao.FornecedorDAO;
import main.java.mvc.core.dao.IDAO;
import main.java.mvc.model.domain.*;

public class TesteControleConsultar {
	
	public static void main(String[] args) throws SQLException {

        String id = "3";

        Controle controle = new Controle();
        controle.consultarFornecedor(id);
        

    }

}
