package test;
import java.sql.SQLException;

import controller.*;

public class TesteControleConsultar {
	
	public static void main(String[] args) throws SQLException {

        String id = "3";

        Controle controle = new Controle();
        controle.consultarFornecedor(id);
        

    }

}
